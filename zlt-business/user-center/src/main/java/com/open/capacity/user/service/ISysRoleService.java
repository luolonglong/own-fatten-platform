package com.open.capacity.user.service;

import java.util.List;
import java.util.Map;

import com.open.capacity.common.model.PageResult;
import com.open.capacity.common.model.Result;
import com.open.capacity.common.model.SysRole;
import com.open.capacity.common.service.ISuperService;

/**
 * @author zlt
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
public interface ISysRoleService extends ISuperService<SysRole> {
	void saveRole(SysRole sysRole) throws Exception;

	void deleteRole(Long id);

	/**
	 * 角色列表
	 * @param params
	 * @return
	 */
	PageResult<SysRole> findRoles(Map<String, Object> params);

	/**
	 * 新增或更新角色
	 * @param sysRole
	 * @return Result
	 */
	Result saveOrUpdateRole(SysRole sysRole) throws Exception;

	/**
	 * 查询所有角色
	 * @return
	 */
	List<SysRole> findAll();
}
