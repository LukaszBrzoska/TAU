package pl.pjwstk.tau;

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

}