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


public class _0002fUsersList_0002ejspUsersList_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002fUsersList_0002ejspUsersList_jsp_0( ) {
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(0,40);to=(14,0)]
                out.write("\r\n<html>\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\">\r\n\r\n<title>\r\na list of the system users\r\n</title>\r\n</head>\r\n<body bgcolor=\"#eeeeee\">\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(14,2);to=(15,3)]
                 if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
                   
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(15,5);to=(15,6)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(15,6);to=(15,38)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(15,38);to=(16,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(16,2);to=(16,4)]
                } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(16,6);to=(25,0)]
                out.write("\r\n\r\n<br>\r\n<table border=\"2\" bordercolor=\"#808080\">\r\n  <tr>\r\n      <td> user name </td>\r\n      <td> account description </td>\r\n      <td> start valid at </td>\r\n      <td> end validation at </td>\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(25,2);to=(47,7)]
                 ResultSet users=connector.executeQuery("SELECT count(pos_id) FROM users");
                  int count=0,i=0;
                  if(users.next()){ //get users count
                    count=users.getInt(1);
                  }
                
                  users=connector.executeQuery("SELECT username,startDate,endDate,pos_id FROM users");
                  String [][] u=new String[count][4]; //ResultSet is used only once, so we store value in
                  //dynamic array then retore the vcalues
                  while((users.next())&&(i<count)){
                    u[i][0]=users.getString("username");
                    u[i][1]=users.getString("startDate");
                    u[i][2]=users.getString("endDate");
                    u[i][3]=users.getString("pos_id");
                    ++i;
                  }
                
                  i=0;
                  while(i<count){
                    String pos_id=u[i][3];
                    users=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+pos_id);
                    if(users.next()){
                       
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(47,9);to=(48,15)]
                out.write(" <tr>\r\n          <td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(48,18);to=(48,27)]
                out.print( u[i][0] );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(48,29);to=(49,15)]
                out.write(" </td>\r\n          <td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(49,18);to=(49,47)]
                out.print( users.getString("pos_name") );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(49,49);to=(50,15)]
                out.write(" </td>\r\n          <td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(50,18);to=(50,27)]
                out.print( u[i][1] );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(50,29);to=(51,15)]
                out.write(" </td>\r\n          <td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(51,18);to=(51,27)]
                out.print( u[i][2] );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(51,29);to=(53,6)]
                out.write(" </td>\r\n       </tr>\r\n      ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(53,8);to=(61,4)]
                
                    }
                    ++i;
                
                  }
                
                  /*
                  while(users.next()){
                    
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(61,6);to=(62,15)]
                out.write(" <tr>\r\n          <td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(62,18);to=(62,47)]
                out.print( users.getString("username") );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(62,49);to=(63,15)]
                out.write(" </td>\r\n          <td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(63,18);to=(63,48)]
                out.print( users.getString("startDate") );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(63,50);to=(64,15)]
                out.write(" </td>\r\n          <td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(64,18);to=(64,46)]
                out.print( users.getString("endDate") );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(64,48);to=(66,4)]
                out.write(" </td>\r\n       </tr>\r\n    ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(66,6);to=(69,0)]
                
                  }
                  */
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\UsersList.jsp";from=(69,2);to=(74,0)]
                out.write("\r\n</table>\r\n\r\n</body>\r\n</html>\r\n");
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
