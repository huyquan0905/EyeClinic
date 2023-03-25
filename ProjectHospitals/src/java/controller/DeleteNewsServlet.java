
package controller;

import dao.NewsDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.News;

public class DeleteNewsServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsDAO ndao = new NewsDAO();
        List<News> nl = ndao.getListNews();
        String nid = request.getParameter("nid");
        ndao.DeleteNews(nid);
        request.setAttribute("nl", nl);
        response.sendRedirect("add_news_servlet");

    }

}
