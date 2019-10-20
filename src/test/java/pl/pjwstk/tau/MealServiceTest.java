package pl.pjwstk.tau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasValue;
import static org.junit.jupiter.api.Assertions.*;

class MealServiceTest {

    private MealService mealService = new MealService();

    @BeforeEach
    void cleanUp() {
        mealService.getAllMeals().clear();
    }

    @Test
    void mealServiceShouldBeImplemented() {
        assertNotNull(new MealServiceTest());
    }

    @Test
    void shouldBeAbleToCreateSingeMealTest() {
        Meal meal = new Meal(1, "Burger", 15);
        assertThat(meal.getId(), is(1));
        assertThat(meal.getMealName(), is("Burger"));
        assertThat(meal.getPrice(), is(15.0));
    }

    @Test
    void shouldBeAbleToAddMealToMealService() {
        //given
        Meal meal = new Meal(1, "Pizza", 10.0);
        //when
        mealService.addMeal(meal);
        //then
        assertThat(mealService.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToFindMealById() {
        //given
        Meal meal = new Meal(1, "Pizza", 10.0);
        mealService.addMeal(meal);
        //when
        List<Meal> result = mealService.getMealById(1);
        //then
        assertThat(result.size(), is(1));
    }

    @Test
    void shouldBeAbleToFindMealByName() {
        //given
        Meal meal = new Meal(1, "Pizza", 10.0);
        mealService.addMeal(meal);
        //when
        List<Meal> result = mealService.getMealByName("Pizza");
        //then
        assertThat(result.size(), is(1));
    }

    @Test
    void shouldBeAbleToFindMealByPrice() {
        //given
        Meal meal = new Meal(1, "Pizza", 10);
        mealService.addMeal(meal);

        //when
        List<Meal> results = mealService.getMealByPrice(10);

        //then
        assertThat(results.size(), is(1));
    }

    @Test
    void shouldBeAbleToGetAllMeals() {
        //given
        Meal meal1 = new Meal(1, "Pizza", 10);
        Meal meal2 = new Meal(2, "Burger", 20);
        mealService.addMeal(meal1);
        mealService.addMeal(meal2);
        //when
        List<Meal> result = mealService.getAllMeals();
        //then
        assertThat(result.size(), is(2));
    }

    @Test
    void shouldBeThrownExceptionWhenTryGetNoExistMeal(){
        //given
        Meal meal = new Meal(1,"Pizza", 10);
        //when
        mealService.addMeal(meal);
        //then
        assertThrows(IllegalArgumentException.class, () -> mealService.getMealById(2));
    }

    @Test
    void shouldBeAbelToRemoveMealFromMealService(){
        //given
        Meal meal = new Meal(1,"Pizza", 10);
        mealService.addMeal(meal);
        //when
        mealService.delete(meal);
        //then
        assertThat(mealService.getAllMeals(), not(contains(meal)));
    }

    @Test
    void shouldBeAbleToUpdateMealName(){
        //given
        Meal meal = new Meal(1,"Pizza",10);
        mealService.addMeal(meal);
        //when
        mealService.updateMealName(1,"burger");
        //then
        assertThat(meal.getMealName(), is("burger"));
    }


}