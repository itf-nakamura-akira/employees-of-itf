package jp.co.itfllc.employeesofitf.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;
import jp.co.itfllc.employeesofitf.mappers.UsersMapper;

@Service
public class AuthorizeService {
    private final UsersMapper usersMapper;

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

        if (data.isEmpty() || !data.get().getIsEnabled()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "認証に失敗しました。");
        }

        // TODO: パスワードのチェックが行えていない

        return data.get();
    }
}
