package ma.youcode.clicktrack.model;

public class Lien {
    private final long id;
    private final String offre;
    private final String urlDestination;
    private final long clicks;
    private final long publisherId;

    public Lien(long id, String offre, String urlDestination,
                long clicks, long publisherId) {
        this.id = id;
        this.offre = offre;
        this.urlDestination = urlDestination;
        this.clicks = clicks;
        this.publisherId = publisherId;
    }
    public long getId() { 
        return id; }
    public String getOffre() { 
        return offre; }
    public String getUrlDestination() { 
        return urlDestination; }
    public long getClicks() { 
        return clicks; }
    public long getPublisherId() { 
        return publisherId; }
}