import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.google.gson.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.*;

// Simple test to try out GSON & Guide

public class MealSearch extends Application {
    public static void main(String[] args) {
        launch(args);     
   }
   
   /**
      This method is called when the app is started and ready to run.
      It is the entry point for this app. It overrides the start method
      of the Application class.
   */
   
   @Override
   public void start(Stage stage) throws Exception
   {
      // Load the GUI from FXML built in Scene Builder
      Parent root = FXMLLoader.load(getClass().getResource("RecipeAppView.fxml"));    
      Scene scene = new Scene(root);      
      stage.setTitle("Recipes App!");
      stage.setScene(scene);
      stage.show();
   }
   
   /** 
      This method is called when the application is stopped. 
      It overrides the stop method of the Application class.
   */
   
   @Override
   public void stop() 
   {
      System.out.println("Stop is called in Application class");
   }

}
