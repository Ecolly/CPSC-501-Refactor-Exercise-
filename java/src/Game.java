import java.util.ArrayList;
import java.util.List;

public class Game {
	//variables
    List <Player> playerlist = new ArrayList<>();
	Question questiondeck;
    int currentID = 0;

    public Game(){
    	this.questiondeck = new Question();
		this.questiondeck.createQuestionList();
    }
	
	public void addPlayer(String playerName) {
		Player player = new Player(playerName);
	    playerlist.add(player);    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + playerlist.size());
	}

	public int howManyPlayers() {
		return playerlist.size();
	}
	
	public void MoveLocation(int roll) {
		Player currentplayer = playerlist.get(currentID);
		System.out.println(currentplayer.getName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (currentplayer.isInPenalityBox()) { //if the player is in penalty box
			if (roll % 2 != 0) {
				currentplayer.setinPenaltyBox(false);
				System.out.println(currentplayer.getName() + " is getting out of the penalty box");
				currentplayer.setLocation(roll);
				questiondeck.askQuestion(currentplayer);
			} else {
				System.out.println(currentplayer.getName() + " is not getting out of the penalty box");
				}
		} else {
			currentplayer.setLocation(roll);
			questiondeck.askQuestion(currentplayer);
		}
	}

	public boolean wasCorrectlyAnswered() {
		Player currentplayer = playerlist.get(currentID);
		if (!currentplayer.isInPenalityBox()){
			System.out.println("Answer was correct!!!!");
			currentplayer.setPurse(1);
			System.out.println(currentplayer.getName()
					+ " now has "
					+ currentplayer.getPurse()
					+ " Gold Coins.");
			boolean winner = currentplayer.didPlayerWin();
			currentID++;
			if (currentID == playerlist.size()) currentID = 0;
			return winner;
		} else {
			currentID++;
			if (currentID == playerlist.size()) currentID = 0;
			return true;
		}
	}
	
	public boolean wrongAnswer(){
		Player currentplayer = playerlist.get(currentID);
		System.out.println("Question was incorrectly answered");
		System.out.println(currentplayer.getName() + " was sent to the penalty box");
		currentplayer.setinPenaltyBox(true);
		
		currentID++;
		if (currentID == playerlist.size()) currentID = 0;
		return true;
	}
}
