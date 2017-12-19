package _10_ObjectCommunicationAndEvents.lab.loggers.implementations;

import _10_ObjectCommunicationAndEvents.lab.loggers.LogType;

public class CombatLogger extends Logger {

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.ATTACK || logType == LogType.MAGIC) {
            System.out.println(logType + ": " + message);
        } else {
            super.passToSuccessor(logType, message);
        }
    }
}
