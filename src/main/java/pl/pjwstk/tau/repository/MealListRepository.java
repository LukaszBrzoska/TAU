package pl.pjwstk.tau.repository;

import pl.pjwstk.tau.model.Meal;

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
                .stream()
                .filter(Meal::isSaveTime)
                .forEach(meal -> meal.setLastReadTime(LocalDateTime.now()));
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Optional<Meal> getMealById(Long id){
        return meals.stream()
                .filter(meal -> meal.getId().equals(id))
                .findFirst();
    }

    public boolean isExistInRepositoryById(final long id) {
        return meals.stream().anyMatch(meal -> meal.getId().equals(id));
    }
}