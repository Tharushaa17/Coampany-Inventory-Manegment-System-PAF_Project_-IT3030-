package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class productCtrl {
	public Connection connect() {
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			System.out.println("Successfully Connected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//Search item--------------
	public String readProduct(){
		String output = "";
				try{
					Connection con = connect();
				if (con == null){
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
					output = "<table border='1'><tr><th>Product Code</th>"+"<th>Product Name</th><th>Product Price</th>"+ "<th> Description</th>"+ "<th>Update</th><th>Remove</th></tr>";
					String query = "SELECT * FROM test.products";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
				
				// iterate through the rows in the result set
				while (rs.next()){
					String itemID = Integer.toString(rs.getInt("id"));
					String itemName = rs.getString("name");
					String itemPrice = rs.getString("price");
					String itemDesc = rs.getString("desc");
				
				// Add a row into the html table
					output += "<tr><td>" + itemID + "</td>";
					output += "<td>" + itemName + "</td>";
					output += "<td>" + itemPrice + "</td>";
					output += "<td>" + itemDesc + "</td>";
				// buttons
					output += "<td><input name='btnUpdate' "
					+ " type='button' value='Update'></td>"
					+ "<td><form method='post' action='items.jsp'>"
					+ "<input name='btnRemove' "
					+ " type='submit' value='Remove' class= 'btn btn-danger'>"
					+ "<input name='itemID' type='hidden' "
					+ " value='" + itemID + "'>" + "</form></td></tr>";
				}
				con.close();
				// Complete the html table
					output += "</table>";
				}
				catch (Exception e){
					output = "Error while reading the items.";
					System.err.println(e.getMessage());
				}
		return output;
		}
	
	//Update item-----
		public String updateProduct(String name,String price,String desc, String id) {
			String output="";
			try {
				Connection con = connect();
				if (con == null){
					return "Error while connecting to the database for Updating.";
				}
			String query ="UPDATE test.products SET name=?,price=?,desc=? WHERE id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, price);
			preparedStmt.setString(3, desc);
			preparedStmt.setInt(4, Integer.parseInt(id));
			//execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
			}
			catch (Exception e) {
				output = "Error while Updating";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
	//Delete item------
		public String deleteProduct(String id) {
			String output ="";
			try {
				Connection con = connect();
				if (con == null){
					return "Error while connecting to the database for Deleting.";
				}
				// create a prepared statement
				String query = " DELETE FROM test.products WHERE id=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(id));
				//execute the statement
				preparedStmt.execute();
				con.close();
				output = "Deleted successfully";
				
			} catch (Exception e) {
				output = "Error while deleting";
				System.err.println(e.getMessage());
			}
		return output;
		}
		
	//Insert item---------------
		public String insertProduct(String id, String name, String price, String desc){
			String output = "";
				try{
					Connection con = connect();
					if (con == null){
						return "Error while connecting to the database";
					}
							// create a prepared statement
							String query = " INSERT INTO test.products(`id`,`name`,`price`,`desc`)"+ " values (?, ?, ?, ?)";
							PreparedStatement preparedStmt = con.prepareStatement(query);
							// binding values
								preparedStmt.setString(1, id);
								preparedStmt.setString(2, name);
								preparedStmt.setString(3, price);
								preparedStmt.setString(4, desc);
					
							//execute the statement
								preparedStmt.execute();
								con.close();
								output = "Inserted successfully";
				}
				catch (Exception e){
					output = "Error while inserting";
					System.err.println(e.getMessage());
				}
			return output;
	}
		
}
