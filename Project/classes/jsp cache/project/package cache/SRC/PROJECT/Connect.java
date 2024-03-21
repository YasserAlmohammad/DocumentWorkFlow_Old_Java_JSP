package project;
import java.sql.*;
/**
 * Title: connection bean class
 * Description: we will use this class to simplify connecting to database and to make it as a template
 * we can use one instance in a whole session
 * the whole code wont change in general, if a database type has changed, we just change the url
 * we can use the general driver :"sun.jdbc.odbc.JdbcOdbcDriver", or we can specify the driver we want to use
 * this class will make things better.
*/

public class Connect  {
  private Connection c=null;
  private Statement s=null;
  private String driver="sun.jdbc.odbc.JdbcOdbcDriver";

  public Connect(){

  }

  //first connect method uses the general sun driver
  public void connect(String url,String username,String password){
   try{
      Class.forName(driver);   //load driver
      c= DriverManager.getConnection(url,username,password);  //make the connection
      s=c.createStatement();   //initialize for query
    }
    catch(SQLException e){
        System.err.print("SQL error, driver not found:"+e.toString());
    }
    catch(ClassNotFoundException e){ System.err.print("Driver not loaded:"+e.toString()); }
  }

  //the second connect method we can specify the driver we want to use
  public void connect(String drive,String url,String username,String password){
   try{
      Class.forName(drive);
      c= DriverManager.getConnection(url,username,password);
      s=c.createStatement();
    }
    catch(SQLException e){
        System.err.print("SQL error, driver not found:"+e.toString());
    }
    catch(ClassNotFoundException e){ System.err.print("Driver not loaded:"+e.toString()); }
  }

  /************** methods for querying databse ************************/
  public ResultSet executeQuery(String query) throws SQLException {
      return s.executeQuery(query);
  }

  public int executeUpdate(String query)throws SQLException{
    return s.executeUpdate(query);
  }

  public boolean execute(String query)throws SQLException{
    return s.execute(query);
  }
  /**************** transaction methods ******************************/
  public void commit() throws SQLException{
    c.commit();
  }

  public void rollBack() throws SQLException {
    c.rollback();
  }

  // jdk bellow 1.4 don't contains methods for savePoint and real transaction
  // jdk 1.4 and above contains this in the Connection interface


  /**************** ending connection ********************************/
  public void disconnect(){
    try{
        if(s!=null) s.close();
        if(c!=null) c.close();
    }
    catch(Exception e){}
  }

  protected void finalize(){
    try{
        if(s!=null) s.close();
        if(c!=null) c.close();
    }
    catch(Exception e){}
  }
}
