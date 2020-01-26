package pl.pjwstk.tau.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjwstk.tau.model.Meal;
import pl.pjwstk.tau.model.MealDateTime;
import pl.pjwstk.tau.repository.MealListRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MealListServiceTest {

    private MealDateTimeService mealDateTimeService = new MealDateTimeService();
    private MealListRepository repository = MealListRepository.getInstance();
    private MealListService mealListService = new MealListService(mealDateTimeService);

    private static final LocalDateTime TIME = LocalDateTime.of(2019,1,1,1,1,1);

    @Mock
    private MealDateTimeService mealDateTimeMockService;



    @BeforeEach
    public void initializeList() {
        repository.collectionAccess().add(new Meal(1, "Hamburger"));
        repository.collectionAccess().add(new Meal(2, "Pizza"));
        repository.collectionAccess().add(new Meal(3, "Fries"));
        repository.collectionAccess().add(new Meal(4, "Cheeseburger"));

    }

    @AfterEach
    public void clear() {
        repository.setMeals(new ArrayList<>());
    }

    @Test
    void addMealToList() {
        //given
        int countBeforeAdd = repository.collectionAccess().size();
        Meal meal = new Meal(5, "Chicken Burger");
        //when

        mealListService.addMeal(meal);
        //then
        assertThat(mealListService.getAllMeals().get(4), is(meal));
        assertThat(countBeforeAdd, is(not(repository.collectionAccess().size())));
    }

    @Test
    void getMealById() {
        //given
        //when
        Meal meal = mealListService.getMealById(1);
        //then
        assertThat(meal.getMealName(), is("Hamburger"));

    }

    @Test
    void getMealByName(){
        //given
        //when
        //then
        assertThat(mealListService.getMealByName("burger"), hasSize(2));
    }

    @Test
    void getMealByNoExistIdShouldThrowNoSuchElementException() {
        //given
        //when
        //then
        assertThrows(NoSuchElementException.class, () -> mealListService.getMealById(10));
    }

    @Test
    void getAllMeals() {
        //given
        //when
        List<Meal> meals = mealListService.getAllMeals();
        //then
        assertThat(meals.size(), is(4));

    }

    @Test
    void deleteMealById() {
        //given
        Meal meal = new Meal(5, "Onion Rings");
        //when
        mealListService.addMeal(meal);
        mealListService.deleteMealById(5);
        //then
        assertThat(mealListService.getAllMeals(), hasSize(4));
    }

    @Test
    void deleteMealByNoExistIdShouldFail() {
        //given
        //when
        //then
        assertFalse(mealListService.deleteMealById(21));
    }

    @Test
    void updateMeal() {
        //given
        Meal meal = new Meal(10, "Onion Rings");
        meal.setPrice(8.50);
        //when
        mealListService.updateMeal(1, meal);
        //then
        assertThat(mealListService.getMealById(1).getMealName(), is("Onion Rings"));
        assertThat(mealListService.getMealById(1).getPrice(), is(8.50));

    }


    @Test
    void updateMealShouldThrowNoSuchElementException() {
        //given
        Meal meal = new Meal(10, "Onion Rings");
        meal.setPrice(12.50);

        //when
        //then
        assertThrows(NoSuchElementException.class, () -> mealListService.updateMeal(35, meal));

    }

        // MOCKI
    @Test
    void dateShouldBeAddedWhenAddNewMeal() {
        //given
        Meal meal = new Meal(99, "Onion Rings");
        LocalDateTime localDateTime = LocalDateTime.now();
        MealListService mealListService2 = new MealListService(mealDateTimeMockService);
        //when
        when(mealDateTimeMockService.createMealDateTime()).thenReturn(localDateTime);
        mealListService2.addMeal(meal);
        //then
        assertThat(mealListService2.getMealById(99).getCreationTime().getLocalDateTime(), equalTo(localDateTime));

    }

    @Test
    void dateShouldBeUpdateWhenUpdatingMeal() {
        //given
        Meal meal = new Meal(30, "Onion Rings");
        LocalDateTime localDateTime = LocalDateTime.now();
        MealListService mealListService2 = new MealListService(mealDateTimeMockService);
        //when
        when(mealDateTimeMockService.createMealDateTime()).thenReturn(localDateTime);
        mealListService2.updateMeal(1, meal);
        //then
        assertThat(mealListService2.getMealById(1).getUpdatedTime().getLocalDateTime(), is(localDateTime));
    }
    @Test
    void dateShouldBeUpdateWhenGetMealById() {
        //given
        Meal meal = new Meal(10, "MealWithNoDataValues");
        LocalDateTime localDateTime = LocalDateTime.now();
        MealListService mealListService2 = new MealListService(mealDateTimeMockService);
        //when
        when(mealDateTimeMockService.createMealDateTime()).thenReturn(localDateTime);
        mealListService2.getMealById(1);
        //then
        assertThat(mealListService2.getMealById(1).getLastReadTime().getLocalDateTime(), is(not(meal.getLastReadTime().getLocalDateTime())));
        assertThat(mealListService2.getMealById(1).getLastReadTime().getLocalDateTime(), is(localDateTime));
    }

    @Test
    void dataShouldBeNullWhenCreationTimeIsNotActive() {
        //given
        Meal meal = new Meal(99, "Onion Rings");
        LocalDateTime localDateTime = LocalDateTime.now();
        meal.getCreationTime().setActive(false);
        MealListService mealListService2 = new MealListService(mealDateTimeMockService);
        //when
        when(mealDateTimeMockService.createMealDateTime()).thenReturn(localDateTime);
        mealListService2.addMeal(meal);
        //then
        assertNull(mealListService2.getMealById(99).getCreationTime().getLocalDateTime());

    }

    @Test
    void dataShouldBeNullWhenUpdateTimeIsNotActive() {
        //given
        Meal meal = new Meal(99, "Onion Rings");
        LocalDateTime localDateTime = LocalDateTime.now();
        meal.getUpdatedTime().setActive(false);
        MealListService mealListService2 = new MealListService(mealDateTimeMockService);
        //when
        when(mealDateTimeMockService.createMealDateTime()).thenReturn(localDateTime);
        mealListService2.updateMeal(1, meal);
        //then
        assertNull(mealListService2.getMealById(1).getUpdatedTime().getLocalDateTime());

    }


}