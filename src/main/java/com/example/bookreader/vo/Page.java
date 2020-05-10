package com.example.bookreader.vo;

import java.util.ArrayList;

public class Page {
    private int pageNum;//第几页
    private int lineLimit;//行数限制
    private int wordLimit;//每行字数限制
    private ArrayList<String> lines;

    public Page() {
        lines=new ArrayList<String>();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getLineLimit() {
        return lineLimit;
    }

    public void setLineLimit(int lineLimit) {
        this.lineLimit = lineLimit;
    }

    public int getWordLimit() {
        return wordLimit;
    }

    public void setWordLimit(int wordLimit) {
        this.wordLimit = wordLimit;
    }

    public String getLine(int index) {
        return lines.get(index);
    }

    public void setLine(String line) {
        this.lines.add(line);
    }
}
