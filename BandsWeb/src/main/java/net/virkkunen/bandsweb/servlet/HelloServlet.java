/*
 * Copyright 2020 Diego Silva <diego.silva at apuntesdejava.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.virkkunen.bandsweb.servlet;

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


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Resource(lookup="jdbc/books")
    private DataSource myds;
    private String message;

    @Override
    public void init() {
        message = "Hello World from Servlet!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        try {
            Connection con = myds.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT a.id,a.firstname,a.lastname FROM author a;");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr><th>Id</th><th>Etunimi</th><th>Sukunimi</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");
            while(rs.next()) {
                out.println("<tr><td>"+rs.getInt("id")+"</td>");
                out.println("<td>"+rs.getString("firstname")+"</td>");
                out.println("<td>"+rs.getString("lastname")+"</td></tr>");
            }    
            out.println("</tbody>");
            out.println("</table>");
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        out.println();
        
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
    }
}