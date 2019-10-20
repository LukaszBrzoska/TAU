package pl.pjwstk.tau;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.junit.jupiter.api.Assertions.*;

class MealRepositoryTest {

    private MealRepository mealRepository = new MealRepository();

    @Test
    void orderTestIsImplementedTest(){
        assertNotNull(new MealRepositoryTest());
    }

    @Test
    void createSingeOrderTest(){
        Meal meal = new Meal(1,"Burger",15);
        assertThat(meal.getId(), is(1));
        assertThat(meal.getMealName(), is("Burger"));
        assertThat(meal.getPrice(), is(15.0));
    }

    @Test
    void shouldBeAbleToAddMealToRepository(){
        //given
        Meal meal = new Meal(1,"Pizza",10.0);
        //when
        mealRepository.addMeal(meal);
        //then
        assertThat(mealRepository.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToFindMealById(){
        //given
        Meal meal1 = new Meal(1,"Pizza",10.0);
        Meal meal2 = new Meal(2,"Burger",15.0);
        //when
        List<Meal> result = mealRepository.getMealById(1;
    }

}