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


public class _0002fcreateAccount_0002ejspcreateAccount_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002fcreateAccount_0002ejspcreateAccount_jsp_0( ) {
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

            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(0,0);to=(1,0)]
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(1,40);to=(16,0)]
                out.write("\r\n\r\n<html>\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\r\n\r\n<title>\r\ncreateAccount\r\n</title>\r\n</head>\r\n<body bgcolor=\"#eeeeee\">\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(16,2);to=(17,3)]
                 if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
                   
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(17,5);to=(17,6)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(17,6);to=(17,38)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(17,38);to=(18,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(18,2);to=(18,4)]
                } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(18,6);to=(21,0)]
                out.write("\r\n\r\n\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(21,2);to=(39,4)]
                
                   // first get the Parameters
                   String newUser=request.getParameter("username"),newPass=request.getParameter("password");
                   String pos_name=request.getParameter("description"),confirmPass=request.getParameter("confirmPass");
                   String startDD=request.getParameter("startDD"),startMM=request.getParameter("startMM"),startYYYY=request.getParameter("startYYYY"),
                   endDD=request.getParameter("endDD"),endMM=request.getParameter("endMM"),endYYYY=request.getParameter("endYYYY"),
                   allow_def=request.getParameter("allow_def");
                
                   int sDD=0,sMM=0,sYYYY=0;
                   int eDD=0,eMM=0,eYYYY=0;
                   try{ // check date format
                      sDD=Integer.valueOf(startDD).intValue();
                      sMM=Integer.valueOf(startMM).intValue();
                      sYYYY=Integer.valueOf(startYYYY).intValue();
                      eDD=Integer.valueOf(endDD).intValue();
                      eMM=Integer.valueOf(endMM).intValue();
                      eYYYY=Integer.valueOf(endYYYY).intValue();
                   }catch(NumberFormatException e){
                    
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(39,6);to=(39,38)]
                out.write(" <h3> invalid date values </h3> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(39,40);to=(53,33)]
                
                   }
                
                   if((sDD>0)&&(sDD<32)&&(sMM<13)&&(sMM>0)&&(sYYYY<2050)&&(sYYYY>1980)){
                    if((eDD>0)&&(eDD<32)&&(eMM<13)&&(eMM>0)&&(eYYYY<2050)&&(eYYYY>1980)){
                       sYYYY-=1900; // java date format
                       eYYYY-=1900;
                       sMM-=1;
                       eMM-=1;
                       Timestamp startDate=new Timestamp(sYYYY,sMM,sDD,0,0,0,0);
                       Timestamp endDate=new Timestamp(eYYYY,eMM,eDD,0,0,0,0);
                  try{
                      if(newPass.equals(confirmPass)){
                         ResultSet testPosName=connector.executeQuery("SELECT pos_name FROM position WHERE pos_name='"+pos_name+"'");
                         if(testPosName.next()){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(53,35);to=(56,6)]
                out.write("  <!-- make sure position name is selected once -->\r\n           <h2> hello there, this account already exists!\r\n                try another name</h2>\r\n      ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(56,8);to=(58,35)]
                }else{  //position name is ok, test user name and passowrd
                              ResultSet User_res=connector.executeQuery("SELECT username,password FROM users WHERE username='"+newUser+"' AND password='"+newPass+"'");
                              if(User_res.next()){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(58,37);to=(60,12)]
                out.write("\r\n                  <H2> account already exists! <H2>\r\n            ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(60,14);to=(72,12)]
                }else{ // every thing is ok
                                  if(allow_def!=null)
                                    allow_def="yes";
                                  else
                                    allow_def="no";
                                  connector.executeUpdate("INSERT INTO position (pos_name,can_define_new_path) VALUES('"+pos_name+"','"+allow_def+"')");
                                  ResultSet pos_id_res=connector.executeQuery("SELECT pos_id FROM position WHERE pos_name='"+pos_name+"'");
                                  if(pos_id_res.next()){
                                    int pos_id=pos_id_res.getInt("pos_id");
                                    connector.executeUpdate("INSERT INTO users (pos_id,username,password,startDate,endDate) VALUES ("+pos_id+",'"+newUser+"','"+newPass+"','"+startDate+"','"+endDate+"')");
                                    // tell here ++++++++++++++++++++++++++++++
                                 }
                            
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(72,14);to=(74,12)]
                out.write("\r\n                  <h2> a new account has been registered <h2>\r\n            ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(74,14);to=(78,21)]
                 }
                        }
                
                    }}
                 catch(Exception e){ 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(78,23);to=(79,11)]
                out.write("\r\n    Error: ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(79,14);to=(79,30)]
                out.print( e.getMessage() );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(79,32);to=(80,1)]
                out.write("\r\n ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(80,3);to=(82,1)]
                 }}
                 else{
                 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(82,3);to=(82,18)]
                out.write(" invalid  date ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(82,20);to=(85,2)]
                
                 }
                 }else{
                  
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(85,4);to=(85,19)]
                out.write(" invalid  date ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(85,21);to=(86,3)]
                
                  }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\createAccount.jsp";from=(86,5);to=(91,0)]
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
