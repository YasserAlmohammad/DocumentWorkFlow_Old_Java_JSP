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


public class _0002finbox_0002ejspinbox_jsp_4 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002finbox_0002ejspinbox_jsp_4( ) {
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
            response.setContentType("text/html; charset=windows-1256");
            pageContext = _jspxFactory.getPageContext(this, request, response,
			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(0,57);to=(1,0)]
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(1,40);to=(16,0)]
                out.write("\r\n\r\n<html>\r\n\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\">\r\n\r\n<title>inbox</title>\r\n</head>\r\n\r\n<body bgcolor=\"#eeeeee\"  link=\"#200000\"  Vlink=\"#aaddcc\">\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(16,2);to=(17,6)]
                 if(userInfo.getPos_id()<0){  //security matter: if you are not signed in you can't see this page
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(17,8);to=(17,9)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(17,9);to=(17,41)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(17,41);to=(18,1)]
                out.write("\r\n ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(18,3);to=(19,0)]
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(19,2);to=(35,2)]
                out.write("\r\n\r\n<p align=\"center\">\r\n<a href=\"inbox.jsp\"><font color=\"#000080\"><b>inbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"outbox.jsp\"><font color=\"#000080\"><b>outbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"sendPageGenerator.jsp\"><font color=\"#000080\"><b>send doc</b></font></a>&nbsp;&nbsp;\r\n<a href=\"reporting.jsp\"><font color=\"#000080\"><b>reporting</b></font></a>&nbsp;&nbsp;\r\n<a href=\"changeUserPass.jsp\"><font color=\"#000080\"><b>changePassword</b></font></a>&nbsp;&nbsp;\r\n<a href=\"helpFiles/help.htm\"><font color=\"#000080\"><b>help&amp;support</b></font></a></p>\r\n<h1 align=\"center\"><font color=\"#800000\" size=\"5\"><i>Inbox</i></font></h1>\r\n<!-- newly recieved messages -->\r\n<br>\r\n  <font color=\"#800000\" size=\"4\">newly received&nbsp; message:</font>\r\n  <br>\r\n\r\n  <!-- ***************************************************************-->\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(35,4);to=(44,76)]
                 ResultSet new_links=connector.executeQuery("SELECT doc_serial,subject,doc_date,arrive_date,visited FROM inbox WHERE belongs_to_pos="+ userInfo.getPos_id()+" AND visited='no'");
                     String doc_ids="",doc_serial="",visited="",subj="";
                     Timestamp doc_date=null,arrive_date=null;
                     while(new_links.next()){
                        doc_serial=new_links.getString("doc_serial");
                        subj=new_links.getString("subject");
                        doc_date=new_links.getTimestamp("doc_date");
                        arrive_date=new_links.getTimestamp("arrive_date");
                        visited=new_links.getString("visited");
                        doc_ids=doc_serial+"*"+doc_date.getTime()+"*"+arrive_date.getTime();
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(44,78);to=(48,40)]
                out.write("\r\n\r\n        <!-- we pass ids throught request -->\r\n        <img border=\"0\" src=\"images/11.gif\" width=\"20\" height=\"20\">&nbsp;\r\n        <a href=\"acceptance.jsp?doc_ids=");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(48,43);to=(48,52)]
                out.print( doc_ids );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(48,54);to=(48,72)]
                out.write("\"><b>message from ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(48,75);to=(48,81)]
                out.print( subj );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(48,83);to=(48,87)]
                out.write(" at ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(48,90);to=(48,100)]
                out.print( doc_date );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(48,102);to=(50,5)]
                out.write("</b> </a>\r\n        <br>\r\n     ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(50,7);to=(50,10)]
                 } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(50,12);to=(58,5)]
                out.write("\r\n<br>\r\n\r\n<br>\r\n<!-- history trash -->\r\n<form method=\"POST\" action=\"deleteVisitedLinks.jsp\">\r\n  <p>\r\n  <font color=\"#800000\" size=\"4\">visited messages(Read only): </font></p>\r\n     ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(58,7);to=(65,76)]
                 ResultSet visited_links=connector.executeQuery("SELECT doc_serial,subject,doc_date,arrive_date,visited FROM inbox WHERE belongs_to_pos="+ userInfo.getPos_id()+" AND visited='yes'");
                     while(visited_links.next()){
                        doc_serial=visited_links.getString("doc_serial");
                        subj=visited_links.getString("subject");
                        doc_date=visited_links.getTimestamp("doc_date");
                        arrive_date=visited_links.getTimestamp("arrive_date");
                        visited=visited_links.getString("visited");
                        doc_ids=doc_serial+"*"+doc_date.getTime()+"*"+arrive_date.getTime();
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(65,78);to=(67,42)]
                out.write("\r\n        <img border=\"0\" src=\"images/11.gif\" width=\"20\" height=\"20\">&nbsp;\r\n        <a href=\"viewReadOnly.jsp?doc_ids=");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(67,45);to=(67,54)]
                out.print( doc_ids );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(67,56);to=(67,74)]
                out.write("\"><b>message from ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(67,77);to=(67,83)]
                out.print( subj );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(67,85);to=(67,89)]
                out.write(" at ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(67,92);to=(67,102)]
                out.print( doc_date );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(67,104);to=(68,3)]
                out.write("</b> </a><br>\r\n   ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(68,5);to=(68,9)]
                  } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\inbox.jsp";from=(68,11);to=(81,0)]
                out.write("\r\n  <p><input type=\"submit\" value=\"delete visted links\" name=\"emptytrash\"></p>\r\n</form>\r\n<p>&nbsp;</p>\r\n<p align=\"right\"><a href=\"homepage.jsp\"><img border=\"0\" src=\"images/60.gif\" width=\"72\" height=\"29\"></a></p>\r\n<form method=\"POST\" action=\"SignOut.jsp\">\r\n  <p>\r\n  <input type=\"submit\" value=\"sign out\" name=\"signout\"></p>\r\n</form>\r\n\r\n</body>\r\n\r\n</html>\r\n");
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
