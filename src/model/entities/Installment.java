package model.entities;

import java.time.LocalDate;

public class Installment {
	private LocalDate dueDate;
	private double amount;
	private int installmentNumber;
	
	public Installment() {}

	public Installment(LocalDate dueDate, double amount, int installmentNumber) {
		this.dueDate = dueDate;
		this.amount = amount;
		this.installmentNumber = installmentNumber;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getinstallmentNumber() {
		return installmentNumber;
	}

	public void setinstallmentNumber(int installmentNumber) {
		this.installmentNumber = installmentNumber;
	}
}
