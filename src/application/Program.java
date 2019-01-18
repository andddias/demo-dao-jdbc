package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Department department = new Department(1, "Financeiro");
		
		Seller seller = new Seller(10, "ANDRÉ LUIZ", "and.ddias@gmail.com", sdf.parse("27/06/1983"), 3007.0, department);
		
		System.out.println(seller);

	}

}
