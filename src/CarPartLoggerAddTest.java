import static org.junit.Assert.*;

import java.sql.SQLException;
import org.junit.Test;

public class CarPartLoggerAddTest {
	

	@Test
	public void testAddPart() throws SQLException {
		CarPartLogger unitTest = new CarPartLogger();
		assertEquals(1, unitTest.addPart("Ford", "F150", "1998"));
		assertEquals(2, unitTest.addPart("Audi", "R8", "2007"));
		assertEquals(3, unitTest.addPart("Audi", "R8", "2007"));
		assertEquals(4, unitTest.addPart("Ford", "R8", "2007"));
		assertEquals(5, unitTest.addPart("Ford", "R8", "2007"));
		assertEquals(0, unitTest.addPart("", "R8", "2007"));
		assertEquals(0, unitTest.addPart("Ford", "", "2007"));
		assertEquals(0, unitTest.addPart("Ford", "R8", ""));
		assertEquals(0, unitTest.addPart(null, "R8", "2007"));
		assertEquals(0, unitTest.addPart("Ford", null, "2007"));
		assertEquals(0, unitTest.addPart("Ford", "R8", null));
		assertEquals(6, unitTest.addPart("BMW", "i8", "2014"));
		
	}

}
