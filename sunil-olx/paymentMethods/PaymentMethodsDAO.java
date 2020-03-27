package paymentMethods;

import java.sql.ResultSet;

import dbConnect.DBConnection;

public class PaymentMethodsDAO implements IPaymentMethodsDAO {

	@Override
	public int addPaymentMethods(PaymentMethods pm) {
		return DBConnection.executeQueryFormat(
				);

	}

	@Override
	public int updateCard(PaymentMethods pm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCard(Long pmID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet getPaymentMethods(Long userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
