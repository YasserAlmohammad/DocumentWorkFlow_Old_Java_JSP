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


public class _0002fviewContent_0002ejspviewContent_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002fviewContent_0002ejspviewContent_jsp_0( ) {
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(0,40);to=(20,2)]
                out.write("\r\n<html>\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\">\r\n\r\n<title> view content </title>\r\n</head>\r\n\r\n<body bgcolor=\"#eeeeee\">\r\n<p align=\"center\">\r\n<a href=\"inbox.jsp\"><font color=\"#000080\"><b>inbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"outbox.jsp\"><font color=\"#000080\"><b>outbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"sendPageGenerator.jsp\"><font color=\"#000080\"><b>send doc</b></font></a>&nbsp;&nbsp;\r\n<a href=\"reporting.jsp\"><font color=\"#000080\"><b>reporting</b></font></a>&nbsp;&nbsp;\r\n<a href=\"changeUserPass.jsp\"><font color=\"#000080\"><b>changePassword</b></font></a>&nbsp;&nbsp;\r\n<a href=\"helpFiles/help.htm\"><font color=\"#000080\"><b>help&amp;support</b></font></a></p>\r\n<!--   -->\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(20,4);to=(43,6)]
                 String doc_ids= request.getParameter("doc_ids");
                     String content="";
                     String doc_serial="";
                     Timestamp doc_date=null;
                     String num_on_doc="";
                     String date_on_doc="";
                    try{
                    //we wrapped document identifiers in the request parameters
                     StringTokenizer tokens=new StringTokenizer(doc_ids);
                     if(tokens.hasMoreElements())
                        doc_serial=tokens.nextToken("*"); // * was the separator between date and serial: date may has spaces
                     if(tokens.hasMoreElements())
                        doc_date=new Timestamp(Long.valueOf(tokens.nextToken("*")).longValue());
                     ResultSet doc=connector.executeQuery("SELECT date,content,num_on_doc,date_on_doc FROM document WHERE serial="+doc_serial);
                
                     while(doc.next()){
                      Timestamp d=doc.getTimestamp("date");
                      //check date match in day,month,year
                      if((d.getYear()==doc_date.getYear())&&(d.getMonth()==doc_date.getMonth())&&(d.getDay()==doc_date.getDay())){
                        content=doc.getString("content");
                        num_on_doc=doc.getString("num_on_doc");
                        date_on_doc=doc.getString("date_on_doc");
                      }
                     }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(43,8);to=(45,63)]
                out.write("\r\n\r\n  <p align=\"left\"><b><font color=\"#800000\"> document numeber : ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(45,66);to=(45,76)]
                out.print(num_on_doc);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(45,78);to=(45,96)]
                out.write("  originated at : ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(45,99);to=(45,110)]
                out.print(date_on_doc);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(45,112);to=(46,48)]
                out.write("    </p></b></font>\r\n  <textarea rows=\"10\" name=\"content\" cols=\"100\">");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(46,51);to=(46,60)]
                out.print( content );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(46,62);to=(47,0)]
                out.write("</textarea>\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(47,2);to=(50,4)]
                
                  }
                  catch(SQLException e){
                    
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(50,6);to=(50,39)]
                out.write(" ERROR, you can't view this page ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(50,41);to=(52,0)]
                
                  }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\viewContent.jsp";from=(52,2);to=(59,7)]
                out.write("\r\n<p align=\"right\"><a href=\"homepage.jsp\"><img border=\"0\" src=\"images/60.gif\" width=\"72\" height=\"29\"></a></p>\r\n<form method=\"POST\" action=\"SignOut.jsp\">\r\n  <p>\r\n  <input type=\"submit\" value=\"sign out\" name=\"signout\"></p>\r\n</form>\r\n</body>\r\n</html>");
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
