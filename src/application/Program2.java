package application;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmetDao();
		
		System.out.println("===== TEST 1: Department findById =====");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);

		System.out.println("\n===== TEST 2: Department findAll =====");
		List<Department> listDepFindAll = departmentDao.findAll();
		listDepFindAll.forEach(System.out::println);
		
		System.out.println("\n===== TEST 3: Department insert =====");
		Department newDep = new Department(null, "Admin");
		
		//Comentado para parar de inserir informações no banco de dados
		departmentDao.insert(newDep);
		System.out.println("Inserted! new id = " + newDep.getId());
		
		System.out.println("\n===== TEST 4: Department update =====");	
		System.out.println("Informações do banco de dados antes da alteração: ");
		
		Department depUpdate = departmentDao.findById(7);
		System.out.println(depUpdate);
				
		//update de um objeto já instanciado de Seller
		depUpdate.setName("Financeiro");
		
		departmentDao.update(depUpdate);
		System.out.println("Informações do banco de dados após alteração: ");
		System.out.println(departmentDao.findById(7));
		
		System.out.println("\n===== TEST 5: seller delete =====");	
		System.out.print("Digite o id que deseja deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Id: " + id + " Deletado com Sucesso, Agora o valor deste ID está: " + departmentDao.findById(id));
		
		sc.close();
	}
}
