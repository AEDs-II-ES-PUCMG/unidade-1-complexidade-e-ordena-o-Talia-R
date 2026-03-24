import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

public class App {
    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;        
    }

    /**
     * Gerador de vetores de objetos do tipo Integer aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor de Objetos Integer com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }

    static Integer[] transformarEmInteger(Object[] obj){
        Integer[] array = new Integer[obj.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = (Integer) obj[i];
        }

        return array;
    }

    static String resumo(IOrdenador ordenador){ 
        StringBuilder s = new StringBuilder();

        int tam = 20;
        Integer[] vetor = gerarVetorObjetos(tam);

        Integer[] vetorOrdenadoBolha = transformarEmInteger(ordenador.ordenar(vetor)); 

        s.append("\n" + "Comparações: " + ordenador.getComparacoes());
        s.append("\n" + "Movimentações: " + ordenador.getMovimentacoes());
        s.append("\n" + "Tempo de ordenação (ms): " + ordenador.getTempoOrdenacao());

        return s.toString();
    } 

    public static void main(String[] args) {

        System.out.println("\nTeste Vetor ordenado método Bolha:");
        BubbleSort<Integer> bolha = new BubbleSort<>();
        System.out.println(resumo(bolha));


        /* 
        TO DO
        *Fazer a implementacao do restante do main para a ordenacao 
        *  com os algoritmos InsertionSort e SelectionSort
        */
    }
}
