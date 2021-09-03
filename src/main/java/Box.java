import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import service.Events;
import service.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class Box {
    private String restMode="";
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
            default:
                result.append(Utils.print(logs));
                break;
        }
        return result.toString();
    }


    public int count() {
        return logs.size();
    }

    public void decrypt(String w3siaWQiOiJldmVudDEifSx7ImlkIjoiZXZlbnQyIn1d) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("http://localhost:8080/decrypt");
            request.addHeader("mode", restMode);
            request.addHeader("message", w3siaWQiOiJldmVudDEifSx7ImlkIjoiZXZlbnQyIn1d);
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
