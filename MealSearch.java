import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.google.gson.*;

// Simple test to try out GSON & Guide

public class MealSearch {
    public static void main(String[] args) {
        try {
            // mealName varirable is not being used
            // String mealName = "Arrabiata";
            String apiURL = "http://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata";

            URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            /*
             * Verifies if redirection is needed because without it it would return as an HTML format and throw an error,
             * therefore to avoid that it goes ahead and retrieves the new URL from the response
             * headers and opens a connection to the new URL
             */
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

            /*
             * Reads the response from the connection and stores it as a 'String' and then prints out the JSON response to the console
             */
            String jsonResponse = response.toString();
            System.out.println(jsonResponse);

            // Not being used (Figure this part out later, even though it works without it)
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(jsonResponse, JsonObject.class);
            
            // Access the "meals" array from the JSON object
            JsonArray mealsArray = json.getAsJsonArray("meals");

            // Loop through each meal in the array and only print the name and category
            for (JsonElement mealElement : mealsArray) {
                JsonObject mealObject = mealElement.getAsJsonObject();
                String mealName = mealObject.get("strMeal").getAsString();
                String mealCategory = mealObject.get("strCategory").getAsString();
                String MealDescription = mealObject.get("strInstructions").getAsString();
                System.out.println("Meal Name: " + mealName);
                System.out.println("Meal Category: " + mealCategory);
                System.out.println("Meal Instructions: " + MealDescription);

            }
            
            // Process the JSON object here

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
