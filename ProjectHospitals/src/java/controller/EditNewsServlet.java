/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NewsDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.News;

/**
 *
 * @author Admin
 */
public class EditNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsDAO dao = new NewsDAO();
        List<News> sl = dao.getListNews();
        request.setAttribute("sl", sl);
        request.getRequestDispatcher("ManagementNews.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsDAO dao = new NewsDAO();
        String nid = request.getParameter("id");
        int id = Integer.parseInt(nid);
        String name = request.getParameter("name");
        String summary = request.getParameter("summary");
        String detail = request.getParameter("detail");
        String author = request.getParameter("author");
        String img = request.getParameter("img");
        dao.EditNews(name, summary, detail, img, author, id);
        response.sendRedirect("add_news_servlet");

    }


}
