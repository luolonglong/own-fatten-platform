package com.open.capacity.oauth.service;

import com.open.capacity.common.model.PageResult;
import com.open.capacity.oauth.model.TokenVo;

import java.util.Map;

/**
 * @author zlt
 */
public interface ITokensService {
    /**
     * 查询token列表
     * @param params 请求参数
     * @param clientId 应用id
     */
    PageResult<TokenVo> listTokens(Map<String, Object> params, String clientId);
}
