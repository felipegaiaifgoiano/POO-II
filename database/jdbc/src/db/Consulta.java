package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta {

    // Método para buscar dados formatados (pode ser usado para alimentar os gráficos)
    public void buscarVendas() {
        String sql = "SELECT trimestre, valor FROM vendas_trimestre ORDER BY trimestre ASC";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String trimestre = rs.getString("trimestre");
                int valor = rs.getInt("valor");

                System.out.println("Trimestre: " + trimestre + "\t Valor: " + valor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}