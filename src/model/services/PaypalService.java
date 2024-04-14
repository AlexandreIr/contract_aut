package model.services;

public class PaypalService implements OnlinePaymentService {
	private final double INTERESTRATE=0.01;
	private final double PAYMENTFEE=1.02;
	
	public double getINTERESTRATE() {
		return INTERESTRATE;
	}

	public double getPAYMENTFEE() {
		return PAYMENTFEE;
	}
}
