package uk.ac.cam.intdes.gr1.ui;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

import java.util.Calendar;

public class DatePicker extends HBox{

    public static String dayToString(int day){
        switch (day){
            case Calendar.THURSDAY: return "Thu";
            case Calendar.FRIDAY: return "Fri";
            case Calendar.SATURDAY: return "Sat";
            case Calendar.SUNDAY: return "Sun";
            case Calendar.MONDAY: return "Mon";
            case Calendar.TUESDAY: return "Tue";
            case Calendar.WEDNESDAY: return "Wed";
        }
        return "";
    }

    public DatePicker(LocationWeather locationWeather, int width){
        super(10);
        setAlignment(Pos.CENTER);
        Calendar calendar = Calendar.getInstance();
        ObservableList<Node> labels = getChildren();
        getStylesheets().add(getClass().getResource("/css/date.css").toExternalForm());
        for(int i = 0; i < 7; i++) {
            Label l = new Label(dayToString(calendar.get(Calendar.DAY_OF_WEEK)) + "\n" + calendar.get(Calendar.DATE));
            labels.add(l);
            l.setPrefWidth(width / 7 - 10);
            l.setTextAlignment(TextAlignment.CENTER);
            l.getStyleClass().add("date");
            calendar.add(Calendar.DATE, 1);
        }

        //Parameters in lambdas must be final
        //There has to be a better way, but...
        labels.get(0).setOnMouseClicked(event -> locationWeather.setDayIndex(0));
        labels.get(1).setOnMouseClicked(event -> locationWeather.setDayIndex(1));
        labels.get(2).setOnMouseClicked(event -> locationWeather.setDayIndex(2));
        labels.get(3).setOnMouseClicked(event -> locationWeather.setDayIndex(3));
        labels.get(4).setOnMouseClicked(event -> locationWeather.setDayIndex(4));
        labels.get(5).setOnMouseClicked(event -> locationWeather.setDayIndex(5));
        labels.get(6).setOnMouseClicked(event -> locationWeather.setDayIndex(6));
    }
}
