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


public class _0002foutbox_0002ejspoutbox_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002foutbox_0002ejspoutbox_jsp_0( ) {
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

            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(0,57);to=(1,0)]
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(1,40);to=(15,0)]
                out.write("\r\n\r\n<html>\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\">\r\n\r\n<title>\r\noutbox\r\n</title>\r\n</head>\r\n<body bgcolor=\"#eeeeee\"  link=\"#200000\"  Vlink=\"#ffffff\">\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(15,2);to=(15,33)]
                 if(userInfo.getPos_id()==-1){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(15,35);to=(16,4)]
                out.write("\r\n    ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(16,4);to=(16,36)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(16,36);to=(18,0)]
                out.write("\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(18,2);to=(18,9)]
                 }else{
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(18,11);to=(28,2)]
                out.write("\r\n<p align=\"center\">\r\n<a href=\"inbox.jsp\"><font color=\"#000080\"><b>inbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"outbox.jsp\"><font color=\"#000080\"><b>outbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"sendPageGenerator.jsp\"><font color=\"#000080\"><b>send doc</b></font></a>&nbsp;&nbsp;\r\n<a href=\"reporting.jsp\"><font color=\"#000080\"><b>reporting</b></font></a>&nbsp;&nbsp;\r\n<a href=\"changeUserPass.jsp\"><font color=\"#000080\"><b>changePassword</b></font></a>&nbsp;&nbsp;\r\n<a href=\"helpFiles/help.htm\"><font color=\"#000080\"><b>help&amp;support</b></font></a></p>\r\n<h1 align=\"center\"><font color=\"#800000\" size=\"5\"><i>Outbox</i></font></h1>\r\n  <!-- -->\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(28,4);to=(66,11)]
                
                       int b=0;
                       String doc_ids="";
                       String doc_serial="";
                       String to_pos="";
                       String pos_name="";
                       Timestamp doc_date=null;
                       Timestamp note_date=null;
                
                       try{
                        ResultSet r;
                       r=connector.executeQuery("SELECT COUNT(pos_id) FROM position");
                       int count=0;
                       int i=0;
                       if(r.next()){
                       count=r.getInt(1);
                       }
                       r=connector.executeQuery("SELECT pos_id,pos_name FROM position");
                       String [][] pos=new String [count][2];
                       while((r.next())&&(i<count)){
                        pos[i][0]=r.getString("pos_id");
                        pos[i][1]=r.getString("pos_name");
                        ++i;
                       }
                       ResultSet link=connector.executeQuery("SELECT to_pos,doc_serial,doc_date,note_date FROM history WHERE from_pos="+userInfo.getPos_id());
                       while(link.next()){
                        b=1;
                        to_pos=link.getString("to_pos");
                        doc_serial=link.getString("doc_serial");
                        doc_date=link.getTimestamp("doc_date");
                        note_date=link.getTimestamp("note_date");
                        doc_ids=doc_serial+"*"+doc_date.getTime()+"*";
                        int j=0;
                        while (j<count){
                          if (pos[j][0].equals(to_pos)){
                           pos_name=pos[j][1];
                           }
                          j++;
                        }  
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(66,13);to=(69,41)]
                out.write("\r\n\r\n        <img border=\"0\" src=\"images/11.gif\" width=\"20\" height=\"20\">&nbsp;\r\n        <a href=\"viewContent.jsp?doc_ids=");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(69,44);to=(69,53)]
                out.print( doc_ids );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(69,55);to=(69,72)]
                out.write("\"> <b>message to ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(69,75);to=(69,85)]
                out.print( pos_name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(69,87);to=(69,91)]
                out.write(" at ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(69,94);to=(69,105)]
                out.print( note_date );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(69,107);to=(71,4)]
                out.write(" </b></a><br>\r\n\r\n    ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(71,6);to=(72,15)]
                }
                     if (b==0){
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(72,17);to=(74,5)]
                out.write("\r\n       <p> <b><font color=\"#666666\" size=\"4\"> there is no document </font></b></p>\r\n     ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(74,7);to=(75,27)]
                }
                    }catch(SQLException e){
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(75,29);to=(76,29)]
                out.write("\r\n        <h2> SQL error:</h2> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(76,32);to=(76,46)]
                out.print( e.toString() );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(76,48);to=(77,2)]
                out.write("\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(77,4);to=(77,8)]
                 }} 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\outbox.jsp";from=(77,10);to=(87,0)]
                out.write("\r\n<br><br><br><br>\r\n<p align=\"right\"><a href=\"homepage.jsp\"><img border=\"0\" src=\"images/60.jpg\" width=\"72\" height=\"29\"></a></p>\r\n<form method=\"POST\" action=\"SignOut.jsp\">\r\n  <p>\r\n  <input type=\"submit\" value=\"sign out\" name=\"signout\"></p>\r\n</form>\r\n</body>\r\n</html>\r\n\r\n");
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
