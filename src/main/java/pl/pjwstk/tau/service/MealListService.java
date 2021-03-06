package pl.pjwstk.tau.service;

import pl.pjwstk.tau.model.Meal;
import pl.pjwstk.tau.model.MealDateTime;
import pl.pjwstk.tau.model.MealList;
import pl.pjwstk.tau.repository.MealListRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class MealListService {

    public MealListService() {
    }



    private MealDateTimeService mealDateTimeService;

    public MealListService(MealDateTimeService mealDateTimeService) {
        this.mealDateTimeService = mealDateTimeService;
    }

    public boolean addMeal(Meal meal) {
        if (meal == null) throw new IllegalArgumentException("Object is null");

        MealListRepository.getInstance().collectionAccess().add(meal);
        if(meal.getCreationTime().isActive()) {
            meal.getCreationTime().setLocalDateTime(mealDateTimeService.createMealDateTime());
        }

        return true;
    }

    public Meal getMealById(long id) {
        if (MealListRepository.getInstance().isExistInRepositoryById(id)) {

            Optional<Meal> optionalMeal = MealListRepository.getInstance().getMealById(id);
            if (optionalMeal.isPresent()) {
                Meal meal = optionalMeal.get();

                if(meal.getLastReadTime().isActive()){
                    meal.getLastReadTime().setLocalDateTime(mealDateTimeService.createMealDateTime());
                }
                return meal;
            }
        }
        throw new NoSuchElementException("Element with this id doesn't exist");
    }

    public List<Meal> getAllMeals() {
        return new ArrayList<>(MealListRepository.getInstance().collectionAccess());
    }

    public boolean deleteMealById(long id) {
        if (MealListRepository.getInstance().isExistInRepositoryById(id)) {
            MealListRepository.getInstance().collectionAccess().remove(getMealById(id));
            return true;
        }
        return false;
    }

    public Meal updateMeal(long id, Meal meal) {
        if (MealListRepository.getInstance().isExistInRepositoryById(id)) {
            Meal mealToUpdate = getMealById(id);

            mealToUpdate.setMealName(meal.getMealName());
            mealToUpdate.setPrice(meal.getPrice());

            if(meal.getUpdatedTime().isActive()) {
                mealToUpdate.getUpdatedTime().setLocalDateTime(mealDateTimeService.createMealDateTime());
            }
            if(meal.getLastReadTime().isActive()) {
                mealToUpdate.getLastReadTime().setLocalDateTime(mealDateTimeService.createMealDateTime());
            }
            MealListRepository.getInstance().collectionAccess().remove(getMealById(id));
            MealListRepository.getInstance().collectionAccess().add(mealToUpdate);

            return mealToUpdate;
        }
        throw new NoSuchElementException("Element with this id doesn't exist");
    }

    public List<Meal> getMealByName(String mealName) {

        if (mealName == null) {
            throw new IllegalArgumentException("mealName cant be null");

        }
        return MealListRepository.getInstance().collectionAccess().stream()
                .filter(meal -> meal.getMealName().contains(mealName))
                .collect(Collectors.toList());
    }

    public List<Meal> getMealByPrice(double price) {
        return MealListRepository.getInstance().collectionAccess().stream()
                .filter(meal -> meal.getPrice() == price).collect(Collectors.toList());
    }

    public boolean deleteMealByName(String mealName) {
        if (mealName == null) {
            throw new IllegalArgumentException("mealName cant by null");
        }
        List<Meal> mealsToDelete = getMealByName(mealName);
        if (mealsToDelete.size() == 0) {
            return false;
        }
        mealsToDelete.forEach(m -> deleteMealById(m.getId()));
        return true;
    }
}