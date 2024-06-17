package com.shop.controller.dao;

import com.shop.service.impl.pojo.Game;

import java.util.List;

public interface GameMapper {
    int deleteByGameId(Integer gameId);

    int insert(Game record);

    Game selectByGameId(Integer gameId);

    int updateByGameId(Game record);

    List<Game> selectAllByCategoryCode(String categoryCode);

    List<Game> selectByGames(Game game);
}
