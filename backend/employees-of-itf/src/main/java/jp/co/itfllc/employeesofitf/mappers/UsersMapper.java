package jp.co.itfllc.employeesofitf.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;

/**
 * ユーザーテーブルに関するMapper
 */
@Mapper
public interface UsersMapper {
    /**
     * 全件取得
     *
     * @return ユーザーテーブルデータ全件
     */
    public List<UsersEntity> selectAll();
}
