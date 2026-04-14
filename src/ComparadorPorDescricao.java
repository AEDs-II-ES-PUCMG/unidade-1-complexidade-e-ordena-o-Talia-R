import java.util.Comparator;

public class ComparadorPorDescricao implements Comparator<Produto>{

    @Override
    public int compare(Produto atual, Produto outro) {
        return atual.compareTo(outro);
    }

    
}
