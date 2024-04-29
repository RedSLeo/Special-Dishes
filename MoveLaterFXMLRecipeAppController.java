import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import java.util.prefs.Preferences;

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
   
   /** A button that, when pressed, will update the available recipes displayed for that type of meal.*/
   @FXML
   private Button searchButton;
   
   /** A enum that keeps track of the user's choice for type of meal. Not sure if I'm going to keep this, depends on if we hardcode the buttons. */
   private enum MealChoice { VEGETARIAN, CHICKEN, BEEF, PORK };
   private MealChoice mealChoice;
   
   protected static final String MEAL_TYPE = "meal_type_key";
   
   
   
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
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   
   @FXML
   protected void displayChoice1(ActionEvent event) 
   {
   
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   @FXML
   protected void displayChoice2(ActionEvent event) 
   {
   
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   @FXML
   protected void displayChoice3(ActionEvent event) 
   {
   
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   
   @FXML
   protected void displayChoice4(ActionEvent event) 
   {
   
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
    
   @FXML
   protected void displayChoice5(ActionEvent event) 
   {
   
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
   
   protected void updateChoice()
   {
      
   }

}
