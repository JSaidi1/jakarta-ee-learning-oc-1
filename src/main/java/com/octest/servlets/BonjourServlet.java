package com.octest.servlets;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "BonjourServlet", value = "/BonjourServlet")
public class BonjourServlet extends HttpServlet {

    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "/home/joel/dataInfo/java/jakarta_ee/others/files/"; // (destination final => A changer)

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //== If we want deactivate the session:
        //HttpSession session = request.getSession();
        //session.invalidate();

        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        HttpSession session = request.getSession();

        session.setAttribute("nom", nom);
        session.setAttribute("prenom", prenom);

        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }
}