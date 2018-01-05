import app.contracts.Action;
import app.contracts.Targetable;
import app.models.actions.OneVsOne;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TestOneVsOne {

    private static final String EXPECTED_ERROR = "There should be exactly 2 participants for OneVsOne!";
    private static final String EXPECTED_WINNER = "%s is victorious!";

    private Action oneVsOne;
    private List<Targetable> participants;

    @Before
    public void init() {
        this.oneVsOne = new OneVsOne();
        this.participants = new ArrayList<>();
    }

    @Test
    public void lessThanTwoParticipantsReturnErrorMessage() {
        this.participants.add(mock(Targetable.class));
        String actualMessage = this.oneVsOne.executeAction(this.participants);
        Assert.assertEquals("Incorrect error message",
                EXPECTED_ERROR, actualMessage);
    }

// doesn't earn points from Judge
    @Test
    public void moreThanTwoParticipantsReturnErrorMessage() {
        Targetable firstParticipant = mock(Targetable.class);
        Targetable secondParticipant = mock(Targetable.class);
        Targetable thirdParticipant = mock(Targetable.class);
        this.participants.addAll(Arrays.asList(
                firstParticipant, secondParticipant, thirdParticipant));
        String actualMessage = this.oneVsOne.executeAction(this.participants);
        Assert.assertEquals("Incorrect error message",
                EXPECTED_ERROR, actualMessage);
    }

    @Test
    public void executeProducesCorrectWinner() {

        Targetable firstParticipant = mock(Targetable.class);
        Mockito.when(firstParticipant.getName()).thenReturn("Sole Survivor");
        Mockito.when(firstParticipant.isAlive()).thenReturn(true);

        Targetable secondParticipant = mock(Targetable.class);
        Mockito.when(secondParticipant.getName()).thenReturn("Desperate Loser");
        Mockito.when(secondParticipant.isAlive()).thenReturn(false);

        Mockito.when(firstParticipant.attack(secondParticipant)).thenReturn("");
        Mockito.when(secondParticipant.attack(firstParticipant)).thenReturn("");

        this.participants.addAll(Arrays.asList(firstParticipant, secondParticipant));

        String actualMessage = this.oneVsOne.executeAction(this.participants).trim();
        Assert.assertTrue("Incorrect final result",
                actualMessage.startsWith(firstParticipant.getName()));
    }

//    @Test
//    public void executeActionShouldSucceedForSecondWarrior() {
//        // Arrange
//        Warrior victor = Mockito.mock(Warrior.class);
//        Warrior looser = Mockito.mock(Warrior.class);
//
//        Mockito.doNothing().when(victor).levelUp();
//        Mockito.doNothing().when(looser).levelUp();
//
//        Mockito.when(victor.attack(looser)).thenReturn("");
//        Mockito.when(looser.attack(victor)).thenReturn("");
//        Mockito.when(victor.isAlive()).thenReturn(true);
//        Mockito.when(victor.getName()).thenReturn("Victor");
//        Mockito.when(looser.isAlive()).thenReturn(false);
//        Mockito.when(looser.getName()).thenReturn("Looser");
//
//        this.participants.add(looser);
//        this.participants.add(victor);
//
//        //Act
//        String result = this.oneVsOne.executeAction(this.participants).trim();
//
//        // Assert
//        Assert.assertTrue(result, result.startsWith(victor.getName()));
//    }
}
