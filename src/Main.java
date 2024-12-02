import java.util.Scanner;
import java.util.HashSet;

public class Main {

    static EventPlanner planner = new EventPlanner();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        planner.addEvent("2020 Fall Colloquium", new HashSet<String>());
        planner.addEvent("2021 Fall Colloquium", new HashSet<String>());
        planner.addAtendee("Louis", "2021 Fall Colloquium");
        planner.addAtendee("Steve", "2021 Fall Colloquium");
        planner.addAtendee("Joe", "2021 Fall Colloquium");
    }

    public void startCycle() {
        boolean done = false;
        while (!done) {
            System.out.println("Choose a command by entering the corresponding number:");
            System.out.println("1. View events");
            System.out.println("2. View attendees for an event");
            System.out.println("3. Add event");
            System.out.println("4. Add attendee to an event");
            System.out.println("5. Add multiple attendees to an event");
            System.out.println("9. Quit");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    viewEvents();
                    break;
                case 2:
                    viewAttendees();
                    break;
                case 3:
                    addEvent();
                    break;
                case 4:
                    addAtendee();
                    break;
                case 5:
                    addAtendees();
                    break;
                case 9:
                    done = true;
            }
        }
    }

    public void viewEvents() {
        for (String event : planner.events.keySet()) {
            System.out.println(event);
        }
    }

    public void viewAttendees() {
        System.out.println("Enter event to view attendees:");
        String event = sc.nextLine();
        planner.fetchEventData(event);
    }

    public void addEvent() {
        System.out.println("Enter event to add:");
        String eventName = sc.nextLine();
        planner.addEvent(eventName);
    }

    public void addAtendee() {
        System.out.println("Enter event to add attentees:");
        String eventName = sc.nextLine();
        System.out.println("Enter the name to be added to the event: ");
        String attendee = sc.nextLine();
        planner.addAtendee(eventName, attendee);
        sc.close();
    }

    public void addAtendees() {
        System.out.println("Enter event to add attentees:");
        String eventName = sc.nextLine();
        boolean con = true;
        HashSet<String> list = new HashSet<>();
        while (con) {
            System.out.println("Enter a name to be added to the event. If done entering names, input 'exit' to exit: ");
            String attendee = sc.nextLine();
            if (attendee.equals("exit")) {
                con = false;
            } else {
                list.add(attendee);
            }
        }
        planner.addAtendeeList(list, eventName);

    }
}