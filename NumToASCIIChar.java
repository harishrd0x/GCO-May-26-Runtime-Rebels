public class NumToASCIIChar {

    public static void main(String[] args) {

        // Parse dash-separated ASCII codes and convert to characters
        String str = "72-101-108-108-111";
        String[] nums = str.split("-");

        String output = "";

        try {
            for (int i = 0; i < nums.length; i++) {
                int n = Integer.parseInt(nums[i]);

                // Validate ASCII range (0-127)
                if (n < 0 || n > 127) {
                    System.out.println("Error: Invalid ASCII code " + n);
                    return;
                }

                output += (char) n;
            }
            System.out.println(output);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in input");
        }
    }
}