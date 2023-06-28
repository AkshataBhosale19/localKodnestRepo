package kodnestbank.com.BankApp;

public interface UserDAO {
	public void Register(user obj);
	public void Login(int AccNo,String password);
	public void viewProfile(int AccNo,String password);
	public void checkBalance(int AccNo,String password);
	public void transferAmount(int AccNo,String password);
	public void updateProfile(int AccNo,String password);
	public void deleteAccount(int AccNo,String password);
	

}
