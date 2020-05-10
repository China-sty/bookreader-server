package com.example.bookreader.bl.book;

import com.example.bookreader.vo.ResponseVO;

/*
* 负责在服务器和oss之间传输文件
* */
public interface BookTransferService {
     void initialize();
     boolean isInitialized();
     ResponseVO uploadBook(String sourcePath, String destBucket, String destFileName) ;
     ResponseVO downloadBook(String bookIndex,String filePath);
}
