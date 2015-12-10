package gmit;
public class PartDatabaseMock implements PartDatabase{
	public void setHost(String host) throws Exception{
		if (!host.equals("10.2.0.205")){
			throw new Exception("Cannot find remote host.");
		}
	}

	public boolean connect(String username, String password) throws Exception {
		if (!username.equals("webuser") || !password.equals("pass")){
			throw new Exception("Invalid username or password.");
		}
		return true;
	}

	public boolean disconnect() throws Exception {
		return true;
	}
	
	public boolean isConnected(){
		return true;
	}
	
	public boolean save(Part p) throws Exception {
		if (!p.getNumber().equals("AA-1111")){
			throw new Exception("Primary key violation.");
		}
		return true;
	}

	public Part getPart(String partNumber) throws Exception {
		return new Part();
	}
}
