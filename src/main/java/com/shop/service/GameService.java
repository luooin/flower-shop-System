package com.shop.service;

import java.util.List;

import com.shop.service.impl.pojo.Game;


public interface GameService {

    Game gameSearchById(Integer gameId);

    List<Game> gameSearchByCode(String catrgoryCode ,Integer page,Integer limit);

    int gameDeleteSearchById(Integer gameId);

    int gameInsert(Game record);

    int gameUpdate(Game record);



    List<Game> searchGames(Game game,Integer page,Integer limit);
}
