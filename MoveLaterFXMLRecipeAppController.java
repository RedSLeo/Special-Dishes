import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class MoveLaterFXMLRecipeAppController
{
   
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
   
   /**
      This method runs when the user selects Beef as their dish category
      of choice. 
   */
   
   @FXML
   void beefChoice(ActionEvent event) 
   {
      
   }

   
   /**
      This method runs when the user selects Chicken as their dish
      category of choice. 
   */   
   @FXML
   void chickChoice(ActionEvent event) 
   {
   
   }
   
   /**
      This method runs when the user selects Pork as their dish category 
      of choice. 
   */      
   @FXML
   void porkChoice(ActionEvent event) 
   {
 
   /**
      This method runs when the user selects Vegetarian as their dish 
      category of choice. 
   */   
   }   
   @FXML
   void vegChoice(ActionEvent event) 
   {
   
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   
   @FXML
   void displayChoice1(ActionEvent event) 
   {
   
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   @FXML
   void displayChoice2(ActionEvent event) 
   {
   
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   @FXML
   void displayChoice3(ActionEvent event) 
   {
   
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
   
   @FXML
   void displayChoice4(ActionEvent event) 
   {
   
   }
   
   /** 
      This method runs when the user clicks the first recipe displayed
      on the left side. It updates the ingredients and recipe 
      instructions displayed to that of the recipe that the user selected.
   */
    
   @FXML
   void displayChoice5(ActionEvent event) 
   {
   
   }
   
   
   @FXML
   void updateChoice(ActionEvent event) 
   {
   
   }
   

}
