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


public class _0002fsend_0002ejspsend_jsp_0 extends HttpJspBase {

    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(0,0);to=(0,69)]
    // end
    // begin [file="G:\\finalProjectFiles\\Project\\ConnectInclude.jsp";from=(1,0);to=(1,74)]
    // end

    static {
    }
    public _0002fsend_0002ejspsend_jsp_0( ) {
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
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(0,40);to=(1,0)]
                out.write("\r\n");
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(1,57);to=(14,0)]
                out.write("\r\n<html>\r\n<head>\r\n\r\n<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">\r\n<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\">\r\n\r\n<title>\r\nsend\r\n</title>\r\n</head>\r\n<body bgcolor=\"#eeeeee\">\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(14,2);to=(15,3)]
                 if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
                   
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(15,5);to=(15,6)]
                out.write(" ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(15,6);to=(15,38)]
                if (true) {
                    out.clear();
                    String _jspx_qfStr = "";
                    pageContext.forward("error.htm" +  _jspx_qfStr);
                    return;
                }
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(15,38);to=(16,0)]
                out.write("\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(16,2);to=(16,4)]
                } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(16,6);to=(21,0)]
                out.write("\r\n\r\n\r\n<!-- tell now we considerd the content as text file, later we may consider it as link to a local file\r\n     that we can upload it from user's machine to the server -->\r\n");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(21,2);to=(36,6)]
                
                   String path_name=request.getParameter("path_val");
                   String num_on_doc=request.getParameter("num_on_doc");
                   String content=request.getParameter("content");
                   String pos_id=request.getParameter("pos_name");
                   String day=request.getParameter("day"), month=request.getParameter("month"), year=request.getParameter("year"),
                   note=request.getParameter("note");
                
                   int dd=0,mm=0,yyyy=0;
                   try{ //check date format
                      dd=Integer.valueOf(day).intValue();
                      mm=Integer.valueOf(month).intValue();
                      yyyy=Integer.valueOf(year).intValue();
                   }
                   catch(NumberFormatException e){
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(36,8);to=(36,65)]
                out.write(" <h3> the date parameters are wrong, check it again</h3> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(36,67);to=(41,6)]
                
                   }
                
                   //check date for value errors
                   if(!((dd>0)&&(dd<32)&&(mm<13)&&(mm>0)&&(yyyy<2050)&&(yyyy>1980))){
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(41,8);to=(41,41)]
                out.write("<h3> error: date is invalid </h3>");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(41,43);to=(49,6)]
                
                   }else{ //continue
                   yyyy=yyyy-1900;
                   mm-=1; //month starts from 0 in Timestamp
                   Timestamp date_on_doc=new Timestamp(yyyy,mm,dd,0,0,0,0);
                
                   //we don't allow null values for : num_on_doc or date_on_doc, also you can't send empty message
                   if((num_on_doc.equals(""))||(content.equals(""))||(path_name.equals("null"))){
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(49,8);to=(49,76)]
                out.write(" <h3> some fields are missing, please check you request again </h3> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(49,78);to=(106,6)]
                
                   }
                   else{
                
                   //if type== Manual then we must send the message to the selected position else to the one at the begining
                   //of address_chain specified by path type
                   try{
                      //first save the document conetent
                      //we may use transactions for the connection class if jdkID >= 1.4
                      connector.executeUpdate("INSERT INTO document(num_on_doc,date_on_doc,content,pos_id,doc_type) VALUES ('"+num_on_doc+"','"+date_on_doc+"','"+content+"',"+userInfo.getPos_id()+",'"+path_name+"')");
                      //now prepare the link info to be sent
                
                      //then we get the subject " or the position description "
                      ResultSet subject=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+userInfo.getPos_id());
                      String subj="";
                      if(subject.next()){
                          subj=subject.getString("pos_name");
                          subject.close();
                      }
                
                      if(!((path_name.equals("manual"))&&(subj.equals("archive")))){ // when position==archive and doc_type==manul the message will be sent to save only
                      //first get the doc_serial and date
                      ResultSet doc_ids=connector.executeQuery("SELECT serial,date FROM document WHERE date=(SELECT MAX(date) FROM document WHERE pos_id="+userInfo.getPos_id()+")");
                      String doc_serial="",doc_date="";
                      if(doc_ids.next()){
                        doc_serial=doc_ids.getString("serial");
                        doc_date=doc_ids.getString("date");
                      }
                
                
                      //if type==Manual then we don't need to know the address chain
                      if(path_name.equals("manual")){
                          //send the link to pos identified by pos_name
                          //address_chain in manual case = 0
                          connector.executeUpdate("INSERT INTO inbox(belongs_to_pos,doc_serial,doc_date,currentAddressPos,address_chain,subject) VALUES ("+pos_id+","+doc_serial+",'"+doc_date+"',1,'"+userInfo.getPos_id()+"','"+subj+"')");
                
                      }
                      else{ //use address_chain info to get the next position
                       ResultSet address_rs=connector.executeQuery("SELECT address_chain FROM path WHERE path_name='"+path_name+"'");
                        if(address_rs.next()){
                           String address=address_rs.getString("address_chain");
                           StringTokenizer tokens=new StringTokenizer(address);
                           tokens.nextToken();
                           pos_id=tokens.nextToken();
                           int current_address_pos=1;
                           if(pos_id.equals(""+userInfo.getPos_id())){
                              pos_id=tokens.nextToken();
                              ++current_address_pos;
                           }
                           //sending a link to inbox
                           connector.executeUpdate("INSERT INTO inbox(belongs_to_pos,doc_serial,doc_date,currentAddressPos,address_chain,subject) VALUES ("+pos_id+","+doc_serial+",'"+doc_date+"',"+current_address_pos+",'"+address+"','"+subj+"')");
                
                        }
                      }
                      //now record this action in the history: FROM -----> TO record
                      connector.executeUpdate("INSERT INTO History(to_pos,from_pos,doc_serial,doc_date,note) VALUES ("+pos_id+","+userInfo.getPos_id()+","+doc_serial+",'"+doc_date+"','"+note+"')");
                
                      
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(106,8);to=(106,48)]
                out.write("<h1>document was successfully sent</h1> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(106,50);to=(107,29)]
                
                     }}catch(SQLException e){
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(107,31);to=(108,30)]
                out.write("\r\n        <h2> SQL error: </h2> ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(108,33);to=(108,47)]
                out.print( e.toString() );
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(108,49);to=(109,2)]
                out.write("\r\n  ");
            // end
            // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(109,4);to=(111,3)]
                 }
                  }
                 } 
            // end
            // HTML // begin [file="G:\\finalProjectFiles\\Project\\send.jsp";from=(111,5);to=(117,0)]
                out.write("\r\n\r\n<!-- we may add the first destination to the history, also we could ignore the first position in the address chain if it\r\n     was the same as the current signed in position -->\r\n</body>\r\n</html>\r\n");
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
