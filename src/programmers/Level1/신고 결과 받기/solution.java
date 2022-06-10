import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportedMap = new HashMap<>();
        Map<String, Integer> reportCountMap = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] persons = report[i].split(" ");
            Set<String> sets = reportedMap.get(persons[0]);
            if (sets == null) {
                sets = new HashSet<String>();
            }
            if (!sets.contains(persons[1])) {
                reportCountMap.put(persons[1], reportCountMap.getOrDefault(persons[1], 0) + 1);
            }
            sets.add(persons[1]);
            reportedMap.put(persons[0], sets);
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = calculate(k, reportedMap.get(id_list[i]), reportCountMap);
        }
        return answer;
    }

    public int calculate(int k, Set<String> sets, Map<String, Integer> maps) {
        int count = 0;
        if (sets == null) return 0;
        Iterator iter = sets.iterator();
        while (iter.hasNext()) {
            if (maps.get(iter.next()) >= k) {
                count += 1;
            }
        }
        return count;
    }
}