package bdd.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import pl.pjwstk.tau.model.Meal;
import pl.pjwstk.tau.repository.MealListRepository;
import pl.pjwstk.tau.service.MealListService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class MealStepsTest extends Steps {

    private MealListService mealListService = new MealListService();
    private MealListRepository mealListRepository = MealListRepository.getInstance();

    private List<Meal> meals = new ArrayList<>();
    private boolean isDeleted;

    @Given("initialize meals list")
    public void initMealsList() {
        mealListRepository.collectionAccess().add(new Meal(1, "burger"));
        mealListRepository.collectionAccess().add(new Meal(2, "cheeseburger"));
        mealListRepository.collectionAccess().add(new Meal(3, "fries"));
    }

    @When("user wanna meals with $mealName in name")
    public void getMealByName(String mealName) {
        meals = mealListService.getMealByName(mealName);
    }

    @Then("user get all meals with $mealName in name")
    public void getAllMealsWithMealName(String mealName) {
        assertThat(meals.size(), is(2));
        assertThat(meals.get(1).getMealName(), containsString(mealName));
    }

    @Given("initialize meals list")
    public void initMealsList2() {
        mealListRepository.collectionAccess().add(new Meal(1, "burger", 10));
        mealListRepository.collectionAccess().add(new Meal(2, "cheeseburger", 12));
        mealListRepository.collectionAccess().add(new Meal(3, "fries", 15));
    }

    @When("user wanna meals with $price ")
    public void getMealByName(int price) {
        meals = mealListService.getMealByPrice(price);
    }

    @Then("user get all meals with $price in name")
    public void getMealsByPrice(double price) {
        assertThat(meals.get(1).getPrice(), is(10));
        assertThat(meals.get(1).getMealName(), is("burger"));
    }

    @Given("add meals to list")
    public void addMealsToList() {
        mealListRepository.collectionAccess().add(new Meal(1, "burger"));
        mealListRepository.collectionAccess().add(new Meal(2, "cheeseburger"));
        mealListRepository.collectionAccess().add(new Meal(3, "fries"));
    }

    @When("user wanna delete meals with $mealName")
    public void deleteMealsWhenContainsBurgerInName(String mealName) {
        isDeleted = mealListService.deleteMealByName(mealName);
    }

    @Then("user remove all meals contains $mealName")
    public void mealsContainsMealNameAreDeleted(String mealName) {
        assertThat(isDeleted, is(true));
        assertThat(meals.size(), equalTo(2));
    }

}
