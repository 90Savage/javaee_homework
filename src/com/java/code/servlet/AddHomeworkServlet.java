package com.java.code.servlet;


import com.java.code.jdbc.HomeworkJdbc;
import com.java.code.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/addHomework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        Homework homework = new Homework();

        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        Date date = new Date();
        homework.setCreateTime(date);

        boolean result = HomeworkJdbc.addHomework(homework);

        req.setAttribute("isOK", result);    //用来判断是否添加作业成功
        req.setAttribute("type","addHomework");
        req.getRequestDispatcher("jsp/t_return.jsp").forward(req,resp);
    }
}