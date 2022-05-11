package inventory_management_vo;

import java.io.Serializable;

public class Admin implements Serializable{
	
	String admin_id;
	String admin_pw; 
	String admin_name;
	String admin_email; 
	
	public Admin() {
	}

	public Admin(String admin_id, String admin_pw, String admin_name, String admin_email) {
		super();
		this.admin_id = admin_id;
		this.admin_pw = admin_pw;
		this.admin_name = admin_name;
		this.admin_email = admin_email;
	}
	
	
	

	public Admin(String admin_id, String admin_pw) {
		super();
		this.admin_id = admin_id;
		this.admin_pw = admin_pw;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pw() {
		return admin_pw;
	}

	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_pw=" + admin_pw + ", admin_name=" + admin_name
				+ ", admin_email=" + admin_email + "]";
	}
	
	
	
	
}
