package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;

public class App {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Número: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("data (dd/mm/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
		System.out.print("Valor do contrato: ");
		double contractValue = sc.nextDouble();
		sc.nextLine();
		System.out.print("Número de parcelas: ");
		int instNumb = sc.nextInt();
		
		Contract contract = new Contract(number, date, contractValue);
		ContractService cs = new ContractService();
		List<Installment> installments = cs.processContract(contract, instNumb);

		for(Installment inst :installments) {
			System.out.println("Parcela #"+inst.getinstallmentNumber()+":");
			System.out.println("Data de vencimento: "+dtf.format(inst.getDueDate())+" - "+"Valor: "+inst.getAmount());
		}
		
		sc.close();
	}
}
