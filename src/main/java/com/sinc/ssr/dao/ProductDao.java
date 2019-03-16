package com.sinc.ssr.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDao {

	@Resource(name="sqlSession")
	private SqlSession session;
}
