package intern.sinc.project;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("TestDao")
public class TestDaoImpl implements TestDao {

	@Resource(name="sqlSession")
	private SqlSession session;
	
	@Override
	public Object SelectRow(Object obj) {
		System.out.println("Dao SelectRow");
		return session.selectOne("com.sinc.mybatis.test.selectOne",obj);
	}

}
