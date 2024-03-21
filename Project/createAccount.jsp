
<%@ include file="ConnectInclude.jsp" %>

<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<title>
createAccount
</title>
</head>
<body bgcolor="#eeeeee">

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>


<%
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
    %> <h3> invalid date values </h3> <%
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
         if(testPosName.next()){ %>  <!-- make sure position name is selected once -->
           <h2> hello there, this account already exists!
                try another name</h2>
      <%}else{  //position name is ok, test user name and passowrd
              ResultSet User_res=connector.executeQuery("SELECT username,password FROM users WHERE username='"+newUser+"' AND password='"+newPass+"'");
              if(User_res.next()){ %>
                  <H2> account already exists! <H2>
            <%}else{ // every thing is ok
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
            %>
                  <h2> a new account has been registered <h2>
            <% }
        }

    }}
 catch(Exception e){ %>
    Error: <%= e.getMessage() %>
 <% }}
 else{
 %> invalid  date <%
 }
 }else{
  %> invalid  date <%
  }%>


</body>
</html>
