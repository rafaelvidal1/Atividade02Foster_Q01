//Hack3d by Paris

package atividade02_q01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Atividade02_Q01 {
    private int[] caminho=null;
    private static int[][] dist=null; //distância entre as cidades
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner entrada = new Scanner(new File("C:\\Users\\Pará\\Documents\\ITA\\5ºSemestre\\CTC-20 (Foster)\\atividade-bim-2-2016\\Grafo01.txt"));
        int n=0; //número de cidades
        int cont=0; //contador
        int customin; //Custo mínimo 
        ArrayList<Integer> lista = new ArrayList<Integer>(); //lista com os subconjuntos
        
        while(entrada.hasNextLine()){
            if(cont==0){
                n = entrada.nextInt();
                dist = new int[n][n];
            }
            for(int i = 0; i<n && cont<n ; i++){
                dist[cont][i]=entrada.nextInt();
            }
            cont++;
        }
        
        for(int i = 0 ; i<n ; i++){
            lista.add(i);
        }
        
        long tempoinicial = System.nanoTime();
        
        customin = PCV(0, lista);
        
        System.out.println("\nVALOR FINAL: "+customin);
        
        long tempofinal = System.nanoTime();
        System.out.println(tempofinal - tempoinicial );
        
    }
    
    public static int PCV(int v , ArrayList<Integer> lista){
        int comparador=1000;
        int aux;
        
        if(lista.size()==1 && dist[v][0]!=-1){
            return dist[0][v];
        }
        
        if(lista.size()==1 && dist[v][0]==-1){
            return -1;
        }
        
        else{
            for(int i = 1 ; i<lista.size() ; i++){
                aux=lista.get(1);
                lista.remove(1);
                int PCV = PCV(aux,lista);
                if(PCV+dist[v][aux]<comparador && dist[v][aux]!=-1 && PCV!=-1){
                        comparador=PCV+dist[v][aux];
                }
                lista.add(aux);
            }
        return comparador;
        }
    }
}
