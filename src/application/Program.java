package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		
		System.out.println("\n===== TEST 2: seller findByDepartment =====");
		Department dep = new Department(4, null);
		List<Seller> listSeller = sellerDao.findByDepartment(dep);
		listSeller.forEach(System.out::println);
		
		System.out.println("\n===== TEST 3: seller findAll =====");
		List<Seller> listSellerFindAll = sellerDao.findAll();
		listSellerFindAll.forEach(System.out::println);
		
		
	}

}
