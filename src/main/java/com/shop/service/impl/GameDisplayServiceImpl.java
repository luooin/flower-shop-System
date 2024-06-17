package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.shop.controller.dao.GameDisplayMapper;
import com.shop.controller.dao.GameMapper;
import com.shop.controller.dao.CategoryMapper;
import com.shop.service.impl.pojo.Game;
import com.shop.service.impl.pojo.Category;
import com.shop.service.GameDisplayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class GameDisplayServiceImpl implements GameDisplayService {
    @Resource
    private GameMapper gameMapper;
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private GameDisplayMapper gameDisplayMapper;


    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.selectAll();
    }

    @Override
    public List<Game> getAllGames(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Game> games = gameMapper.selectAllByCategoryCode(null);
        return games;
    }

    @Override
    public List<Game> getGamesByCategoryCode(Integer page, Integer limit,String categoryCode) {
        PageHelper.startPage(page,limit);
        List<Game> games = gameMapper.selectAllByCategoryCode(categoryCode);
        return games;
    }

    @Override
    public Game getGameDetailsByGameId(Integer gameId) {
        return gameMapper.selectByGameId(gameId);
    }

    @Override
    public List<Game> searchGamesByGameName(Integer page, Integer limit,String gameName) {
        PageHelper.startPage(page, limit);
        List<Game> games = gameDisplayMapper.fuzzyQueryByGameName(gameName);
        return games;
    }
}
