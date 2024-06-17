package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import com.shop.controller.dao.GameMapper;
import com.shop.service.impl.pojo.Game;
import com.shop.service.GameService;

@Service
public class GameServiceImpl implements GameService {
    @Resource
    private GameMapper gameMapper;
	@Override
	public Game gameSearchById(Integer gameId) {

		Game games=gameMapper.selectByGameId(gameId);
		return games;
	}


	@Override
	public List<Game> gameSearchByCode(String catrgoryCode,Integer page,Integer limit) {
			PageHelper.startPage(page, limit);
	      List<Game> games = gameMapper.selectAllByCategoryCode(catrgoryCode);

	      return games;


	}

	@Override
	public int gameDeleteSearchById(Integer gameId) {

		int games=gameMapper.deleteByGameId(gameId);
		return games;
	}

	@Override
	public int gameInsert(Game record) {

		int games=gameMapper.insert(record);
                return games;
	}

	@Override
	public int gameUpdate(Game record) {

		int games=gameMapper.updateByGameId(record);
		return games;

	}



	@Override
	public List<Game> searchGames(Game game, Integer page, Integer limit) {
		PageHelper.startPage(page,limit);
		List<Game> games = gameMapper.selectByGames(game);
		return games;
	}
}
