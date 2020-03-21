package dbConnection;

import java.sql.*;

public class MainClass {

	public static void main(String[] args) {

		try {
			CartUI u = new CartUI();
			
			//u.addToCart();
			
			u.approveBidForSeller();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(" -: Thanks Visit Again :- ");
	}

}
