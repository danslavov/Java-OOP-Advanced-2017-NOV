package _10_ObjectCommunicationAndEvents.ex.p01_event_implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();
        dispatcher.addNameChangeListener(handler);

        String input;
        while (!"End".equals(input = reader.readLine())) {
            dispatcher.setName(input);
        }
    }
}
