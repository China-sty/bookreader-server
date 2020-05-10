package com.example.bookreader.data.book;

import com.example.bookreader.po.book.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {
    int addBook(Book book);

    List<Book> selectBookByAuthor(String authorName);
    List<Book> selectBookByName(String bookName);
    List<Book> selectBookByCategory(String category);
    Book selectBookByIndex(String index);

    int updateBookSavePath(String bookIndex,String savePath);

    int deleteBookByName(String bookName);
    int deleteBookByIndex(String index);

    int getBookNum();
    int getBookNumByCategory(String category);
    int getBookNumByAuthor(String authorName);
    int getBookNumByName(String bookName);
    String getBookImgUrlByIndex(String bookIndex);

}
