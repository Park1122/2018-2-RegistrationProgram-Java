package global;

public class Constants {
	
	public static enum EDataFileName {
		path("data/"),
		root("root"),
		login("login"),
		inform("inform"),
		personalInfo("student");
		
		private String value;
		private EDataFileName(String value) {this.value = value;}
		public String getString() {return this.value;}
	}
	
	public static enum EMain {
		serialVersionUID("1"),
		name("이름:"),
		code("학번:"),
		major("학과:"),
		sex("성별:");
		
		private String value;
		private EMain(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EMainFrame {
		screen("Screen"),
		max("Max"),
		maxToolTip("Maximize Window"),
		hide("Hide"),
		hideToolTip("Minimize Window"),
		exit("Exit"),
		exitToolTip("Exit Window"),
		serialVersionUID("1"),
		title("수강신청"),
		width("1000"),
		height("600");
		
		private String value;
		private EMainFrame(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELoginDialog {
		serialVersionUID("1"),
		loginImage("resource/LoginImage.png"),
		width("550"),
		height("285"),
		login("Login"),
		nameLabel(" 아이디   "),
		nameTextSize("15"),
		passwordLabel("비밀번호"),
		passwordTextSize("15"),
		okButton("확인"),
		okImage("resource/LOGIN.jpg"),
		cancelButton("취소"),
		cancelImage("resource/CANCEL.png"),
		joinImage("resource/JOIN.png");
		
		private String value;
		private ELoginDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EPersonalInfoPanel {
		serialVersionUID("1"),
		lbInsaPostfix("님 안녕하세요"),
		btnInfo("개인정보"),
		btnLogout("로그아웃");
		
		private String value;
		private EPersonalInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EErrorDialog {
		serialVersionUID("1"),
		title("오류"),
		message("잘못 입력 했습니다");
		
		private String value;
		private EErrorDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EDirectoryPanel {
		serialVersionUID("1");
		
		private String value;
		private EDirectoryPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELecturePanel {
		serialVersionUID("1"),
		id("강좌번호"),
		name("강좌명"),
		professorName("담당교수"),
		credit("학점"),
		time("시간");
		
		private String value;
		private ELecturePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EBasketPanel {
		serialVersionUID("1"),
		name("강좌명"),
		professorName("교수명"),
		time("시간");
		
		private String value;
		private EBasketPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EInformPanel {
		serialVersionUID("1"),
		width("200"),
		height("200"),
		inform("님의 개인정보");
		
		private String value;
		private EInformPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EJoinPanel {
		serialVersionUID("1"),
		width("320"),
		height("320"),
		num("15"),
		join("회원가입"),
		name("   이름     "),
		id(" 아이디   "),
		password("비밀번호"),
		save("저장"),
		cancel("취소"),
		code("   학번     "),
		major("   학과     "),
		sex("   성별     ");
		
		private String value;
		private EJoinPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ERegistrationPanel {
		serialVersionUID("1"),
		basket("Basket"),
		result("Result");
		
		private String value;
		private ERegistrationPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}
