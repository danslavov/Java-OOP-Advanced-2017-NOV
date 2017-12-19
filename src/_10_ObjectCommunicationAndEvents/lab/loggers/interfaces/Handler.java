package _10_ObjectCommunicationAndEvents.lab.loggers.interfaces;

import _10_ObjectCommunicationAndEvents.lab.loggers.LogType;

public interface Handler {

    void handle(LogType logType, String message);
    void setSuccessor(Handler handler);
}
