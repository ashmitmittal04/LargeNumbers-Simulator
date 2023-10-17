package simulator.largenumberssim;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SimInterface extends Application {

    private XYChart.Series<String, Number> series;

    //Creating Dice List
    DiceList diceList = new DiceList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Law of Large Numbers Simulator");

        // Creating a ToggleGroup for radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();

        // Creating radio buttons with labels
        RadioButton radioButton10 = createLabeledRadioButton("10", toggleGroup);
        RadioButton radioButton100 = createLabeledRadioButton("100", toggleGroup);
        RadioButton radioButton1000 = createLabeledRadioButton("1000", toggleGroup);
        RadioButton radioButton10000 = createLabeledRadioButton("10000", toggleGroup);

        // Setting the default selection
        toggleGroup.selectToggle(radioButton10);

        // Creating Title Labels
        Label numRollsLabel = new Label("Number of Dice to Roll");
        Label tallyTitleLabel = new Label("Probability For Each Outcome");

        // Creating Tally Labels
        Label probabilityLabelDice1 = new Label("1 : " + diceList.getTallyOfDice(1));
        Label probabilityLabelDice2 = new Label("2 : " + diceList.getTallyOfDice(2));
        Label probabilityLabelDice3 = new Label("3 : " + diceList.getTallyOfDice(3));
        Label probabilityLabelDice4 = new Label("4 : " + diceList.getTallyOfDice(4));
        Label probabilityLabelDice5 = new Label("5 : " + diceList.getTallyOfDice(5));
        Label probabilityLabelDice6 = new Label("6 : " + diceList.getTallyOfDice(6));
        Label probabilityLabelTotalRolls = new Label("Total Rolls: " + diceList.getTotalRolls());

        // Creating a normal button
        Button rollDiceButton = new Button("Roll Dice");
        rollDiceButton.setOnAction(e -> {
            // Handling button click
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                diceList.rollList(Integer.parseInt(selectedRadioButton.getText()));
                diceList.updateProbabilityOfAllDice();

                probabilityLabelDice1.setText("1 : " + diceList.getProbabilityOfDice(1) );
                probabilityLabelDice2.setText("2 : " + diceList.getProbabilityOfDice(2) );
                probabilityLabelDice3.setText("3 : " + diceList.getProbabilityOfDice(3) );
                probabilityLabelDice4.setText("4 : " + diceList.getProbabilityOfDice(4) );
                probabilityLabelDice5.setText("5 : " + diceList.getProbabilityOfDice(5) );
                probabilityLabelDice6.setText("6 : " + diceList.getProbabilityOfDice(6) );
                probabilityLabelTotalRolls.setText("Total Rolls: " + diceList.getTotalRolls());

                updateChart();
            }
        });

        // Creating a GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setBackground(new Background(new BackgroundFill(Color.web("#8d857c"), null, null)));

        //Setting Column constraints for gridPane
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(45);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(10);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(45);
        gridPane.getColumnConstraints().addAll(col1,col2,col3);

        // Adding Title Labels
        gridPane.add(numRollsLabel, 0, 0);
        gridPane.add(tallyTitleLabel, 2, 0);

        GridPane.setHalignment(tallyTitleLabel, HPos.RIGHT);

        // Adding radio buttons to the GridPane with left padding for labels
        gridPane.add(radioButton10, 0, 1);
        gridPane.add(radioButton100, 0, 2);
        gridPane.add(radioButton1000, 0, 3);
        gridPane.add(radioButton10000, 0, 4);

        // Adding roll dice button to the GridPane
        gridPane.add(rollDiceButton, 0, 5);

        // Adding Probability Labels
        gridPane.add(probabilityLabelDice1, 2,1);
        gridPane.add(probabilityLabelDice2, 2,2);
        gridPane.add(probabilityLabelDice3, 2,3);
        gridPane.add(probabilityLabelDice4, 2,4);
        gridPane.add(probabilityLabelDice5, 2,5);
        gridPane.add(probabilityLabelDice6, 2,6);
        gridPane.add(probabilityLabelTotalRolls, 2,7);

        GridPane.setHalignment(probabilityLabelDice1, HPos.RIGHT);
        GridPane.setHalignment(probabilityLabelDice2, HPos.RIGHT);
        GridPane.setHalignment(probabilityLabelDice3, HPos.RIGHT);
        GridPane.setHalignment(probabilityLabelDice4, HPos.RIGHT);
        GridPane.setHalignment(probabilityLabelDice5, HPos.RIGHT);
        GridPane.setHalignment(probabilityLabelDice6, HPos.RIGHT);
        GridPane.setHalignment(probabilityLabelTotalRolls, HPos.RIGHT);

        // Setting font to Calibri for all components with font size 16
        Font calibriFont = Font.font("Calibri", FontWeight.BOLD, 16);

        numRollsLabel.setFont(calibriFont);
        tallyTitleLabel.setFont(calibriFont);

        radioButton10.setFont(calibriFont);
        radioButton100.setFont(calibriFont);
        radioButton1000.setFont(calibriFont);
        radioButton10000.setFont(calibriFont);

        probabilityLabelDice1.setFont(calibriFont);
        probabilityLabelDice2.setFont(calibriFont);
        probabilityLabelDice3.setFont(calibriFont);
        probabilityLabelDice4.setFont(calibriFont);
        probabilityLabelDice5.setFont(calibriFont);
        probabilityLabelDice6.setFont(calibriFont);
        probabilityLabelTotalRolls.setFont(calibriFont);

        rollDiceButton.setFont(calibriFont);

        //Setting Title buttons to white
        Color fontColor = Color.WHITE;
        numRollsLabel.setTextFill(fontColor);
        tallyTitleLabel.setTextFill(fontColor);

        // Setting font color to white for radio buttons
        radioButton10.setTextFill(fontColor);
        radioButton100.setTextFill(fontColor);
        radioButton1000.setTextFill(fontColor);
        radioButton10000.setTextFill(fontColor);

        // Setting text fill color to black for the roll dice button
        rollDiceButton.setTextFill(Color.BLACK);

        //Setting font color for probability Labels
        probabilityLabelDice1.setTextFill(fontColor);
        probabilityLabelDice2.setTextFill(fontColor);
        probabilityLabelDice3.setTextFill(fontColor);
        probabilityLabelDice4.setTextFill(fontColor);
        probabilityLabelDice5.setTextFill(fontColor);
        probabilityLabelDice6.setTextFill(fontColor);
        probabilityLabelTotalRolls.setTextFill(fontColor);

        // CREATING GRAPH

        // Creating the X and Y axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setTickLabelFill(Color.WHITE);
        yAxis.setTickLabelFill(Color.WHITE);


        // Creating the bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Tally's of each Outcome");
        barChart.setAnimated(false);

        barChart.lookup(".chart-title").setStyle("-fx-text-fill: white;");

        // Creating a data series
        series = new XYChart.Series<>();
        series.setName("Number of occurrences");

        // Adding data to the series
        updateChart();

        // Adding the series to the chart
        barChart.getData().add(series);

        gridPane.add(barChart,0, 8, 3, 1);

        // Creating the scene
        Scene scene = new Scene(gridPane, 600, 600);

        // Setting the scene
        primaryStage.setScene(scene);

        // Showing the stage
        primaryStage.show();
    }

    // Helper method to create a RadioButton
    private RadioButton createLabeledRadioButton(String labelText, ToggleGroup toggleGroup) {
        RadioButton radioButton = new RadioButton(labelText);

        radioButton.setToggleGroup(toggleGroup);

        return radioButton;
    }

    private void updateChart() {
        // Clear existing data
        series.getData().clear();

        // Add new data
        series.getData().add(new XYChart.Data<>("1", diceList.getTallyOfDice(1)));
        series.getData().add(new XYChart.Data<>("2", diceList.getTallyOfDice(2)));
        series.getData().add(new XYChart.Data<>("3", diceList.getTallyOfDice(3)));
        series.getData().add(new XYChart.Data<>("4", diceList.getTallyOfDice(4)));
        series.getData().add(new XYChart.Data<>("5", diceList.getTallyOfDice(5)));
        series.getData().add(new XYChart.Data<>("6", diceList.getTallyOfDice(6)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

