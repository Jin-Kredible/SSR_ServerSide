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
		
	
		return productList;
	}
}
