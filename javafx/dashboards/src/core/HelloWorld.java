package core;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    static Logger logger = Logger.getLogger("hello");

    // Método auxiliar para logar as threads, que estava faltando no seu código
    private static void threadLogger(String message) {
        logger.log(Level.INFO, message + " | Executando na Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        threadLogger("In main");
        Application.launch(args);
    }

    // O JavaFX exige obrigatoriamente a implementação deste método start
    @Override
    public void start(Stage primaryStage) {
        threadLogger("In start");

        // Criando os componentes visuais baseados nos seus imports
        Label label = new Label("Olá, JavaFX!");
        Button button = new Button("Clique Aqui");
        
        // Configurando a ação do botão
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText("Botão clicado!");
                threadLogger("Botão acionado");
            }
        });

        // Organizando o layout usando o BorderPane importado
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        
        root.setCenter(label);
        root.setBottom(button);
        
        // Alinhando o botão no centro inferior
        BorderPane.setAlignment(button, Pos.CENTER);

        // Configurando a cena e a janela principal (Stage)
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}