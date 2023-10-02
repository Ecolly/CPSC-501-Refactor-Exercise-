import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;;

public class GameTest {
    @Test
    public void didPlayerWintest(){ //if player wins then the test is set to false
        Game g = new Game();
        g.add("bob");
        g.purses[0] = 6;
        assertFalse("Player won", g.didPlayerWin());
        }

    @Test
    public void getOutOfPenalityTest(){
        Game g = new Game();
        g.add("bob");
        g.inPenaltyBox[0]=true; /// set the first player's penalty to true and see if they ever get out
        g.roll(2); //roll a 2 which means the player gets out
        assertTrue("Player in penality", g.inPenaltyBox[0]);
        g.roll(1); //roll a 2 which means the player gets out
        assertFalse("Player in penality", g.inPenaltyBox[0]);
    }

    @Test
    public void CorrectlyAnsweredTest(){
        Game g = new Game();
        g.add("bob");
        g.inPenaltyBox[0]=true;  //If the player is in the penalty box, then the playr will not get a coin
        g.currentPlayer = 0;
        g.wasCorrectlyAnswered();
        assertEquals("Player gets one coin", 0, g.purses[0]);

        g.inPenaltyBox[0] = false; //If the player is NOT in the penalty box, then the player will get a coin
        g.wasCorrectlyAnswered();
        assertEquals("Player gets one coin", 1, g.purses[0]);
    }
    @Test
    public void WrongAnswerTest(){
        Game g = new Game();
        g.add("bob");
        g.inPenaltyBox[0]=true;  //If the player answered wrongly
        g.currentPlayer = 0;
        g.wrongAnswer();
        assertEquals("Player gets no coin", 0, g.purses[0]);
    }
    @Test
    public void howManyPlayersTest(){
        Game g = new Game();
        g.add("bob");
        assertEquals("There should be only one player",1, g.players.size());
    }
    
}
