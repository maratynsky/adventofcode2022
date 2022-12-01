import java.util.List;
import java.util.stream.Stream;

public class Day1 extends Day {

    @Override
    protected long resolve(Stream<String> input) {
        List<String> calories = input.toList();

        long maxCalories = 0;
        long totalCaloriesCarriedByCurrentElf = 0;

        for (String c : calories) {
            if (c.isBlank()) {
                if (totalCaloriesCarriedByCurrentElf > maxCalories) {
                    maxCalories = totalCaloriesCarriedByCurrentElf;
                }
                totalCaloriesCarriedByCurrentElf = 0;
                continue;
            }
            totalCaloriesCarriedByCurrentElf += Long.parseLong(c);
        }

        if (totalCaloriesCarriedByCurrentElf > maxCalories) {
            maxCalories = totalCaloriesCarriedByCurrentElf;
        }

        return maxCalories;
    }


    public static void main(String[] args) {
        System.out.println(new Day1().resolve());
    }
}
