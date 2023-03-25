/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.News;
import model.Prescription;

/**
 *
 * @author hp
 */
public class NewsDAO extends ConnectMySQL {

    public List<News> getListNews() {
        List<News> listNews = new ArrayList<>();
        String sql = "select * from news";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listNews.add(new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNews;
    }

    public News getNewsByID(String nid) {

        String sql = "select * from news where news_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void InsertNews(String name, String summary, String detail, String img, String author) {

        String sql = "INSERT INTO `projectswp391`.`news` (news_name, news_summary, news_detail, news_img, news_author) values(?, ?, ?, ?,?);";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, summary);
            ps.setString(3, detail);
            ps.setString(4, img);
            ps.setString(5, author);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteNews(String nid) {
        String sql = "  DELETE FROM news WHERE news_id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void EditNews(String name, String summary, String detail, String img, String author, int id) {
        String sql = "UPDATE news  set news_name=?    ,news_summary=?,  news_detail =?,\n" +
"news_img =?   ,news_author = ?\n" +
"               where news_id = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, summary);
            ps.setString(3, detail);
            ps.setString(4, img);
            ps.setString(5, author);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<News> search(String keyword) {
        List<News> list = new ArrayList<>();
        try {
            String sql = "select *  from news where news_name like ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNewsId(rs.getInt(1));
                news.setNewsName(rs.getString(2));
                news.setNewsSummary(rs.getString(3));
                news.setNewsDetail(rs.getString(4));
                news.setNewsImg(rs.getString(5));
                news.setNewsAuthor(rs.getString(6));
                list.add(news);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
   
}
