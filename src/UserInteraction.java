import java.util.ArrayList;
import java.util.Scanner;

public class UserInteraction {
    private static Scanner sc = new Scanner(System.in);
    private static EventPlanner planner = new EventPlanner();

    public UserInteraction(EventPlanner planner) {
        UserInteraction.planner = planner;
    }

    public static void startCycle() {
        boolean done = false;
        while (!done) {
            sc = sc.reset();
            System.out.println("Choose a command by entering the corresponding number:");
            System.out.println("1. View events");
            System.out.println("2. View attendees for an event");
            System.out.println("3. Add event");
            System.out.println("4. Add attendee to an event");
            System.out.println("5. Add multiple attendees to an event");
            System.out.println("6. Remove attendee from an event");
            System.out.println("9. Quit");
            int command = sc.nextInt();
            sc = sc.reset();
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
                case 6:
                    removeAttendee();
                    break;
                case 9:
                    done = true;
            }
        }
    }

    private static void viewEvents() {
        for (String event : planner.getKeySet()) {
            System.out.println(event);
        }
    }

    private static void viewAttendees() {
        System.out.print("Enter event to view attendees: ");
        String event = new Scanner(System.in).nextLine();
        System.out.println(event);
        planner.fetchEventData(event.trim());
        planner.fetchEventData("2021 Colloquium");
    }

    private static void addEvent() {
        System.out.println("Enter event to add:");
        String eventName = new Scanner(System.in).nextLine();
        planner.addEvent(eventName);
    }

    private static void addAtendee() {
        System.out.println("Enter event to add attentees:");
        String eventName = new Scanner(System.in).nextLine();
        System.out.println(eventName);
        System.out.println("Enter the name to be added to the event: ");
        String attendee = new Scanner(System.in).nextLine();
        planner.addAtendee(attendee, eventName);
    }

    private static void removeAttendee() {
        System.out.println("Enter event to remove attentee from: ");
        String eventName = new Scanner(System.in).nextLine();
        System.out.println("Enter the name to be removed from the event: ");
        String attendee = new Scanner(System.in).nextLine();
        planner.removeAtendee(attendee, eventName);
    }

    private static void addAtendees() {
        System.out.println("Enter event to add attentees:");
        String eventName = new Scanner(System.in).nextLine();
        boolean con = true;
        ArrayList<String> list = new ArrayList<>();
        while (con) {
            System.out.println("Enter a name to be added to the event. If done entering names, input 'exit' to exit: ");
            String attendee = new Scanner(System.in).nextLine();
            if (attendee.equals("exit")) {
                con = false;
            } else {
                list.add(attendee);
            }
        }
        planner.addAtendeeList(list, eventName);

    }
}
