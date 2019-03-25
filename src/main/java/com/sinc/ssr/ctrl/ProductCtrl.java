package com.sinc.ssr.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.ssr.service.ProductService;
import com.sinc.ssr.vo.ProductVO;


@Controller
public class ProductCtrl {
	
	@Resource(name="productService")
	private ProductService productService;
	
	@RequestMapping("/product.do") 
	@ResponseBody
	public ArrayList<Object> getProducts(String dummy1, String dummy2) { 
		
		System.out.println("long : " + dummy1 + "lati : "  );
		
		ArrayList<Object> productList =  productService.getRecomProducts();
		System.out.println(productList);
		return productList;
	}
	
	@RequestMapping("/checkPush.do") 
	@ResponseBody
	public int checkPushNotice(String user_id, String dummy2) { 
		System.out.println("inside checkpushctrl :" + user_id);
		int check = productService.checkPushNotice(user_id);
		System.out.println(check);
		
		return check;
	}
	
	
}
