<%--
  Created by IntelliJ IDEA.
  User: ko
  Date: 2020/5/2
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <%@ include file = "AdminMenu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用LPL转会管理平台。</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="AdminPlayerInFo.jsp"><i class="icon-font">&#xe001;</i>选手管理</a>
                    <a href="AdminTransferInFo.jsp"><i class="icon-font">&#xe005;</i>转会信息管理</a>
                    <a href="AdminPlayerInform.jsp"><i class="icon-font">&#xe048;</i>举报信息管理</a>
                </div>
            </div>
        </div>


    <!--/main-->
</div>
</body>
</html>
