package jp.co.itfllc.employeesofitf.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("UsersMapper のテストコード")
public class UsersMapperTests {
    /**
     * UsersMapper
     */
    @Autowired
    private UsersMapper usersMapper;

    @Test
    @DisplayName("selectByAccount メソッドのテスト")
    public void testSelectByAccount() {
        Optional<UsersEntity> actual;

        // データの取得
        actual = this.usersMapper.selectByAccount("yamanouchi");

        // データの確認
        assertNotNull(actual.get());
        assertEquals("yamanouchi", actual.get().getAccount());
        
        // データの取得
        actual = this.usersMapper.selectByAccount("user05");

        // データの確認
        assertNotNull(actual);
        assertEquals("user05", actual.get().getAccount());
        
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
        assertEquals("yamanouchi", actual.get(0).getAccount());
        assertEquals("user01", actual.get(1).getAccount());
        assertEquals("user02", actual.get(2).getAccount());
        assertEquals("user03", actual.get(3).getAccount());
        assertEquals("user04", actual.get(4).getAccount());
        assertEquals("user05", actual.get(5).getAccount());
        assertEquals("user06", actual.get(6).getAccount());
        assertEquals("user07", actual.get(7).getAccount());
        assertEquals("user08", actual.get(8).getAccount());
        assertEquals("user09", actual.get(9).getAccount());
        assertEquals("user10", actual.get(10).getAccount());
        assertEquals("user11", actual.get(11).getAccount());
        assertEquals("user12", actual.get(12).getAccount());
        assertEquals("user13", actual.get(13).getAccount());
        assertEquals("user14", actual.get(14).getAccount());
        assertEquals("user15", actual.get(15).getAccount());
        assertEquals("user16", actual.get(16).getAccount());
        assertEquals("user17", actual.get(17).getAccount());
        assertEquals("user18", actual.get(18).getAccount());
        assertEquals("user19", actual.get(19).getAccount());
        assertEquals("user20", actual.get(20).getAccount());
    }
}
