package com.zxr.web;

import com.zxr.domain.Contact;
import com.zxr.service.ContactService;
import com.zxr.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    //回显
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactService cs=new ContactServiceImpl();
        String id = request.getParameter("id");
        Contact c= cs.getContact(id);
        request.setAttribute("contact",c);
        System.out.println(c);
        int i=1;
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
