package com.example.bookreader.controller.book;

import com.example.bookreader.bean.CachePool;
import com.example.bookreader.bl.book.BookFormatService;
import com.example.bookreader.data.book.BookMapper;
import com.example.bookreader.vo.Charpter;
import com.example.bookreader.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookFormatController {
    @Autowired
    CachePool cachePool;
    @Autowired
    BookFormatService bookFormatService;
    @Autowired
    BookMapper bookMapper;

    @GetMapping("/page")
    public Page page(@RequestParam("bookIndex")String bookIndex,@RequestParam("charpterNum")int charpterNum,@RequestParam("pageNum")int pageNum) throws IOException {
        Page page=cachePool.getPage(bookIndex,charpterNum,pageNum);
        Charpter charpter;
        if(page==null){
            charpter=cachePool.getCharpter(bookIndex,charpterNum);
        }else{
            return page;
        }
        if(charpter==null){
            //分章分页,缓存章
            //todo
            File file=new File(bookMapper.selectBookByIndex(bookIndex).getBookIndex());
            List<Charpter> list=bookFormatService.charptering(file,bookIndex);
        }else{
            //分页,缓存页
            //todo
        }
        return page;
    }
}
