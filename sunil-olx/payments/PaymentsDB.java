package payments;

import java.sql.SQLException;
import dbConnect.DBConnection;

public class PaymentsDB {
	public int addPayment(Long ClassifiedId,Long UserId,Long PaymentMethodId,Long CartId,Double Amount)
			throws ClassNotFoundException, SQLException {
		return DBConnection.executeUpdateFormat(
				"INSERT INTO PAYMENTS(CLASSIFIED_ID,USER_ID,PAYMENT_METHOD_ID,CART_ID,AMOUNT)" + 
				"VALUES(%s,%s,%s,%s,%10.2f)", 
				 ClassifiedId.toString(), UserId.toString(), PaymentMethodId.toString(),CartId.toString(), Amount);
	}
	
//	public int cancelPayment(Long ClassifiedId,Long UserId,Long PaymentMethodId,Long CartId,Double Amount)
//			throws ClassNotFoundException, SQLException {
//		return DBConnection.executeUpdateFormat(
//				"INSERT INTO PAYMENTS(CLASSIFIED_ID,USER_ID,PAYMENT_METHOD_ID,CART_ID,AMOUNT)" + 
//				"VALUES(%s,%s,%s,%s,%10.2f)", 
//				 ClassifiedId.toString(), UserId.toString(), PaymentMethodId.toString(),CartId.toString(), Amount);
//	}
}
