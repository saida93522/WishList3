import java.util.Date;


public class Place implements Comparable <Place> {
    //Place object Fields
    // private means other classes cant access them
    private String name;
    private String reason;
    private Date created;


    /////Public constructor,responsible for initialize created new objects
    public Place(String name, String reason) {
        this.name = name;
        this.reason = reason;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreated() {
        Date datecreated = new Date();

        ///create the date


        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String toString() {
//        return String.format(" Place to visit: %s. Reason: %s . Date created:  %s",
//                name,reason,created);
//
        // Thu Oct 03 10:37:02 CDT 2019

        return String.format(" Place to visit: %s. Reason: %s . Date created:  %s",
                name, reason, created);

    }

    public int compareTo(Place otherPlace) {
        return name.compareToIgnoreCase(otherPlace.getName());
    }
}

