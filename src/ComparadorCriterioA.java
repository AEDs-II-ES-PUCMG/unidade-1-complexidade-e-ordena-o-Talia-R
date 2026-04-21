import java.util.Comparator;

/**
 * Critério A - Valor Final do Pedido (crescente).
 * Desempate 1: Volume Total de Itens (quantProdutos).
 * Desempate 2: Código Identificador do primeiro item do pedido.
 */
public class ComparadorCriterioA implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        double comp = o1.valorFinal() - o2.valorFinal();
        if(comp > 0){
            return 1;
        } else if(comp < 0){
            return -1;
        }
        return 0;
    }
}

/**
 * Produto valorDeVenda()
 * 1 se o o1 for maior
 * -1 se o o1 for menor
 * 0 se forem iguais
 * 50 25 = 25
 */
