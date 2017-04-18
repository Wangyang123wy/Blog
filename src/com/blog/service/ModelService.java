package com.blog.service;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component("modelService")
public class ModelService {

//	public FileSystem fs = HadoopUtils.getFileSystem("192.168.236.3", 9000);
	public boolean uploadFF(String fFPath, String uploadDeltaOrAll_FF) throws IOException, URISyntaxException {
		boolean flag=false;
		
		/*Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.236.3:9000");
        FileSystem fs = FileSystem.get(uri,conf);
        Path resP = new Path(fFPath);
        Path destP = new Path("/aaaaaa");
        if(!fs.exists(destP)){
            fs.mkdirs(destP);
        }
        fs.copyFromLocalFile(resP, destP);
        System.out.println("name is " + fFPath);
        fs.close();*/
		
		ClassPathXmlApplicationContext cpa=new ClassPathXmlApplicationContext("spring-hdfs.xml");
		FileSystem fs=(FileSystem) cpa.getBean("fileSystem");
		FSDataOutputStream fos=fs.create(new Path("hdfs://192.168.236.3:9000/usr/test/"));
		InputStream is=new FileInputStream("D://te.txt");
		int i;
		while((i=is.read())!=-1){
			fos.write(i);
		}
		is.close();
		fos.close();
		fs.close();
		System.out.println("=============uploadFF");
		return flag;
	}

	public boolean uploadPost(String postPath, String uploadDeltaOrAll_Post) {
		boolean flag=false;
		/*String uploadPostPath=null;
		try {
			uploadPostPath=HadoopUtils.uploadPost(postPath,uploadDeltaOrAll_Post);
		} catch (IOException e) {
			if(uploadPostPath!=null){
				HadoopUtils.delete(uploadPostPath);
			}
			flag=false;
		}*/
		return flag;
	}

	public boolean uploadWU(String wUPath, String uploadDeltaOrAll_WU) {
		boolean flag=false;
		/*String uploadWUPath=null;
		try {
			uploadWUPath=HadoopUtils.uploadWU(wUPath,uploadDeltaOrAll_WU);
		} catch (IOException e) {
			if(uploadWUPath!=null){
				HadoopUtils.delete(uploadWUPath);
			}
			flag=false;
		}*/
		return flag;
	}

}
