package application;
	
import java.awt.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.*;


public class Main extends Application {
	  static GridPane grid;
	  static Scene scene;
	  static TextField totalPrice;
	  static TextField totalTax;
	  final static int sceneWidth = 1200;
	  final static int sceneHeight = 475;
	  //Tax Information
	  final static Double importTax = 0.05;
	  final static Double regularTax = 0.1;
	  final static Double importPlusRegularTax = 0.15;
	  
	  //Quantity and Price Information
	  static TextField bookQuantity= new TextField("0");
	  static TextField musicCDQuantity = new TextField("0");
	  static TextField chocolateBarQuantity = new TextField("0");
	  static TextField importedBoxOfChocQuantity = new TextField("0");
	  static TextField importedBottleOfPerfumeQuantity = new TextField("0");
	  static TextField bottleOfPerfumeQuantity = new TextField("0");
	  static TextField packetOfHeadachePillsQuantity = new TextField("0");
	  
	  static TextField bookPrice = new TextField("0");
      static TextField musicCDPrice = new TextField("0");
      static TextField chocolateBarPrice = new TextField("0");
      static TextField importedBoxOfChocPrice = new TextField("0");
      static TextField importedBottleOfPerfumePrice = new TextField("0");
      static TextField bottleOfPerfumePrice = new TextField("0");
      static TextField packetOfHeadachePillsPrice = new TextField("0");
        
      static TextField bookTaxIncl = new TextField("0");
      static TextField musicCDTaxIncl = new TextField("0");
      static TextField chocolateBarTaxIncl = new TextField("0");
      static TextField importedBoxOfChocTaxIncl = new TextField("0");
      static TextField importedBottleOfPerfumeTaxIncl = new TextField("0");
      static TextField bottleOfPerfumeTaxIncl = new TextField("0");
      static TextField packetOfHeadachePillsTaxIncl = new TextField("0");
      
	  public void start(Stage primaryStage) {
		primaryStage.setTitle("Sales Tax Calculator");
		    
	    createAndPositionGrid();
	
	    scene = new Scene(grid, sceneWidth, sceneHeight);
	    primaryStage.setScene(scene);  
	  
	    populateQuantityLabels();
	    populateQuantityTextFields();
	    populatePriceLabels();
	    populatePriceTextFields();
	    populateTaxIncluded();
	    populateResult();
	    populateCalculateButton();
	    populateResetButton();
	    
	    primaryStage.setScene(scene);    
	    primaryStage.show();
    }
	
	public static void createAndPositionGrid(){
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	  }
	  
	public static void populateQuantityLabels() {
	 	Label bookLabel = new Label("# of Books");
        Label musicCDLabel = new Label("# of Music CDs");
        Label chocolateBarLabel = new Label("# of Chocolate Bars");
        Label importedBoxOfChocLabel = new Label("# of Imported Chocolate Bars");
        Label importedBottleOfPerfumeLabel = new Label("# of Imported Bottles of Perfume");
        Label bottleOfPerfumeLabel = new Label("# of Bottle of Perfume");
        Label packetOfHeadachePillsLabel = new Label("# of Packet of Headache Pills");

        grid.add(bookLabel,0,1);
        grid.add(musicCDLabel,0,2);
        grid.add(chocolateBarLabel,0,3);
        grid.add(importedBoxOfChocLabel,0,4);
        grid.add(importedBottleOfPerfumeLabel,0,5);
        grid.add(bottleOfPerfumeLabel,0,6);
        grid.add(packetOfHeadachePillsLabel,0,7);	
	}
	
	public static void populateQuantityTextFields() {
        grid.add(bookQuantity,1,1);
        grid.add(musicCDQuantity,1,2);
        grid.add(chocolateBarQuantity,1,3);
        grid.add(importedBoxOfChocQuantity,1,4);
        grid.add(importedBottleOfPerfumeQuantity,1,5);
        grid.add(bottleOfPerfumeQuantity,1,6);
        grid.add(packetOfHeadachePillsQuantity,1,7);
	}
	
	public static void populatePriceLabels() {
	 	Label bookPrice = new Label("Price of Books");
        Label musicCDPrice = new Label("Price of Music CDs");
        Label chocolateBarPrice = new Label("Price of Chocolate Bars");
        Label importedBoxOfChocPrice = new Label("Price of Imported Chocolate Bars");
        Label importedBottleOfPerfumePrice = new Label("Price of Imported Bottles of Perfume");
        Label bottleOfPerfumePrice = new Label("Price of Bottle of Perfume");
        Label packetOfHeadachePillsPrice = new Label("Price of Packet of Headache Pills");

        grid.add(bookPrice,3,1);
        grid.add(musicCDPrice,3,2);
        grid.add(chocolateBarPrice,3,3);
        grid.add(importedBoxOfChocPrice,3,4);
        grid.add(importedBottleOfPerfumePrice,3,5);
        grid.add(bottleOfPerfumePrice,3,6);
        grid.add(packetOfHeadachePillsPrice,3,7);	
	}
	
	public static void populatePriceTextFields() {
        grid.add(bookPrice,4,1);
        grid.add(musicCDPrice,4,2);
        grid.add(chocolateBarPrice,4,3);
        grid.add(importedBoxOfChocPrice,4,4);
        grid.add(importedBottleOfPerfumePrice,4,5);
        grid.add(bottleOfPerfumePrice,4,6);
        grid.add(packetOfHeadachePillsPrice,4,7);
	}
	
	public static void populateCalculateButton() {
		Button calculateButton = new Button("Calculate");        
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		hbox.getChildren().add(calculateButton);
		grid.add(hbox, 1, 10);
		
		calculateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
            	
            	//Calculate total for each item
            	Double totalBook = (Double.parseDouble(bookPrice.getText()) * Double.parseDouble(bookQuantity.getText()));
            	Double totalMusicCD = (Double.parseDouble(musicCDPrice.getText()) * Double.parseDouble(musicCDQuantity.getText()));
            	Double totalChocBar = (Double.parseDouble(chocolateBarPrice.getText()) * Double.parseDouble(chocolateBarQuantity.getText()));
            	Double totalImpChocBar = (Double.parseDouble(importedBoxOfChocPrice.getText()) * Double.parseDouble(importedBoxOfChocQuantity.getText()));
            	Double totalImpBotPerf = (Double.parseDouble(importedBottleOfPerfumePrice.getText()) * Double.parseDouble(importedBottleOfPerfumeQuantity.getText()));
            	Double totalBotPerf = (Double.parseDouble(bottleOfPerfumePrice.getText()) * Double.parseDouble(bottleOfPerfumeQuantity.getText()));
            	Double totalPackHeadPills = (Double.parseDouble(packetOfHeadachePillsPrice.getText()) * Double.parseDouble(packetOfHeadachePillsQuantity.getText()));
                
            	//Calculate tax for each item
                Double taxBook = 0.0;
                Double taxMusicCD = totalMusicCD * regularTax;
                Double taxChocBar = 0.0;
                Double taxImpChocBar  = totalImpChocBar * importTax;
                Double taxImpBotPerf  = totalImpBotPerf * importPlusRegularTax;
                Double taxBotPerf  = totalBotPerf * regularTax;
                Double taxPackHeadPills = 0.0;
                
                //Calculate individual item with tax
                Double totalBookWithTax = (double) Math.round((totalBook + taxBook) * 20) / 20;
                Double totalMusicCDWithTax = (double) Math.round((totalMusicCD + taxMusicCD) * 20) / 20;
                Double totalChocBarWithTax = (double) Math.round((totalChocBar + taxChocBar) * 20) / 20;
                Double totalImpChocBarWithTax = (double) Math.round((totalImpChocBar + taxImpChocBar) * 20) / 20;
                Double totalImpBotPerfWithTax = (double) Math.round((totalImpBotPerf + taxImpBotPerf) * 20) / 20;
                Double totalBotPerfWithTax = (double) Math.round((totalBotPerf + taxBotPerf) * 20) / 20;
                Double totalPackHeadPillsWithTax = (double) Math.round((totalPackHeadPills + taxPackHeadPills) * 20) / 20;
                
                //Display individual item tax
                bookTaxIncl.setText(totalBookWithTax.toString());
                musicCDTaxIncl.setText(totalMusicCDWithTax.toString());
                chocolateBarTaxIncl.setText(totalChocBarWithTax.toString());
                importedBoxOfChocTaxIncl.setText(totalImpChocBarWithTax.toString());
                importedBottleOfPerfumeTaxIncl.setText(totalImpBotPerfWithTax.toString());
                bottleOfPerfumeTaxIncl.setText(totalBotPerfWithTax.toString());
                packetOfHeadachePillsTaxIncl.setText(totalPackHeadPillsWithTax.toString());
                
                //Calculate Total Tax
                Double totalTaxResult = taxBook + taxMusicCD + taxChocBar + taxImpChocBar + taxImpBotPerf + taxBotPerf + taxPackHeadPills;
                totalTaxResult = (double) Math.round(totalTaxResult * 20) / 20; // Round to nearest 0.05
                totalTax.setText(totalTaxResult.toString());
                
                //Calculate Total Price with tax
                Double totalPriceResult = totalTaxResult + totalBook + totalMusicCD + totalChocBar + totalImpChocBar + totalImpBotPerf + totalBotPerf + totalPackHeadPills;
                totalPriceResult = (double) Math.round(totalPriceResult * 100) / 100; // Round to nearest 0.05
                totalPrice.setText(totalPriceResult.toString());
            }
        });
		
	}
	
	public static void populateResetButton() {
		Button resetButton = new Button("Reset");        
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		hbox.getChildren().add(resetButton);
		grid.add(hbox, 1, 11);
		
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

            bookQuantity.setText("0");
          	musicCDQuantity.setText("0");
          	chocolateBarQuantity.setText("0");
          	importedBoxOfChocQuantity.setText("0");
          	importedBottleOfPerfumeQuantity.setText("0");
          	bottleOfPerfumeQuantity.setText("0");
          	packetOfHeadachePillsQuantity.setText("0");
          	  
          	bookPrice.setText("0");
            musicCDPrice.setText("0");
            chocolateBarPrice.setText("0");
            importedBoxOfChocPrice.setText("0");
            importedBottleOfPerfumePrice.setText("0");
            bottleOfPerfumePrice.setText("0");
            packetOfHeadachePillsPrice.setText("0");
            
            bookTaxIncl.setText("0");
            musicCDTaxIncl.setText("0");
            chocolateBarTaxIncl.setText("0");
            importedBoxOfChocTaxIncl.setText("0");
            importedBottleOfPerfumeTaxIncl.setText("0");
            bottleOfPerfumeTaxIncl.setText("0");
            packetOfHeadachePillsTaxIncl.setText("0");
            
            totalPrice.setText("0");
            totalTax.setText("0");
            }
        });
		
	}
	

	public static void populateResult() {
		Label totalPriceLabel = new Label ("Total Price (Press Calculate)");
		grid.add(totalPriceLabel, 0, 8);
		totalPrice = new TextField("");
		grid.add(totalPrice, 1, 8);
		
		Label totalTaxLabel = new Label ("Total Tax (Press Calculate)");
		grid.add(totalTaxLabel, 0, 9);
		totalTax = new TextField("");
		grid.add(totalTax, 1, 9);
	}
	
	public static void populateTaxIncluded() {
		Label bookPrice = new Label("Price of Books with tax");
        Label musicCDPrice = new Label("Price of Music CDs with tax");
        Label chocolateBarPrice = new Label("Price of Chocolate Bars with tax");
        Label importedBoxOfChocPrice = new Label("Price of Imported Chocolate Barswith tax");
        Label importedBottleOfPerfumePrice = new Label("Price of Imported Bottles of Perfume with tax");
        Label bottleOfPerfumePrice = new Label("Price of Bottle of Perfume with tax");
        Label packetOfHeadachePillsPrice = new Label("Price of Packet of Headache Pills with tax");

        grid.add(bookPrice,5,1);
        grid.add(musicCDPrice,5,2);
        grid.add(chocolateBarPrice,5,3);
        grid.add(importedBoxOfChocPrice,5,4);
        grid.add(importedBottleOfPerfumePrice,5,5);
        grid.add(bottleOfPerfumePrice,5,6);
        grid.add(packetOfHeadachePillsPrice,5,7);	
        
        grid.add(bookTaxIncl,6,1);
        grid.add(musicCDTaxIncl,6,2);
        grid.add(chocolateBarTaxIncl,6,3);
        grid.add(importedBoxOfChocTaxIncl,6,4);
        grid.add(importedBottleOfPerfumeTaxIncl,6,5);
        grid.add(bottleOfPerfumeTaxIncl,6,6);
        grid.add(packetOfHeadachePillsTaxIncl,6,7);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
