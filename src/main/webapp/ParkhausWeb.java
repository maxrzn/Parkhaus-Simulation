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
    //private String log;


    public void init() {
        message = "Parkhaus";
        p = new Parkhaus(10,0.01,new Zeit(4,4,2023,12,30));
        //log = "empty log";
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
        out.println("<br>\n" +
                "<b> aktuelle Zeit</b> " +
                "<table>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "           <form method=\"post\">\n" +
                //"             <input type=\"hidden\" name=\"aktion\" value=\"timewarp\">\n" +
                "               <input type=\"/text\" name=\"inputzeitsprung\" value=\""+p.getAktuelleZeit().toString()+"\">\n" +
                "               <input type=\"submit\" value=\"Timewarp\">" +
                "           </form>\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <form method=\"post\">\n" +
                "            <input type=\"submit\" value=\"+15 min\" name=\"input15min\">\n" +
                "            </form>\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <form method=\"post\">\n" +
                "            <input type=\"submit\" value=\"+1 h\" name=\"input1h\">\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "   <tr>\n" +
                "       <td>\n" +
                "            <form method=\"post\">\n" +
                "               <input type=\"submit\" value=\"auto parken\" name=\"pull\">\n" +
                "       </td>\n" +
                "   </tr>\n" +
                "</table>\n" +
                "<p>" + p.getLog() + "</p>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Zeitsprung
        if(request.getParameter("inputzeitsprung") != null) {
            p.timewarp(request.getParameter("inputzeitsprung"));
        }
        //+15 min
        if(request.getParameter("input15min") != null){
            p.timeskip(0,15);
        }
        //+1h
        if(request.getParameter("input1h") != null) {
            p.timeskip(1,0);
        }
        //pull
        if(request.getParameter("pull") != null) {
            p.pull();
        }


        //request.setAttribute("inputzeitsprung",p.getAktuelleZeit().toString());
        //this.zahl2 = Integer.parseInt(request.getParameter("input15min"));
        out.println("<html><body> ");
        out.println("<br>\n" +
                        "<b> aktuelle Zeit</b> " +
                        "<table>\n" +
                        "    <tr>\n" +
                        "        <td>\n" +
                        "           <form method=\"post\">\n" +
                        //"             <input type=\"hidden\" name=\"aktion\" value=\"timewarp\">\n" +
                        "               <input type=\"/text\" name=\"inputzeitsprung\" value=\""+p.getAktuelleZeit().toString()+"\">\n" +
                        "               <input type=\"submit\" value=\"Timewarp\">" +
                        "           </form>\n" +
                        "        </td>\n" +
                        "        <td>\n" +
                        "            <form method=\"post\">\n" +
                        "            <input type=\"submit\" value=\"+15 min\" name=\"input15min\">\n" +
                        "            </form>\n" +
                        "        </td>\n" +
                        "        <td>\n" +
                        "            <form method=\"post\">\n" +
                        "            <input type=\"submit\" value=\"+1 h\" name=\"input1h\">\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "   <tr>\n" +
                        "       <td>\n" +
                        "            <form method=\"post\">\n" +
                        "               <input type=\"submit\" value=\"auto parken\" name=\"pull\">\n" +
                        "       </td>\n" +
                        "   </tr>\n" +
                        "</table>\n" +
                        "<p>" + p.getLog() + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}