package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		
		System.out.println("\n===== TEST 2: seller findByDepartment =====");
		Department dep = new Department(1, null);
		List<Seller> listSeller = sellerDao.findByDepartment(dep);
		listSeller.forEach(System.out::println);
		
		System.out.println("\n===== TEST 3: seller findAll =====");
		List<Seller> listSellerFindAll = sellerDao.findAll();
		listSellerFindAll.forEach(System.out::println);
		
		System.out.println("\n===== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "André Luiz", "and.ddias@gmail.com", sdf.parse("27/06/1983"), 3007.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
	}
}
