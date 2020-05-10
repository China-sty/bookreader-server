package com.example.bookreader.vo;

public class Charpter {
    private int charpterNum;
    private String content;

    public int getCharpterNum() {
        return charpterNum;
    }

    public void setCharpterNum(int charpterNum) {
        this.charpterNum = charpterNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContentFromRaw(String raw){
        this.content= raw.replaceAll("\\s","");
    }
}
