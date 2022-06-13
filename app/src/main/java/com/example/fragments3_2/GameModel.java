package com.example.fragments3_2;

import java.io.Serializable;

public class GameModel implements Serializable {

    public String firstImg, secondImg, thirdImg, fourthImg, answer, level, count;

    public GameModel(String firstImg, String secondImg, String thirdImg, String fourthImg, String answer, String level, String count) {
        this.firstImg = firstImg;
        this.secondImg = secondImg;
        this.thirdImg = thirdImg;
        this.fourthImg = fourthImg;
        this.answer = answer;
        this.level = level;
        this.count = count;
    }
}
