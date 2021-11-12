package com.example.connect4;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayGround();


        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four Game");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    private MenuBar createMenu(){
        Menu fileMenu=new Menu("File");
        Menu newGame=new Menu("New Game");
        newGame.setOnAction(actionEvent -> controller.resetGame());


        Menu resetGame=new Menu("Reset Game");
        resetGame.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        Menu exitGame=new Menu("Exit Game");
        exitGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                exitGame();
            }
        });

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

        Menu helpMenu=new Menu("Help");
        Menu aboutGame=new Menu("About Connect4");
        aboutGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                aboutConnect4();
            }
        });

        SeparatorMenuItem separator=new SeparatorMenuItem();
        Menu aboutMe=new Menu("About Me");
        aboutMe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                aboutMe();

            }
        });

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;


    }

    private void aboutMe() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Gautam Kumar");
        alert.setContentText("I love to play around with code and create games "+
                "and Connect 4 is one of the best Game. In free time You must be expand your time.");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the"+
                " players first choose a color and then take turns dropping colored discs"+
                " from the top into a seven-column, six-row vertically suspended grid."+
                " The pieces fall straight down, occupying the next available space within the column."+
                " The objective of the game is to be the first to form a horizontal, vertical,"+
                " or diagonal line of four of one's own discs. Connect Four is a solved game."+
                " The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
    }

    public static void main(String[] args){
        launch(args);



    }
}







