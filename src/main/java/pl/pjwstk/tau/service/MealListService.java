package pl.pjwstk.tau.service;

import pl.pjwstk.tau.model.Meal;
import pl.pjwstk.tau.repository.MealListRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MealListService {

    public MealListService() {
    }

    public boolean addMeal(Meal meal) {
        if (meal == null) throw new IllegalArgumentException("Object is null");
            if (meal.isSaveTime()){
        MealListRepository.getInstance().collectionAccess().add(meal);
        meal.setCreationTime(LocalDateTime.now());}
            MealListRepository.getInstance().collectionAccess().add(meal);
        return true;
    }

    public Meal getMealById(long id) {
        if (MealListRepository.getInstance().isExistInRepositoryById(id)) {

            Optional<Meal> optionalMeal = MealListRepository.getInstance().getMealById(id);
            if (optionalMeal.isPresent()) {
                Meal meal = optionalMeal.get();
                if (meal.isSaveTime()) {
                    meal.setLastReadTime(LocalDateTime.now());
                }
                return meal;
            }
        }
        throw new NoSuchElementException("Element with this id doesn't exist");
    }

    public List<Meal> getAllMeals(){
        return new ArrayList<>(MealListRepository.getInstance().collectionAccess());
    }

    public boolean deleteMealById(long id){
        if (MealListRepository.getInstance().isExistInRepositoryById(id)){
            MealListRepository.getInstance().collectionAccess().remove(getMealById(id));
            return true;
        }
        return false;
    }

    public Meal updateMeal(long id , Meal meal){
        if (MealListRepository.getInstance().isExistInRepositoryById(id)){
            Meal mealToUpdate = getMealById(id);

            mealToUpdate.setMealName(meal.getMealName());
            mealToUpdate.setPrice(meal.getPrice());
            mealToUpdate.setSaveTime(meal.isSaveTime());

            if (meal.isSaveTime()){
                mealToUpdate.setUpdatedTime(LocalDateTime.now());
                mealToUpdate.setLastReadTime(LocalDateTime.now());
            }
            MealListRepository.getInstance().collectionAccess().remove(getMealById(id));
            MealListRepository.getInstance().collectionAccess().add(mealToUpdate);

            return mealToUpdate;
        }
        throw new NoSuchElementException("Element with this id doesn't exist");
    }

}
