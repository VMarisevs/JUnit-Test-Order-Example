package ie.gmit.sw;

import org.junit.*;
import static org.junit.Assert.*;

public class TestOrder {
	private Order order = null;
	
	@Before
	public void setup(){
		// set up the text fixture
		order = new Order();
	}
	
	@After
	public void tearDown(){
		// Tear Down the test fixture
		order = null;
	}
	
	@Test
	public void validOrderNumber() throws Exception{
		order.setOrderNumber("AA-123-B9");
		assertNotNull(order.getOrderNumber());
	}
	
	// expecting thrown exception
	@Test(expected=Exception.class)
	public void nullOrderNumber() throws Exception{
		order.setOrderNumber(null);
	}
	
	@Test
	public void addValidLineItem(){
		int count = order.itemCount();
		order.addItem("AA-123-B9", "Daiwa Mooching", 27, 12.99);
		assertTrue(order.itemCount() == count+1);
	}
}
