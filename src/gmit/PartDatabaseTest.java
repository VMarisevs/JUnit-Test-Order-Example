package gmit;
import org.junit.*;
import static org.junit.Assert.*;
public class PartDatabaseTest {
	private PartDatabase db = null;
	
	@Before
	public void createPart(){
		db = PartDatabaseFactory.getPartDatabase();
	}
	
	@After
	public void destroyPart(){
		db = null;
	}
	
	@Test(expected=Exception.class)
	public void validateBadHost() throws Exception{
		db.setHost("10.2.0.206");
	}
	
	@Test
	public void validateGoodSave() throws PartException, Exception{
		Part p = new Part();
		p.setNumber("AA-1111");
		assertTrue(db.save(p));
	}
	
	@Test(expected=Exception.class)
	public void validateBadSave() throws PartException, Exception{
		Part p = new Part();
		p.setNumber("AA-2111");
		db.save(p);
	}
}
