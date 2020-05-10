package com.example.bookreader.data.book;

import java.util.List;

public interface ShelfMapper {
    int addBookToShelf(String userName,String bookIndex);
    int removeBookFromShelf(String userName,String bookIndex);
    //获取已收藏的书的索引
    List<String> getUserShelf(String userName);
    //更新书签
    int updateMark(String userName,String bookIndex,int mark);
    //更新进度
    int updateProcess(String userName,String bookIndex,float process);
}
