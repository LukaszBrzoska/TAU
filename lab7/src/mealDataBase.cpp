#include "mealDataBase.hpp"
#include <algorithm>
#include <utility>
#include <stdexcept>
#include <iostream>

using namespace std;

MealDataBase::MealDataBase() = default;

vector<Meal> MealDataBase::getAll() {
	vector<Meal> meals;

	for (auto& e : map) {
		meals.push_back(e.second);
	}
	return meals;
}

Meal MealDataBase::createMeal(Meal meal) {
	meal.id = id();
	map.insert(std::pair<int, Meal>(meal.id, meal));	
	return  map[meal.id] ;		
	
}

Meal MealDataBase::findMeal(long id)
{
	std::map<int, Meal>::iterator it;
	it = map.find(id);

	if (it == map.end()) {
		throw invalid_argument("not found");
	}

	return map.find(id)->second;
}

void MealDataBase::deleteMeal(long id)
{
	std::map<int, Meal>::iterator it;
	it = map.find(id);
	if ( it == map.end())
	{
		throw invalid_argument("not found");
	}
	else {
		map.erase(id);
	}	
}

unsigned long long int MealDataBase::id()
{
	static unsigned long long int i = 0;
	return ++i;
}

Meal::Meal() = default;

Meal::Meal(string name, int price) : name(move(name)), price(price)
{
}

MealDataBaseHelper::MealDataBaseHelper() : MealDataBase()
{
}

map<int, Meal>& MealDataBaseHelper::getReferenceToMap()
{
	return map;
}


