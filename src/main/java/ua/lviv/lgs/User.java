package ua.lviv.lgs;

public class User {
	private  String nameUser ;
	private String passwordUser;
	private String emailUser;
	public User(String nameUser, String passwordUser, String emailUser) {
		super();
		this.nameUser = nameUser;
		this.passwordUser = passwordUser;
		this.emailUser = emailUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	@Override
	public String toString() {
		return "User [nameUser=" + nameUser + ", passwordUser=" + passwordUser + ", emailUser=" + emailUser + "]";
	}

}
