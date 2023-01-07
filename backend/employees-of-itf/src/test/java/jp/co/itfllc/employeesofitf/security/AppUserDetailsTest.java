package jp.co.itfllc.employeesofitf.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;
import jp.co.itfllc.employeesofitf.mappers.UsersMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("AppUserDetailsTest のテストコード")
public class AppUserDetailsTest {
    /**
     * UsersMapper
     */
    @Autowired
    private UsersMapper usersMapper;

    @Test
    @DisplayName("プロパティーのテスト")
    public void test() {
        UsersEntity user = this.usersMapper.selectById(Hex.decode("0000000000BEC4324C9B9257EE300CFC")).get();
        var actual = new AppUserDetails(user);

        // データの確認
        assertTrue(actual.getAuthorities().stream().map(v -> v.getAuthority()).toList()
                .contains(user.getSystemAuthority().toString()));
        assertEquals(user.getPasswordHash(), actual.getPassword());
        assertEquals(user.getAccount(), actual.getUsername());
        assertEquals(user.getIsEnabled(), actual.isEnabled());
        assertEquals(user.getId(), actual.getId());
    }
}
