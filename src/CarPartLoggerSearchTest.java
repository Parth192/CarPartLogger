import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class CarPartLoggerSearchTest {

	@Test
	public void testSearchInt() throws SQLException {
		CarPartLogger unitTest = new CarPartLogger();
		assertEquals("1FordF1501998", unitTest.search(1));
		assertEquals("2AudiR82007", unitTest.search(2));
		assertEquals("3AudiR82007", unitTest.search(3));
		assertEquals("4FordR82007", unitTest.search(4));
		assertEquals("5FordR82007", unitTest.search(5));
		assertEquals(" No Result Found ", unitTest.search(0));
		assertEquals(" No Result Found ", unitTest.search(10));
		assertEquals(" No Result Found ", unitTest.search(11));
		assertEquals(" No Result Found ", unitTest.search(15));
		assertEquals("6BMWi82014", unitTest.search(6));
	}

	
	@Test
	public void testSearchString() throws SQLException {
		CarPartLogger unitTest = new CarPartLogger();
		List<String> resultList = unitTest.search("Ford");
		String resultString = String.join(",", resultList);	
		assertEquals("1,Ford,F150,1998,4,Ford,R8,2007,5,Ford,R8,2007", resultString);
		resultList.clear();
		resultList = unitTest.search("1998");
		resultString = String.join(",", resultList);
		assertEquals("1,Ford,F150,1998", resultString);
		resultList.clear();
		resultList = unitTest.search("R8");
		resultString = String.join(",", resultList);
		assertEquals("2,Audi,R8,2007,3,Audi,R8,2007,4,Ford,R8,2007,5,Ford,R8,2007", resultString);
		resultList.clear();
		resultList = unitTest.search("2018");
		resultString = String.join(",", resultList);
		assertEquals("No Matching Record", resultString);
		resultList.clear();
		resultList = unitTest.search(null);
		resultString = String.join(",", resultList);
		assertEquals("No Matching Record", resultString);
		resultList.clear();
		resultList = unitTest.search("Fiat");
		resultString = String.join(",", resultList);
		assertEquals("No Matching Record", resultString);
		resultList.clear();
		resultList = unitTest.search("BMW");
		resultString = String.join(",", resultList);
		assertEquals("6,BMW,i8,2014", resultString);
		
		
	}

}
