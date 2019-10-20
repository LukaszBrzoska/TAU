package pl.pjwstk.tau;

import java.util.Objects;

public class Meal {

    private int id;
    private String mealName;
    private double price;


    public Meal() {
    }

    public Meal(int id, String mealName, double price) {
        this.id = id;
        this.mealName = mealName;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return id == meal.id &&
                Double.compare(meal.price, price) == 0 &&
                Objects.equals(mealName, meal.mealName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mealName, price);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", mealName='" + mealName + '\'' +
                ", price=" + price +
                '}';
    }
}