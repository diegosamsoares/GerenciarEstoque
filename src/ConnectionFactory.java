import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	
	public Connection getConnection() {//metodo com retorno de um objeto do tipo Connection que � uma conex�o
	     try {
	    	
	    	  DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Essa linha foi a diferen�a
	         return DriverManager.getConnection("jdbc:mysql://localhost/vendas", "root", "");
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	
	
		
		
	
	}


