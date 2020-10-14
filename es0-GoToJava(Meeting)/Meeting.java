package gotojava1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Meeting {
    private int day;
    private int hour;
    private int duration;

    public static void main(String[] args) {
        ArrayList<Meeting> agenda = new ArrayList<>();

        System.out.println("This is your personal agenda, insert meeting in the format: [day/hour/duration]");

        boolean again = true;

        while (again) {
            System.out.print("New meeting: ");
            Scanner input = new Scanner(System.in);

            Meeting meeting = null;

            try {
                meeting = parseMeetingValues(input);
            } catch (InputMismatchException e) {
                System.err.println(e.toString());
                System.err.println("Error in entered meeting values");
            }

            if (meeting != null) {
                agenda.add(meeting);
                System.out.println("gotojava1.Meeting added to agenda");
            } else System.out.println("Something went wrong, the meeting wasn't added to the agenda");

            System.out.println("Would you like to add another meeting to the agenda? [Y/N]");
            input.nextLine();
            String choice = input.nextLine();
            if (choice.equals("Y")) again = true;
            else if (choice.equals("N")) again = false;
                else System.out.println("you fucking with me i don't like, gonna end program");
        }


        System.out.println(agenda);
        System.out.println("somehow managed to reach end of program");
    }

    private static Meeting parseMeetingValues(Scanner input) {
        int day = input.nextInt();
        int hour = input.nextInt();
        int duration = input.nextInt();

        Meeting meeting = null;
        try {
            meeting = new Meeting(day,hour,duration);
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.toString());
            System.err.println("Entered meeting values are not correct (some might be out of bounds)");
        }
        return meeting;
    }

    public Meeting(int day, int hour, int duration) {
        if (isValidDay(day) && isValidHour(hour) && isValidDuration(duration)) {
            this.day = day;
            this.hour = hour;
            this.duration = duration;
        } else throw new IllegalArgumentException();
    }

    private boolean isValidDay(int day) {
        return true;
    }

    private boolean isValidHour(int hour) {
        return true;
    }

    private boolean isValidDuration(int duration) {
        return true;
    }

    public String toString() {
        return "["+day+","+hour+","+duration+"]";
    }
}
