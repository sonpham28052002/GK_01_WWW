<%@ page import="vn.edu.iuh.fit.entities.LoaiXe" %>
<%@ page import="vn.edu.iuh.fit.DAO.QuanLyXe_Dao" %>
<%@ page import="vn.edu.iuh.fit.entities.Xe" %>
<%@ page import="vn.edu.iuh.fit.DAO.QuanLyLoaiXe_DAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
            crossorigin="anonymous"></script>
</head>
<%
    QuanLyLoaiXe_DAO quanLyLoaiXeDao = new QuanLyLoaiXe_DAO();
    List<LoaiXe> dsXeList = quanLyLoaiXeDao.getLoaiXe();
%>
<body style=" display: flex;justify-content: center; align-items: center ">
<DIV style=" height: 500px;
             width:900px;
             display: flex;
             justify-content: center;
             align-items: center;
             border-width:1px ;
             border-color: black;
             flex-direction: column;
"
>
    <div style="height: 50px; width: 900px; background-color: aqua; border-width: 2px; border-color: black;display: flex;
             justify-content: center;
             align-items: center;">
        <H1>20106801-Phạm Thanh Sơn</H1>
    </div>
    <div >
        <a href="hello-servlet?action=danhsachloaixe" style="margin-right: 10px ">Danh Sách Loại Xe</a>
        <a href="them.jsp" style="margin-right: 10px " >Thêm Xe</a>
    </div>
    <div style="height: 500px; width: 900px">
        <form action="hello-servlet" method="get">
            <div class="form-group">
                <label for="exampleInputEmail1">Tên xe:</label>
                <input type="text" class="form-control" id="exampleInputEmail1" name="ten" placeholder="tên xe">
            </div>
            <div class="form-group">
                <label for="gia">Gía:</label>
                <input type="text" name="gia" class="form-control" id="gia" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="nam">Gía:</label>
                <input type="text" name="nam" class="form-control" id="nam" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Loại Xe</label>
                <select class="form-control" id="exampleFormControlSelect1" name="loai">
                    <% for (LoaiXe xe:dsXeList){%>
                    <option value=<%=xe.getMaLoai()%> ><%=xe.getTenLoai()%></option>
                    <%}%>

                </select>
            </div>
            <button type="submit" name="themxe" class="btn btn-primary">Submit</button>
        </form>
    </div>

</DIV>
</body>
</html>