package com.example.EAD_Lab4.Session_Login_and_Logout;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link2.html").include(request, response);

        HttpSession session = request.getSession(false);
        if(session != null){
            String name = (String)session.getAttribute("name");

            out.print("Hello, " + name + " Welcome to Profile");
        }
        else{
            out.print("Please login first");
            request.getRequestDispatcher("login2.html").include(request, response);
        }
        out.close();
    }
}
