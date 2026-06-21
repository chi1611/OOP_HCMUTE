package assignment;

import java.util.List;

public class LibraryManager {

    public void processAllBorrowable(
            List<Borrowable> items) {

        System.out.println("---BORROWABLE ITEMS---");

        for(Borrowable item : items) {

            System.out.println(
                    item.getTitle()
                    + " | Available: "
                    + item.isAvailable());
        }
    }

    public void notifyAll(
            List<Notifiable> users,
            String message) {

        for(Notifiable user : users) {
            user.sendNotification(message);
        }
    }
}