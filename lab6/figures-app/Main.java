import java.util.*;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        if (args.length == 3 && isTraingle(args)) {
            if (isEquilateralTriangle(args)) {
                System.out.println("Trojkąt rownoboczny");
            } else if (isIsoscelesTriangle(args)) {
                System.out.println("Trojkat rownoramienny");
            } else {
                System.out.println("Trojkat roznoramienny");
            }
        } else if (args.length == 4 && isQuadrangle(args)) {
            if (isSquare(args)) {
                System.out.println("Kwadrat");
            } else if (isRectangle(args)) {
                System.out.println("Prostokąt");
            } else {
                System.out.println("Czworobok");
            }
        } else {
            System.out.println("nierozpoznano");
        }
    }


    private static boolean isTraingle(String[] args) {
        List<Integer> integers = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toList());

        int a = integers.get(0);
        int b = integers.get(1);
        int c = integers.get(2);

        if (a + b > c || a + c > b || b + c > a)
            return true;
        return false;
    }

    private static boolean isEquilateralTriangle(String[] args) {
        List<Integer> integers = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toList());

        int a = integers.get(0);
        int b = integers.get(1);
        int c = integers.get(2);

        if (a == b & b == c)
            return true;
        return false;
    }

    private static boolean isIsoscelesTriangle(String[] args) {
        List<Integer> integers = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toList());

        int a = integers.get(0);
        int b = integers.get(1);
        int c = integers.get(2);

        if (a == b || a == c || b == c)
            return true;
        return false;
    }

    private static boolean isQuadrangle(String[] args) {
        List<Integer> integers = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toList());

        int longest = Collections.max(integers);
        int sum = integers.stream().mapToInt(Integer::intValue).sum() - longest;

        return longest < sum;
    }

    private static boolean isRectangle(String[] args) {
        Set<Integer> integers = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toSet());

        if (integers.size() == 2)
            return true;
        return false;

    }

    private static boolean isSquare(String[] args) {
        Set<Integer> integers = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toSet());

        if (integers.size() == 1)
            return true;
        return false;
    }
}