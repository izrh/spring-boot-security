package cn.ydimall.recharge.cmcc.system.repository;

import cn.ydimall.recharge.cmcc.system.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by zhongruhang on 2017/12/18
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
