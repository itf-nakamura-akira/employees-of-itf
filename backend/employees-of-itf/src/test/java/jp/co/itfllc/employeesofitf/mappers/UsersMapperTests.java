package jp.co.itfllc.employeesofitf.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
    @DisplayName("selectAll メソッドのテスト")
    public void selectAll() {
        // データの取得
        List<UsersEntity> usersList = this.usersMapper.selectAll();

        // 件数の確認
        assertEquals(21, usersList.size());

        // データの確認
        assertEquals("yamanouchi", usersList.get(0).getAccount());
        assertEquals("user01", usersList.get(1).getAccount());
        assertEquals("user02", usersList.get(2).getAccount());
        assertEquals("user03", usersList.get(3).getAccount());
        assertEquals("user04", usersList.get(4).getAccount());
        assertEquals("user05", usersList.get(5).getAccount());
        assertEquals("user06", usersList.get(6).getAccount());
        assertEquals("user07", usersList.get(7).getAccount());
        assertEquals("user08", usersList.get(8).getAccount());
        assertEquals("user09", usersList.get(9).getAccount());
        assertEquals("user10", usersList.get(10).getAccount());
        assertEquals("user11", usersList.get(11).getAccount());
        assertEquals("user12", usersList.get(12).getAccount());
        assertEquals("user13", usersList.get(13).getAccount());
        assertEquals("user14", usersList.get(14).getAccount());
        assertEquals("user15", usersList.get(15).getAccount());
        assertEquals("user16", usersList.get(16).getAccount());
        assertEquals("user17", usersList.get(17).getAccount());
        assertEquals("user18", usersList.get(18).getAccount());
        assertEquals("user19", usersList.get(19).getAccount());
        assertEquals("user20", usersList.get(20).getAccount());
    }
}
