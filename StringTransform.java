import java.util.*;

public class StringTransform {

    static class State {
        String word;
        int steps;

        State(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String start = sc.nextLine();
        String end = sc.nextLine();

        char[] chars = { 'A', 'B', 'C' };

        Queue<State> q = new LinkedList<>();

        Map<String, Integer> dist = new HashMap<>();
        Map<String, Integer> ways = new HashMap<>();

        q.add(new State(start, 0));

        dist.put(start, 0);
        ways.put(start, 1);

        while (!q.isEmpty()) {

            State cur = q.poll();
            String word = cur.word;

            for (int i = 0; i < word.length(); i++) {

                for (char ch : chars) {

                    if (word.charAt(i) == ch)
                        continue;

                    char[] arr = word.toCharArray();
                    arr[i] = ch;

                    String next = new String(arr);

                    if (next.contains("CC"))
                        continue;

                    if (!dist.containsKey(next)) {

                        dist.put(next, dist.get(word) + 1);
                        ways.put(next, ways.get(word));

                        q.add(new State(next, dist.get(next)));
                    }

                    else if (dist.get(next) == dist.get(word) + 1) {

                        ways.put(next, ways.get(next) + ways.get(word));
                    }
                }
            }
        }
        System.out.println("Length: " + dist.get(end));
        System.out.println("Paths: " + ways.get(end));
    }
}