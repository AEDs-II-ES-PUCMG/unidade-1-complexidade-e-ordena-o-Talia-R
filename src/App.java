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

    static String resumo(int[] tamanhos, IOrdenador ordenador){ 
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < tamanhos.length; i++) {
            Integer[] vetor = gerarVetorObjetos(tamanhos[i]);

            Integer[] vetorOrdenado = transformarEmInteger(ordenador.ordenar(vetor)); 

            s.append(String.format("\nTamanho: %15d | Comparações: %15d | Movimentações: %15d | Tempo de ordenação (ms): %15.2f",
                                    tamanhos[i],
                                    ordenador.getComparacoes(),
                                    ordenador.getMovimentacoes(),
                                    ordenador.getTempoOrdenacao()
                                ));
        
        }

        return s.toString();
    } 

    public static void main(String[] args) {

        //#region método BubbleSort
            System.out.println("\n ---- Teste Vetor ordenado método Bolha ----");
            BubbleSort<Integer> bolha = new BubbleSort<>();

            System.out.println("\nTamanhos de vetor médio:");
            System.out.println(resumo(tamanhosTesteMedio, bolha));

            System.out.println("\n" + "-".repeat(40));

            System.out.println("\nTamanhos de vetor grande:");
            System.out.println(resumo(tamanhosTesteGrande, bolha)); 

        //#endregion
         
        //#region método Insertionsort
            System.out.println("\n ---- Teste Vetor ordenado método Insertion Sort ----");
            InsertionSort<Integer> insertion = new InsertionSort<>();

            System.out.println("\nTamanhos de vetor médio:");
            System.out.println(resumo(tamanhosTesteMedio, insertion));

            System.out.println("\n" + "-".repeat(40));

            System.out.println("\nTamanhos de vetor grande:");
            System.out.println(resumo(tamanhosTesteGrande, insertion));
        //#endregion

        //#region método Selectionsort
            System.out.println("\n ---- Teste Vetor ordenado método Insertion Sort ----");
            SelectionSort<Integer> selection = new SelectionSort<>();

            System.out.println("\nTamanhos de vetor médio:");
            System.out.println(resumo(tamanhosTesteMedio, selection));

            System.out.println("\n" + "-".repeat(40));

            System.out.println("\nTamanhos de vetor grande:");
            System.out.println(resumo(tamanhosTesteGrande, selection));

        //#endregion

    }
}
