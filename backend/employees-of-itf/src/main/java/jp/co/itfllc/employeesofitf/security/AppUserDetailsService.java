package jp.co.itfllc.employeesofitf.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;
import jp.co.itfllc.employeesofitf.mappers.UsersMapper;

/**
 * ユーザー情報を取得してUserDetailsを生成、Spring Securityに渡すためのクラス
 */
@Component
public class AppUserDetailsService implements UserDetailsService {
    /**
     * UsersMapper
     */
    private final UsersMapper usersMapper;

    /**
     * コンストラクター
     *
     * @param usersMapper UsersMapper
     */
    public AppUserDetailsService(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    /**
     * クライアントが指定したアカウント情報を取得してUserDetailsを生成する
     */
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        UsersEntity user = this.usersMapper.selectByAccount(account).orElseThrow(() -> new UsernameNotFoundException(account));
        var userDetails = new AppUserDetails(user);

        return userDetails;
    }
}
