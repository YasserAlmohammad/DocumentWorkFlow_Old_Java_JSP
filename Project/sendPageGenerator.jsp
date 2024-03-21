<%@ include file="ConnectInclude.jsp" %>

<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<title>sending new document&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</title>


<SCRIPT language="javascript">

//we'll change the form destination according to the submit button click

function sendClick(){
  document.send.action="send.jsp"  // the default
}

function loadClick(){
  document.send.action="sendPageGenerator.jsp"
}

function pathChange(){
  document.send.loadTemplate.click();

}

</script>

</head>
<body bgcolor="#eeeeee">
<% if(userInfo.getPos_id()<0){  //security matter: if you are not signed in you can't see this page
      %> <jsp:forward page="error.htm" />
 <%}
%>

<p align="center">
<a href="inbox.jsp"><font color="#000080"><b>inbox</b></font></a>&nbsp;&nbsp;
<a href="outbox.jsp"><font color="#000080"><b>outbox</b></font></a>&nbsp;&nbsp;
<a href="sendPageGenerator.jsp"><font color="#000080"><b>send doc</b></font></a>&nbsp;&nbsp;
<a href="reporting.jsp"><font color="#000080"><b>reporting</b></font></a>&nbsp;&nbsp;
<a href="changeUserPass.jsp"><font color="#000080"><b>changePassword</b></font></a>&nbsp;&nbsp;
<a href="helpFiles/help.htm"><font color="#000080"><b>help&amp;support</b></font></a></p>
<h1 align="center"><font color="#800000" size="5"><b><i>sending new document&nbsp;</i></b><i>&nbsp;
</i></font><font size="5">&nbsp;&nbsp; </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</h1>
<p align="left"><font color="#000000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</font><font color="#000000"><img border="0" src="images/D4.gif" width="105" height="78"></font></p>

<p align="left"><b><font color="#808080">please fill the existing fields and
they will be automatically completed</font></b></p>
<p align="left"><b><font color="#808080">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
use </font><a href="helpFiles/help.htm"><font color="#000080"> help</font></a><font color="#808080"> for more information on how this works</font></b></p>
<!-- the jsp generation code -->

<form name="send" method="POST" action="send.jsp" >
  <p>
  <%String path_val=request.getParameter("path_name");
    String template="";
    try{
      //String path_name=request.getParameter("path_name");
      %> <hr> <%
      ResultSet r=connector.executeQuery("SELECT template,address_chain FROM path WHERE path_name='"+path_val+"'");
      if(r.next()){ //view the positions representing the path
        template=r.getString("template");
        StringTokenizer tokens=new StringTokenizer(r.getString("address_chain"));
        if(tokens.hasMoreTokens())
           tokens.nextToken(); //skip your self
        %><%= path_val%> path will follow this way:<br>from you <%
        while(tokens.hasMoreTokens()){
          String pos_id=tokens.nextToken();
          r=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+pos_id);
          if(r.next()){
            %> --> <%= r.getString("pos_name") %> <%
         }
        }
      }
      %> <hr>

  select path for your document:<span lang="ar-sy">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span>&nbsp;<select size="1" name="path_name" onChange="pathChange()">
   <option selected value="<%=path_val%>"><%=path_val%></option>
  <%
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
          %>
          <option value="<%= path_name%>"> <%=path_name %></option>
        <%}
       }
   } %>

  </select>
  <input type="submit" value="load template" name="loadTemplate" onClick="loadClick()"></p>
  <p>if you selected manual as path type select the position you want to send
  it for&nbsp;&nbsp;
  <select size="1" name="pos_name">

<%
   // view all positions available for manual direcing
   String pos_name="",pos_id;

   //administrator is not count, and you can't send message to your self directly
   ResultSet poss=connector.executeQuery("SELECT pos_name,pos_id FROM position WHERE pos_name<> 'administrator' AND pos_id<>"+userInfo.getPos_id());
   while(poss.next()){
       pos_name=poss.getString("pos_name");
       pos_id=poss.getString("pos_id");
      //we can know everything about user from pos_id
       %>

       <option value="<%= pos_id %>"> <%=pos_name %></option>
   <%}


   }catch(SQLException e){ %>
    <h1> SQL error <h1> <%=e.toString() %>
<% } %>
  </select></p>

  <p>you can define new path, if your document type will be frequently used,
  click here
  <a href="newPath.jsp"> define new path</a> </p>
  number on document(required, like 232EF88D8) :  <input type="text" name="num_on_doc" size="25">
  <p>date on document i.e 22-3-2003 :
  <input type="text" name="day" size="2" >
  <input type="text" name="month" size="2" >
  <input type="text" name="year" size="4" >
  <input type="hidden" name="path_val" value="<%=path_val%>">
  </p>
  <p><textarea rows="10" name="content" cols="100"><%=template%></textarea></p>
  <p align="left"><font ><b>if you have a note write it below</b></font></p>
  <p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <textarea rows="6" name="note" cols="72"></textarea></p>
  <p><u><input type="submit" value="send documnet" name="send"><input type="reset" value="   Reset form   " name="B2"></u></p>

</form>
<p align="right"><a href="homepage.jsp"><img border="0" src="images/60.gif" width="72" height="29"></a></p>
<form method="POST" action="SignOut.jsp">
  <p>
  <input type="submit" value="sign out" name="signout"></p>
</form>

</body>

</html>