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


public class _0002fnewPath_0002ejspnewPath_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002fnewPath_0002ejspnewPath_jsp_0( ) {
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(0,40);to=(55,0)]
                out.write("\r\n<html>\r\n\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\r\n\r\n<title>new document type generator</title>\r\n</head>\r\n\r\n<SCRIPT language=\"javaScript\" >\r\n\r\nvar content=\"\";\r\nvar oldPos=\"\";\r\nvar newPos=\"\";\r\nfunction addclick(){\r\n\tcontent=document.newPath.address_chain.value\r\n        newPos=document.newPath.positions.options[document.newPath.positions.selectedIndex].value\r\n        if(oldPos==newPos){ // we'll prevent user from sending letter to him self directly\r\n          alert(\"can't send to your self directly\")\r\n        }\r\n        else{  //it's ok\r\n          // we can parse the address before it's sent to createPath.jsp - for arabic to work -\r\n\r\n          if(content==\"\"){\r\n\t    document.newPath.address_chain.value=newPos\r\n          }\r\n          else{\r\n            document.newPath.address_chain.value=content+\"*\"+newPos\r\n          }\r\n            oldPos=newPos\r\n\r\n        }\r\n\r\n        content=document.newPath.address_chain.value\r\n\r\n        /*\r\n        without checking\r\n        content=document.newPath.address_chain.value\r\n\tdocument.newPath.address_chain.value=content+\">\"+document.newPath.positions.options[document.newPath.positions.selectedIndex].value\r\n        content=document.newPath.address_chain.value\r\n        */\r\n}\r\n\r\nfunction contentChange(){\r\n    document.newPath.address_chain.value=content;\r\n    alert(\"what are you doing? you musn't change this content manually, use reset button to restart building the path\")\r\n}\r\n\r\n</SCRIPT>\r\n\r\n<body bgcolor=\"#eeeeee\">\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(55,2);to=(56,3)]
                 if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
                   
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(56,5);to=(56,6)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(56,6);to=(56,38)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(56,38);to=(57,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(57,2);to=(64,0)]
                }
                  try{
                 //first check if our friend can define paths or not
                  ResultSet r=connector.executeQuery("SELECT can_define_new_path FROM position WHERE pos_id="+userInfo.getPos_id());
                  if(r.next()){
                    String can=r.getString(1);
                    if(can.equals("yes")){ //ok you can
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(64,2);to=(72,0)]
                out.write("\r\n\r\n<form name=\"newPath\" method=\"POST\" action=\"createPath.jsp\">\r\n  <p>name document type:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n  <input type=\"text\" name=\"path_name\" size=\"28\"></p>\r\n  <p>\r\n  <input type=\"button\" value=\"add selected direction\" name=\"add\" onclick=\"addclick()\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n  <select size=\"1\" name=\"positions\">\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(72,2);to=(78,6)]
                
                   ResultSet pos_names=connector.executeQuery("SELECT pos_name,pos_id FROM position WHERE pos_name<>'administrator' AND pos_name<>'archive'");
                   String name="";
                   //add the first positionas selected
                   if(pos_names.next()){
                      name=pos_names.getString("pos_name");
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(78,8);to=(79,21)]
                out.write("\r\n      <option value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(79,24);to=(79,30)]
                out.print( name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(79,32);to=(79,43)]
                out.write("\" selected>");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(79,46);to=(79,52)]
                out.print( name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(79,54);to=(80,3)]
                out.write(" </option>\r\n   ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(80,5);to=(84,43)]
                
                   }
                  //add all positions available
                   while(pos_names.next()){
                      name=pos_names.getString("pos_name");
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(84,45);to=(85,21)]
                out.write("\r\n      <option value=\"");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(85,24);to=(85,30)]
                out.print( name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(85,32);to=(85,36)]
                out.write("\" > ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(85,39);to=(85,45)]
                out.print( name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(85,47);to=(86,2)]
                out.write(" </option>\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(86,4);to=(88,0)]
                
                   }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(88,2);to=(91,2)]
                out.write("\r\n  <!-- we could add check restriction to assure that any position won't put itself in th beginning of path -->\r\n  </select> don't put yourself as the beginner of the path, you will be automatically considerd </p>\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(91,4);to=(100,6)]
                 r=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+userInfo.getPos_id());
                     String current_pos_name="";
                     if(r.next()){
                        current_pos_name=r.getString("pos_name");
                     }
                   r=connector.executeQuery("SELECT username FROM users WHERE pos_id="+userInfo.getPos_id());
                   if(r.next()){
                    String username=r.getString("username");
                    if("admin".equals(username.toLowerCase())){ //allow admin to define paths for others
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(100,8);to=(102,2)]
                out.write("\r\n      <p><textarea rows=\"4\" name=\"address_chain\" cols=\"100\" onChange=\"contentChange()\"></textarea></p>\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(102,4);to=(103,2)]
                }else{
                  
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(103,4);to=(104,83)]
                out.write("\r\n  <p><textarea rows=\"4\" name=\"address_chain\" cols=\"100\" onChange=\"contentChange()\">");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(104,86);to=(104,103)]
                out.print(current_pos_name );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(104,105);to=(105,2)]
                out.write(" </textarea></p>\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(105,4);to=(106,3)]
                }
                  }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(106,5);to=(114,0)]
                out.write("\r\n  <p>input template if you like<br> <textarea rows=\"8\" name=\"template\" cols=\"100\"></textarea></p>\r\n  <p>&nbsp;</p>\r\n  <p><input type=\"submit\" value=\"create path\" name=\"B1\">\r\n  <input type=\"reset\" value=\"Reset\" name=\"B2\"></p>\r\n\r\n</form>\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(114,2);to=(115,4)]
                 }else{ //you can't define new path
                    
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(115,6);to=(116,4)]
                out.write("  <h3> you can't define new document type, contact administrator for more information\r\n    ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(116,6);to=(118,26)]
                
                  }}
                  }catch(SQLException e){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(118,28);to=(118,46)]
                out.write(" <h3> ERROR </H3> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(118,48);to=(118,50)]
                 }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\newPath.jsp";from=(118,52);to=(122,7)]
                out.write("\r\n\r\n</body>\r\n\r\n</html>");
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
