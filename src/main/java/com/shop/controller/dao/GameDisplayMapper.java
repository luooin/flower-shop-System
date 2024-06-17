package com.shop.controller.dao;

import com.shop.service.impl.pojo.Game;

import java.util.List;


public interface GameDisplayMapper {


    List<Game> fuzzyQueryByGameName(String gameName);
}
