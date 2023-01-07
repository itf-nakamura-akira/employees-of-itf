package jp.co.itfllc.employeesofitf.controllers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;
import jp.co.itfllc.employeesofitf.mappers.UsersMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("AuthenticationController のテストコード")
public class AuthenticationControllerTest {
    /**
     * TestUtils
     */
    @Autowired
    TestUtils testUtils;

    /**
     * UsersMapper
     */
    @Autowired
    private UsersMapper usersMapper;

    @Test
    @DisplayName("login メソッドのテスト")
    void testLogin() throws JsonProcessingException, Exception {
        // 正しいパスワードでのリクエスト
        AuthenticationController.LoginReponse actual = this.testUtils.postUtil("/authentication/login",
                new AuthenticationController.PostLoginBody("yamanouchi", "password"), null, status().isOk(),
                AuthenticationController.LoginReponse.class);

        assertTrue(StringUtils.hasText(actual.jwt()));
        assertTrue(StringUtils.hasText(actual.refreshToken()));

        // 間違ったパスワードでのリクエスト
        this.testUtils.postUtil("/authentication/login",
                new AuthenticationController.PostLoginBody("yamanouchi", "fail"), null, status().isUnauthorized());
    }

    @Test
    @DisplayName("logout メソッドのテスト")
    void testLogout() throws Exception {
        UsersEntity user;

        // ログイン -> ログアウト
        AuthenticationController.LoginReponse actual = this.testUtils.postUtil("/authentication/login",
                new AuthenticationController.PostLoginBody("yamanouchi", "password"), null, status().isOk(),
                AuthenticationController.LoginReponse.class);

        // ログインに成功したらリフレシュトークンに値が入っている
        user = this.usersMapper.selectByAccount("yamanouchi").get();
        assertTrue(StringUtils.hasText(user.getRefreshToken()));

        this.testUtils.postUtil("/authentication/logout", null, new HashMap<String, String>() {
            {
                put("Authorization", "Bearer " + actual.jwt());
            }
        }, status().isOk());

        // ログアウトに成功したらリフレシュトークンが空になる
        user = this.usersMapper.selectByAccount("yamanouchi").get();
        assertFalse(StringUtils.hasText(user.getRefreshToken()));

        // 認証情報無しでリクエスト
        this.testUtils.postUtil("/authentication/logout", null, null, status().isUnauthorized());
    }
}
