package olx;

import java.sql.SQLException;

import cart.CartUI;
import dbConnect.DBConnection;

public class OlxMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		writeProperty();
		readProperty();
		
		
//		CartUI cui = new CartUI();
//		cui.addToCart();
		
//		UserUI u;
//		u.login();
//		if(u.isAdmin())
//		{
//			
//			u.AdminMenu();
//		}
//		else{
//			u.UserMenu();
//		}
		
	}
	
	public static void writeProperty(){
				DBConnection.writeProperty();
	}
	public static void readProperty() {
		DBConnection.readProperty();
	}

}
