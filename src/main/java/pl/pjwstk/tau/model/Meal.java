package pl.pjwstk.tau.model;

import java.time.LocalDateTime;

public class Meal {

    private Long id;
    private String mealName;
    private double price;
    private MealDateTime creationTime;
    private MealDateTime updatedTime;
    private MealDateTime lastReadTime;
    private boolean saveTime;


    public Meal() {
    }

    public Meal(long id, String mealName) {
        this.id = id;
        this.mealName = mealName;
        this.saveTime = true;
    }

    public Meal(long id, String mealName, double price) {
        this.id = id;
        this.mealName = mealName;
        this.price = price;
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

    public MealDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(MealDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public MealDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(MealDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public MealDateTime getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(MealDateTime lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public boolean isSaveTime() {
        return saveTime;
    }

    public void setSaveTime(boolean saveTime) {
        this.saveTime = saveTime;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", mealName='" + mealName + '\'' +
                ", price=" + price +
                ", creationTime=" + creationTime +
                ", updatedTime=" + updatedTime +
                ", lastReadTime=" + lastReadTime +
                ", saveTime=" + saveTime +
                '}';
    }
}