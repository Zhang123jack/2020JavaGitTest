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
import java.util.List;

@WebServlet("/ContactQueryServlet")
public class ContactQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactService service=new ContactServiceImpl();
        List<Contact> cons=service.queryAll();
        request.setAttribute("cons",cons);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
