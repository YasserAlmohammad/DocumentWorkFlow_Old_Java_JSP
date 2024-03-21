<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>
<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<title>
changeAccount
</title>
</head>
<body bgcolor="#eeeeee">

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>


<% String oldUser=request.getParameter("olduser"), oldPass=request.getParameter("oldpass");
   String newUser=request.getParameter("newuser"), newPass=request.getParameter("newpass"),
   startDD=request.getParameter("startDD"),startMM=request.getParameter("startMM"),startYYYY=request.getParameter("startYYYY"),
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
    %> <h3> invalid date values </h3> <%
   }

   if((sDD>0)&&(sDD<32)&&(sMM<13)&&(sMM>0)&&(sYYYY<2050)&&(sYYYY>1980)){
    if((eDD>0)&&(eDD<32)&&(eMM<13)&&(eMM>0)&&(eYYYY<2050)&&(eYYYY>1980)){
       sYYYY-=1900; // java date format
       eYYYY-=1900;
       sMM-=1;
       eMM-=1;
       Timestamp startDate=new Timestamp(sYYYY,sMM,sDD,0,0,0,0);
       Timestamp endDate=new Timestamp(eYYYY,eMM,eDD,0,0,0,0);String can_define_new_path=request.getParameter("allow_def");
   //check if old user exists

  try{
      ResultSet r=connector.executeQuery("SELECT username,password,pos_id FROM users WHERE username='"+oldUser+"' AND password='"+oldPass+"'");
      if(r.next()){ //ok
         //check if new info already used or not
         String pos_id=r.getString("pos_id");
         r=connector.executeQuery("SELECT username,password FROM users WHERE username='"+newUser+"' AND password='"+newPass+"'");
         if(r.next()){ // user already exists, fire alert
            %> <h3> hey there, this account is already used, check another </h3> <%
         }
         else{ // account is valid
            //change username and password and leave the pos_id intact, this way the inbox won't change
            connector.executeUpdate("UPDATE users SET username='"+newUser+"',password='"+newPass+"',startDate='"+startDate+"',endDate='"+endDate+"' WHERE pos_id="+pos_id);
            if(can_define_new_path!=null)
                can_define_new_path="yes";
            else
                can_define_new_path="no";
            connector.executeUpdate("UPDATE position SET can_define_new_path='"+can_define_new_path+"' WHERE pos_id="+pos_id);
           %> <h3> account changed successfully </h3> <%
          }
      }
      else{
         %> <h1> this account does't exists or has changed </h3> <%
      }
  }
  catch(SQLException e){
    %> <h3> ERROR: <%= e.toString() %> </h3> <%
  }
  }else{
    %> invalid date <%
  }
  }else{
    %> invalid date <%
  }
%>

</body>
</html>
