package jp.co.itfllc.employeesofitf.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;
import jp.co.itfllc.employeesofitf.enums.SystemAuthority;
import jp.co.itfllc.employeesofitf.security.AppSecurityConfig;
import net.bytebuddy.utility.RandomString;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("UsersMapper のテストコード")
public class UsersMapperTests {
    /**
     * DBのテストデータ
     */
    private final UsersEntity expectedYamanouchi = new UsersEntity(Hex.decode("0000000000BEC4324C9B9257EE300CFC"),
            "yamanouchi",
            "{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84",
            null, "山之内 貴彦", 0, SystemAuthority.Administrator, true);

    /**
     * DBのテストデータ
     */
    private final UsersEntity expectedUser09 = new UsersEntity(Hex.decode("0000000009BEC4324C9B9257EE300CFC"), "user09",
            "{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84",
            null, "ユーザー 09", 9, SystemAuthority.General, true);

    /**
     * UsersMapper
     */
    @Autowired
    private UsersMapper usersMapper;

    /**
     * AppSecurityConfigで定義されているパスワードエンコーダー
     */
    private final PasswordEncoder passwordEncoder = new AppSecurityConfig().passwordEncoder();

    @Test
    @DisplayName("selectById メソッドのテスト")
    public void testSelectById() {
        Optional<UsersEntity> actual;

        // データの取得
        actual = this.usersMapper.selectById(this.expectedYamanouchi.getId());

        // データの確認
        assertNotNull(actual.get());
        this.assertsUsersEntity(this.expectedYamanouchi, actual.get());

        // データの取得
        actual = this.usersMapper.selectById(this.expectedUser09.getId());

        // データの確認
        assertNotNull(actual.get());
        this.assertsUsersEntity(this.expectedUser09, actual.get());

        // データの取得（存在しないID）
        actual = this.usersMapper.selectById(Hex.decode("0000"));

        // データの確認
        assertTrue(actual.isEmpty());
    }

    @Test
    @DisplayName("selectByAccount メソッドのテスト")
    public void testSelectByAccount() {
        Optional<UsersEntity> actual;

        // データの取得
        actual = this.usersMapper.selectByAccount(this.expectedYamanouchi.getAccount());

        // データの確認
        assertNotNull(actual.get());
        this.assertsUsersEntity(this.expectedYamanouchi, actual.get());

        // データの取得
        actual = this.usersMapper.selectByAccount(this.expectedUser09.getAccount());

        // データの確認
        assertNotNull(actual.get());
        this.assertsUsersEntity(this.expectedUser09, actual.get());

        // 存在しないデータの取得
        actual = this.usersMapper.selectByAccount("unknow");

        // データの確認
        assertTrue(actual.isEmpty());
    }

    @Test
    @DisplayName("selectAll メソッドのテスト")
    public void testSelectAll() {
        // データの取得
        List<UsersEntity> actual = this.usersMapper.selectAll();

        // 件数の確認
        assertEquals(21, actual.size());

        // データの確認
        assertsUsersEntity(this.expectedYamanouchi, actual.get(0));
        assertsUsersEntity(this.expectedUser09, actual.get(9));
    }

    @Test
    @DisplayName("insert メソッドのテスト")
    public void testInsert() {
        UsersEntity insertData;
        UsersEntity actual;

        // データの追加
        insertData = new UsersEntity(null, "new_data1", this.passwordEncoder.encode("password"), null, "user name1",
                1000,
                SystemAuthority.Administrator, true);

        this.usersMapper.insert(insertData.getAccount(), insertData.getPasswordHash(),
                insertData.getName(),
                insertData.getEmployeeNo(), insertData.getSystemAuthority(), insertData.getIsEnabled());

        // データの確認
        actual = this.usersMapper.selectByAccount(insertData.getAccount()).get();
        insertData.setId(actual.getId()); // IDはINSERT時にDBで発行するので、ここでセットする
        this.assertsUsersEntity(insertData, actual);

        // データの追加
        insertData = new UsersEntity(null, "new_data2", this.passwordEncoder.encode("password"), null, "user name2",
                1001,
                SystemAuthority.General, false);

        this.usersMapper.insert(insertData.getAccount(), insertData.getPasswordHash(),
                insertData.getName(),
                insertData.getEmployeeNo(), insertData.getSystemAuthority(), insertData.getIsEnabled());

        // データの確認
        actual = this.usersMapper.selectByAccount(insertData.getAccount()).get();
        insertData.setId(actual.getId()); // IDはINSERT時にDBで発行するので、ここでセットする
        this.assertsUsersEntity(insertData, actual);
    }

    @Test
    @DisplayName("updateRefreshToken メソッドのテスト")
    public void testUpdateRefreshToken() {
        String newToken;
        byte[] targetId;
        UsersEntity target;
        Integer result;
        UsersEntity actual;

        // データの更新
        newToken = RandomString.make();
        targetId = this.expectedYamanouchi.getId();
        target = this.usersMapper.selectById(targetId).get();
        result = this.usersMapper.updateRefreshToken(target.getId(), newToken);
        actual = this.usersMapper.selectById(targetId).get();

        // 結果の確認
        assertNotEquals(newToken, target.getRefreshToken());
        assertEquals(1, result);
        assertEquals(newToken, actual.getRefreshToken());

        // データの更新
        newToken = RandomString.make();
        targetId = this.expectedUser09.getId();
        target = this.usersMapper.selectById(targetId).get();
        result = this.usersMapper.updateRefreshToken(target.getId(), newToken);
        actual = this.usersMapper.selectById(targetId).get();

        // 結果の確認
        assertNotEquals(newToken, target.getRefreshToken());
        assertEquals(1, result);
        assertEquals(newToken, actual.getRefreshToken());
    }

    /**
     * UsersEntityのAssert関数
     *
     * @param expected 期待値
     * @param actual   実際の値
     */
    private void assertsUsersEntity(UsersEntity expected, UsersEntity actual) {
        assertEquals(new String(Hex.encode(expected.getId())).toUpperCase(),
                new String(Hex.encode(actual.getId())).toUpperCase());
        assertEquals(expected.getAccount(), actual.getAccount());
        assertEquals(expected.getPasswordHash(), actual.getPasswordHash());
        assertEquals(expected.getRefreshToken(), actual.getRefreshToken());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getEmployeeNo(), actual.getEmployeeNo());
        assertEquals(expected.getSystemAuthority(), actual.getSystemAuthority());
        assertEquals(expected.getIsEnabled(), actual.getIsEnabled());
    }
}
