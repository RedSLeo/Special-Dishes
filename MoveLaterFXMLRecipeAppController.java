import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javax.swing.Action;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.google.gson.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.*;

public class MoveLaterFXMLRecipeAppController extends Application{

   public void start(Stage primarStage) throws Exception {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeAppView.fxml"));
      // RecipeAppViewController controller = new RecipeAppViewController();
      // loader.setController(controller);
      Parent root = loader.load();
      Scene scene = new Scene(root);
      primarStage.setScene(scene);
      primarStage.show();
   }
  
   /*
    * The first set of buttons belongs to the Vegatarian Category
    */
   @FXML
   private Button button1;

  
   @FXML
   private Button button2;

   /*
    * The second set buttons belongs to the Beef Category
    */
    @FXML
    private Button button3;
   
    @FXML
    private Button button4;

    /*
    * The third set of buttons belongs to the Chicken Category
    */
    @FXML
    private Button button5;
   
    @FXML
    private Button button6;

    /*
    * The fourth set of buttons belongs to the Pork Category
    */
    @FXML
    private Button button7;
   
    @FXML
    private Button button8;

    /*
    * The fifth set of buttons belongs to the Seafood Category
    */
    @FXML
    private Button button9;
   
    @FXML
    private Button button10;
   
   /** The button that indicates a selection for beef recipes. */
   @FXML
   private RadioButton beefButton;
   
   /** The button that indicates a selection for chicken recipes. */
   @FXML
   private RadioButton chickButton;
   
   /** The button that indicates a selection for pork recipes. */
   @FXML
   private RadioButton porkButton;
   
   /** The button that indicates a selection for vegetarian recipes. */
   @FXML
   private RadioButton vegButton;

   @FXML
   private RadioButton seaButton;
   
   /** The label next to the buttons for dish type that says "Dish Categories: ". */
   @FXML
   private Label dishLabel;
   
   /** Where the ingredients of the recipe will be displayed. */
   @FXML
   private Label ingredientLabel;
   
   /** Where the instructions of the recipe will be displayed. */
   @FXML
   private Label recipeLabel;
   
   /** A button that, when pressed, will update the available recipes displayed for that type of meal.*/
   @FXML
   private Button searchButton;
   
   /** A enum that keeps track of the user's choice for type of meal. Not sure if I'm going to keep this, depends on if we hardcode the buttons. */
   private enum MealChoice { VEGETARIAN, CHICKEN, BEEF, PORK, SEAFOOD };
   private MealChoice mealChoice;
   
   private String recipeChoice;
   
   protected static final String MEAL_TYPE = "meal_type_key";
   
   
   
   /**
      This method runs when the user selects Beef as their dish category
      of choice. 
   */
   
   @FXML
   protected void beefChoice() 
   {
      this.mealChoice = MealChoice.BEEF;
      button1.setText("Beef Lo Mein");
      button2.setText("Egyptian Fatteh");
   }

   
   /**
      This method runs when the user selects Chicken as their dish
      category of choice. 
   */   
   @FXML
   protected void chickChoice() 
   {
      this.mealChoice = MealChoice.CHICKEN;
      button3.setText("Thai Green Curry");
      button4.setText("Pad See Ew"); 
   }
   
   /**
      This method runs when the user selects Pork as their dish category 
      of choice. 
   */      
   @FXML
   protected void porkChoice() 
   {
      this.mealChoice = MealChoice.PORK;  
      button5.setText("Sweet and Sour Pork");
      button6.setText("Japanese Katsudon");
   }   
   @FXML
   
   /**
      This method runs when the user selects Vegetarian as their dish 
      category of choice. 
   */ 
   protected void vegChoice() 
   {
      this.mealChoice = MealChoice.VEGETARIAN;
      button7.setText("Vegetarian Casserole");
      button8.setText("Vegetarian Chilli");
   }

   @FXML
   protected void seafoodChoice()
   {
      this.mealChoice = MealChoice.SEAFOOD;
      button9.setText("Honey Teriyaki Salmon");
      button10.setText("Fish Soup Ukha");
   }
   
   /** 
      This method runs when the user clicks the recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   
   @FXML
   protected void displayChoice1(ActionEvent event) 
   {
      Button sourceButton = (Button) event.getSource();
      
      recipeChoice = (sourceButton.getText());
      
      beefLoMein(event);
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
  @FXML
  protected void displayChoice2(ActionEvent event) 
  {
   Button sourceButton = (Button) event.getSource();
      
   recipeChoice = (sourceButton.getText());
   
   egyptianFatteh(event);
  }

  @FXML
  protected void displayChoice3(ActionEvent event) 
  {
   Button sourceButton = (Button) event.getSource();
      
   recipeChoice = (sourceButton.getText());
   
   thaiGreenCurry(event);
  }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   @FXML
   protected void displayChoice4(ActionEvent event) 
   {
      Button sourceButton = (Button) event.getSource();
     
     recipeChoice = (sourceButton.getText());
     
     padSeeEw(event);
   }
   
   // PORK OPTION
   @FXML
   protected void displayChoice5(ActionEvent event) 
   {
      Button sourceButton = (Button) event.getSource();
     
     recipeChoice = (sourceButton.getText());
     
     sweetAndSour(event);
   }

   // PORK OPTION
   @FXML
   protected void displayChoice6(ActionEvent event) 
   {
      Button sourceButton = (Button) event.getSource();
     
      recipeChoice = (sourceButton.getText());
      
      japaneseKatsudon(event);
   }
    
   // VEGETARIAN OPTION
   @FXML
   protected void displayChoice7(ActionEvent event) 
   {
      Button sourceButton = (Button) event.getSource();
     
     recipeChoice = (sourceButton.getText());
     
     casserole(event);
   }

   // VEGETARIAN OPTION
   @FXML
   protected void displayChoice8(ActionEvent event) 
   {
      Button sourceButton = (Button) event.getSource();
     
     recipeChoice = (sourceButton.getText());
     
     chilli(event);
   }

   // SEAFOOD OPTION
   @FXML
   protected void displayChoice9(ActionEvent event) 
   {
      Button sourceButton = (Button) event.getSource();
     
     recipeChoice = (sourceButton.getText());
     
     honeyTeriyakiSalmon(event);
   }

   // SEAFOOD OPTION
   @FXML
   protected void displayChoice10(ActionEvent event) 
   {
      Button sourceButton = (Button) event.getSource();
     
     recipeChoice = (sourceButton.getText());
     
     fishSoup(event);
   }
   
   @FXML
   protected void handleMealChoiceRadioActionButton(ActionEvent event) 
   {
      if (event.getSource() == chickButton) {
         chickChoice();
         setButtonVisibility(false, false, true, true, false, false, false, false, false, false);
     } else if (event.getSource() == porkButton) {
         porkChoice();
         setButtonVisibility(false, false, false, false, true, true, false, false, false, false);
     } else if (event.getSource() == vegButton) {
         vegChoice();
         setButtonVisibility(false, false, false, false, false, false, true, true, false, false);
     } else if (event.getSource() == seaButton) {
         seafoodChoice();
         setButtonVisibility(false, false, false, false, false, false, false, false, true, true);
     } else if (event.getSource() == beefButton) {
         beefChoice();
         setButtonVisibility(true, true, false, false, false, false, false, false, false, false);
     }
 }
 
 private void setButtonVisibility(boolean... visibility) {
     if (visibility.length != 10) {
         return;
     }
     
     button1.setVisible(visibility[0]);
     button2.setVisible(visibility[1]);
     button3.setVisible(visibility[2]);
     button4.setVisible(visibility[3]);
     button5.setVisible(visibility[4]);
     button6.setVisible(visibility[5]);
     button7.setVisible(visibility[6]);
     button8.setVisible(visibility[7]);
     button9.setVisible(visibility[8]);
     button10.setVisible(visibility[9]);
      
      // Save new meal preference
      Preferences p = Preferences.userNodeForPackage(MoveLaterFXMLRecipeAppController.class);
      p.put(MEAL_TYPE, this.mealChoice.toString() );
   }

   protected void casserole(ActionEvent event) {
      try {
         String apiURL = "https://themealdb.com/api/json/v1/1/search.php?s=Vegetarian%20Casserole";
         URL url = new URL(apiURL);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line2;
               while ((line2 = reader.readLine()) != null) {
                  response.append(line2);
               }
               reader.close();

               Gson gson = new Gson();
               JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
         }

         conn.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   protected void chilli(ActionEvent event) {
      try {
         String apiURL = "https://themealdb.com/api/json/v1/1/search.php?s=Vegetarian%20Chilli";
         URL url = new URL(apiURL);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line2;
               while ((line2 = reader.readLine()) != null) {
                  response.append(line2);
               }
               reader.close();

               Gson gson = new Gson();
               JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
         }

         conn.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   protected void padSeeEw(ActionEvent event) {
      try {
         String apiURL = "https://themealdb.com/api/json/v1/1/search.php?s=Pad%20See%20Ew";
         URL url = new URL(apiURL);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line2;
               while ((line2 = reader.readLine()) != null) {
                  response.append(line2);
               }
               reader.close();

               Gson gson = new Gson();
               JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
         }

         conn.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   protected void thaiGreenCurry(ActionEvent event) {
      try {
         String apiURL = "https://themealdb.com/api/json/v1/1/search.php?s=Thai%20Green%20Curry";
         URL url = new URL(apiURL);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line2;
               while ((line2 = reader.readLine()) != null) {
                  response.append(line2);
               }
               reader.close();

               Gson gson = new Gson();
               JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
         }

         conn.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   protected void egyptianFatteh(ActionEvent event) {
      try {
         String apiURL = "https://themealdb.com/api/json/v1/1/search.php?s=Egyptian%20Fatteh";
         URL url = new URL(apiURL);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line2;
               while ((line2 = reader.readLine()) != null) {
                  response.append(line2);
               }
               reader.close();

               Gson gson = new Gson();
               JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
         }

         conn.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   protected void beefLoMein(ActionEvent event) {
      try {
         String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Lo%20Mein";
         URL url = new URL(apiURL);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line2;
               while ((line2 = reader.readLine()) != null) {
                  response.append(line2);
               }
               reader.close();

               Gson gson = new Gson();
               JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
         }

         conn.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   protected void sweetAndSour(ActionEvent event) {
      try {
         String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?s=Sweet%20and%20Sour";
         URL url = new URL(apiURL);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line2;
               while ((line2 = reader.readLine()) != null) {
                  response.append(line2);
               }
               reader.close();

               Gson gson = new Gson();
               JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
         }

         conn.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   protected void japaneseKatsudon(ActionEvent event) {
      try {
         String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?s=Japanese%20Katsudon";
         URL url = new URL(apiURL);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line2;
               while ((line2 = reader.readLine()) != null) {
                  response.append(line2);
               }
               reader.close();

               Gson gson = new Gson();
               JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
         }

         conn.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   protected void fishSoup(ActionEvent event) {
      try {
         String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?s=Fish%20Soup";
         URL url = new URL(apiURL);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line2;
               while ((line2 = reader.readLine()) != null) {
                  response.append(line2);
               }
               reader.close();

               Gson gson = new Gson();
               JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
         }

         conn.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   
   protected void honeyTeriyakiSalmon(ActionEvent event) {
      try {
         String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?s=Honey%20Teriyaki%20Salmon";
         URL url = new URL(apiURL);
         HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();
         conn2.setRequestMethod("GET");

         if (conn2.getResponseCode() == HttpURLConnection.HTTP_OK) {
               BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
               StringBuilder response = new StringBuilder();
               String line;
               while ((line = reader2.readLine()) != null) {
                  response.append(line);
               }
               reader2.close();

               Gson gson2 = new Gson();
               JsonObject json = gson2.fromJson(response.toString(), JsonObject.class);

               JsonArray mealsArray = json.getAsJsonArray("meals");

               if (mealsArray.size() > 0) {
                  JsonObject mealObject = mealsArray.get(0).getAsJsonObject();
                  String mealName = mealObject.get("strMeal").getAsString();
                  String mealCategory = mealObject.get("strCategory").getAsString();
                  String mealInstructions = mealObject.get("strInstructions").getAsString();

                  dishLabel.setText("Dish Category: " + mealCategory);
                  ingredientLabel.setText("");
                  recipeLabel.setText("Meal Instructions: " + mealInstructions);
               } else {
                  // No meal found, handle this case appropriately
                  System.err.println("No meal found for Honey Teriyaki Salmon");
               }
         } else {
               // Handle HTTP error response
               System.err.println("HTTP error: " + conn2.getResponseCode() + " " + conn2.getResponseMessage());
         }

         conn2.disconnect();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}
