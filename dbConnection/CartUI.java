package dbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CartUI {
	static Cart c = new Cart();
	
	private Scanner s= new Scanner(System.in);;

	public void addToCart() throws ClassNotFoundException, SQLException {
		bidForClassified();
	}

	private void bidForClassified() throws ClassNotFoundException, SQLException {

		Object ClassifiedId, BidPrice, BidderID;
		
		System.out.println("Enter Classified Id");
		ClassifiedId = s.nextLine();
		System.out.println("Enter Bid Price");
		BidPrice = s.nextLine();
		System.out.println("Enter Bidder ID"); //may not be required if session is maintained
		BidderID = s.nextLine();
		
		int count = c.addToCart(ClassifiedId, BidPrice, BidderID);
		
//		int count = c.addToCart( 4, 90, 103);
		System.out.println(count + " records added");
	}

	public void approveBidForClassified() throws ClassNotFoundException, SQLException {
		s = new Scanner(System.in);
		Object ClassifiedId;
		System.out.println("Enter Classified Id");
		ClassifiedId = s.nextLine();
		
		ResultSet r = c.getBidsForClassified(ClassifiedId);
		String out = String.format("%10s %13s %10s %10s %10s", "CART_ID", "CLASSIFIED_ID", "BIDPRICE", "STATUS",
				"BIDDER_ID");
		System.out.println(out);
		while (r.next()) {
			// CART_ID, CLASSIFIED_ID, BIDPRICE, STATUS, BIDDER_ID
			out = String.format("%10.0f %13.0f %10.2f %10s %10.0f", r.getDouble(1), r.getDouble(2), r.getDouble(3),
					r.getString(4), r.getDouble(5));
			System.out.println(out);
		}
		System.out.println("Enter Cart Id to approve.");
		Object CartID = s.nextLine();
		int apCnt = c.approveBid(CartID);
		System.out.println(apCnt + " bids approved in cart.");
	}

	public void approveBidForSeller() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter Seller Id");
		Object Seller = s.nextLine();
		//get userid of logged in user
		
		ResultSet r = c.getBidsForSeller( Seller);
		String out = String.format("%10s %13s %10s %10s %10s", 
				"CART_ID", "CLASSIFIED_ID", "BIDPRICE", "STATUS","BIDDER_ID");
		System.out.println(out);
		
		while (r.next()) {
			// CART_ID, CLASSIFIED_ID, BIDPRICE, STATUS, BIDDER_ID
			out = String.format("%10.0f %13.0f %10.2f %10s %10.0f", r.getDouble(1), r.getDouble(2), r.getDouble(3),
					r.getString(4), r.getDouble(5));
			System.out.println(out);
		}
		
		System.out.println("Enter Cart Id to approve.");
		Object CartID = s.nextLine();
		
		int apCnt = c.approveBid(CartID);
		System.out.println(apCnt + " bids approved in cart.");
	}

}
