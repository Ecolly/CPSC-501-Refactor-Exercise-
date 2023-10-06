
public class Player {
    private String name;
    private int location;
    private int purse;
    private boolean inPenaltyBox;

    public Player(String name){
        //initialize the player inital value
        this.name = name;
        this.location = 0;
        this.purse = 0;
        this.inPenaltyBox = false;
    }
    //using getter and setter methods for data access and modification
    //getter methods
    public String getName(){
        return name;
    }
    public int getLocation(){
        return location;
    }
    public int getPurse(){
        return purse;
    }
    public boolean isInPenalityBox(){
        return inPenaltyBox;
    }

    //setter methods
    public void setLocation(int newloc){
        this.location = this.location + newloc;
    }
    public void setPurse(int coin){
        this.purse = this.purse + coin;
    }
    public void setinPenaltyBox(boolean pen){
        this.inPenaltyBox = pen;
    }
	public boolean didPlayerWin() {
		return !(this.getPurse()== 6);
	}
}
