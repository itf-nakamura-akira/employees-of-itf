package jp.co.itfllc.employeesofitf.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;
import jp.co.itfllc.employeesofitf.mappers.UsersMapper;

@Component
public class AppUserDetailsService implements UserDetailsService {
    private final UsersMapper usersMapper;

    public AppUserDetailsService(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = this.usersMapper.selectByAccount(username).orElseThrow(() -> new UsernameNotFoundException(username));

        // TODO: 認証していないけどいい？

        var userDetails = new AppUserDetails(user);

        return userDetails;
    }
}
