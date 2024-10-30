package org.example.lr3web;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lr3web.logic.CalculateFunction;


@WebServlet("/CalculateFunServlet")
public class CalculateFunServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
            double a = Double.parseDouble(request.getParameter("a"));
            double b = Double.parseDouble(request.getParameter("b"));
            double start = Double.parseDouble(request.getParameter("start"));
            double finish = Double.parseDouble(request.getParameter("finish"));
            double step = Double.parseDouble(request.getParameter("step"));

            CalculateFunction calculateFunction = new CalculateFunction();
            int steps = calculateFunction.stepsCalc(start, finish, step);
            calculateFunction.arraysGenerate(start, finish, step, a, b);
            double[] xValues = calculateFunction.getXValues();
            double[] yValues = calculateFunction.getYValues();
            int maxIndex = calculateFunction.maxIndex();
            int minIndex = calculateFunction.minIndex();
            double sum = calculateFunction.sumYValues();
            double average = calculateFunction.averageYValues();

        String templatePath = getServletContext().getRealPath("/result.html");
        StringBuilder htmlContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(templatePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                htmlContent.append(line).append("\n");
            }
        }

        StringBuilder tableRows = new StringBuilder();
        for (int i = 0; i < steps; i++) {
            tableRows.append("<tr><td>").append(i)
                    .append("</td><td>").append(xValues[i])
                    .append("</td><td>").append(yValues[i])
                    .append("</td></tr>\n");
        }
        String resultHtml = htmlContent.toString()
                .replace("${tableRows}", tableRows.toString())
                .replace("${maxIndex}", String.valueOf(maxIndex))
                .replace("${maxYValue}", String.valueOf(yValues[maxIndex]))
                .replace("${maxXValue}", String.valueOf(xValues[maxIndex]))
                .replace("${minIndex}", String.valueOf(minIndex))
                .replace("${minYValue}", String.valueOf(yValues[minIndex]))
                .replace("${minXValue}", String.valueOf(xValues[minIndex]))
                .replace("${sum}", String.valueOf(sum))
                .replace("${average}", String.valueOf(average));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(resultHtml);
    }
}
