package cn.ydimall.recharge.cmcc.system.repository;

import cn.ydimall.recharge.cmcc.system.entity.SysPermission;
import cn.ydimall.recharge.cmcc.system.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by zhongruhang on 2017/12/18
 */
public interface SysPermissionRepository extends JpaRepository<SysPermission, Long> {
    List<SysPermission> findByRoles(List<SysRole> roles);

    List<SysPermission> findAll();
}
