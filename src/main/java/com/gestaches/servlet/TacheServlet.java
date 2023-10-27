package com.gestaches.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.gestaches.dao.ITache;
import com.gestaches.dao.TacheImplement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gestaches.entities.Tache;

@WebServlet(urlPatterns = "/Tache", name = "tache")
public class TacheServlet extends HttpServlet {
    private ITache tachedao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        tachedao = new TacheImplement();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("list".equals(action)) {
            // Afficher la liste des tâches
            List<Tache> listeTaches = tachedao.getAllTasks();
            req.setAttribute("tasks", listeTaches);
            req.getRequestDispatcher("listeTaches.jsp").forward(req, resp);
        } else if ("updateStatus".equals(action)) {
            // Mettre à jour le statut d'une tâche
            updateTaskStatus(req);
            resp.sendRedirect(req.getContextPath() + "/Tache?action=list");
        } else if ("delete".equals(action)) {
            // Supprimer une tâche
            deleteTask(req);
            resp.sendRedirect(req.getContextPath() + "/Tache?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Créer une nouvelle tâche
        String titre = req.getParameter("titre").toString();
        String description = req.getParameter("description").toString();
        boolean statut = Boolean.parseBoolean(req.getParameter("statut").toString());
        Date dateEcheance = null;
        try {
            dateEcheance = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dateEcheance"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Tache tache = new Tache();
        tache.setTitre(titre);
        tache.setDescription(description);
        tache.setStatut(statut);
        tache.setDateEcheance(dateEcheance);

        int ok = tachedao.add(tache);

        resp.getWriter().println(ok);
    }

    private void updateTaskStatus(HttpServletRequest req) {
        long taskId = Long.parseLong(req.getParameter("taskId"));
        boolean newStatus = Boolean.parseBoolean(req.getParameter("newStatus"));
        tachedao.updateTaskStatus(taskId, newStatus);
    }

    private void deleteTask(HttpServletRequest req) {
        long taskId = Long.parseLong(req.getParameter("taskId"));
        tachedao.deleteTask(taskId);
    }
}