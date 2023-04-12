//import jdk.internal.org.jline.terminal.impl.LineDisciplineTerminal;

import java.util.Map;

public interface Tracker {

    void push(String message);

    Boolean has(String message);

    void handle(String message, EventHandler e);

    Map<String, Integer> tracker();

    void handle(String messageToReplyWith, EventListener eventListener);
}
