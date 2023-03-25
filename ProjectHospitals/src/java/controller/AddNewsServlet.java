/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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


public class AddNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsDAO dao = new NewsDAO();
        List<News> nl = dao.getListNews();
        request.setAttribute("nl", nl);
        request.getRequestDispatcher("ManagementNews.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsDAO dao = new NewsDAO();
        String name = request.getParameter("name");
        String summary = request.getParameter("summary");
        String detail = request.getParameter("detail");
        String author = request.getParameter("author");
        String img = request.getParameter("img");
        dao.InsertNews(name, summary, detail, img, author);
        response.sendRedirect("add_news_servlet");
    }

  
}
