import db.Consulta;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Consulta c = new Consulta();        
        c.buscarVendas();
    }
}