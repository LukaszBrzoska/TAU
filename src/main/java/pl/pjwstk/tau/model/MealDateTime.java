package pl.pjwstk.tau.model;

import java.time.LocalDateTime;

public class MealDateTime {

    private LocalDateTime localDateTime;
    private boolean IsActive;

    public MealDateTime() {
        IsActive = true;
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }
}
