<%@ include file="ConnectInclude.jsp" %>
<!-- this page will handle the user reject or accept for the document -->
<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>
redirect
</title>
</head>
<body>

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>


<%
   /* working steps:
      1- get parametrs
      2- get all info required to redirect the message
      3- check if the path is manual or automatic
      4- get the next position we'll send the message for
      5- we check the path end, or if the movemevt must stop
      6- send the message to destination inbox
      7- save note and accepatnce in the history
   */
   String choice=request.getParameter("choice");  //parameter contains both: action and doc_serial
   String doc_serial=request.getParameter("doc_serial");
   String doc_date_str=request.getParameter("doc_date");
   String arrive_date_str=request.getParameter("arrive_date");
   String dest_id=request.getParameter("pos_id");
   String note=request.getParameter("note");

   Timestamp doc_date=new Timestamp(Long.valueOf(doc_date_str).longValue());
   Timestamp arrive_date=new Timestamp(Long.valueOf(arrive_date_str).longValue());
   try{
     //first add the current link to the visited links messages
      int doc_y=doc_date.getYear()+1900,inbox_y=arrive_date.getYear()+1900; //time stamp date starts from 1900
      int doc_m=doc_date.getMonth()+1, inbox_m=arrive_date.getMonth()+1; //month and day strts from 0
      int doc_d=doc_date.getDate(),inbox_d=arrive_date.getDate();
      connector.executeUpdate("UPDATE inbox SET visited='yes' WHERE belongs_to_pos="+userInfo.getPos_id()+"AND doc_serial="+doc_serial+""
                              +" AND Year(doc_date)="+doc_y+" AND MONTH(doc_date)="+doc_m+" AND DAY(doc_date)="+doc_d+" AND YEAR(arrive_date)="+inbox_y+" AND MONTH(arrive_date)="+inbox_m+"AND DAY(arrive_date)="+inbox_d+" ");
      ResultSet linkInfo=connector.executeQuery("SELECT doc_date,arrive_date,currentAddressPos,address_chain FROM inbox WHERE belongs_to_pos="+userInfo.getPos_id()+" AND doc_serial="+doc_serial);
      int currentPos=0;
      String address_chain="";
      Timestamp d=null,a=null;
      while(linkInfo.next()){
        d=linkInfo.getTimestamp("doc_date");
        a=linkInfo.getTimestamp("arrive_date");
        if((d.getYear()==doc_date.getYear())&&(d.getMonth()==doc_date.getMonth())&&(d.getDay()==doc_date.getDay()))
           if((a.getYear()==arrive_date.getYear())&&(a.getMonth()==arrive_date.getMonth())&&(a.getDay()==arrive_date.getDay())){
             currentPos=linkInfo.getInt("currentAddressPos");
             address_chain=linkInfo.getString("address_chain");
           }
      }

      //check the document type before continue
      ResultSet docType=connector.executeQuery("SELECT doc_type FROM document WHERE serial="+doc_serial+" AND date='"+d+"'");
      String doc_type="";
      if(docType.next())
        doc_type=docType.getString("doc_type");
      // new subject will be attached to the link
      ResultSet subject=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+userInfo.getPos_id());
      String subj="";
      if(subject.next()){
        subj=subject.getString("pos_name");
        subject.close();
      }
      /****************** manual directing ************************/
      if(doc_type.equals("manual")){
          if(choice.equals("ok")){
            if(!subject.equals("archive")){ //if archive was choosen, the document is saved and not directed to any one
              //now we got all required info to redirect the message
              //in manual case the address chain is being builded over and over
              connector.executeUpdate("INSERT INTO inbox(belongs_to_pos,doc_serial,doc_date,currentAddressPos,address_chain,subject)VALUES ("+dest_id+","+doc_serial+",'"+d+"',"+ ++currentPos+",'"+address_chain+" "+dest_id+"','"+subj+"')");
              //add message link and note to history
              connector.executeUpdate("INSERT INTO history(to_pos,from_pos,doc_serial,doc_date,note) VALUES ("+dest_id+","+userInfo.getPos_id()+","+doc_serial+",'"+d+"','"+note+"')");
            }
          %> <jsp:forward page="inbox.jsp"/> <%
          }
          else{
            if(choice.equals("reject")){
               //now we got all required info to redirect the message
               //first we check if this position is the one who published the document, if yes: we must delete the document and stop the movement
               StringTokenizer temp=new StringTokenizer(address_chain);
               if(userInfo.getPos_id()==Integer.valueOf(temp.nextToken()).intValue()){ //delete
                  //document will be deleted from the database, and can't be restored
                  connector.executeUpdate("DELETE FROM document WHERE serial="+doc_serial+" AND date='"+d+"'" );
               }else{ //continue
                 connector.executeUpdate("INSERT INTO inbox(belongs_to_pos,doc_serial,doc_date,currentAddressPos,address_chain,subject)VALUES ("+dest_id+","+doc_serial+",'"+d+"',"+ ++currentPos+",'"+address_chain+" "+dest_id+"','"+subj+"')");
                 //add message link and note to history
                 connector.executeUpdate("INSERT INTO history(to_pos,from_pos,doc_serial,doc_date,note,response) VALUES ("+dest_id+","+userInfo.getPos_id()+","+doc_serial+",'"+d+"','"+note+"','reject')");
                 //we must delete the document if the position who rejected the document is the same as the one who published it
               }
              %> <jsp:forward page="inbox.jsp"/> <%

            }
          }
      }

      /***************** automatic directing ****************************/
      else{
        if(currentPos==-1){  //means the messages begins the cycling so we must stop the path
          %> <h3> this message was sent by you and now it returned back, you can't send it directly again </h3 <%
        }else{
           if(choice.equals("ok")){       //user's selected choice
              //send the message to the next direction
              ++currentPos;  //move forward in ok case
              StringTokenizer addressTokens=new StringTokenizer(address_chain);
              //we must make sure if we reached the path end, to return the message to original source or to allow replying
              //calculate next direction
              boolean stop=false;
              int i=0;
              while((!stop)&&(i<=currentPos)){
                ++i;
                if(addressTokens.hasMoreElements()){
                  dest_id=addressTokens.nextToken();
                }
                else{ // circle movement
                  //restart address_chain tokens and take the original source pos id "the first one"
                  StringTokenizer temp=new StringTokenizer(address_chain);
                  dest_id=temp.nextToken();
                  stop=true;
                  currentPos=-1;
                 }
              }

              //now we got all required info to redirect the message
              connector.executeUpdate("INSERT INTO inbox(belongs_to_pos,doc_serial,doc_date,currentAddressPos,address_chain,subject)VALUES ("+dest_id+","+doc_serial+",'"+d+"',"+currentPos+",'"+address_chain+"','"+subj+"')");
              //add message link and note to history
              connector.executeUpdate("INSERT INTO history(to_pos,from_pos,doc_serial,doc_date,note) VALUES ("+dest_id+","+userInfo.getPos_id()+","+doc_serial+",'"+d+"','"+note+"')");
             %> <jsp:forward page="inbox.jsp"/> <%


         }
         else{
            if(choice.equals("reject")){
              //message must move back one step
             if(currentPos!=0){ //you can't move back any more
              --currentPos;  //move backward in reject case
              StringTokenizer addressTokens=new StringTokenizer(address_chain);
              //we'll not reached the path end
              //calculate next direction
              int i=0;
              while(i<=currentPos){
                ++i;
                dest_id=addressTokens.nextToken();

              }
              //now we got all required info to redirect the message
              connector.executeUpdate("INSERT INTO inbox(belongs_to_pos,doc_serial,doc_date,currentAddressPos,address_chain,subject)VALUES ("+dest_id+","+doc_serial+",'"+d+"',"+currentPos+",'"+address_chain+"','"+subj+"')");
              //add message link and note to history
              connector.executeUpdate("INSERT INTO history(to_pos,from_pos,doc_serial,doc_date,note,response) VALUES ("+dest_id+","+userInfo.getPos_id()+","+doc_serial+",'"+d+"','"+note+"','reject')");
             %> <jsp:forward page="inbox.jsp"/> <%

            }
            else{
              //document will be deleted from the database, and can't be restored, the path stops here
              connector.executeUpdate("DELETE FROM document WHERE serial="+doc_serial+" AND date='"+d+"'" );
              // all related inbox, History info will be deleted as part of Master-detail relation ship
            }
           }
         }
      }
    }
  }
  catch(Exception e){ %>
  <h1> error </h1> <%= e.toString() %>
<% }%>

</body>
</html>
