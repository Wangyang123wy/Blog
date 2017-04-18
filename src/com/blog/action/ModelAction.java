package com.blog.action;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.blog.service.ModelService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("model")
@Scope("prototype")
public class ModelAction extends ActionSupport implements SessionAware {
	private String info;
	
	private String FFPath;  //用户粉丝-用户关注数据路径
	private String uploadDeltaOrAll_FF;
	
	private String PostPath;  //微博数据路径
	private String uploadDeltaOrAll_Post;
	
	private String WUPath;  //微博用户数据路径
	private String uploadDeltaOrAll_WU;
	
	private ModelService modelService;
	
	private boolean flag;
	
	private Map<String ,Object> session;
	/**
	 * 上传用户粉丝-用户关注数据
	 * @return
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public String uploadFF() throws IOException, URISyntaxException{
		flag=modelService.uploadFF(FFPath,uploadDeltaOrAll_FF);
		if(flag)
			info="上传成功";
		else
			info="上传失败";
		return "upload";
	}

	public void setSession(Map<String, Object> arg0) {
		
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getFFPath() {
		return FFPath;
	}
	public void setFFPath(String fFPath) {
		FFPath = fFPath;
	}
	public String getUploadDeltaOrAll_FF() {
		return uploadDeltaOrAll_FF;
	}
	public void setUploadDeltaOrAll_FF(String uploadDeltaOrAll_FF) {
		this.uploadDeltaOrAll_FF = uploadDeltaOrAll_FF;
	}
	public String getPostPath() {
		return PostPath;
	}
	public void setPostPath(String postPath) {
		PostPath = postPath;
	}
	public String getUploadDeltaOrAll_Post() {
		return uploadDeltaOrAll_Post;
	}
	public void setUploadDeltaOrAll_Post(String uploadDeltaOrAll_Post) {
		this.uploadDeltaOrAll_Post = uploadDeltaOrAll_Post;
	}
	public String getWUPath() {
		return WUPath;
	}
	public void setWUPath(String wUPath) {
		WUPath = wUPath;
	}
	public String getUploadDeltaOrAll_WU() {
		return uploadDeltaOrAll_WU;
	}
	public void setUploadDeltaOrAll_WU(String uploadDeltaOrAll_WU) {
		this.uploadDeltaOrAll_WU = uploadDeltaOrAll_WU;
	}
	public ModelService getModelService() {
		return modelService;
	}
	@Resource
	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Map<String, Object> getSession() {
		return session;
	}
}
