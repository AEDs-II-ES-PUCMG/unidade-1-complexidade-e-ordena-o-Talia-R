import java.util.Comparator;

/**
 * Critério C - Índice de Economia (decrescente).
 * O índice de economia é a diferença entre o valor de catálogo atual e o valor efetivamente pago.
 * Desempate 1: Valor Final do Pedido (crescente).
 * Desempate 2: Código Identificador do pedido (crescente).
 */
public class ComparadorCriterioC implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        int resposta = 1;
        if(o1.valorMedio() < o2.valorMedio()){
            resposta = -1;
        } else if(o1.valorMedio() == o2.valorMedio()){
            Comparator<Pedido> segundoComparador = new ComparadorCriterioA();
            resposta = segundoComparador.compare(o1, o2);
            if(resposta == 0){
                resposta = o1.compareTo(o2);
            }
        }
        return resposta;
}
}

/*
 Ticket Médio por Variedade de Produtos: A ordenação deve ser baseada no valor médio gasto 
por tipo de produto distinto presente no pedido, ou seja, a razão entre o Valor Final do Pedido e a 
quantidade de posições ocupadas no vetor do carrinho, independentemente de quantas unidades de cada 
produto foram solicitadas. 
o Desempate: Em caso de empate, utilize o Valor Final do Pedido e, em seguida, o Código 
Identificador.
*/