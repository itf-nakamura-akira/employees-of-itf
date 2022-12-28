package jp.co.itfllc.employeesofitf.security;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@SpringBootTest
@DisplayName("後で消す")
public class SampleTests {
    @Test
    @DisplayName("getHashedPassword メソッドのテスト")
    public void test() {
        // ハッシュ化アルゴリズムの実行
        Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        String result = encoder.encode("myPassword");
        assertTrue(encoder.matches("myPassword", result));
    }
}
