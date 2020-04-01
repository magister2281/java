package it.hillel.superqajobsearch.pages;

public class Job {
    private String title;
    private String company;
    private String city;
    private String description;
    private String date;
    private String link;

    public Job(String title,String company,String description,String date,String link) {
        this.title = title;
        this.company = company;
        this.description = description;
        this.date = date;
        this.link = link;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
