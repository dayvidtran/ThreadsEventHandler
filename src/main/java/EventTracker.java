import java.util.HashMap;
import java.util.Map;

public class EventTracker implements Tracker {

    private static EventTracker INSTANCE = new EventTracker();

    private Map<String, Integer> tracker;

    private EventTracker() {
        this.tracker = new HashMap<>();
    }

    synchronized public static EventTracker getInstance() {
        return EventTracker.INSTANCE;
    }

    synchronized public void push(String message) {
        if (has(message)){
            tracker.put(message, tracker.get(message)+1);
        }else{
            tracker.put(message,1);
        }
    }

    synchronized public Boolean has(String message) {
        if (tracker.containsKey(message)){
            if (tracker.get(message) > 0);
            return true;
        }
        return false;
    }

    synchronized public void handle(String message, EventHandler e) {
        e.handle();
        tracker.put(message, tracker.get(message)-1);
    }

    @Override
    public Map<String, Integer> tracker() {
        return tracker;
    }

    @Override
    public void handle(String messageToReplyWith, EventListener eventListener) {

    }

    // Do not use this. This constructor is for tests only
    // Using it breaks the singleton class
    EventTracker(Map<String, Integer> tracker) {
        this.tracker = tracker;
    }
}
