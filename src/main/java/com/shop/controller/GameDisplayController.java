package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.service.impl.pojo.Game;
import com.shop.service.impl.pojo.Category;
import com.shop.service.GameDisplayService;
import com.shop.util.ResultCode;
import com.shop.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/index")
public class GameDisplayController {

    @Autowired
    private GameDisplayService gameDisplayService;


    @GetMapping("/category")
    @ResponseBody
    public ResultVO getCategories() {
        List<Category> categories = gameDisplayService.getAllCategories();
        return new ResultVO(ResultCode.SUCCESS,categories);
    }


    @GetMapping("/games")
    @ResponseBody
    public ResultVO getGamesByCategoryCode(@RequestParam(required = false) String categoryCode, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        List<Game> games = gameDisplayService.getGamesByCategoryCode(page==null?1:page, limit==null?10:limit, categoryCode);
        PageInfo pageInfo = new PageInfo(games);
        return new ResultVO(ResultCode.SUCCESS, (int) pageInfo.getTotal(),games);
    }


    @GetMapping("/games/details/{gameId}")
    public String gameDetailsView(@PathVariable("gameId") Integer gameId, Model model) {
        Game game = gameDisplayService.getGameDetailsByGameId(gameId);
        model.addAttribute("game", game);
        return "details";
    }


    @GetMapping("/games/search")
    @ResponseBody
    public ResultVO searchGame(@RequestParam(required = true) String gameName) {
        List<Game> games = gameDisplayService.searchGamesByGameName(1, 10, gameName);
        PageInfo pageInfo = new PageInfo(games);
        return new ResultVO(ResultCode.SUCCESS, (int) pageInfo.getTotal(), games);
    }



}
