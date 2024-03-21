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


public class _0002facceptance_0002ejspacceptance_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002facceptance_0002ejspacceptance_jsp_0( ) {
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(0,40);to=(13,0)]
                out.write("\r\n<html>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\r\n\r\n<head>\r\n<title>acceptance</title>\r\n</head>\r\n\r\n<body bgcolor=\"#eeeeee\">\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(13,2);to=(14,3)]
                 if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
                   
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(14,5);to=(14,6)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(14,6);to=(14,38)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(14,38);to=(15,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(15,2);to=(15,4)]
                } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(15,6);to=(27,2)]
                out.write("\r\n\r\n\r\n<p align=\"center\">\r\n<a href=\"inbox.jsp\"><font color=\"#000080\"><b>inbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"outbox.jsp\"><font color=\"#000080\"><b>outbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"sendPageGenerator.jsp\"><font color=\"#000080\"><b>send doc</b></font></a>&nbsp;&nbsp;\r\n<a href=\"reporting.jsp\"><font color=\"#000080\"><b>reporting</b></font></a>&nbsp;&nbsp;\r\n<a href=\"changeUserPass.jsp\"><font color=\"#000080\"><b>changePassword</b></font></a>&nbsp;&nbsp;\r\n<a href=\"helpFiles/help.htm\"><font color=\"#000080\"><b>help&amp;support</b></font></a></p>\r\n<form method=\"POST\" action=\"redirect.jsp\">\r\n  <p>\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(27,4);to=(51,6)]
                 String doc_ids= request.getParameter("doc_ids");
                     String content="",doc_serial="",doc_type="";
                     Timestamp doc_date=null,arrive_date=null;
                     String num_on_doc="",date_on_doc="";
                    try{
                    //we wrapped document identifiers in the request parameters
                     StringTokenizer tokens=new StringTokenizer(doc_ids);
                     if(tokens.hasMoreElements())
                        doc_serial=tokens.nextToken("*"); // * was the separator between date and serial: date may has spaces
                     if(tokens.hasMoreElements())
                        doc_date=new Timestamp(Long.valueOf(tokens.nextToken("*")).longValue());
                    if(tokens.hasMoreElements())
                        arrive_date=new Timestamp(Long.valueOf(tokens.nextToken("*")).longValue());
                     ResultSet r=connector.executeQuery("SELECT date,content,doc_type,num_on_doc,date_on_doc FROM document WHERE serial="+doc_serial);
                
                     while(r.next()){
                      Timestamp d=r.getTimestamp("date");
                      //check date match in day,month,year
                      if((d.getYear()==doc_date.getYear())&&(d.getMonth()==doc_date.getMonth())&&(d.getDay()==doc_date.getDay())){
                        content=r.getString("content");
                        doc_type=r.getString("doc_type");
                        num_on_doc=r.getString("num_on_doc");
                        date_on_doc=r.getString("date_on_doc");
                      }
                     }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(51,8);to=(53,44)]
                out.write("\r\n\r\n  <font color=\"#800000\"><b>document numeber:");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(53,47);to=(53,57)]
                out.print(num_on_doc);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(53,59);to=(53,74)]
                out.write(" originated at:");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(53,77);to=(53,88)]
                out.print(date_on_doc);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(53,90);to=(54,48)]
                out.write("</b></font>\r\n  <textarea rows=\"20\" name=\"content\" cols=\"100\">");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(54,51);to=(54,60)]
                out.print( content );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(54,62);to=(66,0)]
                out.write("</textarea></p>\r\n  <p>&nbsp;the above text will not change, if you have a note write it bellow:\r\n  </p>\r\n  <p><textarea rows=\"4\" name=\"note\" cols=\"50\"> </textarea></p>\r\n  <p><select size=\"1\" name=\"choice\">\r\n  <!-- we could make serial as hidden field -->\r\n  <option selected value=\"ok\">ok</option>\r\n  <option value=\"reject\">reject</option>\r\n  </select></p>\r\n\r\n\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(66,2);to=(69,3)]
                
                    if(doc_type.equals("manual")){
                       // view all positions available for manual direcing
                   
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(69,5);to=(70,38)]
                out.write(" <h3>you must select destination position to send the message for </h3>\r\n      <select size=\"1\" name=\"pos_id\"> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(70,40);to=(77,9)]
                
                       String pos_name="",pos_id;
                       ResultSet pos=connector.executeQuery("SELECT pos_name,pos_id FROM position WHERE pos_name<> 'administrator' AND pos_id<>"+userInfo.getPos_id());
                       while(pos.next()){
                         pos_name=pos.getString("pos_name");
                         pos_id=pos.getString("pos_id");
                         //we can know everything about user from pos_id
                         
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(77,11);to=(78,24)]
                out.write("\r\n         <option value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(78,27);to=(78,35)]
                out.print( pos_id );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(78,37);to=(78,40)]
                out.write("\"> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(78,43);to=(78,52)]
                out.print(pos_name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(78,54);to=(79,7)]
                out.write("</option>\r\n       ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(79,9);to=(80,8)]
                }
                        
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(80,10);to=(80,27)]
                out.write("   </select></p> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(80,29);to=(83,26)]
                
                
                   }
                  }catch(SQLException e){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(83,28);to=(84,24)]
                out.write("\r\n    <h1> SQL error <h1> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(84,27);to=(84,40)]
                out.print(e.toString() );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(84,42);to=(85,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(85,2);to=(85,5)]
                 } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(85,7);to=(88,48)]
                out.write("\r\n\r\n  <!-- ids for the link are passed between interactived pages-->\r\n  <input type=\"hidden\" name=\"doc_serial\" value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(88,51);to=(88,63)]
                out.print( doc_serial );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(88,65);to=(89,46)]
                out.write("\" >\r\n  <input type=\"hidden\" name=\"doc_date\" value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(89,49);to=(89,67)]
                out.print(doc_date.getTime());
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(89,69);to=(90,49)]
                out.write("\" >\r\n  <input type=\"hidden\" name=\"arrive_date\" value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(90,52);to=(90,73)]
                out.print(arrive_date.getTime());
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(90,75);to=(98,48)]
                out.write("\">\r\n   <h4>if you are the one who published this documnet and rejeted it, it will be deleted permanently\r\n  <br>you can check the document history to be sure of what happened before it reached you</h4>\r\n  <p><input type=\"submit\" value=\"submit\" name=\"submit\">&nbsp;&nbsp; </p>\r\n</form>\r\n\r\n<hr>\r\n<form method=\"POST\" action=\"showHistory.jsp\">\r\n  <input type=\"hidden\" name=\"doc_serial\" value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(98,51);to=(98,63)]
                out.print( doc_serial );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(98,65);to=(99,46)]
                out.write("\" >\r\n  <input type=\"hidden\" name=\"doc_date\" value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(99,49);to=(99,67)]
                out.print(doc_date.getTime());
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\acceptance.jsp";from=(99,69);to=(106,0)]
                out.write("\" >\r\n  <input type=\"submit\" value=\"show this message history\">\r\n</form>\r\n<hr>\r\n</body>\r\n\r\n</html>\r\n");
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
