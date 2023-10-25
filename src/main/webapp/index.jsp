<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.LoaiXe" %>
<%@ page import="vn.edu.iuh.fit.DAO.QuanLyXe_Dao" %>
<%@ page import="vn.edu.iuh.fit.entities.Xe" %>
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
   List<Xe> dsXeList = (List<Xe>) request.getAttribute("dsxe");
   dsXeList = dsXeList != null?dsXeList:new QuanLyXe_Dao().getAllXe();
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
        <a href="dsLoai.jsp" style="margin-right: 10px ">Danh Sách Loại Xe</a>
        <a href="them.jsp" style="margin-right: 10px " >Thêm Xe</a>
    </div>
    <div style="height: 500px; width: 900px">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ma</th>
                <th scope="col">ten</th>
                <th scope="col">gia</th>
                <th scope="col">nam</th>
            </tr>
            </thead>
            <tbody>
        <%for (Xe xe:dsXeList){%>
        <tr>
            <td><%=xe.getMaXe()%></td>
            <td><%=xe.getTenXe()%></td>
            <td><%=xe.getGia()%></td>
            <td><%=xe.getNamSX()%></td>
        </tr>
        <%}%>
            </tbody>
        </table>
    </div>

</DIV>
</body>
</html>