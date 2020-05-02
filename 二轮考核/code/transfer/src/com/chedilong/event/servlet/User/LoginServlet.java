package com.chedilong.event.servlet.User;

import com.chedilong.event.entity.Manager;
import com.chedilong.event.entity.Player;
import com.chedilong.event.service.ManagerService;
import com.chedilong.event.service.PlayerService;
import com.chedilong.event.service.impl.ManagerServiceImpl;
import com.chedilong.event.service.impl.PlayerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transfer/front/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String rank = request.getParameter("rank");
        System.out.println("buzhou1");


        if(rank.equals("玩家")){
            System.out.println("玩家");
            //玩家登录
            PlayerService playerService=new PlayerServiceImpl();
            Player result = playerService.login(userName,password);
            if(result!=null){
                HttpSession session=request.getSession();
                session.setAttribute("user",result);
                //标记位，标记用户是否登录成功
                session.setAttribute("isLogin",1);
                response.sendRedirect("index.jsp");
            }else{
                PrintWriter out=response.getWriter();
                out.write("<script>");
                out.write("alert('登录失败！')");
                out.write("location.href='login.jsp'");
                out.write("</script>");
            }
        }else{
            //战队管理层和超级管理员登录
            ManagerService managerService=new ManagerServiceImpl();
            Manager result=managerService.login(userName,password,rank);
            if(result!=null){
                HttpSession session=request.getSession();
                session.setAttribute("user",result);
                //标记位，标记用户是否登录成功
                session.setAttribute("isLogin",1);
                response.sendRedirect("index.jsp");
            }else{
                PrintWriter out=response.getWriter();
                out.write("<script>");
                out.write("alert('登录失败！')");
                out.write("location.href='login.jsp'");
                out.write("</script>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
