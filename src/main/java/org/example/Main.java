package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

//problema optionala cu Lambda
public class Main {



    public static void main(String[] args) throws IOException {
        String path = "Activities.txt";
        Extractor extractor = new Extractor();

        System.out.println("Requirement 1");

        List<MonitoredData> monitoredDataList = extractor.getMonitoredData(path);
        System.out.println(monitoredDataList);

        System.out.println("Requirement 2");

        long nrDays = extractor.countDays(monitoredDataList);
        System.out.println("Number of distinct days " + nrDays);

        System.out.println("Requirement 3");

        Map<String, Integer> activityNumber= extractor.getActivityNumbers(monitoredDataList);
        System.out.println("Map Activity Number " + activityNumber);
    }
}
