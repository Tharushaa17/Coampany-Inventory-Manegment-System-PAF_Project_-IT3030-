package com.Buyers.BuyersReg;
import com.Buyers.BuyersReg.Dao.BuyerDao;
import com.Buyers.BuyersReg.model.Buyer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class BuyerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BuyerDao BuyerDao;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbc:mysql://localhost:3306/buyers");
        String jdbcUsername = getServletContext().getInitParameter("root");
        String jdbcPassword = getServletContext().getInitParameter("");
 
        BuyerDao = new BuyerDao(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertBuyer(request, response);
                break;
            case "/delete":
                deleteBuyer(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateBuyer(request, response);
                break;
            default:
                listBuyer(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listBuyer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Buyer> listBuyer = BuyerDao.listAllBuyer();
        request.setAttribute("listBuyer", listBuyer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowBuyer.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Buyer existingBuyer = BuyerDao.getBuyer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
        request.setAttribute("buyer", existingBuyer);
        dispatcher.forward(request, response);
 
    }
 
    private void insertBuyer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String FristName = request.getParameter("FristName");
        String LastName = request.getParameter("LastName");
        String Username = request.getParameter("Username");
        String Email = request.getParameter("Email");
        String MobileNu = request.getParameter("MobileNu");
        String Address = request.getParameter("Address");
        String Password = request.getParameter("Password");
 
        Buyer newBuyer = new Buyer(FristName, LastName, Username, MobileNu, Email, Address, Password);
        BuyerDao.insertBuyer(newBuyer);
        response.sendRedirect("list");
    }
 
    private void updateBuyer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String FristName = request.getParameter("FristName");
        String LastName = request.getParameter("LastName");
       String MobileNu = request.getParameter("MobileNu");
       String Email = request.getParameter("Email");
       String Address = request.getParameter("Address");
       String Password = request.getParameter("Password");
 
        Buyer buyer = new Buyer(id, FristName, LastName, LastName, MobileNu, Email, Address, Password);
        BuyerDao.updateBuyer(buyer);
        response.sendRedirect("list");
    }
 
    private void deleteBuyer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Buyer buyer = new Buyer(id);
        BuyerDao.deleteBuyer(buyer);
        response.sendRedirect("list");
 
    }
}