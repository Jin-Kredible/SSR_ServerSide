package intern.sinc.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("TestService")
public class TestServiceImpl implements TestService {

	@Resource(name="TestDao")
	private TestDao dao; 
	
	@Override
	public Object SelectFromDB(Object obj) {
		System.out.println("Service Login");
		return dao.SelectRow(obj);
	}

}
