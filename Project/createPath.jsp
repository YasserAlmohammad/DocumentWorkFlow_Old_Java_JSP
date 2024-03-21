<%@ include file="ConnectInclude.jsp" %>
<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<title>
createPath page handler
</title>
</head>
<body bgcolor="#eeeeee">

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>


<% String pos_chain=request.getParameter("address_chain");
   String path_name=request.getParameter("path_name");
   String template=request.getParameter("template");
   StringTokenizer tokens=new StringTokenizer(pos_chain,"*");
   String pos_name="";
   String address_chain="";
   String oldToken="";
   if(path_name.equals("")){ //don't allow empty named path
      %> <h3> some fields are missing, please fill the form again </h3> <%
   }
   else{
   boolean listIsOk=true;
   //first test if path name is valid: if it's already exsists or if it was empty
   // we can ignore this as an exeption will be fired if name was repeated
   try{
     //we can check the path content if it holds any mistakes
     while((tokens.hasMoreTokens())&&(listIsOk)){
      pos_name=tokens.nextToken();
      if(pos_name.equals(oldToken)) //this case won't happen any way, because we made the check on the client side
        listIsOk=false;             // but we'll keep any way
      oldToken=pos_name;
      // parse the position name to id
      ResultSet pos_id=connector.executeQuery("SELECT pos_id FROM position WHERE pos_name='"+pos_name+"'");
      if(pos_id.next()){
        address_chain=address_chain+pos_id.getString("pos_id")+" ";
      }
      else{
        listIsOk=false;
      }
     }
     if(listIsOk){
         connector.executeUpdate("INSERT INTO path (path_name,address_chain,template) VALUES ('"+path_name+"','"+address_chain+"','"+template+"')");
        %> <h1> new path was succefully created </h1> <%
     }
     else{ %>
        <br> error in the path content, or doublicated position( trying to send to your self directly)
   <%}
   }
    catch(Exception e){
      %> <h1> error </h1> <%= e.toString() %>
   <% }
   }%>


</body>
</html>
