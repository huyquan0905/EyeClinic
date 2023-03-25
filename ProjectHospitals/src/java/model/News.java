/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hp
 */
public class News {
    private int newsId;
    private String newsName;
    private String newsSummary;
    private String newsDetail;
    private String newsImg;
    private String newsAuthor;
    public News() {
    }

    public News(int newsId, String newsName, String newsSummary, String newsDetail, String newsImg, String newsAuthor) {
        this.newsId = newsId;
        this.newsName = newsName;
        this.newsSummary = newsSummary;
        this.newsDetail = newsDetail;
        this.newsImg = newsImg;
        this.newsAuthor = newsAuthor;
    }

  

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsSummary() {
        return newsSummary;
    }

    public void setNewsSummary(String newsSummary) {
        this.newsSummary = newsSummary;
    }

    public String getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    @Override
    public String toString() {
        return "News{" + "newsId=" + newsId + ", newsName=" + newsName + ", newsSummary=" + newsSummary + ", newsDetail=" + newsDetail + ", newsImg=" + newsImg + ", newsAuthor=" + newsAuthor + '}';
    }

   

   
    
}
