package com.sinc.ssr.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.sinc.ssr.service.ProductService;

@Controller
public class ProductCtrl {
	
	@Resource(name="productService")
	private ProductService productService;
}
