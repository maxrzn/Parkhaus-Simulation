package src.main.webapp;

import java.io.*;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "testServlet", value = "/test")
public class testservlet extends HttpServlet {
    private String message;
    private String param;
    private String command;
    private int zahl1;
    private int zahl2;

    public void init() {
        message = "Hallo Mensch ohne Namen";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        boolean urlparamfound = false;
        if(request.getQueryString() != null) {urlparamfound = true;}
        if (urlparamfound) {
            String[] requestParamString = request.getQueryString().split("=");
            this.command = requestParamString[0];
            this.param = requestParamString[1];
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(urlparamfound && request.getQueryString().split("=")[0].equals("name")){
            this.message = "Hallo "+this.param;
            out.println("<h1>" + "Hello" + " " + this.param + "</h1>");
        } else {
            out.println("<h1>"+this.message+"</h1>");
        }
        out.println("<h1></h1><br/><form action=\"test\" method=\"post\">\n" +
                "<label for=\"zahl1\">Zahl1:</label>\n" +
                "<input type=\"text\" id=\"zahl1\" name=\"zahl1\">\n" +
                "<br><br>\n" +
                "<label for=\"zahl2\">Zahl2:</label>\n" +
                "<input type=\"text\" id=\"zahl2\" name=\"zahl2\">\n" +
                "<br><br>" +
                "<input type=\"submit\" value=\"Submit\">" +
                "</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        this.zahl1 = Integer.parseInt(request.getParameter("zahl1"));
        this.zahl2 = Integer.parseInt(request.getParameter("zahl2"));
        int erg = this.zahl1 + this.zahl2;
        out.println("<html><body> "+erg+"</body></html>");
    }

    public void destroy() {
    }
}