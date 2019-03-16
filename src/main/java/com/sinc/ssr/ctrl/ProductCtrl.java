package com.sinc.ssr.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.ssr.service.ProductService;

@Controller
public class ProductCtrl {
	
	@Resource(name="productService")
	private ProductService productService;
	
	@RequestMapping("/product.do") 
	@ResponseBody
	public void androidTestWithRequestAndResponse(String longitude, String latitude) { 
		
		System.out.println("long : " + longitude + "lati : " + latitude);
		
		
	}
}
