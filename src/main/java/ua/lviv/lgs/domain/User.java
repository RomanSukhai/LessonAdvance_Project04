package ua.lviv.lgs.domain;

import java.util.Objects;

public class User {
	private Integer id;
	private String password;
	private String userEmail;
	private String userName;
	public User(Integer id, String password, String userEmail, String userName) {
		super();
		this.id = id;
		this.password = password;
		this.userEmail = userEmail;
		this.userName = userName;
	}
	
	public User(String password, String userEmail, String userName) {
		super();
		this.password = password;
		this.userEmail = userEmail;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, password, userEmail, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(password, other.password) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", userEmail=" + userEmail + ", userName=" + userName
				+ "]";
	}
	
}
