package webapp;

import java.io.*;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java1.Parkhaus;
import java1.Zeit;

@WebServlet(name = "ParkhausWeb", value = "/ParkHausWeb")
public class ParkhausWeb extends HttpServlet {
    private String message;
    private String param;
    private String command;
    private Parkhaus p;


    public void init() {
        message = "Parkhaus";
        p = new Parkhaus(10,0.01,new Zeit(4,4,2023,12,30));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        /*boolean urlparamfound = false;
        if(request.getQueryString() != null) {urlparamfound = true;}
        if (urlparamfound) {
            String[] requestParamString = request.getQueryString().split("=");
            this.command = requestParamString[0];
            this.param = requestParamString[1];
        }*/
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        /* Hello

        if(urlparamfound && request.getQueryString().split("=")[0].equals("name")){
            this.message = "Hallo "+this.param;
            out.println("<h1>" + "Hello" + " " + this.param + "</h1>");
        } else {
            out.println("<h1>"+this.message+"</h1>");
        }*/
        out.println(    "<br>\n" +
                        "<b> aktuelle Zeit</b> " +
                        "<table>\n" +
                        "    <tr>\n" +
                        "        <td>\n" +
                        "           <form method=\"post\">\n" +
                        //"             <input type=\"hidden\" name=\"aktion\" value=\"timewarp\">\n" +
                        "               <input type=\"/text\" name=\"inputzeitsprung\" value="+p.getAktuelleZeit().toString()+">" +
                        "               <input type=\"submit\" value=\"Timewarp\">\n" +
                        "           </form>\n" +
                        "        </td>\n" +
                        "        <td>\n" +
                        "            <form method=\"post\">\n" +
                        "            <input type=\"button\" value=\"+15 min\" name=\"input15min\">\n" +
                        "            </form>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "</table>"



                /*"<form method=\"post\">\n" +
                "<label for=\"zeitsprung\">Zeitsprung: </label>\n" +
                "<input type=\"submit\" id=\"inputzeitsprung\" name=\"zeitsprung\">\n" +
                "<br><br>\n" +
                "<label for=\"15min\">+15min</label>\n" +
                "<input type=\"text\" id=\"input15min\" name=\"15min\">\n" +
                "<br><br>\n" +
                "<input type=\"submit\" value=\"Submit\">" +
                "</form>"*/);
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String zeitsprung = request.getParameter("inputzeitsprung");
        p.timewarp(zeitsprung);

        //request.setAttribute("inputzeitsprung",p.getAktuelleZeit().toString());
        //this.zahl2 = Integer.parseInt(request.getParameter("input15min"));
        out.println("<html><body> "+ p.getAktuelleZeit() +"</body></html>");
    }

    public void destroy() {
    }
}