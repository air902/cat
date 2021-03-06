package com.chedilong.event.servlet.User;

import com.chedilong.event.service.PlayerService;
import com.chedilong.event.service.impl.PlayerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/AdminPlayerBanServlet")
public class AdminPlayerBanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int banPlayer = Integer.valueOf(request.getParameter("banPlayer"));
        String cp = request.getParameter("cp");
        String accountStatus = request.getParameter("accountStatus");
        String playerName = request.getParameter("playerName");
        String operation = request.getParameter("operation");

        System.out.println("Ban的playerId为"+banPlayer);
        System.out.println("Ban的operation为"+operation);

        //到数据库更改用户账号状态
        PlayerService playerService = new PlayerServiceImpl();
        int result = playerService.banApplication(banPlayer,operation);
        if(result>0){
            HttpSession session = request.getSession();
            session.setAttribute("accountStatus",accountStatus);
            session.setAttribute("playerName",playerName);
            session.setAttribute("cp",cp);
            response.sendRedirect("/transfer_war_exploded/manager/AdminPlayerInFoFindServlet");
        }else{
            PrintWriter out=response.getWriter();
            out.write("<script>");
            out.write("alert('操作失败')");
            out.write("location.href='/transfer_war_exploded/manager/AdminPlayerInFoFindServlet");
            out.write("</script>");
        }
    }
}
