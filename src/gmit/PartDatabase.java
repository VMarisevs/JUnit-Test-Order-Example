package gmit;

public interface PartDatabase {
	public abstract void setHost(String host) throws Exception;
	public abstract boolean connect(String username, String password) throws Exception;
	public abstract boolean disconnect() throws Exception;
	public abstract boolean isConnected();
	public abstract boolean save(Part p) throws Exception;
	public abstract Part getPart(String partNumber) throws Exception;
}