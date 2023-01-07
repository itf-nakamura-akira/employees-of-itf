package jp.co.itfllc.employeesofitf.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("AppUserDetailsService のテストコード")
public class AppUserDetailsServiceTest {
    /**
     * AppUserDetailsService
     */
    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Test
    @DisplayName("loadUserByUsername メソッドのテスト")
    public void testLoadUserByUsername() {
        // UserDetailsの取得
        this.assertLoadUserByUsername("yamanouchi");

        // UserDetailsの取得
        this.assertLoadUserByUsername("user01");

        // 存在しないアカウントで取得失敗
        assertThrowsExactly(UsernameNotFoundException.class,
                () -> this.appUserDetailsService.loadUserByUsername("userXX"));
    }

    /**
     * アカウントを指定してUserDetailsが取得できることを確認する
     *
     * @param account アカウント
     */
    private void assertLoadUserByUsername(String account) {
        UserDetails actual = this.appUserDetailsService.loadUserByUsername(account);

        // データの確認
        assertEquals(account, actual.getUsername());
    }
}
