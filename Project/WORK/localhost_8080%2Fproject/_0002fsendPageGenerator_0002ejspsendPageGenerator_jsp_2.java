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


public class _0002fsendPageGenerator_0002ejspsendPageGenerator_jsp_2 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002fsendPageGenerator_0002ejspsendPageGenerator_jsp_2( ) {
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(0,40);to=(34,0)]
                out.write("\r\n\r\n<html>\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\r\n\r\n<title>sending new document&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n</title>\r\n\r\n\r\n<SCRIPT language=\"javascript\">\r\n\r\n//we'll change the form destination according to the submit button click\r\n\r\nfunction sendClick(){\r\n  document.send.action=\"send.jsp\"  // the default\r\n}\r\n\r\nfunction loadClick(){\r\n  document.send.action=\"sendPageGenerator.jsp\"\r\n}\r\n\r\nfunction pathChange(){\r\n  document.send.loadTemplate.click();\r\n\r\n}\r\n\r\n</script>\r\n\r\n</head>\r\n<body bgcolor=\"#eeeeee\">\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(34,2);to=(35,6)]
                 if(userInfo.getPos_id()<0){  //security matter: if you are not signed in you can't see this page
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(35,8);to=(35,9)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(35,9);to=(35,41)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(35,41);to=(36,1)]
                out.write("\r\n ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(36,3);to=(37,0)]
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(37,2);to=(60,2)]
                out.write("\r\n\r\n<p align=\"center\">\r\n<a href=\"inbox.jsp\"><font color=\"#000080\"><b>inbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"outbox.jsp\"><font color=\"#000080\"><b>outbox</b></font></a>&nbsp;&nbsp;\r\n<a href=\"sendPageGenerator.jsp\"><font color=\"#000080\"><b>send doc</b></font></a>&nbsp;&nbsp;\r\n<a href=\"reporting.jsp\"><font color=\"#000080\"><b>reporting</b></font></a>&nbsp;&nbsp;\r\n<a href=\"changeUserPass.jsp\"><font color=\"#000080\"><b>changePassword</b></font></a>&nbsp;&nbsp;\r\n<a href=\"helpFiles/help.htm\"><font color=\"#000080\"><b>help&amp;support</b></font></a></p>\r\n<h1 align=\"center\"><font color=\"#800000\" size=\"5\"><b><i>sending new document&nbsp;</i></b><i>&nbsp;\r\n</i></font><font size=\"5\">&nbsp;&nbsp; </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n</h1>\r\n<p align=\"left\"><font color=\"#000000\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n</font><font color=\"#000000\"><img border=\"0\" src=\"images/D4.gif\" width=\"105\" height=\"78\"></font></p>\r\n\r\n<p align=\"left\"><b><font color=\"#808080\">please fill the existing fields and\r\nthey will be automatically completed</font></b></p>\r\n<p align=\"left\"><b><font color=\"#808080\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\nuse </font><a href=\"helpFiles/help.htm\"><font color=\"#000080\"> help</font></a><font color=\"#808080\"> for more information on how this works</font></b></p>\r\n<!-- the jsp generation code -->\r\n\r\n<form name=\"send\" method=\"POST\" action=\"send.jsp\" >\r\n  <p>\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(60,4);to=(64,6)]
                String path_val=request.getParameter("path_name");
                    String template="";
                    try{
                      //String path_name=request.getParameter("path_name");
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(64,8);to=(64,14)]
                out.write(" <hr> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(64,16);to=(71,8)]
                
                      ResultSet r=connector.executeQuery("SELECT template,address_chain FROM path WHERE path_name='"+path_val+"'");
                      if(r.next()){ //view the positions representing the path
                        template=r.getString("template");
                        StringTokenizer tokens=new StringTokenizer(r.getString("address_chain"));
                        if(tokens.hasMoreTokens())
                           tokens.nextToken(); //skip your self
                        
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(71,13);to=(71,22)]
                out.print( path_val);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(71,24);to=(71,64)]
                out.write(" path will follow this way:<br>from you ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(71,66);to=(76,12)]
                
                        while(tokens.hasMoreTokens()){
                          String pos_id=tokens.nextToken();
                          r=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+pos_id);
                          if(r.next()){
                            
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(76,14);to=(76,19)]
                out.write(" --> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(76,22);to=(76,47)]
                out.print( r.getString("pos_name") );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(76,49);to=(76,50)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(76,52);to=(80,6)]
                
                         }
                        }
                      }
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(80,8);to=(84,27)]
                out.write(" <hr>\r\n\r\n  select path for your document:<span lang=\"ar-sy\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n  </span>&nbsp;<select size=\"1\" name=\"path_name\" onChange=\"pathChange()\">\r\n   <option selected value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(84,30);to=(84,38)]
                out.print(path_val);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(84,40);to=(84,42)]
                out.write("\">");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(84,45);to=(84,53)]
                out.print(path_val);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(84,55);to=(85,2)]
                out.write("</option>\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(85,4);to=(102,10)]
                
                   /*imporant:
                     we'll view only paths that begins with the current user, means: only paths he defined can be
                     viewed or used by him, this way we increase the security and the program will be more trusted
                     so he can't use paths defined by others
                   */
                   String address_chain="",path_name="";
                   ResultSet paths=connector.executeQuery("SELECT path_name,address_chain FROM Path");
                   while(paths.next()){
                       path_name=paths.getString("path_name");
                       address_chain=paths.getString("address_chain");
                       //now see if the begining of the path is the current user, if yes: let it available
                       StringTokenizer posTokens=new StringTokenizer(address_chain);
                       int dept_pos=-1;
                       if(posTokens.hasMoreElements()){
                        dept_pos=Integer.valueOf(posTokens.nextToken()).intValue();
                        if((dept_pos==userInfo.getPos_id())||(path_name.equals("manual"))){ //ok, user can use this path
                          
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(102,12);to=(103,25)]
                out.write("\r\n          <option value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(103,28);to=(103,38)]
                out.print( path_name);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(103,40);to=(103,43)]
                out.write("\"> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(103,46);to=(103,56)]
                out.print(path_name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(103,58);to=(104,8)]
                out.write("</option>\r\n        ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(104,10);to=(106,5)]
                }
                       }
                   } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(106,7);to=(114,0)]
                out.write("\r\n\r\n  </select>\r\n  <input type=\"submit\" value=\"load template\" name=\"loadTemplate\" onClick=\"loadClick()\"></p>\r\n  <p>if you selected manual as path type select the position you want to send\r\n  it for&nbsp;&nbsp;\r\n  <select size=\"1\" name=\"pos_name\">\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(114,2);to=(124,7)]
                
                   // view all positions available for manual direcing
                   String pos_name="",pos_id;
                
                   //administrator is not count, and you can't send message to your self directly
                   ResultSet poss=connector.executeQuery("SELECT pos_name,pos_id FROM position WHERE pos_name<> 'administrator' AND pos_id<>"+userInfo.getPos_id());
                   while(poss.next()){
                       pos_name=poss.getString("pos_name");
                       pos_id=poss.getString("pos_id");
                      //we can know everything about user from pos_id
                       
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(124,9);to=(126,22)]
                out.write("\r\n\r\n       <option value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(126,25);to=(126,33)]
                out.print( pos_id );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(126,35);to=(126,38)]
                out.write("\"> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(126,41);to=(126,50)]
                out.print(pos_name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(126,52);to=(127,3)]
                out.write("</option>\r\n   ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(127,5);to=(130,27)]
                }
                
                
                   }catch(SQLException e){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(130,29);to=(131,24)]
                out.write("\r\n    <h1> SQL error <h1> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(131,27);to=(131,40)]
                out.print(e.toString() );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(131,42);to=(132,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(132,2);to=(132,5)]
                 } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(132,7);to=(143,46)]
                out.write("\r\n  </select></p>\r\n\r\n  <p>you can define new path, if your document type will be frequently used,\r\n  click here\r\n  <a href=\"newPath.jsp\"> define new path</a> </p>\r\n  number on document(required, like 232EF88D8) :  <input type=\"text\" name=\"num_on_doc\" size=\"25\">\r\n  <p>date on document i.e 22-3-2003 :\r\n  <input type=\"text\" name=\"day\" size=\"2\" >\r\n  <input type=\"text\" name=\"month\" size=\"2\" >\r\n  <input type=\"text\" name=\"year\" size=\"4\" >\r\n  <input type=\"hidden\" name=\"path_val\" value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(143,49);to=(143,57)]
                out.print(path_val);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(143,59);to=(145,51)]
                out.write("\">\r\n  </p>\r\n  <p><textarea rows=\"10\" name=\"content\" cols=\"100\">");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(145,54);to=(145,62)]
                out.print(template);
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\sendPageGenerator.jsp";from=(145,64);to=(160,7)]
                out.write("</textarea></p>\r\n  <p align=\"left\"><font ><b>if you have a note write it below</b></font></p>\r\n  <p align=\"left\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n  <textarea rows=\"6\" name=\"note\" cols=\"72\"></textarea></p>\r\n  <p><u><input type=\"submit\" value=\"send documnet\" name=\"send\"><input type=\"reset\" value=\"   Reset form   \" name=\"B2\"></u></p>\r\n\r\n</form>\r\n<p align=\"right\"><a href=\"homepage.jsp\"><img border=\"0\" src=\"images/60.gif\" width=\"72\" height=\"29\"></a></p>\r\n<form method=\"POST\" action=\"SignOut.jsp\">\r\n  <p>\r\n  <input type=\"submit\" value=\"sign out\" name=\"signout\"></p>\r\n</form>\r\n\r\n</body>\r\n\r\n</html>");
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
