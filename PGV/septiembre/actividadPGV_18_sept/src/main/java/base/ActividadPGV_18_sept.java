/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package base;

/**
 *
 * @author 2damb
 */
public class ActividadPGV_18_sept {

   
    
    public static void main(String[] args) {
        
        Proceso[] procesos = new Proceso[5];
        
        procesos[0] = new Proceso("AAA", 4);
        procesos[1] = new Proceso("BBB", 2);
        procesos[2] = new Proceso("CCC", 5);
        procesos[3] = new Proceso("DDD", 1);
        procesos[4] = new Proceso("EEE", 3);
        
        int[] listado = {1, 2, 5, 6, 3, 7, 4};

        System.out.println("FIFO:");
        for (int i = 0; i < procesos.length; i++){
            procesos[i].imprimirTextos();
        }
        
        System.out.println("\nSJF:");
        for (int completo = 0; completo < listado.length; completo++){
            for (int i = 0; i < listado.length; i++) {
                if (listado[i] == completo + 1){
                    System.out.print(listado[i] + " ");
                }
            }
        }
        
        System.out.println("\nRR:");
        
    }
}
