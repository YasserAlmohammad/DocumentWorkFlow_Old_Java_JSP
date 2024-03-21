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


public class _0002fhomepage_0002ejsphomepage_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002fhomepage_0002ejsphomepage_jsp_0( ) {
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

            // HTML // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(0,57);to=(1,0)]
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(1,40);to=(17,0)]
                out.write("\r\n\r\n<html>\r\n\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\">\r\n\r\n<title>homepage</title>\r\n</head>\r\n\r\n<body bgcolor=\"#eeeeee\">\r\n\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(17,2);to=(18,3)]
                 if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
                   
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(18,5);to=(18,6)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(18,6);to=(18,38)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(18,38);to=(19,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(19,2);to=(19,4)]
                } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(19,6);to=(22,0)]
                out.write("\r\n\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(22,2);to=(26,0)]
                 ResultSet r=connector.executeQuery("SELECT username FROM users WHERE pos_id="+userInfo.getPos_id());
                   String username="";
                   if(r.next())
                     username=r.getString("username");
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(26,2);to=(31,0)]
                out.write("\r\n\r\n<p><font color=\"#800000\" size=\"6\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\nW</font><font color=\"#800000\" size=\"4\">elcome\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(31,3);to=(31,11)]
                out.print(username);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\homepage.jsp";from=(31,13);to=(51,0)]
                out.write(" to your Home Page&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n</p>\r\n<p align=\"center\"><img border=\"0\" src=\"images/mmm.gif\" width=\"140\" height=\"56\"></p>\r\n<h3 align=\"center\"><a href=\"inbox.jsp\"><font color=\"#000000\"><b>inbox</b></font></a></h3>\r\n<h3 align=\"center\"><a href=\"outbox.jsp\"><font color=\"#000000\"><b>outbox</b></font></a></h3>\r\n<h3 align=\"center\"><a href=\"sendPageGenerator.jsp\"><font color=\"#000000\"><b>send doc</b></font></a></h3>\r\n<h3 align=\"center\"><a href=\"reporting.jsp\"><font color=\"#000000\"><b>reporting</b></font></a></h3>\r\n<h3 align=\"center\"><a href=\"changeUserPass.jsp\"><font color=\"#000000\"><b>changePassword</b></font></a></h3>\r\n<h3 align=\"center\"><a href=\"helpFiles/help.htm\"><font color=\"#000000\"><b>help&amp;support</b></font></a></h3>\r\n<h3 align=\"center\"><a href=\"help/new_page_1.htm\"><font color=\"#000000\"><b>help&amp;support 2nd version</b></font></a></h3>\r\n\r\n<form method=\"POST\" action=\"SignOut.jsp\">\r\n  <!--webbot bot=\"SaveResults\" U-File=\"_private/form_results.csv\" S-Format=\"TEXT/CSV\" S-Label-Fields=\"TRUE\" startspan --><input TYPE=\"hidden\" NAME=\"VTI-GROUP\" VALUE=\"0\"><!--webbot bot=\"SaveResults\" i-checksum=\"43374\" endspan --><p>\r\n  <input type=\"submit\" value=\"signout\" name=\"signout\"></p>\r\n</form>\r\n<p align=\"left\">&nbsp;</p>\r\n\r\n</body>\r\n\r\n</html>\r\n");
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
