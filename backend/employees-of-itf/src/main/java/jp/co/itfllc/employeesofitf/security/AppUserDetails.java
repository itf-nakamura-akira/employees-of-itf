package jp.co.itfllc.employeesofitf.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.itfllc.employeesofitf.entities.UsersEntity;

/**
 * Spring Securityで利用されるユーザー情報
 */
public class AppUserDetails implements UserDetails {
    /**
     * UsersEntity
     */
    private final UsersEntity user;

    /**
     * データベースの権限情報をUserDetailsの権限情報に変換した結果
     */
    private final Collection<? extends GrantedAuthority> authorities;

    /**
     * コンストラクター
     *
     * @param user データ元となるデータベースの情報
     */
    public AppUserDetails(UsersEntity user) {
        this.user = user;

        // 権限情報の生成
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        var authority = new SimpleGrantedAuthority(this.user.getSystemAuthority().toString());
        authorities.add(authority);
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return this.user.getAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getIsEnabled();
    }

    public byte[] getId() {
        return this.user.getId();
    }
}
