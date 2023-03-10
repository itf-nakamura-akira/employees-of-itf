package jp.co.itfllc.employeesofitf.entities;

import jp.co.itfllc.employeesofitf.enums.SystemAuthority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザーテーブル
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {
    /**
     * ID
     */
    private byte[] id;

    /**
     * アカウント
     */
    private String account;

    /**
     * ハッシュ化済みパスワード
     */
    private String passwordHash;

    /**
     * リフレッシュトークン
     */
    private String refreshToken;

    /**
     * 表示名
     */
    private String name;

    /**
     * 社員番号
     */
    private Integer employeeNo;

    /**
     * システム権限
     */
    private SystemAuthority systemAuthority;

    /**
     * 有効フラグ
     */
    private Boolean isEnabled;
}
