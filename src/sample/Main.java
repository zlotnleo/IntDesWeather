package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import uk.ac.cam.intdes.gr1.ui.WeatherCard;

public class Main extends Application {
    private TitledPane createRow() {
        ScrollPane sp1 = new ScrollPane();
        HBox hbox = new HBox();

//        WeatherCard card = new WeatherCard();
//        card.setWeatherType(WeatherCard.WeatherType.Snow);
//        card.setLocationName("Zel am See");
//        hbox.getChildren().add(card);
//
//        WeatherCard card2 = new WeatherCard();
//        card.setWeatherType(WeatherCard.WeatherType.Sunny);
//        card.setLocationName("Bla");
//        hbox.getChildren().add(card2);
//
//        WeatherCard card3 = new WeatherCard();
//        card.setWeatherType(WeatherCard.WeatherType.Sunny);
//        card.setLocationName("Bla");
//        hbox.getChildren().add(card3);

        sp1.setContent(hbox);
        sp1.setFitToHeight(true);
        sp1.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        TitledPane tp = new TitledPane("general", sp1);
        tp.setCollapsible(false);
        return tp;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        VBox root = new VBox();

        root.getChildren().add(createRow());
        root.getChildren().add(createRow());
        root.getChildren().add(createRow());

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
