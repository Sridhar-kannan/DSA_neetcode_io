package stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {

        
        ArrayList<ArrayList<Integer>> cars = new ArrayList<>();

        for (int i = 0; i < speed.length; i++) {
            cars.add(new ArrayList<>(
                    List.of(position[i], speed[i])));
        }

        cars.sort((o1, o2) -> o2.getFirst() - o1.getFirst());

        Stack<ArrayList<Integer>> stack = new Stack<>();

        for (ArrayList<Integer> car : cars) {
            if (stack.isEmpty()) {
                stack.push(car);
                continue;
            }

            // compare speeds
            ArrayList<Integer> topCar = stack.peek();

            // casting to float, else 1.33 becomes 1 and incorrect outputs.

            float topTime = (float)(target - topCar.getFirst()) / topCar.getLast();
            float currentTime = (float)(target - car.getFirst()) / car.getLast();

            if (topTime < currentTime) {
                stack.push(car);
            }
  

        }

        return stack.size();
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = { 10,8,0,5,3 };
        int[] speed = {2,4,1,1,3 };



        System.out.println(carFleet(target, position, speed));
    }
}

