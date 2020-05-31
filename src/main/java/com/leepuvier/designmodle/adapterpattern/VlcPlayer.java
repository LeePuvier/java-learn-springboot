package com.leepuvier.designmodle.adapterpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/13  1:48 PM
 * @ContentUse :
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void palyMp4(String fileName) {

    }
}
