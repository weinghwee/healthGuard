package um.healthguard.healthguard_nov;

public class Article {

    private int id;
    private String title;
    private String shortdesc;
    private double rating;
    int image;
    private String details;

    public Article(int id, String title, String shortdesc, double rating, int image, String details) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.image = image;
        this.details = details;
    }

    public int getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {

        return rating;
    }

    public int getImage() {

        return image;
    }

    public String getDetails() {
        return details;
    }
}
