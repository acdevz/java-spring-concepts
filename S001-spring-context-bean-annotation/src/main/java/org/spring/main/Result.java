package org.spring.main;

import java.util.*;

class Result {
    public static int getMaxTrafficTime(List<Integer> start, List<Integer> end) {
        int n = start.size();
        int maxTraffic = 1; // Maximum concurrent interactions
        int earliestTime = start.get(0); // Time when maxTraffic first occurs

        for (int i = 0; i < n; i++) {
            int currentTraffic = 1; // Count of overlapping intervals for this iteration
            for (int j = i + 1; j < n; j++) {
                // Check if intervals overlap
                if ((start.get(i) >= start.get(j) && start.get(i) <= end.get(j)) ||
                        (start.get(j) >= start.get(i) && start.get(j) <= end.get(i))) {
                    currentTraffic++;
                }
            }
            // Update maxTraffic and earliestTime if a new maximum is found
            if (currentTraffic > maxTraffic) {
                maxTraffic = currentTraffic;
                earliestTime = start.get(i);
            } else if (currentTraffic == maxTraffic && start.get(i) < earliestTime) {
                earliestTime = start.get(i); // Take the earliest time for maxTraffic
            }
        }
        return earliestTime;
    }

    public static void main(String[] args) {
        List<Integer> start = Arrays.asList(1, 6, 2, 9);
        List<Integer> end = Arrays.asList(8, 7, 6, 10);

        int result = getMaxTrafficTime(start, end);
        System.out.println("The earliest time with maximum traffic is: " + result);
    }
}
