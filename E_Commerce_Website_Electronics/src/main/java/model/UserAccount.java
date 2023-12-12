package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class UserAccount implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userAccountId;
	
	@OneToOne
	private User user;
	@Column(unique=true)
	private String userName;
	private String passWord;
	
	
	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}	
}
