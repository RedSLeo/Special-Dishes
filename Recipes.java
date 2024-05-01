/**
   This class represents a collection of recipes.
*/
public class Recipes
{
   // An array of meals returned by the API.
   public Meal[] meals;
   
   /**
      This method is a getter method for the
      meals field.
      @return meals An array of meals.
   */
   public Meal[] getMeals()
   {
      return meals;
   }
}