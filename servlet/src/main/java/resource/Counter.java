package resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.Map;

public class Counter {
    private static Integer counter = 0;

    public static synchronized String getCounter(){
        String outString = "";
        try{
            outString = new ObjectMapper().writeValueAsString(
                    Map.of("date", LocalDateTime.now().toString(), "value", counter.toString()));
        }
        catch (JsonProcessingException e){
            outString = e.getMessage();
        }

        return outString;
    }

    public static synchronized void setCounter() {
        Counter.counter += 1;
    }

    public static synchronized void delCounter(int count) {
        Counter.counter -= count;
    }

    public static synchronized void nullCounter() {
        Counter.counter = 0;
    }
}

