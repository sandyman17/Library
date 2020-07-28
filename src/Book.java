/**
 * @author Jacob Sandefur
 * @version 3/31/2020
 */
public class Book {
    private int id;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String publisher;
    private String publisherCity;
    private int publicationYear;
    private int numCheckouts;
    private double purchasePrice;
    private boolean currentlyLoaned;

    public Book(int id, String title, String authorFirstName, String authorLastName, String publisher,
                String publisherCity, int publicationYear, int numCheckouts, double purchasePrice,
                boolean currentlyLoaned) {
        this.id = id;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.publisher = publisher;
        this.publisherCity = publisherCity;
        this.publicationYear = publicationYear;
        this.numCheckouts = numCheckouts;
        this.purchasePrice = purchasePrice;
        this.currentlyLoaned = currentlyLoaned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumCheckouts() {
        return numCheckouts;
    }

    public void setNumCheckouts(int numCheckouts) {
        this.numCheckouts = numCheckouts;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public boolean isCurrentlyLoaned() {
        return currentlyLoaned;
    }

    public void setCurrentlyLoaned(boolean currentlyLoaned) {
        this.currentlyLoaned = currentlyLoaned;
    }

    public double averageLoanCost() {
        double avgLoanCost;
        avgLoanCost = this.purchasePrice/this.numCheckouts;
        return avgLoanCost;
    }
    public void editNumLoans() {
        numCheckouts++;
    }
}
