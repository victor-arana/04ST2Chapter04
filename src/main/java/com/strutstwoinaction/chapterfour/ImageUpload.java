package com.strutstwoinaction.chapterfour;

import java.io.File;
import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;
import com.strutstwoinaction.chapterfour.utils.PortfolioService;

/* 
 * This action uploads an image file using the default fileUpload
 * interceptor. The intercetor is in the default stack and the only
 * thing we have to do here in the action is implement JavaBean's
 * properties to receive the File and meta-data from the interceptor.
 */

public class ImageUpload extends ActionSupport {
	
	private static final long serialVersionUID = 1887848446984207622L;

	@Override
	public String execute() throws Exception {
		try{
			getPortfolioService().addImage(pic, getPicFileName(), fileSystemPath);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/* JavaBeans Properties to Receive Request Parameters */
	File pic;
	String picContentType;
	String picFileName;
	String fileSystemPath;
	
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
	    this.pic = pic;
	}
	
	public String getPicContentType() {
		return picContentType;
	}
	void setPicContentType(String picContentType) {
	    this.picContentType = picContentType;
	}
	
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public String getPicFileName() {
		return picFileName;
	}
	public void setFileSystemPath(String fileSystemPath) {
		this.fileSystemPath = fileSystemPath;
	}

	/*  
	 * Simple way to retrieve our business logic and data persistence
	 * object.  Late versions of the portfolio app will integrate with
	 * more sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService( ) 	{
		
		return new PortfolioService();
		
	}
}
