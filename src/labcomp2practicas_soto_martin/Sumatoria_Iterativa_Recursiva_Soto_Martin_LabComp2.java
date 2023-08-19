
package RecursividadVsIteracion;

import java.util.Scanner;

public class Sumatoria_Iterativa_Recursiva_Soto_Martin_LabComp2 {

    
    //Sin atributos
    
    static Scanner sc = new Scanner(System.in);
    //Solucion Iterativa
    public static int sumaToria(int nump){    
        int acum =  0;
        for(int i = 0; i<=nump; i++){
            acum = acum + i;
        }
            return acum;
    }
    //------------------------------------------------------------------------------------------
    
    //Solucion Recursiva
    public static int sumaToria(long nump){
       long aux = nump-1;
       if(aux == 0){
            return (int)nump;
        }else{
          nump = nump + sumaToria(aux);  
        }
            return (int)nump;
    }
    //-------------------------------------------------------------------------------------------------------
    
    //Ejecucion
    public static void main(String args[]){
        
        System.out.print("Este programa calcula las sumas consecutivas desde 0 hasta donde se indique.\n"+
        "Ejemp :  0+1+2+3+...+199\n"+
        "Valor hasta el cual sumar desde cero ¿? >>> : ");
        
        int num = sc.nextInt();
        int resultado1, resultado2;
        resultado1 = sumaToria(num);
        resultado2 = sumaToria(num);
        System.out.println("Metodo Iterativo >>> "+resultado1);
        System.out.println("Metodo Recursivo >>> "+resultado2);
        
    }
    //-----------------------------------------------------------------------------------------------------------
    
}
