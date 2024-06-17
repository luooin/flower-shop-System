package com.shop.service;

import com.github.pagehelper.PageInfo;
import com.shop.service.impl.pojo.Game;
import com.shop.service.impl.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/6/4 15:37
 */
@SpringBootTest
public class GameDisplayServiceTest {
    @Autowired
    private GameDisplayService  gameDisplayService;

    @Test
    public void testGetAllCategories() {
        List<Category> allCategories = gameDisplayService.getAllCategories();
        allCategories.stream().forEach(category -> {
            System.out.println(category);
        });
    }

    @Test
    public void testGetAllGames() {
        List<Game> games = gameDisplayService.getAllGames(1, 5);
        games.stream().forEach(game -> {
            System.out.println(game);
        });
        PageInfo pageInfo = new PageInfo(games);
        System.out.println(pageInfo.getTotal());
    }

    @Test
    public void testGetGamesByCategoryCode() {
        List<Game> games = gameDisplayService.getGamesByCategoryCode(1, 5,"novel");
        games.stream().forEach(game -> {
            System.out.println(game);
        });
        PageInfo pageInfo = new PageInfo(games);
        System.out.println(pageInfo.getTotal());
    }

    @Test
    public void testGetGameById() {
        Game game = gameDisplayService.getGameDetailsByGameId(5);
        System.out.println(game);
    }

    @Test
    public void testSearchGamesByName() {
        List<Game> games = gameDisplayService.searchGamesByGameName(1, 5, "光");
        games.stream().forEach(game -> {
            System.out.println(game);
        });
    }
}
