package jp.co.itfllc.employeesofitf.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;
import jp.co.itfllc.employeesofitf.mappers.UsersMapper;

/**
 * 認証関連Service
 */
@Service
public class AuthorizeService {
    /**
     * UsersMapper
     */
    private final UsersMapper usersMapper;

    /**
     * コンストラクター
     *
     * @param usersMapper UsersMapper
     */
    public AuthorizeService(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    /**
     * 認証処理
     *
     * @param account アカウント
     * @param password パスワード
     *
     * @return 認証に成功したユーザーデータ
     */
    public UsersEntity Authenticate(String account, String password) {
        Optional<UsersEntity> data = this.usersMapper.selectByAccount(account);

        if (data.isEmpty() || !data.get().getIsEnabled() || !this.validatePassword(password, data.get().getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "認証に失敗しました。");
        }

        return data.get();
    }

    /**
     * 入力されたパスワードをハッシュ化した結果と、ハッシュ化されたパスワードが一致することを検証する
     *
     * @param password 入力されたパスワード
     * @param hashedPassword ハッシュ化されたパスワード
     * @return true: 一致, false: 不一致
     */
    private Boolean validatePassword(String password, String hashedPassword) {
        // TODO: ハッシュ化できていない
        return password == hashedPassword;
    }
}
