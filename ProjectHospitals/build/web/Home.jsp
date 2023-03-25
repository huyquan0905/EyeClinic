<%-- 
    Document   : Home
    Created on : Feb 6, 2023, 11:31:33 AM
    Author     : Hi! Le Minh Hieu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="style/home.css">

<jsp:include page="Header.jsp"/>
<main class="responsive-wrapper">


    <div class="page-title">
        <h1>Eyes Hospital</h1>
    </div>
    <div class="magazine-layout">
        <div class="magazine-column">
            <article class="article">
                <h2 class="article-title article-title--large">
                    <mark class="mark mark--primary">Lời nói đầu</mark>
                </h2>
                <div class="article-author">
                    <div class="article-author-img">
                        <img src="https://haiduong.matquocte.vn/wp-content/uploads/2015/05/banner-slogan-scaled.jpg" />
                    </div>
                    <div class="article-excerpt">
                        <p>Được thành lập từ năm 2002, trải qua gần 20 năm hoạt động, Bệnh viện mắt Minh Hiếu ngày càng khẳng định vị thế và uy tín của mình
                            trong lĩnh vực kính thuốc và kính thời trang tại thị trường Việt Nam.Nơi đây đã trở thành địa chỉ tin cậy về khám và chăm
                            sóc mắt của nhiều thế hệ khách hàng.
                            Đội ngũ Bác sỹ có trình độ chuyên môn cao, đến từ những bệnh viện danh tiếng đem đến cho Quý khách hàng
                            những dịch vụ khám và tư vấn chuyên sâu.
                            Phòng khám Lê Minh Hiếu với hệ thống trang thiết bị hiện đại, đội ngũ nhân viên nhiệt tình, thân thiện sẽ mang
                            đến cho Khách hàng sự thoải mái, an tâm và tin tưởng tuyệt đối và giúp khách hàng chọn cho mình những sản
                            phẩm kính thuốc phù hợp nhất mà vẫn hợp thời trang...</p>
                        <button type="submit">Tìm Hiểu Thêm</button>
                    </div>
                </div>
            </article>
            <div class="chuyen_gia">
                <h1>CHUYÊN GIA CỦA CHÚNG TÔI</h1>
                <div>Một trong những yếu tố quan trọng tạo nên thương hiệu của Vinaoptic chính là</div>
                <div>đội ngũ Bác sĩ, chuyên gia
                    hàng đầu với nhiều năm kinh nghiệm trong khám và</div>
                <div> tư vấn cho các khách hàng.</div>
                <br>
                <div class="info">
                    <img src="https://taimuihongsg.com/wp-content/uploads/2018/05/Kim-Bun-ThuongE_taimuihongsg.jpg" alt="">
                    <h4>Chuyên Khoa</h4>
                    <div class="tim_hieu">Tìm Hiểu Thêm</div>
                </div>
                <div class="info">
                    <img src="https://taimuihongsg.com/wp-content/uploads/2019/01/Trinh-Tan-Lap_taimuihongsg.jpg" alt="">
                    <h4>Chuyên Khoa</h4>
                    <div class="tim_hieu">Tìm Hiểu Thêm</div>
                </div>
                <div class="info">
                    <img
                        src="https://benhviendakhoatinhphutho.vn/wp-content/uploads/2021/12/BSDK-TRAN-QUANG-LUC.jpg">
                    <h4>Chuyên Khoa</h4>
                    <div class="tim_hieu">Tìm Hiểu Thêm</div>
                </div>
                <div class="info">
                    <img
                        src="https://taimuihongsg.com/wp-content/uploads/2018/05/Nguyen-Duy-Binh_taimuihongsg.jpg">
                    <h4>Chuyên Khoa</h4>
                    <div class="tim_hieu">Tìm Hiểu Thêm</div>
                </div>
                </article>
            </div>
            <br><!-- comment -->
            <br><!-- <br><!-- comment -->
            <br> 
            <h1 style="text-align: center">News</h1>
            <div class="container" style="margin-top: 50px;text-align: center">
                <div class="row">

                    <c:forEach var="n" items="${requestScope.nl}">
                        <div class="info">
                            <div class="col-lg-4 col-sm-6 mb-4">
                                <div class="card h-100">
                                    <div class="contain-product layout-default">
                                        <a href="news_detail_servlet?nid=${n.getNewsId()}" class="link-to-news d-flex align-items-center p-4" style="height: 250px;">
                                            <img class="card-img-top img-fluid" src="${n.getNewsImg()}" alt="img" style="margin: 0 auto; width: 100%; height: 200px">
                                        </a>
                                        <div class="card-body">
                                            <h4 class="card-title text-center"><a href="news_detail_servlet?nid=${n.getNewsId()}" style="text-decoration: none" class="pr-name">${n.getNewsName()}</a></h4>
                                            <div class="card-text">
                                                <p style="display: block;
  	display: -webkit-box;
  	line-height: 1.3;
  	-webkit-line-clamp: 3;
  	-webkit-box-orient: vertical;
  	overflow: hidden;
  	text-overflow: ellipsis;
  	margin-top:10px;
}">${n.getNewsSummary()}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </c:forEach>       

                </div>
            </div>

            <br><!-- comment -->
            <br><!-- <br><!-- comment -->
            <br> 
            <div class="article-title article-title--medium">
                <h2 class="article-link">Giờ làm việc tại Phòng Khám</h2>
                <div class="time"> 1.Từ <strong> Thứ 2</strong> đến<strong> Thứ 7</strong>
                    <li class="time"> Sáng: <strong>07:30 - 12:00</strong> </li>
                    <li class="time"> Chiều: <strong>13:00 - 18:00</strong> </li>
                    <br><!-- comment -->
                    <br><!-- comment -->
                    <div class="time">2.<strong>Chủ Nhật:</strong></div>
                    <li class="time"> Sáng: <strong>07:30 - 12:00</strong> </li>
                    <li class="time"> Chiều: <strong>13:00 - 17:00</strong> </li>
                </div>
            </div>

            </main>

            <jsp:include page="Footer.jsp"/>
            </html>
