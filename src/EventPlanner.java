import java.util.HashMap;
import java.util.ArrayList;

public class EventPlanner {
    HashMap<String, ArrayList<String>> events;

    public EventPlanner() {
        events = new HashMap<>();
    }

    public void addEvent(String eventName) {
        events.put(eventName, new ArrayList<>());
    }

    public void addEvent(String eventName, ArrayList<String> names) {
        events.put(eventName, names);
    }

    public void addAtendee(String name, String eventName) {
        events.get(eventName).add(name);
    }

    public void addAtendeeList(ArrayList<String> names, String eventName) {
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
