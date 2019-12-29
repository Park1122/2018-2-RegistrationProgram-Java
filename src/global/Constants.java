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
		name("�̸�:"),
		code("�й�:"),
		major("�а�:"),
		sex("����:");
		
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
		title("������û"),
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
		nameLabel(" ���̵�   "),
		nameTextSize("15"),
		passwordLabel("��й�ȣ"),
		passwordTextSize("15"),
		okButton("Ȯ��"),
		okImage("resource/LOGIN.jpg"),
		cancelButton("���"),
		cancelImage("resource/CANCEL.png"),
		joinImage("resource/JOIN.png");
		
		private String value;
		private ELoginDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EPersonalInfoPanel {
		serialVersionUID("1"),
		lbInsaPostfix("�� �ȳ��ϼ���"),
		btnInfo("��������"),
		btnLogout("�α׾ƿ�");
		
		private String value;
		private EPersonalInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EErrorDialog {
		serialVersionUID("1"),
		title("����"),
		message("�߸� �Է� �߽��ϴ�");
		
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
		id("���¹�ȣ"),
		name("���¸�"),
		professorName("��米��"),
		credit("����"),
		time("�ð�");
		
		private String value;
		private ELecturePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EBasketPanel {
		serialVersionUID("1"),
		name("���¸�"),
		professorName("������"),
		time("�ð�");
		
		private String value;
		private EBasketPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EInformPanel {
		serialVersionUID("1"),
		width("200"),
		height("200"),
		inform("���� ��������");
		
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
		join("ȸ������"),
		name("   �̸�     "),
		id(" ���̵�   "),
		password("��й�ȣ"),
		save("����"),
		cancel("���"),
		code("   �й�     "),
		major("   �а�     "),
		sex("   ����     ");
		
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
