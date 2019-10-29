package pl.pjwstk.tau.model;

import java.time.LocalDateTime;

public class MealTimeDTO {
    private LocalDateTime creationTime;
    private LocalDateTime updatedTime;
    private LocalDateTime lastReadTime;

    public MealTimeDTO() {
    }

    public MealTimeDTO(LocalDateTime creationTime, LocalDateTime updatedTime, LocalDateTime lastReadTime) {
        this.creationTime = creationTime;
        this.updatedTime = updatedTime;
        this.lastReadTime = lastReadTime;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public LocalDateTime getLastReadTime() {
        return lastReadTime;
    }

    public MealTimeDTO create(Meal meal) {
        return new MealTimeDTO(meal.getCreationTime(), meal.getUpdatedTime(), meal.getLastReadTime());
    }
}
