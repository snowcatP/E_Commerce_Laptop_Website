package model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class AdminAccount implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminAcountId;
	
	@OneToOne
	private Admin admin;
	
	@Column(unique=true)
	private String userName;
	private String passWord = "admin";
	
	
	public Long getAdminAcountId() {
		return adminAcountId;
	}

	public void setAdminAcountId(Long adminAcountId) {
		this.adminAcountId = adminAcountId;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
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
	
	public AdminAccount(Long adminAcountId, Admin admin, String userName, String passWord) {
		this.adminAcountId = adminAcountId;
		this.admin = admin;
		this.userName = userName;
		this.passWord = passWord;
	}

	public AdminAccount() {
		
	}
}
