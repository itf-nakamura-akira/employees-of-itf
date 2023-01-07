package jp.co.itfllc.employeesofitf.services;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import jp.co.itfllc.employeesofitf.mappers.UsersMapper;

@Service
public class AuthorizationService {
    /**
     * UsersMapper
     */
    private final UsersMapper usersMapper;

    /**
     * コンストラクター
     *
     * @param usersMapper UsersMapper
     */
    public AuthorizationService(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    /**
     * リフレッシュトークンを更新する
     *
     * @param id 対象のユーザーID
     * @return 新しいリフレッシュトークン
     */
    public String updateRefreshToken(byte[] id) {
        String newRefreshToken = this.generateRefreshToken();
        Integer result = this.usersMapper.updateRefreshToken(id, newRefreshToken);

        if (result != 1) {
            throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
        }

        return newRefreshToken;
    }

    /**
     * ログアウトする(リフレッシュトークンを削除する)
     *
     * @param id 対象のユーザーID
     */
    public void logout(byte[] id) {
        Integer result = this.usersMapper.updateRefreshToken(id, null);

        if (result != 1) {
            throw new HttpServerErrorException(HttpStatus.FORBIDDEN);
        }
    }

    /**
     * リフレッシュトークンを生成する
     *
     * @return リフレッシュトークン
     */
    private String generateRefreshToken() {
        // 意図的なスリープ(ブルートフォース対策)
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }

        return UUID.randomUUID().toString();
    }
}
