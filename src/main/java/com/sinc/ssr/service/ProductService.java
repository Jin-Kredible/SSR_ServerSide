package com.sinc.ssr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.ssr.dao.ProductDao;

@Service("productService")
public class ProductService {
	
	@Resource(name="productDao")
	private ProductDao productDao;
}
