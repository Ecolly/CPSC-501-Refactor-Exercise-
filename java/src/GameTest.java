import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;;

public class GameTest {
    @Test
    public void didPlayerWintest(){ //if player wins then the test is set to true
        Game g = new Game();
        g.currentID = 0;
        g.add("bob");
        g.playerlist.get(0).setPurse(5);
        assertTrue("Player won", g.didPlayerWin());
    }
    @Test
    public void getOutOfPenalityTest(){
        Game g = new Game();
        g.currentID = 0;
        g.add("bob");
        g.playerlist.get(0).setinPenaltyBox(true); /// set the first player's penalty to true and see if they ever get out
        g.roll(2); //roll a 2 which means the player gets out
        assertTrue("Player in penality",g.playerlist.get(0).getinPenaltyBox());
        g.roll(1); //roll a 1 which means the player not getting out
        assertFalse("Player not in penality", g.playerlist.get(0).getinPenaltyBox());
    }
    
    @Test
    public void CorrectlyAnsweredTest(){
        Game g = new Game();
        g.add("bob");
        g.currentID = 0;
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
        Game g = new Game();
        g.add("bob");
        g.currentID = 0;
        Player current = g.playerlist.get(0);  
        current.setinPenaltyBox(true);  //If the player answered wrongly
        g.wrongAnswer();
        assertEquals("Player gets no coin", 0, current.getPurse());
    }
    @Test
    public void howManyPlayersTest(){
        Game g = new Game();
        g.add("bob");
        assertEquals("There should be only one player",1, g.playerlist.size()) ;
    }
    @Test
    public void testPlayerMoveLocation(){

    }
    
}
