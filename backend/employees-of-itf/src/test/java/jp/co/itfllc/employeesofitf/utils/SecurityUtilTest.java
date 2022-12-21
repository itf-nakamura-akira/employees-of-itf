package jp.co.itfllc.employeesofitf.utils;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("SecurityUtilTest のテストコード")
public class SecurityUtilTest {
    /**
     * SecurityUtil
     */
    @Autowired
    private SecurityUtil securityUtil;

    @Test
    @DisplayName("getHashedPassword メソッドのテスト")
    public void testGetHashedPassword() {
        try {
            String hashedPassword1 = this.securityUtil.getHashedPassword("password");
            String hashedPassword2 = this.securityUtil.getHashedPassword("password");

            assertNotNull(hashedPassword1);
            assertNotNull(hashedPassword2);
            assertNotEquals(hashedPassword1, hashedPassword2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}