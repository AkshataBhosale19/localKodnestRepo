package kodnestbank.com.BankApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class user {
	@Id
	@Column(name="AccNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int AccNo;
	@Column(name="Name")
	String name;
	@Column(name="Amount")
	int amount;
	@Column(name="Password")
	String password;
	@Column(name="Email")
	String email;
	@Column(name="Phone")
	String phone;
	
	public user() {
		// TODO Auto-generated constructor stub
	}
	public user(String name, int amount, String password, String email, String phone) {
		super();
		this.name = name;
		this.amount = amount;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accNo) {
		AccNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "user [AccNo=" + AccNo + ", name=" + name + ", amount=" + amount + ", password=" + password + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
	

}
