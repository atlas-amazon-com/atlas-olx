package payments;

import java.sql.*;
import java.util.Scanner;

public class Payments {
	Long PaymentID;
	Long ClassifiedID;
	Long UserID;
	Long PaymentMethodID;
	Long CartID;
	Double Amount;

	private static Scanner s = new Scanner(System.in);

	void readPayment() {
		System.out.println("Enter Payment ID:");
		PaymentID = Long.valueOf(s.nextLine().trim());

		System.out.println("Enter Classified ID");
		ClassifiedID = Long.valueOf(s.nextLine().trim());

		if (UserID == null) {
			// may not be required if session is maintained
			System.out.println("Enter User ID");
			UserID = Long.valueOf(s.nextLine().trim());
		}

		// show PaymentMethodID for user
		// let the user select an payment method ID

		System.out.println("Enter Payment Method ID");
		PaymentMethodID = Long.valueOf(s.nextLine().trim());

		System.out.println("Enter Cart Id:");
		CartID = Long.valueOf(s.nextLine().trim());

		System.out.println("Enter payment amount:");
		Amount = Double.valueOf(s.nextLine().trim());
	}

	void writeHead() {
		System.out.printf("%10s %13s %10s %13s %10s %10s%n", "PAYMENT_ID", "CLASSIFIED_ID", "USER_ID", "PMT_METHOD_ID",
				"CART_ID", "AMOUNT");
	}

	void readRecord(ResultSet r) throws SQLException {
		PaymentID = r.getLong(1);
		ClassifiedID = r.getLong(2);
		UserID = r.getLong(3);
		PaymentMethodID = r.getLong(4);
		CartID = r.getLong(5);
		Amount = r.getDouble(6);
	}

	void writeRow() {
		System.out.printf("%10d %13d %10d %13d %10d %10.2f%n", PaymentID, ClassifiedID, UserID, PaymentMethodID, CartID,
				Amount);
	}

	void writeResultSet(ResultSet r) throws SQLException {
		writeHead();
		while (r.next()) {
			readRecord(r);
			writeRow();
		}
	}

}
