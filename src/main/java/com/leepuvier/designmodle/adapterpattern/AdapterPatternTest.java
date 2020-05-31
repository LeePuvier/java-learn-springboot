package com.leepuvier.designmodle.adapterpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/13  2:00 PM
 * @ContentUse :
 */
public class AdapterPatternTest {

    public static void main(String[] args){
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp4", "Hony.mp4");
        audioPlayer.play("mp3", "Hony.mp3");
        audioPlayer.play("vcl", "Hony.vcl");
        audioPlayer.play("vai", "Hony.vai");
    }
}
