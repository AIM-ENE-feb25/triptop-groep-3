package nl.han.se.bewd;

public class DatabaseService {
    public void saveServiceRequest(String userId, String serviceId, String status) {
        System.out.println("Saving service request for user " + userId + " with status " + status);
    }

    public void getUserSession(String userId) {
        System.out.println("Fetching user session for " + userId);
    }

    public void updateServiceStatus(String requestId, String status) {
        System.out.println("Updating service status for request " + requestId + " to " + status);
    }
}
