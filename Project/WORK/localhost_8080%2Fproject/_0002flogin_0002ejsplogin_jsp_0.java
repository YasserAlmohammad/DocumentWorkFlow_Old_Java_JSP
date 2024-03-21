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


public class _0002flogin_0002ejsplogin_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002flogin_0002ejsplogin_jsp_0( ) {
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(0,40);to=(18,0)]
                out.write("\r\n\r\n<html>\r\n<head>\r\n<title>\r\nlogin ensurance\r\n</title>\r\n</head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\">\r\n\r\n<body bgcolor=\"#eeeeee\">\r\n<h1>\r\nTesting user authentication\r\n</h1>\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(18,2);to=(28,49)]
                 String user=request.getParameter("username"),pass=request.getParameter("password");
                
                  try{
                      connector.connect("jdbc:odbc:project","","");
                      ResultSet r=connector.executeQuery("SELECT pos_id,username,password,enddate,startdate FROM users WHERE username='"+user+"' AND password='"+pass+"'");
                      if(r.next()){
                         userInfo.setPos_id(r.getInt("pos_id"));
                         Timestamp endDate=r.getTimestamp("enddate"); //check user have access any more
                         Timestamp startDate=r.getTimestamp("startdate");
                         Timestamp sysDate=new Timestamp(System.currentTimeMillis());
                         if("admin".equals(user.toLowerCase())){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(28,51);to=(29,12)]
                out.write("\r\n            ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(29,12);to=(29,52)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("administrator.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(29,52);to=(30,8)]
                out.write("\r\n        ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(30,10);to=(33,22)]
                 }else{
                                 if((endDate==null)||(endDate.after(sysDate))){ //make sure the user still valid
                                    if(startDate.before(sysDate)){ // he starts after the current time
                                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(33,24);to=(33,25)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(33,25);to=(33,60)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("homepage.jsp" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(33,60);to=(34,20)]
                out.write("\r\n                    ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(34,22);to=(37,47)]
                }
                                    else{
                                        connector.disconnect();
                                        userInfo.setPos_id(-1);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(37,49);to=(37,108)]
                out.write(" you dont have access yet, you can access the system after ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(37,111);to=(37,122)]
                out.print( startDate );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(37,124);to=(37,125)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(37,127);to=(42,44)]
                
                                    }
                                 }
                                 else{
                                    connector.disconnect();
                                    userInfo.setPos_id(-1); 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(42,46);to=(42,121)]
                out.write(" you don't have access anymore, contact Administartor for more information ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(42,123);to=(45,35)]
                }
                            }
                      }else{
                            connector.disconnect();
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(45,37);to=(46,9)]
                out.write("\r\n         ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(46,12);to=(46,17)]
                out.print(user );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(46,19);to=(47,0)]
                out.write(" you are invalid user, try a gain\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(47,2);to=(48,25)]
                  }
                    }catch(Exception e){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(48,27);to=(49,19)]
                out.write("\r\n    <p> error </p> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(49,22);to=(49,38)]
                out.print( e.getMessage() );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(49,40);to=(50,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(50,2);to=(50,3)]
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\login.jsp";from=(50,5);to=(55,0)]
                out.write("\r\n\r\n\r\n</body>\r\n</html>\r\n");
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
