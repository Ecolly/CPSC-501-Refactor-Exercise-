import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;;

public class GameTest {
    Game g = new Game();
    {
        g.currentID = 0;
        g.add("bob");
    }
    @Test
    public void didPlayerWintest(){ //if player loses then the test is set to true
        Player g = new Player("bob");
        g.setPurse(5);
        assertTrue("Player won", g.didPlayerWin());
    }
    @Test
    public void getOutOfPenalityTest(){      
        g.playerlist.get(0).setinPenaltyBox(true); /// set the first player's penalty to true and see if they ever get out
        g.MoveLocation(2); //roll a 2 which means the player gets out
        assertTrue("Player in penality",g.playerlist.get(0).isInPenalityBox());
        g.MoveLocation(1); //roll a 1 which means the player not getting out
        assertFalse("Player not in penality", g.playerlist.get(0).isInPenalityBox());
    }
    
    @Test
    public void CorrectlyAnsweredTest(){
        Player current = g.playerlist.get(0);        
        current.setinPenaltyBox(true); //If the player is in the penalty box, then the playr will not get a coin
        g.wasCorrectlyAnswered();
        assertEquals("Player gets one coin",0,current.getPurse());

        current.setinPenaltyBox(false); //If the player is NOT in the penalty box, then the player will get a coin
        g.wasCorrectlyAnswered();
        assertEquals("Player gets no coins",1,current.getPurse());
    }
    @Test
    public void WrongAnswerTest(){
        Player current = g.playerlist.get(0);  
        current.setinPenaltyBox(true);  //If the player answered wrongly
        g.wrongAnswer();
        assertEquals("Player gets no coin", 0, current.getPurse());
    }
    @Test
    public void howManyPlayersTest(){
        assertEquals("There should be only one player",1, g.playerlist.size()) ;
    }
    @Test
    public void testPlayerMoveLocation(){
        Player current = g.playerlist.get(0);
        current.setLocation(13);
        g.MoveLocation(2);
        assertEquals("The player location gets set to 3",3, current.getLocation());
    }
    @Test
    public void QuestionTeststart(){
        assertEquals("Rock Question start","Rock Question 1", g.rockQuestions.get(1));
    }
    @Test
    public void QuestionTestend(){
        assertEquals("Rock Question start","Rock Question 49", g.rockQuestions.getLast());
    }
}
