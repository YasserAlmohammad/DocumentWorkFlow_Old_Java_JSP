package project;

public class UserInfo {

  private int pos_id;  //means no successful sign in happended yet
  public UserInfo() {
    pos_id=-1;
  }

  public void setPos_id(int id){ pos_id=id;}
  public int getPos_id(){ return pos_id;}
}