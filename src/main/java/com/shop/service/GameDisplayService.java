package com.shop.service;

import com.shop.service.impl.pojo.Game;
import com.shop.service.impl.pojo.Category;

import java.util.List;


public interface GameDisplayService {

    List<Category> getAllCategories();

    List<Game> getAllGames(Integer page, Integer limit);

    List<Game> getGamesByCategoryCode(Integer page, Integer limit,String categoryCode);

    Game getGameDetailsByGameId(Integer gameId);

    List<Game> searchGamesByGameName(Integer page, Integer limit,String gameName);
}

