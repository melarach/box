package service;

import java.util.List;

public class Utils {
    public static final String SEPARATEUR = "-";

    public static String print(List<Events> logs) {
        StringBuilder result = new StringBuilder();
        for (Events log : logs) {
            if (result.length() == 0) {
                result.append(log.getId());
            } else {
                result.append(SEPARATEUR);
                result.append(log.getId());
            }
        }
        return result.toString();
    }
}
