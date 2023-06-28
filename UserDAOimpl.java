package kodnestbank.com.BankApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class UserDAOimpl implements UserDAO{
	Scanner scan=new Scanner(System.in);
	SessionFactory sf=null;
	public SessionFactory getSessionFactory()
	{
		if(sf==null) {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.build();
			sf = configuration.buildSessionFactory(serviceRegistry);
			return sf;
		}
		return sf;

	}

	@Override
	public void Register(user obj) {
		Session session=null;
		try{
		sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		session.persist(obj);
		session.getTransaction().commit();
		System.out.println("Registration Successfull");
		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error:: Please try again");
		}
		finally {
			session.close();
		}
	}

	@Override
	public void Login(int AccNo,String pass) {

		Session session=null;
		try{
		sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		user u= (user) session.get(user.class,AccNo);
		if(u.getPassword().equals(pass)) {
			System.out.println("Login Successfull\n\n ");
			System.out.println(u);
		}
		else {
			System.out.println("Error : Invalid Password : Please try again");
		}
		
		}
		catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error : Please try again");
		}
		finally {
		session.close();
	}
	}

	@Override
	public void viewProfile(int AccNo,String password) {

		Session session=null;
		try{
		sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		user u= (user) session.get(user.class,AccNo);
		
		if(u.getPassword().equals(password)){
			
			System.out.println(u);
			
		}
		else {
			System.out.println("Error : Invalid Password : Please try again");
		}
		
		}
		catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error : Please try again");
		}
		finally {
		session.close();
	}
	}

	@Override
	public void checkBalance(int AccNo,String password) {

		Session session=null;
		try{
		sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		user u= (user) session.get(user.class,AccNo);
		if(u.getPassword().equals(password)){
			
			System.out.println("\nYour Balance is "+u.getAmount());
		}
		else {
			System.out.println("Error : Invalid Password : Please try again");
		}
		
		}
		catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error : Please try again");
		}
		finally {
		session.close();
	}
	}

	@Override
	public void transferAmount(int AccNo,String password) {

		Session session=null;
		try{
		sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		user u= (user) session.get(user.class,AccNo);
		if(u != null && u.getPassword().equals(password)){
			System.out.println("Enter the Account Number to which you want to tranfer amount");
			int toacc=scan.nextInt();
			user u1=(user) session.get(user.class, toacc);
			
			System.out.println("Enter the Amount you want to tranfer");
			int amount=scan.nextInt();

			int amt=u.getAmount();
			if(amt<amount)
			{
				System.out.println("Amount is Insufficient");
			}
			else {
				int amt1=u1.getAmount();
			u1.setAmount( amt1+amount);
			session.update(u1);
			u.setAmount(amt-amount);
			session.update(u);
			session.getTransaction().commit();
			 System.out.println("Amount transferred successfully!");
			}
			
		}
		else {
			System.out.println("Error : Invalid Password : Please try again");
		}
		
		}
		catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error : Please try again");
		}
		finally {
		session.close();
	}
	}

	@Override
	public void updateProfile(int AccNo,String password) {

		Session session=null;
		try{
		sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		user u= (user) session.get(user.class,AccNo);
		if(u.getPassword().equals(password)){
			System.out.println("1) name,2)email,3)password,4)phone number\nEnter your choice to update");
			int up=scan.nextInt();
			if(up==1)
			{
				System.out.println("Enter New Name");
				u.setName(scan.next());
				session.update(u);
				session.getTransaction().commit();
				System.out.println("Updation Successfull");
			}
			else if(up==2)
			{
				System.out.println("Enter New Email-Id");
				u.setEmail(scan.next());
				session.update(u);
				session.getTransaction().commit();
				System.out.println("Updation Successfull");
				
			}else if(up==3)
			{
				System.out.println("Enter New Password");
				u.setPassword(scan.next());
				session.update(u);
				session.getTransaction().commit();
				System.out.println("Updation Successfull");
				
			}else if(up==4)
			{
				System.out.println("Enter New Phone Number");
				u.setPhone(scan.next());
				session.update(u);
				session.getTransaction().commit();
				System.out.println("Updation Successfull");
				
			}
			else
			{
				System.out.println("Invalid number");
			}
			
		}
		else {
			System.out.println("Error : Invalid Password : Please try again");
		}
		
		}
		catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error : Please try again");
		}
		finally {
		session.close();
	}
	}

	@Override
	public void deleteAccount(int AccNo,String password) {

		Session session=null;
		try{
		sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		user u= (user) session.get(user.class,AccNo);
		if(u.getPassword().equals(password)){
			session.delete(u);
			session.getTransaction().commit();
			System.out.println("Deletion Successfull ");
		}
		else {
			System.out.println("Error : Invalid Password : Please try again");
		}
		
		}
		catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error : Please try again");
		}
		finally {
		session.close();
	}
	}
	
}
