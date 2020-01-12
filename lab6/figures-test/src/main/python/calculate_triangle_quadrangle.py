class GeometryCalculator:
    def __init__(self, first_side=None, second_side=None, third_side=None, fourth_side=None):
        self.first_side = first_side
        self.second_side = second_side
        self.third_side = third_side
        self.fourth_side = fourth_side

    def triangle_calculator(self):
        if (self.first_side + self.second_side > self.third_side) \
                or (self.first_side + self.third_side > self.second_side) \
                or (self.second_side + self.third_side > self.first_side):
            print("Given sides can create a triangle.")
        else:
            print("Given sides cant create a triangle.")
        if (self.first_side == self.second_side == self.third_side):
            print("Equilateral")
        elif (self.first_side == self.second_side or self.first_side == self.third_side or self.second_side == self.third_side):
            print("Isosceles")
        else:
            print("Scalene")

    def quadrangle_calculator(self):
        if max(self.first_side, self.second_side, self.third_side, self.fourth_side) \
                < (self.first_side + self.second_side + self.third_side + self.fourth_side -
                   max(self.first_side, self.second_side, self.third_side, self.fourth_side)):
            print("Given sides can create a quadrangle")
        else:
            print("Given sides cant create a quadrangle")
        if (self.first_side == self.second_side == self.third_side == self.fourth_side):
            print("Square")
        elif (self.first_side == self.third_side and self.second_side == self.fourth_side):
            print("Rectangle")
        else:
            print("Not a quadrangle")


if __name__ == '__main__':
    calculator = GeometryCalculator()

    try:
        print("Enter float value of sides:")
        a = float(input("First side:"))
        b = float(input("Second side:"))
        c = float(input("Third side:"))
        key = input("If you want to build a triangle, press T, if you want to build a quadrangle, press Q:")
        if key == 'T':
            GeometryCalculator(a, b, c).triangle_calculator()
        elif key == 'Q':
            d = float(input("Fourth side:"))
            GeometryCalculator(a, b, c, d).quadrangle_calculator()
        else:
            print("Something went wrong")
    except ValueError:
        print("You have to enter float value, try again.")
