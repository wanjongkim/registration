/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wankim
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
    	//ServletContext session = this.getServletContext();
    	FormBean formBean = (FormBean) session.getAttribute("formBean");
    	if(formBean == null) {
    		formBean = new FormBean();
    		session.setAttribute("formBean", formBean);
    	}
    	formBean.setFirstName(request.getParameter("FName"));
    	formBean.setLastName(request.getParameter("LName"));
    	formBean.setCity(request.getParameter("City"));
    	formBean.setCountry(request.getParameter("CountryOfRes"));
    	formBean.setDisplayName(request.getParameter("alias"));
    	formBean.setEmail(request.getParameter("UserID"));
    	formBean.setLanguage(request.getParameter("Language"));
    	formBean.setPassword(request.getParameter("Password"));
    	formBean.setSecurityAnswer(request.getParameter("SecurityAns"));
    	formBean.setSecurityQuestion(request.getParameter("SecurityQues"));
    	formBean.setVerifyPassword(request.getParameter("RePassword"));
    	formBean.setNC_CHECK_EMAIL(request.getParameter("NC_CHECK_EMAIL"));
    	formBean.setNC_CHECK_OTHER(request.getParameter("NC_CHECK_OTHER"));
    	
    	RequestDispatcher rd = request.getRequestDispatcher("myJSP.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
