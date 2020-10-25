package com.chenxin.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.chenxin.domain.insertbean;
import com.chenxin.domain.vobean;
import com.chenxin.service.productservice;
import com.chenxin.utils.Myconvert;


public class insertproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 Map<String,String> map=new HashMap<String,String>();
		 insertbean insertbean=new insertbean();
		
		
		
		   String tempPath = this.getServletContext().getRealPath("temp");
		   //创建文件解析对象
            DiskFileItemFactory dis=new DiskFileItemFactory();
            //设定使用内存超过5M时，将产生临时文件并存储于临时目录中 
            dis.setSizeThreshold(5*1024*1024); 
            
            // 设定存储临时文件的目录
            dis.setRepository(new File(tempPath)); 

            //创建上传文件实例
            ServletFileUpload upload = new ServletFileUpload(dis);
            upload.setHeaderEncoding("UTF-8");

         
            	//判断是否是文件上传表单
            try {
            boolean item= upload.isMultipartContent(request);
              if(item){
            	  //获取每一个表单项
            	    List<FileItem> parseRequest;
				
					parseRequest = upload.parseRequest(request);
					if(parseRequest!=null){
		            	 for (FileItem fileItem : parseRequest) {
		            		 //判断该表单是不是普通表单，是普通表单返回true
							boolean formField = fileItem.isFormField();
							if(formField){
								//获取该表单项的名称
								String fieldName = fileItem.getFieldName();
								//获取该表单项的value
								//fileItem.getString();//这个是不指定编码的
								String fieldValue = fileItem.getString("UTF-8");//指定编码
								
								map.put(fieldName, fieldValue);
						       
							}else{
								//获得文件的名称
								String name= fileItem.getName();
								//随机生成图片名称
								String namestr = UUID.randomUUID().toString()+name;
								if(name==null){
									request.setAttribute("filenull", "请选择文件");
									request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
									return;
								}
								//获得文件里面的内容,文件输入流
								InputStream in = fileItem.getInputStream();
								//获得存文件的绝对路径
								String uploadpath = "F:\\upload";
								//或得文件输出流
								OutputStream out=new FileOutputStream(uploadpath+"/"+namestr);
								//使用IO的工具类复制文件
								IOUtils.copy(in, out);
								//关闭流
								in.close();
								out.close();
								//关闭临时文件
								fileItem.delete();
								
								insertbean.setTushuimages(namestr);
								
								
							}
						} 
		            	
		              }
              }  
				}catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	  
             
               
				Date date=new Date();
				insertbean.setTushusjsj(date);
				//类型转换器
			  ConvertUtils.register( new Myconvert(),Date.class);
			    try {
			    	
					BeanUtils.populate(insertbean, map);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				productservice service=new productservice();
				
			    service.insertproductservice(insertbean);
				 
				response.sendRedirect(request.getContextPath()+"/producthoutai");
            }
	
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
