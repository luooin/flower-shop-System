package com.shop.controller;

import java.util.List;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.shop.service.impl.pojo.Game;
import com.shop.service.GameService;
import com.shop.util.ResultCode;
import com.shop.util.ResultVO;

import javax.validation.Valid;


@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;


    @GetMapping("/searchid")
    public ResultVO gameSearchByGameId(Integer gameId) {

        Game games = gameService.gameSearchById(gameId);
        if (games != null)
            return new ResultVO(ResultCode.SUCCESS,games);
        else
            return new ResultVO(ResultCode.RECORD_NOT_FOUND, null);
    }


    @PostMapping("/delete")
    public ResultVO gameDelete(Integer gameId) {
        int games = gameService.gameDeleteSearchById(gameId);
        return new ResultVO(ResultCode.SUCCESS, null);
    }


    @PostMapping("/insert")
    public ResultVO gameInsert(@Valid Game record) {
        int games = gameService.gameInsert(record);
        return new ResultVO(ResultCode.SUCCESS, null);
    }



    @GetMapping("/searchcode")
  public ResultVO gameSerchByCategoryCode(String catrgoryCode,Integer page,Integer limit) {
      List<Game> games = gameService.gameSearchByCode(catrgoryCode,page,limit);
        PageInfo pageInfo = new PageInfo(games);
     if(games.size()!=0)
     {
      return new ResultVO(ResultCode.SUCCESS,(int)pageInfo.getTotal(), games);
     }
     else
    	 return new ResultVO(ResultCode.RECORD_NOT_FOUND, null);

  }



    @PostMapping("/update")
    public ResultVO gameUpdate(@Valid Game record) {
        int games = gameService.gameUpdate(record);
        return new ResultVO(ResultCode.SUCCESS, null);
    }


    @GetMapping("/search")
    public ResultVO searchGames(Game game,Integer page, Integer limit) {
        if(game.getGameName().isEmpty()){
            game.setGameName(null);
        }
        if(game.getIsbn().isEmpty()){
            game.setIsbn(null);
        }
        List<Game> games = gameService.searchGames(game, page, limit);
        PageInfo pageInfo = new PageInfo(games);
        return new ResultVO(ResultCode.SUCCESS, (int) pageInfo.getTotal(), games);
    }


}
