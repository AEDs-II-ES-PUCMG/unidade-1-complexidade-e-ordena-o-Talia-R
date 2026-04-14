import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements IOrdenador<T>{
	private long comparacoes;
    private long movimentacoes;
    private double tempoOrdenacao;
    private double inicio;

    private double nanoToMilli = 1.0/1_000_000;

    private void iniciar(){
        this.comparacoes = 0;
        this.movimentacoes = 0;
        this.inicio = System.nanoTime();
    }

    private void terminar(){
        this.tempoOrdenacao = (System.nanoTime() - this.inicio) * nanoToMilli;
    }

	/**
	* Algoritmo que intercala os elementos localizados entre as posições esq e dir
	* @param int esq: início do array a ser ordenado
	* @param int meio: posição do meio do array a ser ordenado
	* @param int dir: fim do array a ser ordenado
	*/
    private void intercalar(T[] dados, int esq, int meio, int dir) {

        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        T[] a1 = Arrays.copyOfRange(dados, esq, meio + 1);
        T[] a2 = Arrays.copyOfRange(dados, meio + 1, dir + 1);

        int i = 0, j = 0, k = esq;

        while (i < n1 && j < n2) {
            comparacoes++;
            if (a1[i].compareTo(a2[j]) <= 0) {
                dados[k++] = a1[i++];
            } else {
                dados[k++] = a2[j++];
            }
            movimentacoes++;
        }

        while (i < n1) {
            dados[k++] = a1[i++];
            movimentacoes++;
        }

        while (j < n2) {
            dados[k++] = a2[j++];
            movimentacoes++;
        }
    }

	/**
	* Algoritmo de ordenação Mergesort.
	* @param int esq: início do array a ser ordenado
	* @param int dir: fim do array a ser ordenado
	*/
	private void mergesort(T[] dados, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(dados, esq, meio);
            mergesort(dados, meio + 1, dir);
            intercalar(dados, esq, meio, dir);
        }
    }

	
    @Override
    public T[] ordenar(T[] dados) {
        T[] dadosOrdenados = Arrays.copyOf(dados, dados.length);
        iniciar();
        mergesort(dadosOrdenados, 0, dadosOrdenados.length - 1);
        terminar();
        return dadosOrdenados;
    }

	@Override
	public long getComparacoes() {
		return comparacoes;
	}

	@Override
	public long getMovimentacoes() {
		return movimentacoes;
	}

	@Override
	public double getTempoOrdenacao() {
		return tempoOrdenacao;
	}
}