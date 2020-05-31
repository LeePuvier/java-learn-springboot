package com.leepuvier.designmodle.templatepattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/20  1:50 PM
 * @ContentUse :
 */
public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板

    public final void play(){
        //初始化游戏
        initialize();
        //开始游戏
        startPlay();
        //结束游戏
        endPlay();
    }

}
