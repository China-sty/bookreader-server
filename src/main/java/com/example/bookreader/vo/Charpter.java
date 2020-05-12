package com.example.bookreader.vo;

public class Charpter {
    private String bookIndex;
    private int charpterNum;
    private String content;

    public Charpter() {
    }

    public String getBookIndex() {
        return bookIndex;
    }

    public void setBookIndex(String bookIndex) {
        this.bookIndex = bookIndex;
    }

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
