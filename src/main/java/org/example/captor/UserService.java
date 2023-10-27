package org.example.captor;

public class UserService {
    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message, String username) {
        User user = new User(username, username + "@example.com");
        notificationService.sendNotification(message, user);
    }
}
