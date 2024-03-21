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


public class _0002fworkLoad_0002ejspworkLoad_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002fworkLoad_0002ejspworkLoad_jsp_0( ) {
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

            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(0,57);to=(1,0)]
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(1,40);to=(18,0)]
                out.write("\r\n<html>\r\n<head>\r\n<title>\r\nworkLoad\r\n</title>\r\n</head>\r\n<body bgcolor=\"#eeeeee\">\r\n\r\n<br>\r\n<table border=\"2\" cellpadding=\"1\" cellspacing=\"1\">\r\n  <tr>\r\n    <td>position name</td>\r\n    <td>number of incoming documents</td>\r\n    <td>number of out going documnets </td>\r\n  </tr>\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(18,2);to=(34,4)]
                 // first the arriving documents
                try{
                  ResultSet workLoad=connector.executeQuery("SELECT COUNT(pos_id) FROM position");
                  int count=0,i=0;
                  if(workLoad.next()){
                    count=workLoad.getInt(1);
                  }
                  workLoad=connector.executeQuery("SELECT pos_id,pos_name FROM position");
                  String [][] pos=new String [count][2];
                  while((workLoad.next())&&(i<count)){
                    pos[i][0]=workLoad.getString("pos_id");
                    pos[i][1]=workLoad.getString("pos_name");
                    ++i;
                  }
                  i=0;
                  while(i<count){
                    
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(34,6);to=(35,15)]
                out.write(" <tr>\r\n          <td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(35,18);to=(35,29)]
                out.print( pos[i][1] );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(35,31);to=(35,38)]
                out.write(" </td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(35,40);to=(38,7)]
                
                    workLoad=connector.executeQuery("SELECT count(from_pos) FROM history WHERE from_pos="+pos[i][0]);
                    if(workLoad.next()){
                       
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(38,9);to=(38,14)]
                out.write(" <td>");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(38,17);to=(38,40)]
                out.print( workLoad.getString(1) );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(38,42);to=(38,49)]
                out.write(" </td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(38,51);to=(42,7)]
                
                    }
                    workLoad=connector.executeQuery("SELECT count(to_pos) FROM history WHERE to_pos="+pos[i][0]);
                    if(workLoad.next()){
                       
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(42,9);to=(42,14)]
                out.write(" <td>");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(42,17);to=(42,40)]
                out.print( workLoad.getString(1) );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(42,42);to=(42,49)]
                out.write(" </td> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(42,51);to=(44,4)]
                
                    }
                    
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(44,6);to=(44,12)]
                out.write(" <tr> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(44,14);to=(48,24)]
                
                    ++i;
                  }
                  //out going documents number
                }catch(SQLException e){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(48,26);to=(48,27)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(48,30);to=(48,43)]
                out.print(e.toString() );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(48,45);to=(48,46)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(48,48);to=(49,0)]
                 }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\workLoad.jsp";from=(49,2);to=(54,0)]
                out.write("\r\n\r\n</table>\r\n</body>\r\n</html>\r\n");
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
