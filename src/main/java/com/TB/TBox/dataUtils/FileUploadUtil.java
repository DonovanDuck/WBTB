package com.TB.TBox.dataUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Repository
public class FileUploadUtil{
	
	/**
	 * 封装传入MultipartFile时将其存入图片仓库，并返回保存名
	 * 
	 * @param re
	 * @return
	 * @throws IOException
	 */
	public List<String> MultiPartFileUpLoad(MultipartRequest re, String userNumber, int noteId) throws IOException {
		InputStream in = null;
		List<String> b3List = new ArrayList<String>();
		int cont = 0;// b3List脚标
		// 对图片的获取
		List<MultipartFile> fileList = re.getFiles("ufacing");
		// 遍历MultipartFile集合
		int i = 0;
		for (MultipartFile file : fileList) {
			// multipartfile 转 file 上传文件大小若小于2048，则不会生成临时文件
			CommonsMultipartFile cf = (CommonsMultipartFile) file;
			DiskFileItem fi = (DiskFileItem) cf.getFileItem();
			File f = fi.getStoreLocation();
//			File tmpFile = null;
			byte[] buffer = file.getBytes();
			// 手动创建临时文件
//			if (f.length() < 2048) {
//				tmpFile = new File(
//						System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + f.getName());
//				try {
//					
//					file.transferTo(tmpFile);
//				} catch (IllegalStateException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			//获取保存路径
			String houzhui =".png";
//			try {
//				// 创建临时文件输入流
//				if(tmpFile!=null){
//					in = new FileInputStream(tmpFile);
//					//获取保存路径
////					 houzhui = tmpFile.getName().substring(tmpFile.getName().lastIndexOf("."));
//				}
//				else{
//					in = new FileInputStream(f);
//					String a = f.getName();
//					//获取保存路径
////					 houzhui = f.getName().substring(f.getName().lastIndexOf("."));
//				}
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			// 创建缓冲区
//			BufferedInputStream bis = new BufferedInputStream(in);
//			int length = bis.available();//获取输入流长度
//			byte[] bin = new byte[length];
//			Properties property = new Properties();
//			property.load(getClass().getClassLoader().getResourceAsStream("fileupload.properties"));
			String savePath = "C:/image/"+userNumber+"_"+noteId+"_"+i+houzhui;
			//获得文件输出流,并存入库中
			OutputStream out = new FileOutputStream(savePath);
			BufferedOutputStream bot = new BufferedOutputStream(out);
			bot.write(buffer);
			bot.flush();
			bot.close();
			// 获取文件保存库的名字放入list
			b3List.add(userNumber+"_"+noteId+"_"+i+houzhui);
			++i;
		}
		return b3List;
	}
}
