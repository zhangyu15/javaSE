package userdomain;
/*
 * 账号信息包括，账号，密码，姓名，是否为超级管理员
 */
public class UserAccount {
	private String id;
	private String password;
	private String name;
	private int superUser;
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAccount(String id, String password, String name,
			int superUser) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.superUser = superUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSuperUser() {
		return superUser;
	}
	public void setSuperUser(int superUser) {
		this.superUser = superUser;
	}
	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", password=" + password + ", name="
				+ name + ", superUser=" + superUser + "]";
	}
	
}
