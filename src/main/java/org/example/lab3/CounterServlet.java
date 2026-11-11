package org.example.lab3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", value = "/CounterServlet")
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer counterGet = (Integer)
                request.getSession().getAttribute("CounterGetName");
        if (counterGet == null) {
            counterGet = 0;
        }
        String increment = request.getParameter("inc");
        String decrement = request.getParameter("dec");
        if(increment != null && !increment.isEmpty()){
            try{
                counterGet += Integer.parseInt(increment);
            }
            catch(NumberFormatException e){
                counterGet++;
            }
        }
        if(decrement != null && !decrement.isEmpty()){
            try{
                counterGet -= Integer.parseInt(decrement);
            }
            catch(NumberFormatException e){
                counterGet--;
            }
        }
        if(counterGet==0){
            request.getSession().setAttribute("warningGET",true);
        }
        else{
            request.getSession().removeAttribute("CounterGetName");
        }
        request.getSession().setAttribute("CounterGetName", counterGet);
        status(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer counterPost = (Integer)
                request.getSession().getAttribute("CounterPostName");
        if (counterPost == null) {
            counterPost = 0;
        }
        String increment = request.getParameter("inc");
        String decrement = request.getParameter("dec");
        if(increment != null && !increment.isEmpty()){
            try{
                counterPost += Integer.parseInt(increment);
            }
            catch(NumberFormatException e){
                counterPost++;
            }
        }
        if(decrement != null && !decrement.isEmpty()){
            try{
                counterPost -= Integer.parseInt(decrement);
            }
            catch(NumberFormatException e){
                counterPost--;
            }
        }
        if(counterPost==0){
            request.getSession().setAttribute("warningPOST",true);
        }
        else{
            request.getSession().removeAttribute("CounterPostName");
        }
        request.getSession().setAttribute("CounterPostName", counterPost);
        status(request, response);
    }

    private void status(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h2>Welcome to Counter Servlet</h2>");
        Integer counterGet = (Integer)
                request.getSession().getAttribute("CounterGetName");
        printWriter.println("<br> Counter for GET: " + counterGet);
        Boolean warningGET = (Boolean)
                request.getSession().getAttribute("warningGET");
        printWriter.println(" <strong style='color:red;'>WARNING GET</strong>");
        Integer counterPost = (Integer)
                request.getSession().getAttribute("CounterPostName");
        Boolean warningPOST = (Boolean)
                request.getSession().getAttribute("warningPOST");
        printWriter.println("<br> Counter for POST: " + counterPost);
        printWriter.println("<br> Counter for POST: " + counterPost);
    }
}