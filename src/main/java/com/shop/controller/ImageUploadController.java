package com.shop.controller;

import com.shop.exception.CustomizeException;
import com.shop.util.ResultCode;
import com.shop.util.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/upload")
public class ImageUploadController {

    @PostMapping("/game_image")
    public ResultVO uploadGameImage(MultipartFile gameImage, HttpServletRequest request) {


        String path = "src/main/resources/static/images/game_images";
        File pathFile=new File("src/main/resources/static/images/game_images");
        System.out.println(pathFile.getAbsolutePath());
        String targetFileName=gameImage.getOriginalFilename();
        File targetFile = new File(pathFile.getAbsolutePath(), targetFileName);


        try {
            gameImage.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomizeException(ResultCode.FAILED, "上传图片失败");
        }
        return new ResultVO(ResultCode.SUCCESS,targetFileName);
    }
}
