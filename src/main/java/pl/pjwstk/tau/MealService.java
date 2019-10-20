package pl.pjwstk.tau;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MealRepository {

    private List<Meal> meals = new ArrayList<>();




    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }

    public List<Meal> getAllMeals(){
        return meals;
    }
    public void delete(Meal meal){
        meals.remove(meal);
    }

    public List<Meal> getMealById(int id) {
        if ()
    }
}
