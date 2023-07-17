package entity;


import java.time.LocalDateTime;

public class Board {
	private int bid;
	private String uid;
	private String title;
	private String content;
	private LocalDateTime modTime;
	private int viewCount;
	private int replyCount;
	private int isDelted;
	private String files;
	private String uname; // users table과 join한 결과를 받기 위해 추가 uid를 안보여주고 uname을 보여주려고
	
	
	// 기본 생성자
	public Board() { }
	
	// 게시글 생성시 필요한 생성자
	public Board(String uid, String title, String content, String files) {
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.files = files;
	}
	
	// update할때 게시글 수정시 필요한 생성자 bid필요
	public Board(int bid, String uid, String title, String content, String files) {
		this.bid = bid;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.files = files;
	}
	//게시글 목록 조회시 필요한 생성자 content, uid필요x
	public Board(int bid, String title, LocalDateTime modTime, int viewCount, int replyCount, String files,
			String uname) {
		this.bid = bid;
		this.title = title;
		this.modTime = modTime;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.files = files;
		this.uname = uname;
	}

	public Board(int bid, String uid, String title, String content, LocalDateTime modTime, int viewCount,
			int replyCount, int isDelted, String files, String uname) {
		this.bid = bid;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.isDelted = isDelted;
		this.files = files;
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", uid=" + uid + ", title=" + title + ", content=" + content + ", modTime="
				+ modTime + ", viewCount=" + viewCount + ", replyCount=" + replyCount + ", isDelted=" + isDelted
				+ ", files=" + files + ", uname=" + uname + "]";
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getModTime() {
		return modTime;
	}

	public void setModTime(LocalDateTime modTime) {
		this.modTime = modTime;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getIsDelted() {
		return isDelted;
	}

	public void setIsDelted(int isDelted) {
		this.isDelted = isDelted;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	
}
