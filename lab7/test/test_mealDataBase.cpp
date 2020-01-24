#include <iostream>

#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "mealDataBase.hpp"

TEST_CASE("check if a method exists")
{
	MealDataBaseHelper database = MealDataBaseHelper();

	REQUIRE_NOTHROW(database.getAll());
}

TEST_CASE("Test method getAll()")
{
	MealDataBaseHelper database = MealDataBaseHelper();

	SECTION("new class should be empty") {
		REQUIRE(database.getAll().empty());
	}

	SECTION("when map is not empty should return object")
	{
		Meal meal = Meal("Burger", 10);
		std::map<int, Meal>* mapExample = &database.getReferenceToMap();
		mapExample->insert(std::pair<int, Meal>(1, meal));

		REQUIRE(database.getAll().size() == 1);
		REQUIRE(database.getAll()[0].id == 0);
		REQUIRE(database.getAll()[0].name == "Burger");
		REQUIRE(database.getAll()[0].price == 10);
	}
}

TEST_CASE("check if createMeal method exists") {
	MealDataBaseHelper database = MealDataBaseHelper();
	Meal meal = Meal("Burger", 10);

	REQUIRE_NOTHROW(database.createMeal(meal)); // meal.id = 1
	
}

TEST_CASE("createMeal method test"){
	MealDataBaseHelper database = MealDataBaseHelper();
	Meal meal = Meal("Burger", 10);

	SECTION("should return created meal") {

		auto createdMeal = database.createMeal(meal);  //meal.id = 2 
		REQUIRE(createdMeal.price == 10);
		REQUIRE(createdMeal.name == "Burger");
	}

	SECTION("should assing id to meal") {
		auto createdMeal = database.createMeal(meal);  //meal.id = 3
		REQUIRE(createdMeal.id == 3);
	}

	SECTION("should contains 3 elements in map") {
		database.createMeal(meal);						//meal.id = 4
		database.createMeal(meal);						//meal.id = 5
		database.createMeal(meal);						//meal.id = 6
		
		auto size = database.getReferenceToMap().size();

		REQUIRE(size == 3);
	}
}

TEST_CASE("findMeal Method Test") {
	MealDataBaseHelper database = MealDataBaseHelper();
	Meal meal = Meal("Burger", 10);	

	SECTION("should throw exception when Meal with given id dont exist")
	{
		REQUIRE_THROWS(database.findMeal(10));
	}

	SECTION("should find object by given id")
	{
		Meal mealToInsert = Meal("Fries", 5);
		database.createMeal(mealToInsert);				//meal.id = 7

		REQUIRE(database.findMeal(7).id == 7);
		REQUIRE(database.findMeal(7).name == "Fries");
		REQUIRE(database.findMeal(7).price == 5);
	}
}

TEST_CASE("deleteMeal Method Test") {
	
	SECTION("should remove card by given id")
	{
		MealDataBaseHelper database = MealDataBaseHelper();
		Meal meal = Meal("chicken", 15);
		database.createMeal(meal);								//meal.id = 8
		
		REQUIRE(database.findMeal(8).id == 8);

		database.deleteMeal(8);

		REQUIRE(database.getAll().empty());
	}

	SECTION("should throw exception when try delete no exist meal")
	{
		MealDataBaseHelper database = MealDataBaseHelper();
		REQUIRE_THROWS(database.deleteMeal(15));
	}
}

SCENARIO("deleted data from database", "[mealDataBase][bdd][deleteMeal]") {

	GIVEN("meals with id 1 and 2") {
		MealDataBaseHelper database = MealDataBaseHelper();
		Meal meal = Meal("burger", 10);
		meal.id = 1;

		Meal meal2 = Meal("Fries", 15);
		meal2.id = 2;

		std::map<int, Meal>* maps = &database.getReferenceToMap();
		maps->insert(std::pair<int, Meal>(meal.id, meal));
		maps->insert(std::pair<int, Meal>(meal2.id, meal2));

		REQUIRE(maps->size() == 2);


		WHEN("delete meal with id 1") {
			database.deleteMeal(1);

			THEN("DataBase size is equals 1") {
				REQUIRE(database.getAll().size() == 1);
			}

			THEN("Meal with id 2 still is in database") {
				REQUIRE(database.findMeal(2).name == "Fries");
			}
		}
	}
}

