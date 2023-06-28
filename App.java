package kodnestbank.com.BankApp;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	UserDAOimpl ref=new UserDAOimpl();
		System.out.println("Hello Welcome To Kodnest Bank");
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.printf("\n\n1) Registration\n2) Login\n3) Check Balance\n4) Transfer Amount\n5) Update Profile\n6) Delete Account\n7) View Profile\n*) Stop\n");
			System.out.println("Enter your choice");
			int ch=scan.nextInt();
			switch(ch)
			{
			case 1:{
				System.out.println("\n\nEnter Name,Amount,Password,Email-Id and Phone Number in same order");
				user u=new user(scan.next(),scan.nextInt(),scan.next(),scan.next(),scan.next());
				ref.Register(u);
				break;
				}
			case 2:{
				System.out.println("Enter Account Number And Password");
				ref.Login(scan.nextInt(),scan.next());
				break;
				}
			case 3:
			{

				System.out.println("Enter Account Number And Password");
				ref.checkBalance(scan.nextInt(),scan.next());
				break;
			}
			case 4:
			{
				System.out.println("Enter Account Number And Password");
				ref.transferAmount(scan.nextInt(),scan.next());
				break;
			}
			case  5:{

				System.out.println("Enter Account Number And Password");
				ref.updateProfile(scan.nextInt(),scan.next());
				break;
			}
			case 6:
			{
				System.out.println("Enter Account Number And Password");
				ref.deleteAccount(scan.nextInt(),scan.next());
				break;
			}
			case 7:
			{
				System.out.println("Enter Account Number And Password");
				ref.viewProfile(scan.nextInt(),scan.next());
				break;
			}
			default:
			{
				System.out.println("Thank you for Using KodnestBank's Online Services");
				System.exit(0);
			}
			scan.close();
			}
		}
	
	
	}
}
