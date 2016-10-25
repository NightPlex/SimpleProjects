import java.sql.*;
import java.util.*;

public class SqlConnection {
	
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7141584";
		
		conn = DriverManager.getConnection(url, "sql7141584", "q9snpTQ9du");
		
	
		return conn;
		
	}
	
	public boolean addUser(String firstName, String lastName, String username, 
			String password){
		
		Random random = new Random();
		String temp = "";
		
		for (int i = 0; i < 9; i++) {
			
			temp = temp + random.nextInt(9);
			
		}
		System.out.println(temp);
		
		int accountNumber = Integer.parseInt(temp);
		
		try{
		
		String statement = "INSERT INTO BankUsers (firstName, lastName, username, password, accountNumber, credits) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement prepStatement = getConnection().prepareStatement(statement);
		
		prepStatement.setString(1, firstName);
		prepStatement.setString(2, lastName);
		prepStatement.setString(3, username);
		prepStatement.setString(4, password);
		prepStatement.setInt(5, accountNumber);
		prepStatement.setDouble(6, 100.00);
		
		prepStatement.executeQuery();
		
		return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
			
		}
		
	}
	
	
	public double getCredits(String username) {
		
		try {
			
				String statement = "SELECT credits FROM BankUsers WHERE username = ?";
				
				PreparedStatement pStatement = getConnection().prepareStatement(statement);
				
				pStatement.setString(1, username);
				
				ResultSet result = pStatement.executeQuery();
				
				double credits = 0;
				
				while(result.next()) {
					
					credits = result.getDouble("credits");
					
				}
				
				return credits;
			
		} catch(SQLException e) {
			
			return 0;
			
		}
		
		
	}
	
	public String getData(String column, String username) {
		
		try {
			
			String statement = "SELECT " + column + " FROM BankUsers WHERE username = ?";
			
			PreparedStatement pStatement = getConnection().prepareStatement(statement);
			
			pStatement.setString(1, username);
			
			ResultSet result = pStatement.executeQuery();
			
			String columnData = "";
			
			while(result.next()) {
				
				columnData = result.getString(column);
				
			}
		
			
			return columnData;
			
		} catch(SQLException e) {
			
			return null;
			
		}
		
	}
	
	public boolean sendCredit(String from, String to, double amount) {
		
		if (getCredits(from) - amount > 0) {
			
			
			try{	
				String statement = "UPDATE BankUsers SET credits = ? WHERE username = ?";
				
				PreparedStatement pStatementFrom = getConnection().prepareStatement(statement);
				
				pStatementFrom.setDouble(1, getCredits(from) - amount);
				pStatementFrom.setString(2, from);
				
				pStatementFrom.executeQuery();
				
				System.out.println(getCredits(from));
				
				
				PreparedStatement pStatementTo = getConnection().prepareStatement(statement);
				
				pStatementTo.setDouble(1, getCredits(to) + amount);
				pStatementTo.setString(2, to);
				
				pStatementTo.executeQuery();
				
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Something went wrong ");
				return false;
				
			}		
					
					
				
			} else {
				
				return false;
				
			}
			
		}
		
		
	
	

}
