package dev.spacelearning.spacelearning;

import java.util.Date;

public class MesRevisions {

    // Attributs
    private String status;
    private String description;
    private Date date;

    // Constructeurs
    public MesRevisions() {
        this.status = "Not Started";
        this.description = "";
        this.date = null;
    }

    // Méthodes
    public void viewStatus() {
        System.out.println("Status: " + status);
    }

    public void viewDescription() {
        System.out.println("Description: " + description);
    }

    public void viewDate() {
        if (date != null) {
            System.out.println("Date: " + date.toString());
        } else {
            System.out.println("Date: Not set");
        }
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    public void updateDate(Date newDate) {
        this.date = newDate;
    }

    // Add getter methods for 'status', 'description', and 'date'
    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }
}
