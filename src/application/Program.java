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
		Seller newSeller = new Seller(null, "Andr� Luiz", "and.ddias@gmail.com", sdf.parse("27/06/1983"), 3007.0, dep);
		
		//Comentado para parar de inserir informa��es no banco de dados
		//sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println("\n===== TEST 5: seller update =====");	
		System.out.println("Informa��es do banco de dados antes da altera��o: ");
		
		Seller sellerUpdate = sellerDao.findById(10);
		System.out.println(sellerUpdate);
		
		//Update a partir de uma nova instacia de Seller		
		//sellerDao.update(new Seller(10, "Andr� Luiz Alves Dias", "and.ddias@gmail.com", sdf.parse("27/06/1983"), 12345.99, dep));;
		
		//update de um objeto j� instanciado de Seller
		sellerUpdate.setName("Andr� Dias");
		sellerUpdate.setBaseSalary(25638.65);
		sellerDao.update(sellerUpdate);
		System.out.println("Informa��es do banco de dados ap�s altera��o: ");
		System.out.println(sellerDao.findById(10));
		
		System.out.println("\n===== TEST 6: seller delete =====");	
		System.out.println("Informa��es do banco de dados antes da altera��o: ");
		System.out.println(sellerDao.findById(12));
		
		sellerDao.deleteById(12);
		
		System.out.println("Informa��es do banco de dados ap�s altera��o: ");
		System.out.println(sellerDao.findById(12));
		
	}
}
