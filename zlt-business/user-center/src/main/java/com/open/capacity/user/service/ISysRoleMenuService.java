package com.open.capacity.user.service;

import com.open.capacity.common.model.SysMenu;
import com.open.capacity.common.service.ISuperService;
import com.open.capacity.user.model.SysRoleMenu;

import java.util.List;
import java.util.Set;

/**
 * @author zlt
 */
public interface ISysRoleMenuService extends ISuperService<SysRoleMenu> {
	int save(Long roleId, Long menuId);

	int delete(Long roleId, Long menuId);

	List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, Integer type);

	List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, Integer type);
}
