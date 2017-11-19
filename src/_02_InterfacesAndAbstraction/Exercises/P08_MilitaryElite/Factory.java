package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.other.MissionImp;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.other.RepairImp;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.soldiers.*;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other.Mission;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other.Repair;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Private;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Soldier;

import java.util.*;

public class Factory {

    public static Soldier createSoldier(String params[]) {
        String type = params[0];
        int id = Integer.parseInt(params[1]);
        String firstName = params[2];
        String lastName = params[3];

        switch (type) {

            case "Private":
                double salary = Double.parseDouble(params[4]);
                return new PrivateImp(id, firstName, lastName, salary);

            case "LeutenantGeneral":
                salary = Double.parseDouble(params[4]);
                return new LeutenantGeneralImp(
                        id, firstName, lastName, salary, createPrivates(params));

            case "Engineer":
                salary = Double.parseDouble(params[4]);
                String corps = params[5];
                try {
                    return new EngineerImp(id, firstName, lastName,
                            salary, corps, createRepairs(params));
                } catch (IllegalArgumentException iae) {
                    return null;
                }


            case "Commando":
                salary = Double.parseDouble(params[4]);
                corps = params[5];
                try {
                    return new CommandoImp(
                            id, firstName, lastName, salary, corps, createMissions(params));
                } catch (IllegalArgumentException iae) {
                    return null;
                }

            case "Spy":
                int codeNumber = Integer.parseInt(params[4]);
                return new SpyImp(id, firstName, lastName, codeNumber);

            default:
                return null;
        }
    }

    private static List<Repair> createRepairs(String[] params) {
        List<Repair> repairs = new ArrayList<>();
        for (int i = 6; i < params.length; i++) {
            String partName = params[i];
            int hoursWorked = Integer.parseInt(params[++i]);
            repairs.add(new RepairImp(partName, hoursWorked));
        }
        return repairs;
    }

    private static Map<Integer, Private> createPrivates(String[] params) {
        TreeMap<Integer, Private> privates = new TreeMap<>();
        for (int i = 5; i < params.length; i++) {
            int privateId = Integer.parseInt(params[i]);
            Soldier soldier = Main.getArmy().get(privateId);
            privates.putIfAbsent(privateId, (Private) soldier);
        }

        // return map in descending order:
        return privates.descendingMap();
    }

    private static List<Mission> createMissions(String[] params) {
        List<Mission> missions = new ArrayList<>();
        for (int i = 6; i < params.length; i++) {
            String missionName = params[i];
            String missionState = params[++i];
            try {
                MissionImp mission = new MissionImp(missionName, missionState);
                missions.add(mission);
            } catch (IllegalArgumentException ignored) {}
        }
        return missions;
    }
}
