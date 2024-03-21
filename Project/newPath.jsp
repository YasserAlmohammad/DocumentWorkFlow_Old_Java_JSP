<%@ include file="ConnectInclude.jsp" %>
<html>

<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<title>new document type generator</title>
</head>

<SCRIPT language="javaScript" >

var content="";
var oldPos="";
var newPos="";
function addclick(){
	content=document.newPath.address_chain.value
        newPos=document.newPath.positions.options[document.newPath.positions.selectedIndex].value
        if(oldPos==newPos){ // we'll prevent user from sending letter to him self directly
          alert("can't send to your self directly")
        }
        else{  //it's ok
          // we can parse the address before it's sent to createPath.jsp - for arabic to work -

          if(content==""){
	    document.newPath.address_chain.value=newPos
          }
          else{
            document.newPath.address_chain.value=content+"*"+newPos
          }
            oldPos=newPos

        }

        content=document.newPath.address_chain.value

        /*
        without checking
        content=document.newPath.address_chain.value
	document.newPath.address_chain.value=content+">"+document.newPath.positions.options[document.newPath.positions.selectedIndex].value
        content=document.newPath.address_chain.value
        */
}

function contentChange(){
    document.newPath.address_chain.value=content;
    alert("what are you doing? you musn't change this content manually, use reset button to restart building the path")
}

function loadEvent(){
  oldPos=document.newPath.address_chain.value
}

</SCRIPT>

<body bgcolor="#eeeeee" onLoad="loadEvent()">

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%}
  try{
 //first check if our friend can define paths or not
  ResultSet r=connector.executeQuery("SELECT can_define_new_path FROM position WHERE pos_id="+userInfo.getPos_id());
  if(r.next()){
    String can=r.getString(1);
    if(can.equals("yes")){ //ok you can
%>

<form name="newPath" method="POST" action="createPath.jsp">
  <p>name document type:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="path_name" size="28"></p>
  <p>
  <input type="button" value="add selected direction" name="add" onclick="addclick()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <select size="1" name="positions">
<%
   ResultSet pos_names=connector.executeQuery("SELECT pos_name,pos_id FROM position WHERE pos_name<>'administrator' AND pos_name<>'archive'");
   String name="";
   //add the first positionas selected
   if(pos_names.next()){
      name=pos_names.getString("pos_name");
      %>
      <option value="<%= name %>" selected><%= name %> </option>
   <%
   }
  //add all positions available
   while(pos_names.next()){
      name=pos_names.getString("pos_name");%>
      <option value="<%= name %>" > <%= name %> </option>
  <%
   }
%>
  <!-- we could add check restriction to assure that any position won't put itself in th beginning of path -->
  </select> don't put yourself as the beginner of the path, you will be automatically considerd </p>
  <% r=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+userInfo.getPos_id());
     String current_pos_name="";
     if(r.next()){
        current_pos_name=r.getString("pos_name");
     }
   r=connector.executeQuery("SELECT username FROM users WHERE pos_id="+userInfo.getPos_id());
   if(r.next()){
    String username=r.getString("username");
    if("admin".equals(username.toLowerCase())){ //allow admin to define paths for others
      %>
      <p><textarea rows="4" name="address_chain" cols="100" onChange="contentChange()"></textarea></p>
  <%}else{
  %>
  <p><textarea rows="4" name="address_chain" cols="100" onChange="contentChange()"><%=current_pos_name %> </textarea></p>
  <%}
  }%>
  <p>input template if you like<br> <textarea rows="8" name="template" cols="100"></textarea></p>
  <p>&nbsp;</p>
  <p><input type="submit" value="create path" name="B1">
  <input type="reset" value="Reset" name="B2"></p>

</form>

<% }else{ //you can't define new path
    %>  <h3> you can't define new document type, contact administrator for more information
    <%
  }}
  }catch(SQLException e){ %> <h3> ERROR </H3> <% }%>

</body>

</html>