package com.example.bookreader.po.book;

public class Shelf {
    private String userName;
    private String bookIndex;
    private int mark;
    private float process;

    public Shelf() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookIndex() {
        return bookIndex;
    }

    public void setBookIndex(String bookIndex) {
        this.bookIndex = bookIndex;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public float getProcess() {
        return process;
    }

    public void setProcess(float process) {
        this.process = process;
    }
}
