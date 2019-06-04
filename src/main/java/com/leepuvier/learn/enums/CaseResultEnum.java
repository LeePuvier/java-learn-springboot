package com.leepuvier.learn.enums;

/**
 * @Author : LeePuvier
 * @CreateTime : 2019/6/4  下午8:43
 * @ContentUse ：用例执行结果枚举
 */
public enum CaseResultEnum {

    RESULT_NO_EXEC("未执行", 0), RESULT_IS_SUCC("成功", 1), RESULT_IS_FAIL("失败", 2), RESULT_IS_GO("执行中", 3);

    private String content;

    private int type;

    CaseResultEnum(String content, int type) {
        this.content = content;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.content + "-对应的类型值为-" + this.type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static String contentOf(int type){
        for (CaseResultEnum info : CaseResultEnum.values())
            if(info.type == type){
                return info.content;
            }
            return null;
    }


    public static int typeOf(String content){
        for (CaseResultEnum info : CaseResultEnum.values())
            if(info.content.equals(content)){
                return info.type;
            }
        return -1;
    }

}
