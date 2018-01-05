package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

public class OneVsOne implements Action {

    private static final String VICTORIOUS = "%s is victorious!%s%s";
    private static final String ERROR = "There should be exactly 2 participants for OneVsOne!";
    private static final int REQUIRED_PARTICIPANT_COUNT = 2;

    @Override
    public String executeAction(List<Targetable> participants) {

        if (participants.size() != REQUIRED_PARTICIPANT_COUNT) {
            return ERROR;
        }

        StringBuilder sb = new StringBuilder();

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        while (firstHero.isAlive()) {
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
            } else {
                break;
            }
        }

        if (firstHero.isAlive()) {
            sb.append(String.format(VICTORIOUS,
                    firstHero.getName(),
                    System.lineSeparator(),
                    firstHero.toString()));
        } else {
            sb.append(String.format(VICTORIOUS,
                    secondHero.getName(),
                    System.lineSeparator(),
                    secondHero.toString()));
        }

        return sb.toString();
    }
}
