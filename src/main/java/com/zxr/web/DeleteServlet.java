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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contactId = request.getParameter("id");
        ContactService service=new ContactServiceImpl();
        service.deleteById(contactId);
        response.sendRedirect("query_contact_page");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
