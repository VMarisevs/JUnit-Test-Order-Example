package gmit;

public class PartExample {
	public static void main(String[] args) {
		PartDatabase db = PartDatabaseFactory.getPartDatabase();
		Part p = new Part();
		try {
			p.setNumber("AA-1233");
			p.setName("3Com Ethernet 10 PCI Combo");
			p.setDescription("Interea magno misceri murmurepontum, emissamque hiemem.");
			p.setPrice(49.99f);
		} catch (PartException e) {
			e.printStackTrace();
		}
		
		try {
			db.setHost("jdbc:mysql://10.2.0.205:3306/ORDER_SYSTEM");
			db.connect("webuser","store");
			db.save(p);
			db.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
