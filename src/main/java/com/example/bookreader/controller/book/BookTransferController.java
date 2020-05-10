package com.example.bookreader.controller.book;

import com.example.bookreader.bl.book.BookTransferService;
import com.example.bookreader.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookTransferController {
    @Autowired
    BookTransferService bookTransferService;

    @RequestMapping("/upload")
    public ResponseVO uploadBook(@RequestParam( "sourcePath") String sourcePath,@RequestParam("destBucket") String bucketName,@RequestParam("destPath") String destPath){
        if(!bookTransferService.isInitialized())
            bookTransferService.initialize();
        return bookTransferService.uploadBook(sourcePath,bucketName,destPath);
    }

    @GetMapping("/download")
    public ResponseVO downBook(@RequestParam( "bookIndex") String bookIndex,@RequestParam("savePath") String savePath){
        if(!bookTransferService.isInitialized())
            bookTransferService.initialize();
        return bookTransferService.downloadBook(bookIndex,savePath);
    }

}
