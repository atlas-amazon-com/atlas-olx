package paymentMethods;

import java.sql.ResultSet;

public interface IPaymentMethodsDAO {
	int addPaymentMethods(PaymentMethods pm);
	int updateCard(PaymentMethods pm);
	int deleteCard(Long pmID);
	ResultSet getPaymentMethods(Long userID);
}
