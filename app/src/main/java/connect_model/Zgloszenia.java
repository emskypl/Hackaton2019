package connect_model;

public class Zgloszenia {



    public Zgloszenia(int idNotification, String notificationName, int notificationType, String description, double localization, int idStatus, String statusDescription, double score, String notificationTime) {
        this.idNotification = idNotification;
        this.notificationName = notificationName;
        this.notificationType = notificationType;
        this.description = description;
        this.localization = localization;
        this.idStatus = idStatus;
        this.statusDescription = statusDescription;
        this.score = score;
        this.notificationTime = notificationTime;
    }

    private int idNotification;
    private String notificationName;
    private int notificationType;
    private String description;
    private double localization;
    private int idStatus;
    private String statusDescription;
    private double score;
    private String notificationTime;



    public int getIdNotification() { return idNotification; }

    public String getNotificationName() { return notificationName; }

    public int getNotificationType() { return notificationType; }

    public String getDescription() { return description; }

    public double getLocalization() { return localization; }

    public int getIdStatus() { return idStatus; }

    public String getStatusdescription() { return statusDescription; }

    public double getScore() { return score; }

    public String getNotificationTime() { return notificationTime; }


}
