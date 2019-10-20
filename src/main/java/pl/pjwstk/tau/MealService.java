package pl.pjwstk.tau;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MealService {

    private List<Meal> meals = new ArrayList<>();


    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }

    public List<Meal> getAllMeals() {
        return meals;
    }

    public void delete(Meal meal) {
        meals.remove(meal);
    }

    public List<Meal> getMealById(int id) {
        for (Meal meal : meals) {
            if (meal.getId() == id)
                return meals.stream()
                        .filter(meal1 -> meal.getId() == id)
                        .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("No find that id");
    }

    public List<Meal> getMealByName(String mealName) {
        return meals.stream()
                .filter(meal -> meal.getMealName() == mealName)
                .collect(Collectors.toList());
    }

    public List<Meal> getMealByPrice(double price) {
        return meals.stream()
                .filter(meal -> meal.getPrice() == price)
                .collect(Collectors.toList());
    }

    public List<Meal> updateMealName(int id, String mealName) {
        for (Meal meal : meals) {
            if (meal.getId() == id) {
                meal.setMealName(mealName);
                return meals.stream()
                        .filter(meal1 -> meal.getId() == id)
                        .collect(Collectors.toList());
            }
        }
        throw new NoSuchElementException("No meal with that id");
    }

    public List<Meal> updateMeal(int id, String mealName, double price) {
        for (Meal meal : meals) {
            if (meal.getId() == id) {
                meal.setMealName(mealName);
                meal.setPrice(price);
                return meals.stream()
                        .filter(meal1 -> meal.getId() == id)
                        .collect(Collectors.toList());
            }
        }
        throw new IllegalArgumentException("No meal to update with that id");
    }
}
