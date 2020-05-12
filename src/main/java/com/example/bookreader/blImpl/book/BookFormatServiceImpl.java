package com.example.bookreader.blImpl.book;

import com.example.bookreader.bl.book.BookFormatService;
import com.example.bookreader.vo.Charpter;
import com.example.bookreader.vo.Page;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookFormatServiceImpl implements BookFormatService {

    @Override
    public List<Page> paging(Charpter charpter, int lineLimit,int wordLimit) {
        List<Page> list=new ArrayList<>();
        String content=charpter.getContent();
        ByteArrayInputStream stream=new ByteArrayInputStream(content.getBytes());
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(stream));
        for(int i=1;i<=(content.length()%(lineLimit*wordLimit)==0?content.length()/(lineLimit*wordLimit):content.length()/(lineLimit*wordLimit)+1);i++){
            Page page=new Page();
            page.setLineLimit(lineLimit);
            page.setWordLimit(wordLimit);
            page.setPageNum(i);
            page.setCharpterNum(charpter.getCharpterNum());
            page.setBookIndex(charpter.getBookIndex());

            //读取每个page
            for(int j=0;j<lineLimit;j++){
                char[] lineChars=new char[wordLimit];
                try {
                    bufferedReader.read(lineChars);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                page.setLine(String.valueOf(lineChars));
            }
            list.add(page);
        }
        return list;
    }

    @Override
    public List<Charpter> charptering(File file,String bookIndex) throws IOException {
        HashMap<String,Integer> reflection=new HashMap<String, Integer>() {
            {
                put("一", 1);
                put("二",2);
                put("三",3);
                put("四",4);
                put("五",5);
                put("六",6);
                put("七",7);
                put("八",8);
                put("九",9);
                put("十",10);
                put("十一",11);
                put("十二",12);
                put("十三",13);
                put("十四",14);
                put("十五",15);
                put("十六",16);
                put("十七",17);
                put("十八",18);
                put("十九",19);
                put("二十",20);
                put("二十一",21);
            }
        };
        List<Charpter> charpterList=new ArrayList<>();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
        String line;
        StringBuffer buffer=new StringBuffer();
        boolean isStarted=false;
        Charpter charpter=null;
        while((line=bufferedReader.readLine())!=null){
            line=line.trim();
           // System.out.println(line);
            Pattern pattern=Pattern.compile("第(\\S{1,3})章");
            Matcher matcher=pattern.matcher(line);
            if(matcher.find()){
                if(isStarted){
                    charpter=new Charpter();
                    charpter.setCharpterNum(reflection.get(matcher.group(1))-1);
                    charpter.setContentFromRaw(buffer.toString());
                    charpter.setBookIndex(bookIndex);
                    charpterList.add(charpter);
                    buffer.delete(0,buffer.length());//清空buffer
                }
                isStarted=true;
            }else{
                if(isStarted)
                    buffer.append(line);
            }

        }
        charpter.setContentFromRaw(buffer.toString());
        charpter.setCharpterNum(charpterList.get(charpterList.size()-1).getCharpterNum()+1);
        charpter.setBookIndex(bookIndex);
        charpterList.add(charpter);
        return charpterList;
    }

    public static void main(String[] args) throws IOException {
        List<Charpter> charpters=new BookFormatServiceImpl().charptering(new File("C:\\Users\\Administrator\\Desktop\\百年孤独.txt"),"L1");
        List<Page> pages=new BookFormatServiceImpl().paging(charpters.get(0),10,15);
        System.out.print(pages.size());
    }
}
