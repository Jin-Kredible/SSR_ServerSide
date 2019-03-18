package com.sinc.ssr.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.ssr.vo.ProductVO;

@Repository("productDao")
public class ProductDao {

	@Resource(name="sqlSession")
	private SqlSession session;
	
	
	public ArrayList<Object> getProductsByUser(ProductVO productVo, int randomTrend) {
		
		ArrayList<Object> productList = null;
		System.out.println(randomTrend + "in dao");
		
		//Testing 용으로 셋팅
		randomTrend = 2;
		
		switch(randomTrend) {
		case 0: productList = (ArrayList<Object>) session.selectList("com.sinc.ssr.mybatis.product.getTrendA",productVo);
				break;
		case 1: productList = (ArrayList<Object>) session.selectList("com.sinc.ssr.mybatis.product.getTrendB",productVo);
				break;
		case 2: productList = (ArrayList<Object>) session.selectList("com.sinc.ssr.mybatis.product.getTrendC",productVo);
		        break; 
		case 3: productList = (ArrayList<Object>) session.selectList("com.sinc.ssr.mybatis.product.getTrendD",productVo);
		        break;
		}
		
		ProductVO productVo2 = new ProductVO();
		for(int i =1; i < 93; i++) {
			
			String path = "/recomproducts/";
			path = path + Integer.toString(i) +".jpg";
			System.out.println("path" + path);

			productVo2.setItem_img_path(path);
			productVo2.setAge(i);
		session.update("com.sinc.ssr.mybatis.product.updateRows",productVo2);
		}
		return productList;
	}
}
