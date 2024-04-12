package model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	public List<Installment> processContract(Contract contract, Integer months){
		List<Installment> installments = new ArrayList<Installment>();
		PaypalService pps = new PaypalService();
		LocalDate dueDate = contract.getDate();
		
		double contractInstallment = contract.getTotalValue()/months;
		for(int i=1;i<=months;i++) {
			double contractWithFee = pps.paymentFee(contractInstallment);
			double contractWithInterest = pps.interest(contractWithFee, i);
			dueDate = dueDate.plusMonths(1);
			Installment isnt = new Installment(dueDate, contractWithInterest, i);
			installments.add(isnt);
		}		
		return installments;
		
	}
}
