import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.google.gson.*;

// Simple test to try out GSON & Guide

public class MealSearch {
    public static void main(String[] args) {
        try {
            // This is the FIRST meal
            // mealName varirable is not being used
            // String mealName = "Arrabiata";
            String apiURL1 = "http://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata";

            URL url1 = new URL(apiURL1);
            HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
            conn1.setRequestMethod("GET");

            /*
             * Verifies if redirection is needed because without it it would return as an HTML format and throw an error,
             * therefore to avoid that it goes ahead and retrieves the new URL from the response
             * headers and opens a connection to the new URL
             */
            if (conn1.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM || conn1.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                String newUrl = conn1.getHeaderField("Location");
                conn1 = (HttpURLConnection) new URL(newUrl).openConnection();
                conn1.setRequestMethod("GET");
            }

            BufferedReader reader1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
            StringBuilder response1 = new StringBuilder();
            String line1;
            while ((line1 = reader1.readLine()) != null) {
                response1.append(line1);
            }
            reader1.close();

            /*
             * Reads the response from the connection and stores it as a 'String' and then prints out the JSON response to the console
             */
            String jsonResponse1 = response1.toString();
            System.out.println(jsonResponse1);

            // Not being used (Figure this part out later, even though it works without it)
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(jsonResponse1, JsonObject.class);
            
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

            conn1.disconnect();

            // This is the SECOND meal
            // mealName varirable is not being used
            // String mealName = "Honey Teriyaki Salmon";
            String apiURL2 = "https://www.themealdb.com/api/json/v1/1/search.php?s=Honey%20Teriyaki%20Salmon";

            URL url2 = new URL(apiURL2);
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
            conn2.setRequestMethod("GET");

            /*
             * Verifies if redirection is needed because without it it would return as an HTML format and throw an error,
             * therefore to avoid that it goes ahead and retrieves the new URL from the response
             * headers and opens a connection to the new URL
             */
            if (conn2.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM || conn2.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                String newUrl2 = conn1.getHeaderField("Location");
                conn2 = (HttpURLConnection) new URL(newUrl2).openConnection();
                conn2.setRequestMethod("GET");
            }

            BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
            StringBuilder response2 = new StringBuilder();
            String line2;
            while ((line2 = reader2.readLine()) != null) {
                response2.append(line2);
            }
            reader2.close();

            /*
             * Reads the response from the connection and stores it as a 'String' and then prints out the JSON response to the console
             */
            String jsonResponse2 = response2.toString();
            System.out.println("\n" + jsonResponse2);

            // Not being used (Figure this part out later, even though it works without it)
            Gson gson2 = new Gson();
            JsonObject json2 = gson2.fromJson(jsonResponse2, JsonObject.class);
            
            // Access the "meals" array from the JSON object
            JsonArray mealsArray2 = json2.getAsJsonArray("meals");

            // Loop through each meal in the array and only print the name and category
            for (JsonElement mealElement : mealsArray2) {
                JsonObject mealObject = mealElement.getAsJsonObject();
                String mealName = mealObject.get("strMeal").getAsString();
                String mealCategory = mealObject.get("strCategory").getAsString();
                String MealDescription = mealObject.get("strInstructions").getAsString();
                System.out.println("Meal Name: " + mealName);
                System.out.println("Meal Category: " + mealCategory);
                System.out.println("Meal Instructions: " + MealDescription);

            }

            conn2.disconnect();

            // This is the THIRD meal
            // mealName varirable is not being used
            // String mealName = "Honey Teriyaki Salmon";
            String apiURL3 = "https://www.themealdb.com/api/json/v1/1/search.php?s=Fish%20Soup";

            URL url3 = new URL(apiURL3);
            HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
            conn3.setRequestMethod("GET");

            /*
             * Verifies if redirection is needed because without it it would return as an HTML format and throw an error,
             * therefore to avoid that it goes ahead and retrieves the new URL from the response
             * headers and opens a connection to the new URL
             */
            if (conn3.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM || conn3.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                String newUrl3 = conn1.getHeaderField("Location");
                conn3 = (HttpURLConnection) new URL(newUrl3).openConnection();
                conn3.setRequestMethod("GET");
            }

            BufferedReader reader3 = new BufferedReader(new InputStreamReader(conn3.getInputStream()));
            StringBuilder response3 = new StringBuilder();
            String line3;
            while ((line3 = reader3.readLine()) != null) {
                response3.append(line3);
            }
            reader3.close();

            /*
             * Reads the response from the connection and stores it as a 'String' and then prints out the JSON response to the console
             */
            String jsonResponse3 = response3.toString();
            System.out.println("\n" + jsonResponse3);

            // Not being used (Figure this part out later, even though it works without it)
            Gson gson3 = new Gson();
            JsonObject json3 = gson3.fromJson(jsonResponse3, JsonObject.class);
            
            // Access the "meals" array from the JSON object
            JsonArray mealsArray3 = json3.getAsJsonArray("meals");

            // Loop through each meal in the array and only print the name and category
            for (JsonElement mealElement : mealsArray3) {
                JsonObject mealObject = mealElement.getAsJsonObject();
                String mealName = mealObject.get("strMeal").getAsString();
                String mealCategory = mealObject.get("strCategory").getAsString();
                String MealDescription = mealObject.get("strInstructions").getAsString();
                System.out.println("Meal Name: " + mealName);
                System.out.println("Meal Category: " + mealCategory);
                System.out.println("Meal Instructions: " + MealDescription);

            }

            conn3.disconnect();

            // This is the FOURTH meal
            // mealName varirable is not being used
            // String mealName = "Honey Teriyaki Salmon";
            String apiURL4 = "https://www.themealdb.com/api/json/v1/1/search.php?s=Pad%20See";

            URL url4 = new URL(apiURL4);
            HttpURLConnection conn4 = (HttpURLConnection) url4.openConnection();
            conn4.setRequestMethod("GET");

            /*
             * Verifies if redirection is needed because without it it would return as an HTML format and throw an error,
             * therefore to avoid that it goes ahead and retrieves the new URL from the response
             * headers and opens a connection to the new URL
             */
            if (conn4.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM || conn4.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                String newUrl4 = conn1.getHeaderField("Location");
                conn4 = (HttpURLConnection) new URL(newUrl4).openConnection();
                conn4.setRequestMethod("GET");
            }

            BufferedReader reader4 = new BufferedReader(new InputStreamReader(conn4.getInputStream()));
            StringBuilder response4 = new StringBuilder();
            String line4;
            while ((line4 = reader4.readLine()) != null) {
                response4.append(line4);
            }
            reader4.close();

            /*
             * Reads the response from the connection and stores it as a 'String' and then prints out the JSON response to the console
             */
            String jsonResponse4 = response4.toString();
            System.out.println("\n" + jsonResponse4);

            // Not being used (Figure this part out later, even though it works without it)
            Gson gson4 = new Gson();
            JsonObject json4 = gson4.fromJson(jsonResponse4, JsonObject.class);
            
            // Access the "meals" array from the JSON object
            JsonArray mealsArray4 = json4.getAsJsonArray("meals");

            // Loop through each meal in the array and only print the name and category
            for (JsonElement mealElement : mealsArray4) {
                JsonObject mealObject = mealElement.getAsJsonObject();
                String mealName = mealObject.get("strMeal").getAsString();
                String mealCategory = mealObject.get("strCategory").getAsString();
                String MealDescription = mealObject.get("strInstructions").getAsString();
                System.out.println("Meal Name: " + mealName);
                System.out.println("Meal Category: " + mealCategory);
                System.out.println("Meal Instructions: " + MealDescription);

            }

            conn4.disconnect();
            
             // This is the FIFTH meal
            // mealName varirable is not being used
            // String mealName = "Honey Teriyaki Salmon";
            String apiURL5 = "https://www.themealdb.com/api/json/v1/1/search.php?s=Thai%20Green%20Curry";

            URL url5 = new URL(apiURL5);
            HttpURLConnection conn5 = (HttpURLConnection) url5.openConnection();
            conn5.setRequestMethod("GET");

            /*
             * Verifies if redirection is needed because without it it would return as an HTML format and throw an error,
             * therefore to avoid that it goes ahead and retrieves the new URL from the response
             * headers and opens a connection to the new URL
             */
            if (conn5.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM || conn4.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                String newUrl5 = conn1.getHeaderField("Location");
                conn4 = (HttpURLConnection) new URL(newUrl5).openConnection();
                conn4.setRequestMethod("GET");
            }

            BufferedReader reader5 = new BufferedReader(new InputStreamReader(conn5.getInputStream()));
            StringBuilder response5 = new StringBuilder();
            String line5;
            while ((line5 = reader5.readLine()) != null) {
                response5.append(line5);
            }
            reader5.close();

            /*
             * Reads the response from the connection and stores it as a 'String' and then prints out the JSON response to the console
             */
            String jsonResponse5 = response5.toString();
            System.out.println("\n" + jsonResponse5);

            // Not being used (Figure this part out later, even though it works without it)
            Gson gson5 = new Gson();
            JsonObject json5 = gson5.fromJson(jsonResponse5, JsonObject.class);
            
            // Access the "meals" array from the JSON object
            JsonArray mealsArray5 = json5.getAsJsonArray("meals");

            // Loop through each meal in the array and only print the name and category
            for (JsonElement mealElement : mealsArray5) {
                JsonObject mealObject = mealElement.getAsJsonObject();
                String mealName = mealObject.get("strMeal").getAsString();
                String mealCategory = mealObject.get("strCategory").getAsString();
                String MealDescription = mealObject.get("strInstructions").getAsString();
                System.out.println("Meal Name: " + mealName);
                System.out.println("Meal Category: " + mealCategory);
                System.out.println("Meal Instructions: " + MealDescription);

            }

            conn5.disconnect();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
