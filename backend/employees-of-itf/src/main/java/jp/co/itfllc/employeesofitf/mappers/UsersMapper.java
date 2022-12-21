package jp.co.itfllc.employeesofitf.mappers;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;

/**
 * ユーザーテーブルに関するMapper
 */
@Mapper
public interface UsersMapper {
    /**
     * アカウント指定で1件取得
     *
     * @param account アカウント
     * @return ユーザーテーブルデータ
     */
    public Optional<UsersEntity> selectByAccount(String account);

    /**
     * 全件取得
     *
     * @return ユーザーテーブルデータ全件
     */
    public List<UsersEntity> selectAll();
}
