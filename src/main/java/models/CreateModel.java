package models;

public class CreateModel {

    private int id;
    private String name;
    private String job;
    private String createdAt;

    public CreateModel() {
    }

    public CreateModel(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public CreateModel(int id, String createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public CreateModel(int id, String name, String job, String createdAt) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
