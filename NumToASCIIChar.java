public class NumToASCIIChar {

    public static void main(String[] args) {

        String str = "72-101-108-108-111";
        String[] nums = str.split("-");

        String output = "";

        for (int i = 0; i < nums.length; i++) {

            int n = Integer.parseInt(nums[i]);
            output += (char) n;
        }

        System.out.println(output);
    }
}