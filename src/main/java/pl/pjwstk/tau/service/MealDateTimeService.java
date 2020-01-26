package pl.pjwstk.tau.service;


import pl.pjwstk.tau.model.MealDateTime;

import java.time.LocalDateTime;

public class MealDateTimeService {
        public LocalDateTime createMealDateTime() {
           return LocalDateTime.now();
        }

}
