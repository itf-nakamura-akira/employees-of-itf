package jp.co.itfllc.employeesofitf.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;
import jp.co.itfllc.employeesofitf.mappers.UsersMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("AuthorizationService のテストコード")
public class AuthorizationServiceTest {
    /**
     * AuthorizationService
     */
    @Autowired
    private AuthorizationService authorizationService;

    /**
     * UsersMapper
     */
    @Autowired
    private UsersMapper usersMapper;

    @Test
    @DisplayName("updateRefreshToken メソッドのテスト")
    void testUpdateRefreshToken() {
        // リフレッシュトークンの更新
        this.assertUpdateRefreshToken("0000000000BEC4324C9B9257EE300CFC");

        // リフレッシュトークンの更新
        this.assertUpdateRefreshToken("0000000001BEC4324C9B9257EE300CFC");

        // 存在しないユーザーIDで更新失敗
        HttpServerErrorException exception = assertThrowsExactly(HttpServerErrorException.class,
                () -> this.authorizationService.updateRefreshToken(Hex.decode("00000000000000000000000000000000")));
        assertEquals(HttpStatus.UNAUTHORIZED, exception.getStatusCode());
    }

    @Test
    @DisplayName("logout メソッドのテスト")
    void testLogout() {
        // ログアウト
        this.assertLogout("0000000000BEC4324C9B9257EE300CFC");

        // ログアウト
        this.assertLogout("0000000001BEC4324C9B9257EE300CFC");

        // 存在しないユーザーIDでログアウト失敗
        HttpServerErrorException exception = assertThrowsExactly(HttpServerErrorException.class,
                () -> this.authorizationService.logout(Hex.decode("00000000000000000000000000000000")));
        assertEquals(HttpStatus.FORBIDDEN, exception.getStatusCode());
    }

    /**
     * リフレッシュトークンが更新され、処理に時間がかかることを確認する
     *
     * @param userId ユーザーID
     */
    private void assertUpdateRefreshToken(String userId) {
        // リフレッシュトークンの更新
        byte[] targetId = Hex.decode(userId);
        Instant start = Instant.now();
        String refreshToken = this.authorizationService.updateRefreshToken(targetId);
        Instant end = Instant.now();
        UsersEntity actual = this.usersMapper.selectById(targetId).get();

        // 処理に1秒以上かかること
        assertTrue(end.toEpochMilli() - start.toEpochMilli() >= 1000);
        assertEquals(refreshToken, actual.getRefreshToken());
    }

    /**
     * リフレッシュトークンが削除されることを確認する
     *
     * @param userId ユーザーID
     */
    private void assertLogout(String userId) {
        // リフレッシュトークンの更新
        byte[] targetId = Hex.decode(userId);
        this.authorizationService.logout(targetId);
        UsersEntity actual = this.usersMapper.selectById(targetId).get();

        // 処理に1秒以上かかること
        assertNull(actual.getRefreshToken());
    }
}
