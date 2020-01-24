#ifndef __MEAL_DATABASE__
#define __MEAL_DATABASE__


#include <map>
#include <vector>
#include <string>


class Meal
{
public:
	long id{};
	std::string  name;
	int price{};

	Meal();
	Meal(std::string name, int price);
};

class MealDataBase {
public: 
	MealDataBase();
	std::vector<Meal> getAll();
	Meal createMeal(Meal meal);
	Meal findMeal(long id);
	void deleteMeal(long id);
protected:
	std::map<int, Meal> map;
private:
	unsigned long long int id();
};

class MealDataBaseHelper : public MealDataBase
{
public:
	MealDataBaseHelper();

	std::map<int, Meal> &getReferenceToMap();
};

#endif 

