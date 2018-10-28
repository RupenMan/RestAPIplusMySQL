package edu.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	

	public List<Employee> findAll(){
		List<Employee> employees = null;
		
		Connection conn = DatabaseConnection.getDBConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			employees = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int salary = rs.getInt(3);
				String dept = rs.getString(4);
				
				employees.add(new Employee(id, name, dept, ""+salary));
			}
			
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public Employee save(Employee emp) {
		String query ="INSERT INTO employee values(?,?,?,?)";
		Connection conn = DatabaseConnection.getDBConnection();
		try {
			PreparedStatement pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, Integer.parseInt(emp.getSalary()));
			pStmt.setString(4, emp.getDept());
			pStmt.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return emp;
	}
	
	public Employee update(Employee emp) {
		String query = "UPDATE employee SET name=?,salary=?,dept=? WHERE id=?";
		Connection conn = DatabaseConnection.getDBConnection();
		try {
			PreparedStatement pStmt = conn.prepareStatement(query);
			pStmt.setString(1, emp.getName());
			pStmt.setInt(2, Integer.parseInt(emp.getSalary()));
			pStmt.setString(3, emp.getDept());
			pStmt.setInt(4, emp.getId());
			pStmt.executeUpdate();
		}catch(SQLException ex) {
			
		}
		return emp;
	}
	
	public Employee delete(Employee emp) {
		String query = "DELETE FROM employee WHERE id=?";
		Connection conn = DatabaseConnection.getDBConnection();
		try {
			PreparedStatement pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, emp.getId());
			pStmt.executeUpdate();
		}catch(SQLException ex) {
			
		}
		return emp;
	}
	
	public Employee findById(int id) {
		String query = "Select * FROM employee WHERE id=?";
		Connection conn = DatabaseConnection.getDBConnection();
		Employee employee= null;
		try {
			PreparedStatement pStmt = conn.prepareStatement(query);
			pStmt.executeQuery();
		}catch(SQLException ex) {
			
		}
		return employee;
	}
}
