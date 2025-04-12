package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Extractor {

    //la fel ca la assignmentul de la laborator - subpunctul a
    public List<MonitoredData> getMonitoredData(String path) throws IOException {
        Stream<String> stream = Files.lines(Paths.get(path));
        return stream.map(line -> {
            String[] data = line.split("\t\t"); //sparg linia din fisier dupa doua tab-uri
            MonitoredData monitoredData = new MonitoredData(data[0], data[1], data[2]); //start data, end data, activity
            return monitoredData;
        }).collect(Collectors.toList()); //colectez in lista
    }

    public long countDays(List<MonitoredData> monitoredDataList) {
        return Stream.concat(monitoredDataList.stream()
                                .map(data -> data.getStartTime().substring(0, 10)), //substringul fara ore, doar data
                        monitoredDataList.stream()
                                .map(data -> data.getEndTime().substring(0, 10)))
                .distinct().count();
    }

    public Map<String, Integer> getActivityNumbers(List<MonitoredData> monitoredDataList) {
        return monitoredDataList.stream().collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.collectingAndThen(Collectors.toList(), List::size)));
       // return monitoredDataList.stream().filter(x-> x.getActivity().equals("Toileting")).collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.collectingAndThen(Collectors.toList(), List::size)));
       // pentru assignmentul optional de la laborator, ca iau doar activitatea "Toileting" - subpunctul b

    }
    //grupez dupa activitate apoi le adaug intr-o lista, obtin size-ul liste care va reprezenta de cate ori are loc o activitate

}
