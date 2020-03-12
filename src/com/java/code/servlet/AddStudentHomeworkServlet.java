package com.java.code.servlet;


import com.java.code.jdbc.HomeworkJdbc;
import com.java.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/add")
public class AddStudentHomeworkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentHomework sh = new StudentHomework();
        /**
         * 赋值
         */
        sh.setStudentId(Long.getLong(req.getParameter("student_id")));
        HomeworkJdbc.addStudentHomework(sh);

        resp.sendRedirect("list");
    }
}