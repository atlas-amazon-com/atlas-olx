import java.util.*;

public class User{

	public static void main(String[] args) {
		Scanner ss=new Scanner(System.in);
		while(true) {
		System.out.println("Enter the option you would like to proceed with");
		System.out.println("1. Sign In");
		System.out.println("2. Sign Up");
		int value=ss.nextInt();
		if(value==1) {
			signIn();	
			break;
		}
		else if(value==2) {
			signUp();
			break;
		}
		else {
			System.out.println("Please select the correct option");
			}
		}
	}
	static void signIn() {
		//email e=new email();
		//e.verifyEmail();
		//password p=new password();
		//p.verifyPassword();
	}
	static void signUp() {
//		name n= new name();
//		n.profileName();
//		phoneNo ph= new phoneNo();
//		ph.validatePhoneNo();
//		email em= new email();
//		em.readEmail();
//		password pw= new password();
//		pw.readPassword();
	}
}
