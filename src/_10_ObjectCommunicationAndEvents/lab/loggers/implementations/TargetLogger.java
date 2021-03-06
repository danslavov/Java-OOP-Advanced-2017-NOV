package _10_ObjectCommunicationAndEvents.lab.loggers.implementations;

import _10_ObjectCommunicationAndEvents.lab.loggers.LogType;

public class TargetLogger extends Logger {
    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.TARGET) {
            System.out.println(logType + ": " + message);
        } else {
            super.passToSuccessor(logType, message);
        }
    }
}
