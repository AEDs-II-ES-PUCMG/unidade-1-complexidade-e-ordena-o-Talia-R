import java.util.Comparator;

/**
 * Critério B - Volume Total de Itens (crescente).
 * Desempate 1: Data do Pedido.
 * Desempate 2: Código Identificador do pedido.
 */
public class ComparadorCriterioB implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        int primeiroCriterio = 1;
        int resposta = primeiroCriterio;
        if(o1.getformaDePagamento() < o2.getformaDePagamento()){
            return resposta;
        } else if(o1.getformaDePagamento() == o2.getformaDePagamento()){
            Comparator<Pedido> segundoComparador = new ComparadorCriterioA();
            resposta = segundoComparador.compare(o1, o2);
            if(resposta == 0){
                resposta = o1.compareTo(o2);
            }
        }

        return resposta;
        //Sua lógica de comparação aqui
    }
}

// forma de pagamento, a vista: 1
// parcelado 2
// se for mesmo tipo usa valorFinal ou hashcode
