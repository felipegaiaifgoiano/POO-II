package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private static final Logger logger = Logger.getLogger("conexao");
    
    // Altere o nome do banco (ex: meu_banco) e as credenciais conforme seu ambiente local
    private static final String URL = "jdbc:mysql://localhost:3306/Vendas?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "12345678";

    public static Connection getConexao() {
        try {
            logger.log(Level.INFO, "Tentando conectar ao banco de dados...");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exceção ao conectar ao banco de dados!", e);
            throw new RuntimeException(e);
        }
    }
}
