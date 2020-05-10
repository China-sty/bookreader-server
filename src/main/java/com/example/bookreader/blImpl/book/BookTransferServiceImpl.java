package com.example.bookreader.blImpl.book;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.example.bookreader.bl.book.BookTransferService;
import com.example.bookreader.config.OSSconfig;
import com.example.bookreader.data.book.BookMapper;
import com.example.bookreader.po.book.Book;
import com.example.bookreader.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Service
public class BookTransferServiceImpl implements BookTransferService {
    @Autowired
    BookMapper bookMapper;

    private OSS oss=null;

    @Override
    public void initialize(){
        String endpoint= OSSconfig.endpoint;
        String accessKeyId=OSSconfig.accessKeyId;
        String accessKeySecret=OSSconfig.accessKeySecret;
        oss= new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }


    @Override
    public boolean isInitialized(){
        return oss != null;
    }

    /*
    * 上传图书
    *
    * */
    @Override
    public ResponseVO uploadBook(String sourcePath, String destBucket, String destFileName)  {
        if(!isInitialized()){
            return ResponseVO.buildFailure("OSS服务未初始化");
        }
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(sourcePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("找不到文件");
        }
        oss.putObject(destBucket, destFileName, inputStream);
        oss.shutdown();
        return ResponseVO.buildSuccess();
    }

     /*
     * 下载图书
     *
     * */
     @Override
     public ResponseVO downloadBook(String bookIndex, String filePath){
         Book book=bookMapper.selectBookByIndex(bookIndex);
         String savePath=book.getSavePath();
         String bucket=savePath.split(":")[0];
         String fileName=savePath.split(":")[1];
         return downloadBook(filePath,bucket,fileName);
     }

    private ResponseVO downloadBook(String savePath, String targetBucket, String targetFileName){
        if(!isInitialized()){
            return ResponseVO.buildFailure("OSS服务未初始化");
        }
        oss.getObject(new GetObjectRequest(targetBucket, targetFileName), new File(savePath));
        oss.shutdown();
        return ResponseVO.buildSuccess();
    }



    public static void main(String[] args)  {
        BookTransferServiceImpl bookServiceImpl =new BookTransferServiceImpl();
        bookServiceImpl.initialize();
        ResponseVO responseVO= bookServiceImpl.uploadBook("C:\\Users\\Administrator\\Desktop\\book1.txt","bookstorage","abc/samplebook.txt");
        System.out.println(responseVO.getSuccess());
    }

}
