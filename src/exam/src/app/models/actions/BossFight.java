package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.Boss;

import java.util.*;
import java.util.stream.Collectors;

public class BossFight implements Action {

    private static final String ERROR = "There should be at least 1 participant for boss fight!";
    private static final String BOSS_SLAIN_BY = "Boss has been slain by:";
    private static final String BOSS_SLAIN_ALL = "Boss has slain them all!";
    private static final int MIN_PARTICIPANT_NUMBER = 2;
    private static final String INVALID_BOSS = "Invalid boss.";

    @Override
    public String executeAction(List<Targetable> participants) {

        if (participants.size() < MIN_PARTICIPANT_NUMBER) {
            return ERROR;
        }

        Targetable boss = participants.get(0);

        if (!(boss instanceof Boss)) {
            return INVALID_BOSS;
        }

        Queue<Targetable> heroes = new ArrayDeque<>();
        for (int i = 1; i < participants.size(); i++) {
            Targetable hero = participants.get(i);
            if (hero.isAlive()) {
                heroes.offer(participants.get(i));
            }
        }

        StringBuilder result = new StringBuilder();

        while (!heroes.isEmpty()) {

            Targetable hero = heroes.poll();

            String heroAttackResult = hero.attack(boss);
            if (heroAttackResult.length() > 0) {
                result.append(heroAttackResult).append(System.lineSeparator());
            }

            if (boss.isAlive()) {
                String bossAttackResult = boss.attack(hero);
                if (bossAttackResult != null) {
                    result.append(bossAttackResult).append(System.lineSeparator());
                }

            } else {
                for (Targetable h : heroes) {
                    h.levelUp();
                    h.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                }
                hero.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                heroes.offer(hero);

                List<Targetable> orderedHeroes = heroes.stream()
                        .sorted(Comparator.comparing(Targetable::getName))
                        .collect(Collectors.toList());

                result.append(BOSS_SLAIN_BY)
                        .append(System.lineSeparator());

                for (int i = 0; i < orderedHeroes.size(); i++) {
                    Targetable h = orderedHeroes.get(i);
                    result.append(h.toString());

                    if (i < orderedHeroes.size() - 1) {
                        result.append(System.lineSeparator());
                    }
                }

                break;
            }

            if (hero.isAlive()) {
                heroes.offer(hero);
            }
        }

        if (heroes.isEmpty()) {
            result.append(BOSS_SLAIN_ALL);
        }

        return result.toString();
    }
}

