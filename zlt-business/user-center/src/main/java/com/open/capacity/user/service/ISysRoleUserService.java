package com.open.capacity.user.service;

import com.open.capacity.common.model.SysRole;
import com.open.capacity.common.service.ISuperService;
import com.open.capacity.user.model.SysRoleUser;

import java.util.List;

/**
 * @author zlt
 */
public interface ISysRoleUserService extends ISuperService<SysRoleUser> {
	int deleteUserRole(Long userId, Long roleId);

	int saveUserRoles(Long userId, Long roleId);

	/**
	 * 根据用户id获取角色
	 *
	 * @param userId
	 * @return
	 */
	List<SysRole> findRolesByUserId(Long userId);

	/**
	 * 根据用户ids 获取
	 *
	 * @param userIds
	 * @return
	 */
	List<SysRole> findRolesByUserIds(List<Long> userIds);
}
