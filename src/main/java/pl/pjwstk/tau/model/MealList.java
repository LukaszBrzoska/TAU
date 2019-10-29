package pl.pjwstk.tau.model;


import java.util.List;


public class MealList {
    private Long id;
    private List<Meal> meals;


    public MealList() {
    }

    public MealList(long id, List<Meal> meals) {
        this.id = id;
        this.meals = meals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
