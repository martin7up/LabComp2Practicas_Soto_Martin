
package RecursividadVsIteracion;

public class Factorial_Iterativo_Recursivo_Soto_Martin_LabComp2 {
    
    //Sin atributos
    
    //Solucion Iterativa
    public static long factoRial(long nump){
        if(nump == 1 || nump == 0)return 1;
        long aux = nump;
        for(int i = 1; i<aux; i++){
            nump = nump*(aux-i);
        }
        return nump;
    }
    //-----------------------------------------
    
    //Solucion Recursiva
    public static long factoRial(long nump, Object referenciaNula){
        if(nump == 1 || nump == 0){
            return 1;
        }else{
            nump = nump*factoRial(nump-1, null);
        }
        return nump;
    }
    //---------------------------------------------------------------------
    
    
    public static void main(String args[]){
        
        for(long i = 20; i>=0; i--){
            System.out.println("Metodo Iterativo : >>> "+"("+i+")!"+" = "+factoRial(i));
            System.out.println("Metodo Recursivo : >>> "+"("+i+")!"+" = "+factoRial(i, null)+"\n\n");
        }
    }
}
