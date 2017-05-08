package com.snowcattle.game.wolfshoot.db.service.entity;


import com.snowcattle.game.wolfshoot.db.entity.MoreOrder;

import java.util.List;

/**
 * Created by jiangwenping on 17/4/5.
 */
public interface IMoreOrderService {
    public List<MoreOrder> getMoreOrderList(MoreOrder moreOrder);
    public void insertMoreOrderList(List<MoreOrder> orderList);

    public long insertMoreOrder(MoreOrder moreOrder);
    public MoreOrder getMoreOrder(long userId, long id);
    public List<MoreOrder> getMoreOrderList(long userId);
    public List<MoreOrder> getMoreOrderList(long userId, String status);
    void updateMoreOrder(MoreOrder order);
    void deleteMoreOrder(MoreOrder order);
    public void updateMoreOrderList(List<MoreOrder> orderList);
    public void deleteMoreOrderList(List<MoreOrder> orderList);
}
