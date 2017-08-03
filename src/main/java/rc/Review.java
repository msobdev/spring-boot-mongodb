package rc;

/**
 * Created by sob1 on 03.08.2017.
 */
public class Review {
    private String userName;
    private int rating;
    private Boolean approved;

    protected Review(){

    }

    public Review(String userName, int rating, Boolean approved) {
        this.userName = userName;
        this.rating = rating;
        this.approved = approved;
    }

    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }

    public Boolean getApproved() {
        return approved;
    }
}
