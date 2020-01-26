package pl.pjwstk.tau.repository;

import pl.pjwstk.tau.model.Meal;
import pl.pjwstk.tau.model.MealDateTime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MealListRepository {

    private static MealListRepository instance = new MealListRepository();

    private MealListRepository() {
    }

    public static MealListRepository getInstance() {
        return instance;
    }

    private List<Meal> meals = new ArrayList<>();

    public List<Meal> collectionAccess() {
        meals
                .forEach(meal -> meal.setLastReadTime(new MealDateTime()));
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Optional<Meal> getMealById(Long id) {
        return meals.stream()
                .filter(meal -> meal.getId().equals(id))
                .findFirst();
    }

    public boolean isExistInRepositoryById(final Long id) {
        return meals.stream().anyMatch(meal -> meal.getId().equals(id));
    }
}
