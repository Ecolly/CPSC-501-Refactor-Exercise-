import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    List <Player> playerlist = new ArrayList<>();
    
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    int currentID = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }


	
	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}

	public void add(String playerName) {
		Player player = new Player(playerName);
	    playerlist.add(player);    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + playerlist.size());
	}
	
	public int howManyPlayers() {
		return playerlist.size();
	}

	public void roll(int roll) {
		Player currentplayer = playerlist.get(currentID);
		System.out.println(currentplayer.getName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (currentplayer.getinPenaltyBox()) { //if the player is in penalty box
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				currentplayer.setinPenaltyBox(false);
				System.out.println(currentplayer.getName() + " is getting out of the penalty box");
				currentplayer.setLocation(roll);
				if (currentplayer.getLocation() > 11) currentplayer.setLocation(12);
				
				System.out.println(currentplayer.getName()
						+ "'s new location is " 
						+ currentplayer.getLocation());
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(currentplayer.getName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			currentplayer.setLocation(roll);
			if (currentplayer.getLocation() > 11) currentplayer.setLocation(12);
			
			System.out.println(currentplayer.getName()
						+ "'s new location is " 
						+ currentplayer.getLocation());
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	
	private String currentCategory() { //depending on the location of the player, return the question
		Player currentplayer = playerlist.get(currentID);
		if (currentplayer.getLocation() == 0) return "Pop";
		if (currentplayer.getLocation() == 4) return "Pop";
		if (currentplayer.getLocation() == 8) return "Pop";
		if (currentplayer.getLocation() == 1) return "Science";
		if (currentplayer.getLocation() == 5) return "Science";
		if (currentplayer.getLocation() == 9) return "Science";
		if (currentplayer.getLocation() == 2) return "Sports";
		if (currentplayer.getLocation() == 6) return "Sports";
		if (currentplayer.getLocation() == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		Player currentplayer = playerlist.get(currentID);
		if (currentplayer.getinPenaltyBox()){
			if (isGettingOutOfPenaltyBox) {
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
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			currentplayer.setPurse(1);
			System.out.println(currentplayer.getName()
					+ " now has "
					+ currentplayer.getPurse()
					+ " Gold Coins.");
			
			boolean winner = currentplayer.didPlayerWin();
			currentID++;
			if (currentID == playerlist.size()) currentID = 0;
			
			return winner;
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
