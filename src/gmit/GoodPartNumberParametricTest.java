package gmit;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith(Parameterized.class)
public class GoodPartNumberParametricTest {
	private String number;
	private boolean match;	
	private Part part = null;
	
	@Before
	public void createPart(){
		part = new Part();
	}
	
	@After
	public void destroyPart(){
		part = null;
	}
	
	public GoodPartNumberParametricTest(String phrase, boolean match) {
		this.number = phrase;
		this.match = match;
	}

	@Test
	public void verifyGoodPartNumber() throws PartException{
		part.setNumber(number);
		assertEquals(part.getNumber() != null, match);
	}
	
	@Parameters
	public static Collection<Object[]> regExValues() {
		return Arrays.asList(new Object[][] {
				{"AB-1234", true },
				{"aZ-0000", true },
				{"Az-9999", true },
				{"az-0001", true },
				{"Za-9191", true },
				{"aa-1123", true }
		});
	}
}