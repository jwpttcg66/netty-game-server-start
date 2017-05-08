package com.snowcattle.game.wolfshoot.db.service.entity;


import com.snowcattle.game.wolfshoot.db.entity.Tocken;

import java.util.List;

/**
 * Created by sunmosh on 2017/4/5.
 */
public interface ITockenService {
    public long insertTocken(Tocken Tocken);
    public Tocken getTocken(long userId, String id);
    public List<Tocken> getTockenList(long userId);
    void updateTocken(Tocken Tocken);
    void deleteTocken(Tocken Tocken);
}
