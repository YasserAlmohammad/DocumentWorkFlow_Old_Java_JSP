import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;
import org.apache.jasper.runtime.*;
import java.beans.*;
import org.apache.jasper.JasperException;
import java.sql.*;
import  java.util.StringTokenizer;


public class _0002freporting_0002ejspreporting_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002freporting_0002ejspreporting_jsp_0( ) {
    }

    private static boolean _jspx_inited = false;

    public final void _jspx_init() throws JasperException {
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse  response)
        throws IOException, ServletException {

        JspFactory _jspxFactory = null;
        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        String  _value = null;
        try {

            if (_jspx_inited == false) {
                _jspx_init();
                _jspx_inited = true;
            }
            _jspxFactory = JspFactory.getDefaultFactory();
            response.setContentType("text/html; charset=windows-1252");
            pageContext = _jspxFactory.getPageContext(this, request, response,
			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(0,57);to=(1,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
                project.Connect connector = null;
                boolean _jspx_specialconnector  = false;
                 synchronized (session) {
                    connector= (project.Connect)
                    pageContext.getAttribute("connector",PageContext.SESSION_SCOPE);
                    if ( connector == null ) {
                        _jspx_specialconnector = true;
                        try {
                            connector = (project.Connect) Beans.instantiate(this.getClass().getClassLoader(), "project.Connect");
                        } catch (Exception exc) {
                             throw new ServletException (" Cannot create bean of class "+"project.Connect");
                        }
                        pageContext.setAttribute("connector", connector, PageContext.SESSION_SCOPE);
                    }
                 } 
                if(_jspx_specialconnector == true) {
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,69);to=(1,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
                project.UserInfo userInfo = null;
                boolean _jspx_specialuserInfo  = false;
                 synchronized (application) {
                    userInfo= (project.UserInfo)
                    pageContext.getAttribute("userInfo",PageContext.APPLICATION_SCOPE);
                    if ( userInfo == null ) {
                        _jspx_specialuserInfo = true;
                        try {
                            userInfo = (project.UserInfo) Beans.instantiate(this.getClass().getClassLoader(), "project.UserInfo");
                        } catch (Exception exc) {
                             throw new ServletException (" Cannot create bean of class "+"project.UserInfo");
                        }
                        pageContext.setAttribute("userInfo", userInfo, PageContext.APPLICATION_SCOPE);
                    }
                 } 
                if(_jspx_specialuserInfo == true) {
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,74);to=(2,0)]
                out.write("\r\n");
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(1,40);to=(15,0)]
                out.write("\r\n\r\n<html>\r\n\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\">\r\n\r\n<title>Reporting</title>\r\n</head>\r\n\r\n<body bgcolor=\"#eeeeee\">\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(15,2);to=(16,3)]
                 if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
                   
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(16,5);to=(16,6)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(16,6);to=(16,38)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(16,38);to=(17,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(17,2);to=(17,4)]
                } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(17,6);to=(49,0)]
                out.write("\r\n\r\n<p align=\"center\">\r\n<a href=\"inbox.jsp\"><font color=\"#000080\"><b>inbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"outbox.jsp\"><font color=\"#000080\"><b>outbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"sendPageGenerator.jsp\"><font color=\"#000080\"><b>send doc</b></font></a>&nbsp;&nbsp;\r\n<a href=\"reporting.jsp\"><font color=\"#000080\"><b>reporting</b></font></a>&nbsp;&nbsp;\r\n<a href=\"changeUserPass.jsp\"><font color=\"#000080\"><b>changePassword</b></font></a>&nbsp;&nbsp;\r\n<a href=\"helpFiles/help.htm\"><font color=\"#000080\"><b>help&amp;support</b></font></a></p>\r\n<h1 align=\"center\"><font color=\"#800000\" size=\"5\"><i>Reporting</i></font></h1>\r\n\r\n<form method=\"POST\" action=\"searchDoc.jsp\">\r\n <dl>\r\n    <p align=\"left\"><b><font color=\"#666666\">Find specefic document&nbsp;</font></b></p>\r\n     <p> <input type=\"checkbox\" name=\"C1\"  value=\"ON\"> <b><font color=\"#666666\">number on document&nbsp; : &nbsp;&nbsp;&nbsp;</b></font> <input type=\"text\" name=\"num_on_doc\" size=\"20\" ></p>\r\n     <p> <input type=\"checkbox\" name=\"C2\"  value=\"ON\"> <b><font color=\"#666666\">date   on document&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;</b></font>\r\n     <input type=\"text\" name=\"day\" size=\"2\" >\r\n     <input type=\"text\" name=\"month\" size=\"2\" >\r\n     <input type=\"text\" name=\"year\" size=\"4\" >\r\n     </p>\r\n     <dt>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n     <input type=\"submit\" value=\"find\" name=\"find\"></dt>\r\n     </dl>\r\n</form>\r\n<hr>\r\n<!--       -->\r\n<form method=\"POST\" action=\"getDocsFrom.jsp\">\r\n <dl>\r\n   <p align=\"left\"><b><font color=\"#666666\">Find document reached from specefic\r\n   position&nbsp;</font></b></p>\r\n   <select size=\"1\" name=\"pos_name\">\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(49,2);to=(58,7)]
                try{
                   String pos_name="";
                   String pos_id="";
                
                   //administrator is not count, and you can't send message to your self directly
                   ResultSet poss=connector.executeQuery("SELECT pos_name FROM position WHERE pos_name<> 'administrator' AND pos_id<>"+userInfo.getPos_id());
                   while(poss.next()){
                       pos_name=poss.getString("pos_name");
                      //we can know everything about user from pos_id
                       
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(58,9);to=(60,22)]
                out.write("\r\n\r\n       <option value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(60,25);to=(60,35)]
                out.print( pos_name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(60,37);to=(60,40)]
                out.write("\"> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(60,43);to=(60,52)]
                out.print(pos_name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(60,54);to=(61,3)]
                out.write("</option>\r\n   ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(61,5);to=(61,30)]
                }}catch(SQLException e){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(61,32);to=(62,24)]
                out.write("\r\n    <h1> SQL error <h1> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(62,27);to=(62,40)]
                out.print(e.toString() );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(62,42);to=(63,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(63,2);to=(63,5)]
                 } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(63,7);to=(79,2)]
                out.write("\r\n  </select>&nbsp;&nbsp;\r\n  <input type=\"submit\" value=\"find\" name=\"find\">\r\n  </p></dl>\r\n  <br><br>\r\n</form>\r\n\r\n<hr>\r\n\r\n<form method=\"POST\" action=\"getSendedTo.jsp\">\r\n\r\n <dl>\r\n  <p align=\"left\"> <b><font color=\"#666666\">Find documents sent to spesefic\r\n  position</font></b></p>\r\n   <select size=\"1\" name=\"pos_name\">\r\n\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(79,4);to=(88,7)]
                try{
                   String pos_name="";
                   String pos_id="";
                
                   //administrator is not count, and you can't send message to your self directly
                   ResultSet poss=connector.executeQuery("SELECT pos_name FROM position WHERE pos_name<> 'administrator' AND pos_id<>"+userInfo.getPos_id());
                   while(poss.next()){
                       pos_name=poss.getString("pos_name");
                      //we can know everything about user from pos_id
                       
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(88,9);to=(89,22)]
                out.write("\r\n       <option value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(89,25);to=(89,34)]
                out.print( pos_name);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(89,36);to=(89,39)]
                out.write("\"> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(89,42);to=(89,51)]
                out.print(pos_name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(89,53);to=(90,3)]
                out.write("</option>\r\n   ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(90,5);to=(90,30)]
                }}catch(SQLException e){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(90,32);to=(91,24)]
                out.write("\r\n    <h1> SQL error <h1> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(91,27);to=(91,40)]
                out.print(e.toString() );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(91,42);to=(92,2)]
                out.write("\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(92,4);to=(92,5)]
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\reporting.jsp";from=(92,7);to=(140,7)]
                out.write("\r\n  </select>&nbsp;&nbsp;\r\n  <input type=\"submit\" value=\"find\" name=\"find\">\r\n  </p></dl>\r\n</form>\r\n\r\n<hr>\r\n\r\n<form method=\"POST\" action=\"sentDocsBetweenTwoDates.jsp\">\r\n   <b><font color=\"#666666\">Find documents sent between &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></b>\r\n   <input type=\"text\" name=\"day1\" size=\"2\" >\r\n   <input type=\"text\" name=\"month1\" size=\"2\" >\r\n   <input type=\"text\" name=\"year1\" size=\"4\" >\r\n   <b><font color=\"#666666\">&nbsp;&nbsp; and &nbsp;&nbsp;</font></b>\r\n   <input type=\"text\" name=\"day2\" size=\"2\" >\r\n   <input type=\"text\" name=\"month2\" size=\"2\" >\r\n   <input type=\"text\" name=\"year2\" size=\"4\" >&nbsp;dates&nbsp;&nbsp;\r\n   <input type=\"submit\" value=\"find\" name=\"find\">\r\n</form>\r\n\r\n<hr>\r\n\r\n<form method=\"POST\" action=\"findRecieved.jsp\">\r\n   <b><font color=\"#666666\">Find documents reached between &nbsp;&nbsp;</font></b>\r\n   <input type=\"text\" name=\"day1\" size=\"2\" >\r\n   <input type=\"text\" name=\"month1\" size=\"2\" >\r\n   <input type=\"text\" name=\"year1\" size=\"4\" >\r\n   <b><font color=\"#666666\">&nbsp;&nbsp; and &nbsp;&nbsp;</font></b>\r\n   <input type=\"text\" name=\"day2\" size=\"2\" >\r\n   <input type=\"text\" name=\"month2\" size=\"2\" >\r\n   <input type=\"text\" name=\"year2\" size=\"4\" >&nbsp;dates&nbsp;&nbsp;\r\n   <input type=\"submit\" value=\"find\" name=\"find\">\r\n</form>\r\n<br>\r\n\r\n<hr>\r\n<form method=\"POST\" action=\"workLoad.jsp\">\r\n  <input type=\"submit\" value=\"show work Load for all positions\" >\r\n</form>\r\n<hr>\r\n<p align=\"right\"><a href=\"homepage.jsp\"><img border=\"0\" src=\"images/60.gif\" width=\"72\" height=\"29\"></a></p>\r\n<form method=\"POST\" action=\"SignOut.jsp\">\r\n  <p>\r\n  <input type=\"submit\" value=\"sign out\" name=\"signout\"></p>\r\n</form>\r\n\r\n</body>\r\n\r\n</html>");
            // end

        } catch (Exception ex) {
            if (out.getBufferSize() != 0)
                out.clearBuffer();
            pageContext.handlePageException(ex);
        } finally {
            out.flush();
            _jspxFactory.releasePageContext(pageContext);
        }
    }
}
