package com.Buyers.BuyersReg.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Buyers.BuyersReg.model.Buyer;


/**
 * This DAO class provides CRUD database operations for the table buyerreg
 * in the buyer database.
 */
public class BuyerDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public BuyerDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     //insert buyer
    public boolean insertBuyer(Buyer buyer) throws SQLException {
        String sql = "INSERT INTO buyerreg (FristName, LastName, MobileNu, Username, Email, Address, Password) VALUES (?, ?, ?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, buyer.getFristName());
        statement.setString(2, buyer.getLastName());
        statement.setString(3, buyer.getUsername());
        statement.setString(4, buyer.getMobileNu());
        statement.setString(5, buyer.getEmail());
        statement.setString(6, buyer.getAddress());
        statement.setString(7, buyer.getPassword());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     //listing buyer info
    public List<Buyer> listAllBuyer() throws SQLException {
        List<Buyer> listBuyer = new ArrayList<>();
         
        String sql = "SELECT * FROM buyerreg";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String FristName = resultSet.getString("FristName");
            String LastName = resultSet.getString("LastName");
            String Username = resultSet.getString("Username");
            String MobileNu = resultSet.getString("MobileNu");
            String Address = resultSet.getString("Addess");
            String Password = resultSet.getString("Password");
             
            Buyer buyer = new Buyer(id, FristName, LastName, Username, MobileNu, MobileNu, Address, Password);
            listBuyer.add(buyer);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listBuyer;
    }
     //delete buyer
    public boolean deleteBuyer(Buyer buyer) throws SQLException {
        String sql = "DELETE FROM buyerreg where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, buyer.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     //update buyer
    public boolean updateBuyer(Buyer buyer) throws SQLException {
        String sql = "UPDATE buyerreg SET FristName = ?, LatName = ?, Username = ?,MobileNu = ?, Email = ?, Address = ?, Password = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, buyer.getId());
        statement.setString(2, buyer.getFristName());
        statement.setString(3, buyer.getLastName());
        statement.setString(4, buyer.getUsername());
        statement.setString(5, buyer.getEmail());
        statement.setString(6, buyer.getMobileNu());
        statement.setString(7, buyer.getAddress());
        statement.setString(8, buyer.getPassword());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Buyer getBuyer(int id) throws SQLException {
        Buyer buyer = null;
        String sql = "SELECT * FROM buyerreg WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String FristName = resultSet.getString("FristName");
            String LastName = resultSet.getString("LastName");
            String Username = resultSet.getString("Username");
            String Email = resultSet.getString("Email");
            String MobileNu = resultSet.getString("MobileNu");
            String Address = resultSet.getString("Address");
            String Password = resultSet.getString("Password");
            
            buyer = new Buyer(FristName, LastName, Username, MobileNu, Email, Address, Password);
        }
         
        resultSet.close();
        statement.close();
         
        return buyer;
    }
}
