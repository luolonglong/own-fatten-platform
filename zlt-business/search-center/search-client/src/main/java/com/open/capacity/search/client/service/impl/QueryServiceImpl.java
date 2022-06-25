package com.open.capacity.search.client.service.impl;

import cn.hutool.core.util.StrUtil;
import com.open.capacity.common.model.PageResult;
import com.open.capacity.search.client.feign.AggregationService;
import com.open.capacity.search.client.feign.SearchService;
import com.open.capacity.search.client.service.IQueryService;
import com.open.capacity.search.model.LogicDelDto;
import com.open.capacity.search.model.SearchDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 搜索客户端Service
 *
 * @author zlt
 * @date 2019/4/24
 */
public class QueryServiceImpl implements IQueryService {
    @Autowired(required = false)
    private SearchService searchService;

    @Resource
    private AggregationService aggregationService;

    @Override
    public PageResult<JsonNode> strQuery(String indexName, SearchDto searchDto) {
        return strQuery(indexName, searchDto, null);
    }

    @Override
    public PageResult<JsonNode> strQuery(String indexName, SearchDto searchDto, LogicDelDto logicDelDto) {
        setLogicDelQueryStr(searchDto, logicDelDto);
        return searchService.strQuery(indexName, searchDto);
    }

    /**
     * 拼装逻辑删除的条件
     * @param searchDto 搜索dto
     * @param logicDelDto 逻辑删除dto
     */
    private void setLogicDelQueryStr(SearchDto searchDto, LogicDelDto logicDelDto) {
        if (logicDelDto != null
                && StrUtil.isNotEmpty(logicDelDto.getLogicDelField())
                && StrUtil.isNotEmpty(logicDelDto.getLogicNotDelValue())) {
            String result;
            //搜索条件
            String queryStr = searchDto.getQueryStr();
            //拼凑逻辑删除的条件
            String logicStr = logicDelDto.getLogicDelField() + ":" + logicDelDto.getLogicNotDelValue();
            if (StrUtil.isNotEmpty(queryStr)) {
                result = "(" + queryStr + ") AND " + logicStr;
            } else {
                result = logicStr;
            }
            searchDto.setQueryStr(result);
        }
    }

    /**
     * 访问统计聚合查询
     * @param indexName 索引名
     * @param routing es的路由
     */
    @Override
    public Map<String, Object> requestStatAgg(String indexName, String routing) {
        return aggregationService.requestStatAgg(indexName, routing);
    }
}
