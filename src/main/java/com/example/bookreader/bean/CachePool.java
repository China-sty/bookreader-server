package com.example.bookreader.bean;

import com.example.bookreader.vo.Charpter;
import com.example.bookreader.vo.Page;

import java.util.List;

/*
* 缓存
* 可缓存Page和Charpter
* */
public class CachePool {
    //采取直接映射

    private CharpterCache charpterCache;
    private PageCache pageCache;

    private  int size1=20;
    private int size2=20;

    private static CachePool cachePool=new CachePool();

    public static CachePool getCachePool(){
        return cachePool;
    }

    public int getSize1() {
        return size1;
    }

    public void setSize1(int size1) {
        this.size1 = size1;
    }

    public int getSize2() {
        return size2;
    }

    public void setSize2(int size2) {
        this.size2 = size2;
    }

    public void cacheCharpter(Charpter charpter){
        //缓存一章
        this.charpterCache.cacheCharpter(charpter);
    }

    public void cacheCharpters(List<Charpter> list){
        for(Charpter charpter:list){
            cacheCharpter(charpter);
        }
    }

    public void cachePage(Page page){
        //缓存一页
        this.pageCache.cachePage(page);
    };

    public void cachePages(List<Page> list){
        for(Page page:list){
            cachePage(page);
        }
    };

    public Charpter getCharpter(String bookIndex,int charpterNum){
        return this.charpterCache.getCharpter(bookIndex,charpterNum);
    }

    public Page getPage(String bookIndex,int charpterNum,int pageNum){
        return this.pageCache.getPage(bookIndex,charpterNum,pageNum);
    }

    private CachePool(){}



    private class CharpterCache{
        Charpter[] charpters;
        CharpterCache(){
            charpters=new Charpter[size1];
        }

        void cacheCharpter(Charpter charpter){
            //缓存一章
            int loc=charpter.getCharpterNum()%size1;
            this.charpters[loc]=charpter;
        }

        Charpter getCharpter(String bookIndex,int charpterNum){
            Charpter charpter=this.charpters[charpterNum%size1];
            if(charpter!=null&& charpter.getBookIndex().equals(bookIndex)){
                return charpter;
            }
            return null;
        }

    }
    private class PageCache{
        Page[] pages;
        PageCache(){
            pages=new Page[size2];
        }
        void cachePage(Page page){
            //缓存一页
            int loc=(page.getPageNum()+page.getCharpterNum())%size2;
            this.pages[loc]=page;
        }

        Page getPage(String bookIndex,int charpterNum,int pageNum){
            Page page=this.pages[(pageNum+charpterNum)%size2];
            if(page!=null&&page.getBookIndex().equals(bookIndex)&&page.getCharpterNum()==charpterNum){
                return page;
            }
            return null;
        }
    }


}
