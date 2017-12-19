package _10_ObjectCommunicationAndEvents.lab.loggers.implementations;

import _10_ObjectCommunicationAndEvents.lab.loggers.LogType;
import _10_ObjectCommunicationAndEvents.lab.loggers.interfaces.Handler;

public abstract class Logger implements Handler {

    private Handler successor;

    @Override
    public abstract void handle(LogType logType, String message);

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }

    protected void passToSuccessor(LogType logType, String message) {
        if (this.successor != null) {
            this.successor.handle(logType, message);
        }
    }
}
