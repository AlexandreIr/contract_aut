package model.services;

public interface OnlinePaymentService {
	double getINTERESTRATE();
	double getPAYMENTFEE();
	
	default double paymentFee(double amount) {
		return amount * getPAYMENTFEE();
	};

	default double interest(double amount, int months) {
		return amount + (amount * (getINTERESTRATE() * months));
	};
}
