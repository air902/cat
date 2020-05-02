package com.chedilong.event.servlet.User;

import com.chedilong.event.entity.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PlayerAddServlet")
public class PlayerAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        Player player = new Player(null,
                request.getParameter("account"),
                request.getParameter("password"),
                request.getParameter("portrait"),
                request.getParameter("name"),
                Integer.valueOf(request.getParameter("age")),
                request.getParameter("introduction"),
                request.getParameter("lastTeam"),
                request.getParameter("joinDate"),
                request.getParameter("email"),
                "审核中",
                "未提交转会申请",
                "玩家");

        String account = request.getParameter("account");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
