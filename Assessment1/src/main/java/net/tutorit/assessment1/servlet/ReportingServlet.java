package net.tutorit.assessment1.servlet;

import jakarta.annotation.Resource;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;


@WebServlet(name = "reportingServlet", value = "/reporting")
public class ReportingServlet extends HttpServlet {
    @Resource(lookup="jdbc/books")
    private DataSource myds;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Tuoteraportti</h1>");
        try{
            // Tähän tietokantahaku ja taulukon tulostaminen toimeksiannon mukaisesti
            Connection con = myds.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT m.name,p.product_name,p.price FROM manufacturer m LEFT JOIN product p ON (p.manufacturer_id=m.id);");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr><th>Valmistaja</th><th>Tuote</th><th>Hinta</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");
            while(rs.next()) {
                out.println("<tr><td>"+rs.getString("m.name")+"</td>");
                out.println("<td>"+rs.getString("p.product_name")+"</td>");
                out.println("<td>"+rs.getDouble("p.price")+"</td></tr>");
            }    
            out.println("</tbody>");
            out.println("</table>");
        }
        catch(Exception ex){
            System.out.println("******************Virhe");
            ex.printStackTrace();
        }
    }

}