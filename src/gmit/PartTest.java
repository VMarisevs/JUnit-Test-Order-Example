package gmit;

import org.junit.*;
import static org.junit.Assert.*;

public class PartTest {
	private Part part = null;
	
	@Before
	public void createPart(){
		part = new Part();
	}
	
	@After
	public void destroyPart(){
		part = null;
	}
	
	@Test
	public void validateGoodPartNumber() throws PartException{
		part.setNumber("QD-1322");
		assertNotNull(part.getNumber());
	}
	
	@Test(expected=PartException.class)
	public void validateBadPartNumber() throws PartException{
		part.setNumber("QD-A322");
	}
	
	@Test
	public void validateGoodPartName() throws PartException{
		part.setName("Digital Camcorder");
		assertNotNull(part.getName());
	}
	
	@Test(expected=PartException.class)
	public void validateBadPartName() throws PartException{
		part.setName("Microsoft Office 2000 Professional English/1 User License");
	}
	
	@Test(expected=PartException.class)
	public void validateBadPartNameBVA() throws PartException{
		part.setName("");
	}

	@Test
	public void validateGoodPartDescription() throws PartException{
		part.setDescription("Interea magno misceri murmurepontum, emissamque hiemem.");
		assertNotNull(part.getDescription());
	}
	
	@Test(expected=PartException.class)
	public void validateBadPartDescription() throws PartException{
		part.setDescription("Interea magno misceri murmurepontum, emissamque hiemem. Neptunus, et imis stagna refusavadis, graviter commotus; etalto prospiciens, summa placidum caput extulit unda. DisiectamAeneae, toto videt aequore");
	}
	
	@Test(expected=PartException.class)
	public void validateBadPartDescriptionBVA() throws PartException{
		part.setDescription("");
	}	
	
	@Test 
	public void validateGoodPrice() throws PartException{
		part.setPrice(120.00d);
		assertTrue(part.getPrice() > 0);
	}
	
	@Test 
	public void validatePricePrecision() throws PartException{
		part.setPrice(120.001d);
		assertEquals(null, part.getPrice(), 120.00d, 0.01);
	}
	
	@Test(expected=PartException.class)
	public void validateLowBadPrice() throws PartException{
		part.setPrice(-1.00d);
	}	
	
	@Test(expected=PartException.class)
	public void validateHighBadPrice() throws PartException{
		part.setPrice(201.00d);
	}	
}
