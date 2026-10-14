package core;

public class MinhaExcecao extends ArithmeticException {

	// Construtor padrão que já define a mensagem de erro fixa
    public MinhaExcecao(long populacaoInformada) {
        super("Dados incorretos: a população não pode ser menor que zero. População informada: " + 
        	populacaoInformada);
    }
}