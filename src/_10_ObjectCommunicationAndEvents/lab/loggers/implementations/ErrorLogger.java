package _10_ObjectCommunicationAndEvents.lab.loggers.implementations;

import _10_ObjectCommunicationAndEvents.lab.loggers.LogType;

public class ErrorLogger extends Logger {

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.ERROR) {
            System.out.println(logType + ": " + message);
        } else {
            super.passToSuccessor(logType, message);
        }
    }
}
