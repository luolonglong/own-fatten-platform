package com.open.capacity.order.service;

import com.open.capacity.order.mapper.OrderMapper;
import com.open.capacity.order.feign.AccountFeignClient;
import com.open.capacity.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zlt
 * @date 2019/9/14
 */
@Slf4j
@Service
public class OrderService {
    @Resource
    private AccountFeignClient accountFeignClient;

    @Resource
    private OrderMapper orderMapper;

    //@Transactional(rollbackFor = Exception.class)
    public void create(String userId, String commodityCode, Integer count) {
        //订单金额
        Integer orderMoney = count * 2;

        Order order = new Order()
                .setUserId(userId)
                .setCommodityCode(commodityCode)
                .setCount(count)
                .setMoney(orderMoney);
        orderMapper.insert(order);

        accountFeignClient.reduce(userId, orderMoney);
    }
}
