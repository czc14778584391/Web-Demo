package com.czc.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.czc.Model.Goods;
import com.czc.service.GoodsService;

/**
 * Servlet implementation class AdminUpdateDetailServlet
 */
@WebServlet("/admin/update_goodsDetail")
public class AdminUpdateDetailServlet extends HttpServlet {
	GoodsService gService=new GoodsService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int goodsId= Integer.parseInt(request.getParameter("id"));
		 DiskFileItemFactory factory=new DiskFileItemFactory();
		 ServletFileUpload upload=new ServletFileUpload(factory);
		 List<FileItem>list=null;
		 try {
			list=upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Goods g=gService.getGooddetail(goodsId);
		 
		 for(FileItem item:list) {
			 if(item.isFormField()) {
				 switch (item.getFieldName()) {
				case "name":
					g.setName(item.getString("utf-8"));
					break;
               case "price":
					g.setPrice(Float.parseFloat(item.getString("utf-8")));
					break;
               case "stock":
					g.setStock(Integer.parseInt(item.getString("utf-8")));
					break;
               case "intro":
					g.setIntro(item.getString("utf-8"));
					break;
               case "typeid":
					g.setTypeid(Integer.parseInt(item.getString("utf-8")));
					break;
				
				}
				 
			 }else {
				 if(item.getInputStream().available()<=0)continue;
				    String fileName = item.getName();
					fileName = fileName.substring(fileName.lastIndexOf("."));
					fileName = "/"+new Date().getTime()+fileName;
					String path = this.getServletContext().getRealPath("/picture")+fileName;
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(path);
					byte[] buffer = new byte[1024];
					int len=0;
					while( (len=in.read(buffer))>0 ) {
						out.write(buffer);
					}
				 in.close();
				 out.close();
				 item.delete();
				 
				 switch (item.getFieldName()) {
				case "cover":
					g.setCover("/picture"+fileName);
					break;

                case "image1":
					g.setImage1("/picture"+fileName);
					break;
                case "image2":
					g.setImage2("/picture"+fileName);
					break;
				default:
					break;
				}
				 
				
				 
			 }
		 }
	
			gService.updateGoods(g);

			response.sendRedirect(request.getContextPath()+"/admin/goods_list");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
