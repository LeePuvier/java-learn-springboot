package com.leepuvier.designmodle.adapterpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/13  1:49 PM
 * @ContentUse :
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void palyMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
