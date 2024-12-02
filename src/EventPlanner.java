import java.util.HashMap;
import java.util.HashSet;

public class EventPlanner {
    HashMap<String, HashSet<String>> events;

    public EventPlanner() {
        events = new HashMap<>();
    }

    public void addEvent(String eventName) {
        events.put(eventName, new HashSet<>());
    }

    public void addEvent(String eventName, HashSet<String> names) {
        events.put(eventName, names);
    }

    public void addAtendee(String name, String eventName) {
        events.get(eventName).add(name);
    }

    public void addAtendeeList(HashSet<String> names, String eventName) {
        events.get(eventName).addAll(names);
    }

    public void fetchEventData(String eventName) {
        if (events.containsKey(eventName)) {
            System.out.println(events.get(eventName));
        } else {
            System.out.println("Event not found");
        }
    }
}
