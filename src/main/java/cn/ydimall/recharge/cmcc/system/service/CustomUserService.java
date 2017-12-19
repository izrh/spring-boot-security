package cn.ydimall.recharge.cmcc.system.service;

import cn.ydimall.recharge.cmcc.system.entity.SysPermission;
import cn.ydimall.recharge.cmcc.system.entity.SysUser;
import cn.ydimall.recharge.cmcc.system.repository.SysPermissionRepository;
import cn.ydimall.recharge.cmcc.system.repository.SysUserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhongruhang on 2017/12/18
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;

    @Autowired
    SysPermissionRepository permissionRepository;

    private Log log = LogFactory.getLog(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.debug("username:" + user.getUsername() + ";password:" + user.getPassword());
        List<SysPermission> permissions = permissionRepository.findByRoles(user.getRoles());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysPermission permission : permissions) {
            if (permission != null && permission.getName() != null) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}

