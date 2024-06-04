import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer count = Integer.parseInt(bf.readLine());
        char[] first = bf.readLine().toCharArray();

        for (int i = 0; i < count - 1; i++) {
            char[] word = bf.readLine().toCharArray();
            for (int j = 0; j < word.length; j++) {
                if (first[j] != word[j]) {
                    first[j] = '?';
                }
            }
        }

        System.out.println(first);

    }
}