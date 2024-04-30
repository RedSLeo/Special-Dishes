import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.*;
import java.util.prefs.Preferences;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.google.gson.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.*;
import javafx.scene.control.Alert.AlertType;

public class MoveLaterFXMLRecipeAppController
{
   //private HttpClient client;
   
   @FXML
   /** The first recipe button. */
   private Button button1;
   
   /** The second recipe button. */
   @FXML
   private Button button2;
    
   /** The third recipe button. */
   @FXML 
   private Button button3;
    
   /** The fourth recipe button. */
   @FXML
   private Button button4;
    
   /** The fifth recipe button. */
   @FXML
   private Button button5;
   
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
   
   /** The label next to the buttons for dish type that says "Dish Categories: ". */
   @FXML
   private Label dishLabel;
   
   /** Where the ingredients of the recipe will be displayed. */
   @FXML
   private Label ingredientLabel;
   
   /** Where the instructions of the recipe will be displayed. */
   @FXML
   private Label recipeLabel;
      
   /** A enum that keeps track of the user's choice for type of meal. Not sure if I'm going to keep this, depends on if we hardcode the buttons. */
   private enum MealChoice { VEGETARIAN, CHICKEN, BEEF, PORK };
   private MealChoice mealChoice;
   
   private String recipeChoice;
   
   protected static final String MEAL_TYPE = "meal_type_key";
   
   /** Keeps track of which button has just been pressed. */
   private Button sourceButton;
   
   protected JsonObject json;
   
   
   /**
      This method runs when the user selects Beef as their dish category
      of choice. 
   */
   
   @FXML
   protected void beefChoice() 
   {
      this.mealChoice = MealChoice.BEEF;
      button1.setText("Beef Sunday Roast");
      button2.setText("Beef Lo Mein");
      button3.setText("Moussaka");
      button4.setText("Massaman Beef Curry");
      button5.setText("Mulukhiyah");
   }

   
   /**
      This method runs when the user selects Chicken as their dish
      category of choice. 
   */   
   @FXML
   protected void chickChoice() 
   {
      this.mealChoice = MealChoice.CHICKEN;
      button1.setText("15-minute chicken & halloumi burgers");
      button2.setText("Ayam Percik");
      button3.setText("Brown Stew Chicken");
      button4.setText("Chick-Fil-A Sandwich");
      button5.setText("Chicken & mushroom Hotpot");
      
   }
   
   /**
      This method runs when the user selects Pork as their dish category 
      of choice. 
   */      
   @FXML
   protected void porkChoice() 
   {
      this.mealChoice = MealChoice.PORK;  
      button1.setText("BBQ Pork Sloppy Joes");
      button2.setText("Bigos (Hunters Stew)");
      button3.setText("Boxty Breakfast");
      button4.setText("Coddled pork with cider");
      button5.setText("Crispy Sausages and Greens");
   }   
   @FXML
   
   /**
      This method runs when the user selects Vegetarian as their dish 
      category of choice. 
   */ 
   protected void vegChoice() 
   {
      this.mealChoice = MealChoice.VEGETARIAN;
      button1.setText("Baingan Bharta");
      button2.setText("Beetroot Soup (Borscht)");
      button3.setText("Cabbage Soup (Shchi)");
      button4.setText("Chickpea Fajitas");
      button5.setText("Crispy Eggplant");
   }
   
   /** 
      This method runs when the user clicks the recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   
   @FXML
   protected void displayChoice1(ActionEvent event) 
   {
      if (beefButton.isSelected() || chickButton.isSelected() ||
         vegButton.isSelected() || porkButton.isSelected())
         {
         sourceButton = (Button) event.getSource();
      
         recipeChoice = (sourceButton.getText());
      
         updateChoice();
         }
      else
      {
         Alert a1 = new Alert(AlertType.NONE, "Please select a dish category!", ButtonType.OK);
         a1.show();
      }
         
      
   }
      
   
   @FXML
   protected void handleMealChoiceRadioActionButton(ActionEvent event) 
   {
      if(event.getSource() == chickButton)
         chickChoice();
      if(event.getSource() == beefButton)
         beefChoice();
      if(event.getSource() == vegButton)
         vegChoice();
      if(event.getSource() == porkButton)
         porkChoice();
      
      // Save new meal preference
      Preferences p = Preferences.userNodeForPackage(MoveLaterFXMLRecipeAppController.class);
      p.put(MEAL_TYPE, this.mealChoice.toString() );
   }
   
   protected void setIngredients()
   {
      String ingredientList = ( json.meals[0].strMeasure1 + " " + json.meals[0].strIngredient1 + "\n"
                              + json.meals[0].strMeasure2 + " " + json.meals[0].strIngredient2 + "\n"
                              + json.meals[0].strMeasure3 + " " + json.meals[0].strIngredient3 + "\n"
                              + json.meals[0].strMeasure4 + " " + json.meals[0].strIngredient4 + "\n"
                              + json.meals[0].strMeasure5 + " " + json.meals[0].strIngredient5 + "\n"
                              + json.meals[0].strMeasure6 + " " + json.meals[0].strIngredient6 + "\n"
                              + json.meals[0].strMeasure7 + " " + json.meals[0].strIngredient7 + "\n"
                              + json.meals[0].strMeasure8 + " " + json.meals[0].strIngredient8 + "\n"
                              + json.meals[0].strMeasure9 + " " + json.meals[0].strIngredient9 + "\n"
                              + json.meals[0].strMeasure10 + " " + json.meals[0].strIngredient10 + "\n"
                              + json.meals[0].strMeasure11 + " " + json.meals[0].strIngredient11 + "\n"
                              + json.meals[0].strMeasure12 + " " + json.meals[0].strIngredient12 + "\n"
                              + json.meals[0].strMeasure13 + " " + json.meals[0].strIngredient13 + "\n"
                              + json.meals[0].strMeasure14 + " " + json.meals[0].strIngredient14 + "\n"
                              + json.meals[0].strMeasure15 + " " + json.meals[0].strIngredient15 + "\n"
                              + json.meals[0].strMeasure16 + " " + json.meals[0].strIngredient16 + "\n"
                              + json.meals[0].strMeasure17 + " " + json.meals[0].strIngredient17 + "\n"
                              + json.meals[0].strMeasure18 + " " + json.meals[0].strIngredient18 + "\n"
                              + json.meals[0].strMeasure19 + " " + json.meals[0].strIngredient19 + "\n"
                              + json.meals[0].strMeasure20 + " " + json.meals[0].strIngredient20 + "\n" );
      ingredientLabel.setText(ingredientList);
   }
   
   protected void updateChoice()
   {
      try {
            // This is the FIRST meal
            // mealName varirable is not being used
            // String mealName = "Arrabiata";
            //String apiURL1 = ("https://www.themealdb.com/api/json/v1/1/filter.php?c=" + recipeChoice);
            
            // This needs to be fixed, to use recipeChoice or some other String (determined by some kind of conditional) to call the right recipe
            String formattedChoice = recipeChoice.replace(" ", "_");
            String apiURL1 = ("http://www.themealdb.com/api/json/v1/1/search.php?s=" + formattedChoice);

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
            json = gson.fromJson(jsonResponse1, JsonObject.class);
            
            recipeLabel.setText((json.meals[0]).strInstructions);
            setIngredients();
      }
   
      catch (Exception e) {
         e.printStackTrace();
      }
   }

}
