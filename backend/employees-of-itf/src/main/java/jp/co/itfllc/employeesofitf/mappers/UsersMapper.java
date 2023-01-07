package jp.co.itfllc.employeesofitf.mappers;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;
import jp.co.itfllc.employeesofitf.enums.SystemAuthority;

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

    /**
     * ID指定で1件取得
     *
     * @param id ID
     * @return ユーザーテーブルデータ
     */
    public Optional<UsersEntity> selectById(byte[] id);

    /**
     * アカウント指定で1件取得
     *
     * @param account アカウント
     * @return ユーザーテーブルデータ
     */
    public Optional<UsersEntity> selectByAccount(String account);

    /**
     * ユーザーデータの追加
     *
     * @param account         アカウント
     * @param passwordHash    ハッシュ化済みパスワード
     * @param name            表示名
     * @param employeeNo      社員番号
     * @param systemAuthority システム権限
     * @param isEnabled       有効/無効
     */
    public void insert(String account, String passwordHash, String name, Integer employeeNo,
            SystemAuthority systemAuthority, Boolean isEnabled);

    /**
     * リフレッシュトークンの更新
     *
     * @param id 更新対象のID
     * @param refreshToken 新しいリフレッシュトークン
     * @return 更新件数
     */
    public Integer updateRefreshToken(byte[] id, String refreshToken);
}
