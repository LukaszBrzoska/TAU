package pl.pjwstk.tau.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Meal {

    private Long id;
    private String mealName;
    private double price;
    private LocalDateTime creationTime;
    private LocalDateTime updatedTime;
    private LocalDateTime lastReadTime;
    private boolean saveTime;


    public Meal() {
    }

    public Meal(long id, String mealName) {
        this.id = id;
        this.mealName = mealName;
        this.price = price;
      //  this.creationTime = LocalDateTime.now();
        this.saveTime = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public LocalDateTime getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(LocalDateTime lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public boolean isSaveTime() {
        return saveTime;
    }

    public void setSaveTime(boolean saveTime) {
        this.saveTime = saveTime;
    }
}