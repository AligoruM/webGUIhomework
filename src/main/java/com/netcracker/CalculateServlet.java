package com.netcracker;


import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double a = Double.parseDouble(req.getParameter("A"));
        double b = Double.parseDouble(req.getParameter("B"));
        double c = Double.parseDouble(req.getParameter("C"));

        Answer ans = new Answer(a,b,c);
        String answerStr = new Gson().toJson(ans);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(answerStr);

        out.flush();
    }
}
