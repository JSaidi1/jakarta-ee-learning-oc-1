package com.octest.servlets;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import com.octest.bdd.Nom;
import com.octest.beans.Utilisateur;

@WebServlet(name = "BonjourServlet", value = "/BonjourServlet")
public class BonjourServlet extends HttpServlet {

    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "/home/joel/dataInfo/java/jakarta_ee/others/files/"; // (destination final => A changer)

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Nom tableNoms = new Nom();
        request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());

        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(request.getParameter("nom"));
        utilisateur.setPrenom(request.getParameter("prenom"));

        Nom tableNoms = new Nom();
        tableNoms.ajouterUtilisateur(utilisateur);

        request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());

        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }
}