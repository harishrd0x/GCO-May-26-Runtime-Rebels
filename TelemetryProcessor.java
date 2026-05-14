import java.util.*;

public class TelemetryProcessor {

    static int gcd(int a, int b) {

        if (b == 0)
            return Math.abs(a);

        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        String[] lines = {
                "18 24 30",
                "7,14,21",
                "9, 27, 81",
                "100 200 300",
                "5 10",
                "8,16,24,32",
                "-12 -18 -24",
                "11, 22, abc",
                "0 0 5"
        };

        int total = 0;

        for (String line : lines) {

            boolean valid = line.matches("-?\\d+ -?\\d+ -?\\d+") ||
                    line.matches("-?\\d+  +-?\\d+  +-?\\d+") ||
                    line.matches("-?\\d+,-?\\d+,-?\\d+") ||
                    line.matches("-?\\d+, -?\\d+, -?\\d+");

            if (!valid)
                continue;

            String[] nums;

            if (line.contains(", "))
                nums = line.split(", ");
            else if (line.contains(","))
                nums = line.split(",");
            else
                nums = line.trim().split("\\s+");

            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);

            total += gcd(gcd(a, b), c);
        }

        System.out.println(total);
    }
}