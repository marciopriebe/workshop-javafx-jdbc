package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartamentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao(); 
	
	public List<Department> fidAll(){		
		return dao.findAll();		
	}
}
