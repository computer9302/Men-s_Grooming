package dto;

public class MemberDto {
	private String MEMBER_ID;
	private String pass_word;
	private String pass_word2;
	private String address;
	private String phone_number;
	private String e_mail;
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String member_id, String pass_word, String pass_word2, String address, String phone_number,
			String e_mail) {
		super();
		this.MEMBER_ID = member_id;
		this.pass_word = pass_word;
		this.pass_word2 = pass_word2;
		this.address = address;
		this.phone_number = phone_number;
		this.e_mail = e_mail;
	}

	public String getMember_id() {
		return MEMBER_ID;
	}

	public void setMember_id(String member_id) {
		this.MEMBER_ID = member_id;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getPass_word2() {
		return pass_word2;
	}

	public void setPass_word2(String pass_word2) {
		this.pass_word2 = pass_word2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	
	
	
	
}
