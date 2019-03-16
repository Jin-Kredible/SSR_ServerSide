package intern.sinc.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestCtrl {
	@Resource(name="TestService")
	private TestService testService;
	
	
	@RequestMapping(value="/test/android.do")
	@ResponseBody
	public TestVO androidlogin(TestVO test) {
		System.out.println("android Login ctrl!");
		System.out.println(test);
		Object result = testService.SelectFromDB(test);
		System.out.println(result);
		return (TestVO)result;
}
	
}
