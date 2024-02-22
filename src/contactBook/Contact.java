package contactBook;

public class Contact {
	private String name;
	private String phnNo;
	private String mail;
	Contact(String name,String phnNo,String mail)
	{
		this.name = name;
		this.phnNo = phnNo;
		this.mail = mail;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhnNo() {
		return phnNo;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phnNo=" + phnNo + ", mail=" + mail + "]";
	}
	
	
	

}
