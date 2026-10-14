package core.controls;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Componentes extends Application {
    static Logger logger = Logger.getLogger("componentes");

    private static void threadLogger(String message) {
        logger.log(Level.INFO, message + " | Executando na Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        threadLogger("In main (Componentes)");
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        threadLogger("In start (Componentes)");

        // 1. Rótulo (Label) e Campo de Texto (TextField)
        Label lblNome = new Label("Formulário Completo JavaFX:");
        lblNome.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        
        TextField txtField = new TextField();
        txtField.setPromptText("Digite seu nome completo aqui...");

        // 2. Campo de Senha (PasswordField)
        PasswordField txtSenha = new PasswordField();
        txtSenha.setPromptText("Digite sua senha de acesso...");

        // 3. Área de Texto (TextArea) - Múltiplas linhas
        TextArea txtArea = new TextArea();
        txtArea.setPromptText("Escreva observações ou comentários adicionais...");
        txtArea.setPrefRowCount(3);

        // 4. Caixa de Seleção (CheckBox)
        CheckBox chkTermos = new CheckBox("Aceito os termos e condições do sistema");

        // 5. Botões de Opção Unitária (RadioButton) agrupados
        ToggleGroup grupoGenero = new ToggleGroup();
        RadioButton rbMasc = new RadioButton("Masculino");
        rbMasc.setToggleGroup(grupoGenero);
        RadioButton rbFem = new RadioButton("Feminino");
        rbFem.setToggleGroup(grupoGenero);

        // 6. Caixa de Seleção Suspensa (ComboBox)
        ComboBox<String> comboEstado = new ComboBox<>();
        comboEstado.getItems().addAll("São Paulo", "Rio de Janeiro", "Minas Gerais", "Goiás", "Outro");
        comboEstado.setPromptText("Selecione seu Estado");

        // 7. Seletor de Data (DatePicker)
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Data de Nascimento");

        // 8. Barra de Progresso (ProgressBar) e Controle Deslizante (Slider)
        ProgressBar progressBar = new ProgressBar(0.6); // 60% preenchido
        Slider slider = new Slider(0, 100, 50);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        // 9. Botão de Ação (Button) com evento de log
        Button btnSalvar = new Button("Salvar Cadastro");
        btnSalvar.setOnAction(e -> {
            threadLogger("Botão Salvar acionado!");
            System.out.println("Nome digitado: " + txtField.getText());
            System.out.println("Estado selecionado: " + comboEstado.getValue());
        });

        // Layout organizador vertical (VBox)
        VBox layoutConteudo = new VBox(12);
        layoutConteudo.setPadding(new Insets(20));
        layoutConteudo.setAlignment(Pos.TOP_LEFT);
        
        // Adicionando todos os componentes criados ao layout
        layoutConteudo.getChildren().addAll(
            lblNome, 
            new Label("Nome:"), txtField, 
            new Label("Senha:"), txtSenha, 
            new Label("Gênero:"), rbMasc, rbFem,
            new Label("Estado natal:"), comboEstado,
            new Label("Data histórica:"), datePicker,
            new Label("Biografia:"), txtArea, 
            chkTermos,
            new Label("Nível de Volume (Slider):"), slider,
            new Label("Progresso do Envio:"), progressBar,
            btnSalvar
        );

        // ScrollPane evita que a tela corte componentes se a janela for pequena
        ScrollPane scrollPane = new ScrollPane(layoutConteudo);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 450, 600);
        primaryStage.setTitle("Demonstração de Componentes UI JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
