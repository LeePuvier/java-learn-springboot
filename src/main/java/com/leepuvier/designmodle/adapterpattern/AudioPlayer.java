package com.leepuvier.designmodle.adapterpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/13  1:56 PM
 * @ContentUse :
 */
public class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("MP3")){
            System.out.println("Playing mp3 file. Name: " + fileName);
        }else if (audioType.equalsIgnoreCase("MP4") || audioType.equalsIgnoreCase("VCL")){
            mediaAdapter = new MediaAdapter(audioType);

            mediaAdapter.play(audioType, fileName);
        }
    }
}
