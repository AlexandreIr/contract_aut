package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	
	public ContractService (OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	public void processContract(Contract contract, Integer months) {
		

		double contractInstallment = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			double contractWithFee = onlinePaymentService.paymentFee(contractInstallment);
			double contractWithInterest = onlinePaymentService.interest(contractWithFee, i);
			LocalDate dueDate = contract.getDate().plusMonths(i);
			Installment isnt = new Installment(dueDate, contractWithInterest, i);
			contract.getInstallmentes().add(isnt);
		}

	}
}
