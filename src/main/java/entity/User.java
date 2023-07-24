package entity;

/*
 * /// pwd업데이트 추가시
 * user entity에서 생성자 맞추고 순서 중요
 * userDao에서 sql문에 pwd추가해주기
 * userController에서 pwd,pwd2,hashedpwd 받고
 * 패스워드 변경하면 pwd,pwd2 동일한지 확인하고 변경한pwd로 업데이트해주고
 * pwd,pwd2가 빈칸이면 기존pwd가져가기로 controller update추가해줘야함
 */
import java.time.LocalDate;

public class User {
	private String uid;
	private String pwd;
	private String uname;
	private String email;
	private LocalDate regDate;
	private int isDeleted;
	private String profile;
	private String addr;
	
	public User() { }
	
	// update할 때 pwd제외였으나 추가해보자
	public User(String uid, String uname, String email, String profile, String addr) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.profile = profile;
		this.addr = addr;
	}	
	
	// insert할 때 default값 제외한 생성자 
	// pwd 추가 이 생성자 사용할건데 순서 이거와 맞게 컨트롤러에서사용
	public User(String uid, String pwd, String uname, String email, String profile, String addr) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.profile = profile;
		this.addr = addr;
	}
	
	public User(String uid, String pwd, String uname, String email, LocalDate regDate, int isDeleted, String profile,
			String addr) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.regDate = regDate;
		this.isDeleted = isDeleted;
		this.profile = profile;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", email=" + email + ", regDate=" + regDate
				+ ", isDeleted=" + isDeleted + ", profile=" + profile + ", addr=" + addr + "]";
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
