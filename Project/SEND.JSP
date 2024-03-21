<%@ include file="ConnectInclude.jsp" %>
<%@ page contentType="text/html; charset=windows-1256" %>
<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>
send
</title>
</head>
<body bgcolor="#eeeeee">
<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>


<!-- tell now we considerd the content as text file, later we may consider it as link to a local file
     that we can upload it from user's machine to the server -->
<%
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
      %> <h3> the date parameters are wrong, check it again</h3> <%
   }

   //check date for value errors
   if(!((dd>0)&&(dd<32)&&(mm<13)&&(mm>0)&&(yyyy<2050)&&(yyyy>1980))){
      %><h3> error: date is invalid </h3><%
   }else{ //continue
   yyyy=yyyy-1900;
   mm-=1; //month starts from 0 in Timestamp
   Timestamp date_on_doc=new Timestamp(yyyy,mm,dd,0,0,0,0);

   //we don't allow null values for : num_on_doc or date_on_doc, also you can't send empty message
   if((num_on_doc.equals(""))||(content.equals(""))||(path_name.equals("null"))){
      %> <h3> some fields are missing, please check you request again </h3> <%
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

      %><h1>document was successfully sent</h1> <%
     }}catch(SQLException e){%>
        <h2> SQL error: </h2> <%= e.toString() %>
  <% }
  }
 } %>

<!-- we may add the first destination to the history, also we could ignore the first position in the address chain if it
     was the same as the current signed in position -->
</body>
</html>
