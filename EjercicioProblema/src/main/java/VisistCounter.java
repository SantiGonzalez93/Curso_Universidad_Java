import java.util.*;
import java.util.stream.*;


public class VisistCounter {

    public Map<Long, Long> count(Map<String, UserStats>... visitis) {
        Map<Long, Long> result = new HashMap<>();
        //Recover every Map
        for (Map<String, UserStats> visit : visitis) {
            //iterate each map
            visit.forEach((keys, values) -> {

                if (keys.matches("\\d+")) {
                    try {
                        Long key = Long.parseLong(keys);
                        Long value = values.getVisitColum().orElse(null);
                        if (value != null) {
                            result.put(key, value);
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                });

            }
            return result;
        }

    }
