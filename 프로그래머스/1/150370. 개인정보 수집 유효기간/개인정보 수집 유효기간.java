import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        StringTokenizer st = new StringTokenizer(today,".");
        HashMap<String, Integer> termMap = new HashMap<>();



        Integer year = Integer.valueOf(st.nextToken());
        Integer month = Integer.valueOf(st.nextToken());
        Integer day = Integer.valueOf(st.nextToken());

        for (String t : terms) {
            st = new StringTokenizer(t," ");
            termMap.put(st.nextToken(), Integer.valueOf(st.nextToken()));
        }
        int index = 0;
        int[] answer = new int[privacies.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i], " ");
            String date = st.nextToken();
            String type = st.nextToken();

            st = new StringTokenizer(date, ".");

            Integer end = termMap.get(type)*28;


            Integer pYear = Integer.valueOf(st.nextToken());
            Integer pMonth = Integer.valueOf(st.nextToken());
            Integer pDay = Integer.valueOf(st.nextToken());


            if (countDay(pYear, pMonth, pDay, year, month, day)>=end) {
                list.add(i+1);
            }
        }
        System.out.println(list);
        return  list.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public static int countDay(Integer y, Integer m , Integer d,
                               Integer ty, Integer tm, Integer td) {
        Integer result1 = ((y * 12) * 28) + ((m-1) * 28) + d;
        Integer result2 = ((ty * 12) * 28) + ((tm-1) * 28) + td;
        return result2 - result1;
    }

}