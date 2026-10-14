package core.dashboards;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Graficos extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // 1. Definição dos eixos para os gráficos lineares
        CategoryAxis xAxisBarra = new CategoryAxis();
        NumberAxis yAxisBarra = new NumberAxis();
        CategoryAxis xAxisLinha = new CategoryAxis();
        NumberAxis yAxisLinha = new NumberAxis();

        xAxisBarra.setLabel("Trimestre");
        yAxisBarra.setLabel("Vendas");
        xAxisLinha.setLabel("Trimestre");
        yAxisLinha.setLabel("Vendas");

        // 2. Gráfico de Barras (BarChart)
        BarChart<String, Number> graficoBarra = new BarChart<>(xAxisBarra, yAxisBarra);
        graficoBarra.setTitle("Vendas por Trimestre (Barras)");
        XYChart.Series<String, Number> seriesBarra = new XYChart.Series<>();
        seriesBarra.setName("2026");
        seriesBarra.getData().add(new XYChart.Data<>("T1", 300));
        seriesBarra.getData().add(new XYChart.Data<>("T2", 500));
        seriesBarra.getData().add(new XYChart.Data<>("T3", 450));
        seriesBarra.getData().add(new XYChart.Data<>("T4", 700));
        graficoBarra.getData().add(seriesBarra);

        // 3. Gráfico de Linha (LineChart) - Mesmos dados
        LineChart<String, Number> graficoLinha = new LineChart<>(xAxisLinha, yAxisLinha);
        graficoLinha.setTitle("Evolução de Vendas (Linha)");
        XYChart.Series<String, Number> seriesLinha = new XYChart.Series<>();
        seriesLinha.setName("2026");
        seriesLinha.getData().add(new XYChart.Data<>("T1", 300));
        seriesLinha.getData().add(new XYChart.Data<>("T2", 500));
        seriesLinha.getData().add(new XYChart.Data<>("T3", 450));
        seriesLinha.getData().add(new XYChart.Data<>("T4", 700));
        graficoLinha.getData().add(seriesLinha);

        // 4. Gráfico de Pizza (PieChart) - Mesmos dados
        ObservableList<PieChart.Data> dadosPizza = FXCollections.observableArrayList(
                new PieChart.Data("T1", 300),
                new PieChart.Data("T2", 500),
                new PieChart.Data("T3", 450),
                new PieChart.Data("T4", 700)
        );
        PieChart graficoPizza = new PieChart(dadosPizza);
        graficoPizza.setTitle("Distribuição de Vendas (Pizza)");

        // Layout horizontal para alinhar os três gráficos
        HBox root = new HBox(15);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(graficoBarra, graficoLinha, graficoPizza);

        Scene scene = new Scene(root, 1100, 400);
        primaryStage.setTitle("Demonstração de Gráficos JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
