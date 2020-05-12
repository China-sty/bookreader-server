package com.example.bookreader.bl.book;

import com.example.bookreader.vo.Charpter;
import com.example.bookreader.vo.Page;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
* 负责将原文件进行格式化
* */
public interface BookFormatService {
    List<Page> paging(Charpter charpter,int lineLimit,int wordLimit);//分页
    List<Charpter> charptering(File file,String bookIndex) throws IOException;//分章

}
