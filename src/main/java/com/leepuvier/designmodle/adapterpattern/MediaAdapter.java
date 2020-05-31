package com.leepuvier.designmodle.adapterpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/13  1:50 PM
 * @ContentUse :
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType ){
        if (audioType.equalsIgnoreCase("VCL")){
            advancedMediaPlayer = new VlcPlayer();
        }else if (audioType.equalsIgnoreCase("MP4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("VCL")){
            advancedMediaPlayer.playVlc(fileName);
        }else if (audioType.equalsIgnoreCase("MP4")){
            advancedMediaPlayer.palyMp4(fileName);
        }else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
