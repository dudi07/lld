package loggingLibrary.appender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {
    HashMap<Integer, List<LogObserver>> mapOfLogObserver = new HashMap<>();

    public void addObserver(int level, LogObserver logObserver){
        if(mapOfLogObserver.containsKey(level)){
            List<LogObserver>existingLogObservers = mapOfLogObserver.get(level);
            existingLogObservers.add(logObserver);
            mapOfLogObserver.remove(level);
            mapOfLogObserver.put(level, existingLogObservers);
        }
        else{
            List<LogObserver> logObservers = new ArrayList<>();
            logObservers.add(logObserver);
            mapOfLogObserver.put(level, logObservers);
        }
    }

    public void notifyAllLogObservers(int level, String message){
        for(Map.Entry<Integer,  List<LogObserver>> entry : mapOfLogObserver.entrySet()){
            if(entry.getKey() == level){
                entry.getValue().forEach(observer -> observer.log(message));
            }
        }
    }
}
