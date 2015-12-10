package gmit;

import java.sql.*;

public class PartDatabaseImpl implements PartDatabase{
	private boolean isConnected = false;
	private Connection connection = null;
	private String host = null; 
	
	public void setHost(String host) throws Exception{
		this.host = host;
	}
	
	public boolean connect(String username, String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(host, username, password);
		connection.setAutoCommit(false);
		isConnected = true;
		return isConnected;
	}

	public boolean isConnected(){
		return isConnected;
	}

	public boolean disconnect() throws Exception {
		connection.close();
		return true;
	}

	public boolean save(Part p) throws Exception {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO PART VALUES (?,?,?,?)");
		ps.setString(1, p.getNumber());
		ps.setString(2, p.getName());
		ps.setString(3, p.getDescription());
		ps.setDouble(4, p.getPrice());
		ps.executeUpdate();
		ps.close();
		connection.commit();
		return true;
	}

	public Part getPart(String partNumber) throws Exception {
		Part p = null;
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM PART WHERE PART_NUMBER='" + partNumber + "'");
		while (rs.next()){
			p = new Part();
			try {
				p.setNumber(rs.getString("PART_NUMBER"));
				p.setName(rs.getString("PART_NAME"));
				p.setDescription(rs.getString("PART_DESCRIPTION "));
				p.setPrice(rs.getFloat("PART_PRICE"));
			} catch (PartException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

}
