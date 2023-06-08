package webapp;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java1.Auto;
import java1.Parkhaus;
import java1.Zeit;


//TODO http://localhost:8080/Team_33_sose23_war_exploded/ParkHausWeb servlet bis jetzt nur hier aufrufbar
@WebServlet(name = "ParkHausWeb", value = "/ParkHausWeb")
public class ParkhausWeb extends HttpServlet {
    private Parkhaus p;
    //private String log;
    private String inLog;


    public void init() {
        p = new Parkhaus(10,0.01,new Zeit(4,4,2023,12,30));
        //log = "empty log";
        this.inLog = "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //main output
        out.println("<html>" +
                "<body>" +
                "<style type=\"text/css\">\n" +
                "table.tb, .tb tr:first-child td {\n" +
                "  border: solid black;\n" +
                "  border-collapse: collapse;\n" +
                "}\n" +
                ".tb td { border: 1px solid black;" +
                "         padding: 5px;}\n" +
                "div.wrap {\n" +
                "  width: 25%;\n" +
                "  float: left;\n" +
                "  margin: 0px;\n" +
                "}\n" +
                "p.color {\n" +
                "  color: #0d0100;\n" +
                "}\n" +
                "\n" +
                ".color red {\n" +
                "  color: #ed4d47;\n" +
                "}" +
                "</style>");

        out.println(
                // "<fieldset>" +
                //  "   <legend> <h3> Environmental Settings </h3> </legend>" +
                "<table style =\"border:1px solid black;\" >\n" +
                        "    <thead>\n" +
                        "        <tr>\n" +
                        "        <th colspan=\"5\" align=\"center\"><b> Zeiteinstellungen </b> </th>\n" +
                        "        <th>&nbsp;</th>\n" +
                        "        <th colspan=\"2\"> Autos </th>\n" +
                        "    </thead>\n"+
                        "    <tbody>\n" +
                        "        <tr>\n" +
                        "            <td>\n" +
                        "                <form method=\"post\">\n" +
                        "                <input type=\"/text\" name=\"inputzeitsprung\" value=\""+p.getAktuelleZeit().toString()+"\">\n" +
                        "                </form>\n" +
                        "            </td>\n" +
                        "            <td>        \n" +
                        "                <form method=\"post\">\n" +
                        "                <input type=\"submit\" value=\"+1 min\" name=\"input1min\"> \n" +
                        "        </form>        \n" +
                        "            </td>\n" +
                        "            <td>\n" +
                        "                <form method=\"post\">\n" +
                        "                <input type=\"submit\" value=\"+15 min\" name=\"input15min\">\n" +
                        "            </form>\n" +
                        "            </td>\n" +
                        "            <td>\n" +
                        "                <form method=\"post\">\n" +
                        "                <input type=\"submit\" value=\"+1 h\" name=\"input1h\">\n" +
                        "                </form>\n" +
                        "            </td>\n" +
                        "            <td>           \n" +
                        "                <form method=\"post\">\n" +
                        "                <input type=\"submit\" value=\"+12 h\" name=\"input12h\">\n" +
                        "               </form>\n" +
                        "            </td>\n" +
                        "            <td>\n" +
                        "                &nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "            </td>\n" +
                        "            <td align=\"left\">\n" +
                        "                <form method=\"post\">\n" +
                        "                    <input type=\"submit\" style=\"background-color:lightgreen\" value=\"+1 Auto\" name=\"pull\">\n" +
                        "                </form>\n" +
                        "            </td>\n" +
                        "            <td>\n" +
                        "                <form method=\"post\">\n" +
                        "                    <input type=\"submit\" style=\"background-color:lightgreen\" value=\"+10 Autos\" name=\"pull10\">\n" +
                        "                </form>\n" +
                        "            </td>"+
                        "        </tr>\n" +
                        "    </tbody>\n" +
                        "</table>" +
                        // "</fieldset>" +
                        "<br>\n" +
                        "<br>\n" +
                        "<br>\n"+
                        "<div class=\"wrap\">\n" +
                        "<table class=\"tb\">\n" +
                        "    <thead>\n" +
                        "        <tr>\n" +
                        "            <th align=\"center\" colspan=\"2\"> Einfahrt Log </th> \n" +
                        "        </tr>\n" +
                        "    </thead>\n" +
                        "<tbody>\n" +
                        "    <tr>\n" +
                        "        <td align=\"center\">Zeit </td>\n" +
                        "        <td align=\"center\">Kennzeichen</td>\n" +
                        "    </tr> " +
                        this.inLog +
                        "</tbody>" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div class=\"wrap\">\n" +
                        "<table class=\"tb\">\n" +
                        "    <tr>\n" +
                        "<th align=\"center\" colspan=\"4\"> Ausfahrt Log </th>" +
                        "    </tr>\n" +
                        "<tbody>\n" +
                        "<tr>" +
                        "<td align=\"center\">" +
                        "Zeit" +
                        "</td>" +
                        "<td align=\"center\">" +
                        "Kennzeichen" +
                        "</td>" +
                        "<td align=\"center\">" +
                        "Dauer" +
                        "</td>" +
                        "<td align=\"center\">" +
                        "Preis" +
                        "</td>" +
                        "</tr>" +
                        p.getLog() +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n"
        );
        out.println("</body></html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //TODO known bug: refresh direkt nach button press --> erneute formular übermittlung button ist noch !=null und führt funktion daher nochmal aus


        if(request.getParameter("inputzeitsprung") != null) {               //Zeitsprung (ist immer != null deswegen nur if, glaub ich)
            p.timewarp(request.getParameter("inputzeitsprung"));
        }
        if(request.getParameter("input1min") != null) {                     //+1 min
            p.timeskip(0,1);
        } else if(request.getParameter("input15min") != null){              //+15 min
            p.timeskip(0,15);
        } else if(request.getParameter("input1h") != null) {                //+1h
            p.timeskip(1,0);
        } else if(request.getParameter("input12h") != null) {               //+12h
            p.timeskip(12,0);
        } else if(request.getParameter("pull") != null) {                   // pull
            Auto a = p.pull();
            this.inLog +="<tr>\n" +
                    "   <td>\n" +
                    "       <p class=\"color\"> <red>" + p.getAktuelleZeit() + " </red></p>\n" +
                    "   </td>\n" +
                    "   <td>\n" +
                    "       <p>" + a.getId() + "</p>\n" +
                    "   </td>\n" +
                    "</tr>\n";
        } else if(request.getParameter("pull10") != null) {                 //pull10
            for(int i=0; i<10; i++){
                Auto a = p.pull();
                this.inLog +="<tr>\n" +
                        "   <td>\n" +
                        "       <p class=\"color\"> <red>" + p.getAktuelleZeit() + " </red></p>\n" +
                        "   </td>\n" +
                        "   <td>\n" +
                        "       <p>" + a.getId() + "</p>\n" +
                        "   </td>\n" +
                        "</tr>\n";
            }
        }



        //main output
        out.println("<html>" +
                "<body>" +
                "<style type=\"text/css\">\n" +
                "table.tb, .tb tr:first-child td {\n" +
                "  border: solid black;\n" +
                "  border-collapse: collapse;\n" +
                "}\n" +
                ".tb td { border: 1px solid black;" +
                "         padding: 5px;}\n" +
                "div.wrap {\n" +
                "  width: 25%;\n" +
                "  float: left;\n" +
                "  margin: 0px;\n" +
                "}\n" +
                "p.color {\n" +
                "  color: #0d0100;\n" +
                "}\n" +
                "\n" +
                ".color red {\n" +
                "  color: #ed4d47;\n" +
                "}" +
                "</style>");

        out.println(
                "<fieldset>\n" +
                "   <legend> <h3> Environmental Settings </h3> </legend><table style =\"border:1px solid black;\" >\n" +
                "    <thead>\n" +
                "        <tr>\n" +
                "        <th colspan=\"5\" align=\"center\"><b> Zeiteinstellungen </b> </th>\n" +
                "        <th>&nbsp;</th>\n" +
                "        <th colspan=\"2\"> Autos </th>\n" +
                "        <th>&nbsp;</th>\n" +
                "        <th colspan=\"2\" align=\"center\"> Parkhaus </th>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <form method=\"post\">\n" +
                "                <input type=\"/text\" name=\"inputzeitsprung\" value=\""+p.getAktuelleZeit()+"\">\n" +
                "                </form>\n" +
                "            </td>\n" +
                "            <td>        \n" +
                "                <form method=\"post\">\n" +
                "                <input type=\"submit\" value=\"+1 min\" name=\"input1min\"> \n" +
                "        </form>        \n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <form method=\"post\">\n" +
                "                <input type=\"submit\" value=\"+15 min\" name=\"input15min\">\n" +
                "            </form>\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <form method=\"post\">\n" +
                "                <input type=\"submit\" value=\"+1 h\" name=\"input1h\">\n" +
                "                </form>\n" +
                "            </td>\n" +
                "            <td>           \n" +
                "                <form method=\"post\">\n" +
                "                <input type=\"submit\" value=\"+12 h\" name=\"input12h\">\n" +
                "               </form>\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "            </td>\n" +
                "            <td align=\"left\">\n" +
                "                <form method=\"post\">\n" +
                "                    <input type=\"submit\" style=\"background-color:lightgreen\" value=\"+1 Auto\" name=\"pull\">\n" +
                "                </form>\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <form method=\"post\">\n" +
                "                    <input type=\"submit\" style=\"background-color:lightgreen\" value=\"+10 Autos\" name=\"pull10\">\n" +
                "                </form>\n" +
                "            </td>        \n" +
                "            <td>\n" +
                "                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <form action=\"post\">\n" +
                "                    <input type=\"text\" placeholder=\"Größe\" name=\"inputsize\">\n" +
                "        \n" +
                "                    <input type=\"text\" placeholder=\"Tarif in &#8364; p. min.\" name=\"inputtarif\">\n" +
                "            \n" +
                "                    <input type=\"text\" placeholder=\"DD.MM.YYY, hh:mm\" name=\"inputtime\">\n" +
                "                    <input type=\"submit\" name=\"inputparkhaus\" value=\"new Parkhaus\">\n" +
                "                </form>\n" +
                "            </td>\n" +
                "             <td>\n" +
                "                <form method=\"post\">\n" +
                "                    <input type=\"submit\" style=\"background-color:red\" value=\"reset\" name=\"inputreset\">\n" +
                "                </form>\n" +
                "            </td>\n" +
                "            </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</fieldset>\n"+
                "<br>\n" +
                "<br>\n" +
                "<br>\n"+
                "<div class=\"wrap\">\n" +
                "<table class=\"tb\">\n" +
                "    <thead>\n" +
                "        <tr>\n" +
                "            <th align=\"center\" colspan=\"2\"> Einfahrt Log </th> \n" +
                "        </tr>\n" +
                "    </thead>\n" +
                "<tbody>\n" +
                "    <tr>\n" +
                "        <td align=\"center\">Zeit </td>\n" +
                "        <td align=\"center\">Kennzeichen</td>\n" +
                "    </tr> " +
                this.inLog +
                "</tbody>" +
                "</table>\n" +
                "</div>\n" +
                "<div class=\"wrap\">\n" +
                "<table class=\"tb\">\n" +
                "    <tr>\n" +
                "<th align=\"center\" colspan=\"4\"> Ausfahrt Log </th>" +
                "    </tr>\n" +
                "<tbody>\n" +
                "<tr>" +
                "<td align=\"center\">" +
                "Zeit" +
                "</td>" +
                "<td align=\"center\">" +
                "Kennzeichen" +
                "</td>" +
                "<td align=\"center\">" +
                "Dauer" +
                "</td>" +
                "<td align=\"center\">" +
                "Preis" +
                "</td>" +
                "</tr>" +
                p.getLog() +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n"
        );
        out.println("</body></html>");
        //out.flush();
    }

    public void destroy() {
    }
}