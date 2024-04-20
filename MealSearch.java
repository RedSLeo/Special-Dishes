import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.google.gson.*;

// Simple test to try out GSON & Guide

public class MealSearch {
    public static void main(String[] args) {
        try {
            String mealName = "Arrabiata";
            String apiURL = "http://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata";

            URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Check if redirection is needed
            if (conn.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM || conn.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                String newUrl = conn.getHeaderField("Location");
                conn = (HttpURLConnection) new URL(newUrl).openConnection();
                conn.setRequestMethod("GET");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String jsonResponse = response.toString();
            System.out.println(jsonResponse);

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(jsonResponse, JsonObject.class);
            
            // Process the JSON object here

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
