import java.util.LinkedList;

public class Question {
    LinkedList <String> popQuestions = new LinkedList<>();
    LinkedList <String> scienceQuestions = new LinkedList<>();
    LinkedList <String> sportsQuestions = new LinkedList<>();
    LinkedList <String> rockQuestions = new LinkedList<>();
    
    public void createQuestionList(){
		for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(("Rock Question " + i));
    	}
	}
    public void askQuestion(Player player) {
		if (currentCategory(player) == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory(player) == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory(player) == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory(player) == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	public String currentCategory(Player player) { //depending on the location of the player, return the question
		if (player.getLocation() == 0) return "Pop";
		if (player.getLocation() == 4) return "Pop";
		if (player.getLocation() == 8) return "Pop";
		if (player.getLocation() == 1) return "Science";
		if (player.getLocation() == 5) return "Science";
		if (player.getLocation() == 9) return "Science";
		if (player.getLocation() == 2) return "Sports";
		if (player.getLocation() == 6) return "Sports";
		if (player.getLocation() == 10) return "Sports";
		return "Rock";
	}

}
