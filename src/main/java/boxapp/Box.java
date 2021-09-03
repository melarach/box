package boxapp;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.Events;
import service.Utils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Box {
    private String restMode = "";
    private List<Events> logs = new ArrayList<>();


    public Box(String restMode) {
        this.restMode = restMode;
    }


    public boolean isEmpty() {
        return logs.isEmpty();
    }

    public void log(String s) {
        this.logs.add(new Events(s));
    }

    public String readLogs() {
        StringBuilder result = new StringBuilder();
        switch (restMode) {
            case "S":
                result.append("Secure(");
                result.append(Utils.print(logs));
                result.append(")");
                break;
            case "R":
                result.append(Utils.eventsToJson(logs));
                break;
            default:
                result.append(Utils.print(logs));
                break;
        }
        return result.toString();
    }


    public int count() {
        return logs.size();
    }

    public void decrypt(String message) {
        try {
            logs.addAll(Utils.jsonToEvents(Utils.sendRequestToApi(message, restMode)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}