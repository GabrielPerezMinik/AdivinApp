package adivinApp;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application{
	Label numeroLabel=new Label();
	Button comprobarButton=new Button();
	TextField numeroTextField=new TextField();
	VBox root= new VBox();
	
	int numRandom= (int) Math.floor(Math.random() * (100 - 1) + 1);
	static IntegerProperty num = new SimpleIntegerProperty();
	int mostrarInt;
	int Intentos=0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		numeroLabel.setText("introduce un número del 1 al 100");
		comprobarButton.setText("Comprobar");
		comprobarButton.setDefaultButton(true);
		
		//forma Pro
		comprobarButton.setOnAction(this::onSaludarAction);
		
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);
		root.setFillWidth(false);
		root.getChildren().addAll(numeroLabel,numeroTextField,comprobarButton);
		Scene scene = new Scene(root,320,200);
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	private void onSaludarAction(ActionEvent e) {
		
		try {
			num.set(Integer.parseInt(numeroTextField.getText()));
			
			if(num.getValue()==numRandom) {
				Alert Ganar = new Alert(AlertType.INFORMATION);
				Ganar.setTitle("AdivinApp");
				Ganar.setHeaderText("¡Has ganado!");
				Ganar.setContentText("Sólo has necesitado " + Intentos + " intentos.\n Vuelve a jugar y Hazlo mejor");
				Ganar.showAndWait();
				}
				else if(num.getValue()>numRandom && num.getValue()!=0) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El numero a adivinar es menor que "+num.getValue() +"."+ "\nVuelve a intentarlo.");
				Intentos++;
				alert.showAndWait();
				}
				
				else if(num.getValue()<numRandom && num.getValue()!=0) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("AdivinApp");
					alert.setHeaderText("¡Has fallado!");
					alert.setContentText("El numero a adivinar es mayor que "+ num.getValue() +"."+ "\n Vuelve a intentarlo.");
					
					Intentos++;
					alert.showAndWait();
					}
				else if (num.getValue()==0) {
					Alert error = new Alert(AlertType.ERROR);
					error.setTitle("AdivinApp");
					error.setHeaderText("Error");
					error.setContentText("El número introducido no es válido.");
					error.showAndWait();
				}
		} catch (Exception e2) {
			if(num.getValue()==null ||numeroTextField.getText()=="" ){
				Alert error = new Alert(AlertType.ERROR);
				error.setTitle("AdivinApp");
				error.setHeaderText("Error");
				error.setContentText("Dejar el campo vacio no es válido.");
				error.showAndWait();
				}
			else {
				Alert error = new Alert(AlertType.ERROR);
				error.setTitle("AdivinApp");
				error.setHeaderText("Error");
				error.setContentText("Las letras no son válidas.");
				error.showAndWait();
			}
		}
	
			
		
		}
	
	public static void main(String[] args) {
		launch(args);

	}
	
}
