package core;

public class App {

	public static void main(String[] args) {
		int populacao = -5000;
		
		if (populacao < 0) {
			// TODO: retire o comentário para gerar a exceção customizada
            // throw new MinhaExcecao(populacao);
        }

		try {
	        // Seu código que pode gerar múltiplas exceções aqui
			// TODO: altere aqui para gerar outra exceção
			int x = 10;
			x += 2/0;
			
	    } catch (Exception e) {
	        // 1. Verifica e trata o Tipo 1
	        if (e instanceof NullPointerException ex) {
	            System.out.println("Tratando ponteiro nulo: " + ex.getMessage());
	        } 
	        // 2. Verifica e trata o Tipo 2
	        else if (e instanceof ArithmeticException ex) {
	            System.out.println("Tratando erro de cálculo: " + ex.getMessage());
	        } 
	        // 3. Verifica e trata o Tipo 3
	        else if (e instanceof IllegalArgumentException ex) {
	            System.out.println("Tratando argumento inválido: " + ex.getMessage());
	        } 
	        // 4. Lança qualquer outro tipo de exceção para cima
	        else {
	            throw e; 
	        }
	    }
		finally {
			// sempre é executado!
		}	
	}
}
