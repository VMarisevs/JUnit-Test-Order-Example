package gmit;

public class PartDatabaseFactory {

	public static PartDatabase getPartDatabase() {
		return new PartDatabaseMock();
	}

}
