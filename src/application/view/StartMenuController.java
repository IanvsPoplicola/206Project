package application.view;

//import application.util.NavigatorUtil;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import org.controlsfx.control.PopOver;

import java.net.URISyntaxException;
import java.util.Optional;

import static application.MainApp.mascotImage;
import static org.controlsfx.control.PopOver.ArrowLocation.BOTTOM_RIGHT;

public class StartMenuController extends AbstractController {

	@FXML private ImageView mascot;
	private PopOver clickHerePopOver = new PopOver();

	@FXML
	public void initialize(){
		// TODO change this because we need to set it from reading a file storing user's previous choice

		mascot.setImage(mascotImage);

	}
	
	/**
	 * This method gets called when the user clicks on the practice button
	 * will give users instructions before continuing to practice stage
	 */
	@FXML
	public void handlePractice() {
		_mainApp.initInstructions();
	}	
	
	@FXML
	public void handleQuit() {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Are you sure you want to quit?");
		alert.setContentText("We'd love for you to keep learning!");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			_mainApp.close();
		} else {
			//do nothing
		}
	}

	@FXML
	public void handlePlay(){
		_mainApp.initPlaySelect();//initialises the PlaySelectScreen.fxml and PlaySelectScreeenController
	}

	@FXML
	public void handleStatistics(){
		_mainApp.initStatistics();
	}

	@FXML
	public void handleCharacter(){
		clickHerePopOver.hide();
		_mainApp.initCharacters();
	}


	@FXML
	public void handleMic(){
		_mainApp.initMic();
	}

	@FXML
	public void showClickMe(){
		setPopOver();
	}

	@FXML
	public void closeClickMe(){
		clickHerePopOver.hide();
	}

	private void setPopOver(){
		String text = "Click Me!";
		Label help = new Label(text);
		help.setFont(new Font("Maiandra GD",40));
		clickHerePopOver.setContentNode(help);
		clickHerePopOver.setArrowLocation(BOTTOM_RIGHT);
		clickHerePopOver.setArrowSize(10);
		clickHerePopOver.setAutoHide(false);
		// remove min height property.
		DoubleProperty minHeight = clickHerePopOver.getRoot().minHeightProperty();
		minHeight.unbind();
		minHeight.set(0);
		// Set padding
		clickHerePopOver.getRoot().setPadding(new Insets(8));
		clickHerePopOver.show(mascot);
	}

}
