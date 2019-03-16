package intern.sinc.project;

public class TestVO {
	private int user_id;
	private String name;
	private int gender;
	private int age;
	
	public TestVO(int user_id, String name, int gender, int age) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public TestVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "TestVO [user_id=" + user_id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
	
	
}
