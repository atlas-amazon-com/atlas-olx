package payments;

import java.sql.SQLException;

public class PaymnetsUI {
	Payments p = new Payments();
	PaymentsDB pdb = new PaymentsDB();
	
	public void addPayment() throws ClassNotFoundException, SQLException {
		p.readPayment();
		int count = pdb.addPayment(p.ClassifiedID, p.UserID, p.PaymentMethodID, p.CartID, p.Amount);
		
		System.out.println(count + " payment saved.");
	}
	
	public void cancelPayment() throws ClassNotFoundException, SQLException {
		p.readPayment();
		int count = pdb.addPayment(p.ClassifiedID, p.UserID, p.PaymentMethodID, p.CartID, -p.Amount);
		System.out.println(count + " payment cancelled.");
	}

}
