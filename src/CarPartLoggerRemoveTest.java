import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class CarPartLoggerRemoveTest {

	@Test
	public void testRemovePart() throws SQLException {
		CarPartLogger unitTest = new CarPartLogger();
		assertEquals("1FordF1501998", unitTest.removePart(1));
		assertEquals(" No Result Found ", unitTest.removePart(1));
		assertEquals(" No Result Found ", unitTest.removePart(0));
		assertEquals("2AudiR82007", unitTest.removePart(2));
		assertEquals("3AudiR82007", unitTest.removePart(3));
		assertEquals("4FordR82007", unitTest.removePart(4));
		assertEquals("5FordR82007", unitTest.removePart(5));
		assertEquals(" No Result Found ", unitTest.removePart(2));
		assertEquals(" No Result Found ", unitTest.removePart(3));
		assertEquals(" No Result Found ", unitTest.removePart(4));
		assertEquals(" No Result Found ", unitTest.removePart(5));
		assertEquals("6BMWi82014", unitTest.removePart(6));
		assertEquals(" No Result Found ", unitTest.removePart(6));
		
	
	}
}
