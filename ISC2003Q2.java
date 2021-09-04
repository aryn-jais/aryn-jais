import java.util.Scanner;

public class ISC2003Q2 {
    public static void main(String[] args) {
        int hr, min;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter the hour");
            hr = sc.nextInt();
            if (hr < 1 || hr > 12)
                System.out.println("Invalid time entered, try again.");
        } while (hr < 1 || hr > 12);
        do {
            System.out.println("Enter the minute");
            min = sc.nextInt();
            if (min < 0 || min > 59)
                System.out.println("Invalid time entered, try again.");
        } while (min < 0 || min > 59);
        Time obj = new Time(hr, min);
        obj.getTime();
        sc.close();
    }
}

class Time {
    // instance variables defined here
    private int hour;
    private int minute;
    private String[] minute_past = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty" };
    private String[] Minute = { "Quarter past", "Half past", "Quarter to" };
    private String[] Hour = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve" };

    // extracts statement to be printed for hour
    private String hour_Statement(int hr, int min) {
        String str;
        if (min <= 30)
            str = " " + Hour[hr - 1];
        else {
            if (hr == 12)
                str = " One";
            else
                str = "" + Hour[hr];
        }
        return str;
    }

    // extracts statement to be printed for minutes
    private String minute_statement(int min) {
        String str = "";
        if (min <= 30) {
            if (min == 15)
                str = Minute[0];
            else if (min == 30)
                str = Minute[1];
            else if (min <= 20)
                str = min < 2 ? minute_past[min - 1] + " Minute Past" : minute_past[min - 1] + " Minutes Past";
            else if (min > 20)
                str = "Twenty " + minute_past[min % 10 - 1] + " Minutes Past";
        } else {
            int temporary = 60 - min;
            if (min == 45)
                str = Minute[2];
            else if (min >= 40)
                str = temporary < 2 ? minute_past[temporary - 1] + " Minute To" : minute_past[temporary - 1] + " Minutes To";
            else if (min < 40)
                str = "Twenty " + minute_past[temporary % 10 - 1] + " Minutes To";
        }
        return str;
    }

    Time(int hr, int min) {
        hour = hr;
        minute = min;
    }

    // the display function
    public void getTime() {
        System.out.println("OUTPUT:");
        if (minute < 10)
            System.out.println("TIME: " + hour + ":0" + minute);
        else
            System.out.println("TIME: " + hour + ":" + minute);
        if (minute == 0)
            System.out.println(hour_Statement(hour, minute) + " O'Clock");
        else
            System.out.println(minute_statement(minute) + " " + hour_Statement(hour, minute));
    }
}