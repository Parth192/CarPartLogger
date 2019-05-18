import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CarPartLogger {

	// Method To Add New Part Paramater Are : Make, Model, Year
	// Returns the PartId of Newly Inserted Record
	public int addPart(String make, String model, String year) throws SQLException {

		if (make == null || model == null || year == null || make.isEmpty() || model.isEmpty() || year.isEmpty()) {
			return 0;
		}
		// Creates Connection with SQL server
		Connection conn = getNewConnection.getSQLConnection();
		// MaxPartId is the integer value of highest PartId available in the system
		int maxPartId = 0;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select Max(partid) from cars");
		if (rs.next()) {
			maxPartId = rs.getInt("Max(partid)");
		}
		String query = " insert into cars (partid, make, model, Caryear)" + " values (?, ?, ?, ?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		// Insert the maxPartId + 1 for the new record
		preparedStmt.setInt(1, maxPartId + 1);
		preparedStmt.setString(2, make);
		preparedStmt.setString(3, model);
		preparedStmt.setString(4, year);
		preparedStmt.execute();
		// Closing The Connection
		conn.close();
		return maxPartId + 1;
	}

	// Method To Search a part from the system based on partId
	// Return the Selected Record if part is present in the system
	// in the form of String.
	public static String search(int partId) throws SQLException {
		String searchRecord = "";
		Connection conn = getNewConnection.getSQLConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from cars where partId ='" + partId + "'");
		while (rs.next()) {
			int delPartId = rs.getInt("partId");
			String delMake = rs.getString("make");
			String delModel = rs.getString("model");
			String delYear = rs.getString("Caryear");
			searchRecord = delPartId + delMake + delModel + delYear;
		}
		conn.close();
		// If there is no record to display for the Part ID
		if (searchRecord.isEmpty()) {
			return " No Result Found ";
		}
		return searchRecord;

	}

	// Method To Search a part from the system based on make, Model or Year
	// Return the Selected Record if part is present in the system
	// in the form of LinkedList.
	public static List<String> search(String makeModelOrYear) throws SQLException {
		List<String> resultList = new LinkedList<>();
		Connection conn = getNewConnection.getSQLConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from cars where make ='" + makeModelOrYear + "' OR model ='"
				+ makeModelOrYear + "' OR Caryear = '" + makeModelOrYear + "'");
		while (rs.next()) {
			resultList.add(rs.getString("partId"));
			resultList.add(rs.getString("make"));
			resultList.add(rs.getString("model"));
			resultList.add(rs.getString("Caryear"));

		}
		if (resultList.isEmpty()) {
			resultList.add("No Matching Record");
		}
		return resultList;

	}

	// Method To Remove a part from the system based on partId
	// Removes the Record and Return the Deleted Record in the form of String.
	public static String removePart(int partId) throws SQLException {
		// Creates Connection with SQL server
		Connection conn = getNewConnection.getSQLConnection();
		Statement stmt = conn.createStatement();
		// Searches the record from the system by partId and Stores it in a String
		String deletedRecord = search(partId);
		// Delete the record from the system
		stmt.executeUpdate("delete from cars where partId ='" + partId + "'");
		conn.close();
		return deletedRecord;
	}

}
