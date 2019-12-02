package model.bean;

public class Users {
	private int id;
	private String userName;
	private String fullName;
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", fullName=" + fullName + "]";
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public Users(String userName, String fullName, int id) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.id = id;
	}
	
	
}
