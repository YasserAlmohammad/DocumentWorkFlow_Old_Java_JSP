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


public class _0002fchangeUserPass_0002ejspchangeUserPass_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002fchangeUserPass_0002ejspchangeUserPass_jsp_0( ) {
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
            response.setContentType("text/html;charset=8859_1");
            pageContext = _jspxFactory.getPageContext(this, request, response,
			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\changeUserPass.jsp";from=(0,40);to=(14,0)]
                out.write("\r\n\r\n<html>\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\r\n\r\n<title>\r\nchangePassword\r\n</title>\r\n</head>\r\n<body bgcolor=\"#eeeeee\">\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\changeUserPass.jsp";from=(14,2);to=(14,33)]
                 if(userInfo.getPos_id()==-1) {
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\changeUserPass.jsp";from=(14,35);to=(15,4)]
                out.write("\r\n    ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\changeUserPass.jsp";from=(15,4);to=(15,36)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\changeUserPass.jsp";from=(15,36);to=(17,0)]
                out.write("\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\changeUserPass.jsp";from=(17,2);to=(17,3)]
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\changeUserPass.jsp";from=(17,5);to=(45,0)]
                out.write("\r\n  <p align=\"center\">\r\n<a href=\"inbox.jsp\"><font color=\"#000080\"><b>inbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"outbox.jsp\"><font color=\"#000080\"><b>outbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"sendPageGenerator.jsp\"><font color=\"#000080\"><b>send doc</b></font></a>&nbsp;&nbsp;\r\n<a href=\"reporting.jsp\"><font color=\"#000080\"><b>reporting</b></font></a>&nbsp;&nbsp;\r\n<a href=\"changeUserPass.jsp\"><font color=\"#000080\"><b>changePassword</b></font></a>&nbsp;&nbsp;\r\n<a href=\"helpFiles/help.htm\"><font color=\"#000080\"><b>help&amp;support</b></font></a></p>\r\n  <h1 align=\"center\"><font color=\"#800000\" size=\"5\"><i>changePassword</i></font></h1>\r\n\r\n  <!-- -->\r\n  <form method=\"POST\" action=\"change.jsp\">\r\n  <p> <b><font color=\"#666666\">username &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;</b></font> <input type=\"text\" name=\"username\" size=\"20\" ></p>\r\n  <p> <b><font color=\"#666666\">oldPassword &nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;</b></font> <input type=\"password\" name=\"oldPassword\" size=\"20\" ></p>\r\n  <p> <b><font color=\"#666666\">newPassword &nbsp; : &nbsp;&nbsp;&nbsp;</b></font> <input type=\"password\" name=\"newPassword\" size=\"20\" ></p>\r\n<br>\r\n  <p>\r\n  <input type=\"submit\" value=\"change\" name=\"signout\"></p>\r\n</form>\r\n<p align=\"right\"><a href=\"homepage.jsp\"><img border=\"0\" src=\"images/60.gif\" width=\"72\" height=\"29\"></a></p>\r\n<form method=\"POST\" action=\"SignOut.jsp\">\r\n  <p>\r\n  <input type=\"submit\" value=\"sign out\" name=\"signout\"></p>\r\n</form>\r\n\r\n</body>\r\n</html>\r\n\r\n");
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
