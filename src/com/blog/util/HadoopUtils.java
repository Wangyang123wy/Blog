package com.blog.util;

import java.io.IOException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class HadoopUtils {

	public static final String IN_PATH="hdfs://192.168.236.3:9000/Blog/Data";
	public static final String IN_FF=IN_PATH+"/follower_followee";
	public static final String IN_POST=IN_PATH+"/user_post";
	public static final String IN_WU=IN_PATH+"/weibo_user";
	
//	static Configuration conf=new Configuration();
	
	public static String uploadFF(FileSystem fs, String fFPath, String uploadDeltaOrAll_FF) {
		String out=IN_FF+System.currentTimeMillis();
		Path srcPath=new Path(fFPath);
		Path dstPath=new Path(out);
		try {
			if("all".equals(uploadDeltaOrAll_FF)){
				fs.delete(dstPath,true);
			}
			fs.copyFromLocalFile(srcPath,dstPath);
		}catch(Exception e){
			System.err.println(e.getMessage());
			try {
				fs.delete(dstPath, true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			out=null;
		}finally{
			try {
				if(fs!=null){
					fs.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		return out;
	}

	public static void delete(String uploadFFPath) {
		// TODO Auto-generated method stub
		
	}

	public static String uploadPost(String postPath,
			String uploadDeltaOrAll_Post) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String uploadWU(String wUPath, String uploadDeltaOrAll_WU) {
		// TODO Auto-generated method stub
		return null;
	}

	public synchronized static FileSystem getFileSystem(String ip, int port) {  
        FileSystem fs = null;  
        String url = "hdfs://" + ip + ":" + String.valueOf(port)+"/usr";  
        Configuration config = new Configuration();  
        config.set("fs.default.name", url);  
        try {  
            fs = FileSystem.get(config);  
        } catch (Exception e) {  
            System.out.println("getFileSystem failed :"  
                    + ExceptionUtils.getFullStackTrace(e));  
        }  
        return fs;  
    }  

}
