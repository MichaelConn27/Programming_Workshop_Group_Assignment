import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static EventPlanner planner = new EventPlanner();
    static UserInteraction inter = new UserInteraction(planner);

    public static void main(String[] args) {
        planner.addEvent("2020 Colloquium");
        planner.addEvent("2021 Colloquium");
        planner.addAtendee("Louis", "2021 Colloquium");
        planner.addAtendee("Steve", "2021 Colloquium");
        planner.addAtendee("Joe", "2021 Colloquium");
        inter.startCycle();
    }
}