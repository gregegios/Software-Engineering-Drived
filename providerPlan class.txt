import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProviderPlan {
    private List<String> days;
    private List<String> availableTimes;
    private String providerID;

    public ProviderPlan() {
        days = new ArrayList<>();
        availableTimes = new ArrayList<>();
        providerID = "";
    }

    public void setDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day to set availability:");
        String day = scanner.nextLine();
        days.add(day);
    }

    public void updateDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day you want to update availability:");
        String day = scanner.nextLine();

        if (days.contains(day)) {
            System.out.println("Enter the new available time:");
            String availableTime = scanner.nextLine();
            availableTimes.add(availableTime);
            System.out.println("Availability updated successfully!");
        } else {
            System.out.println("Day not found in the schedule. Please set the date first.");
        }
    }