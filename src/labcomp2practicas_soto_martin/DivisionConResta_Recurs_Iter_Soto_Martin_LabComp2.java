
package RecursividadVsIteracion;

public class DivisionConResta_Recurs_Iter_Soto_Martin_LabComp2 {
    
   //Sin atributos//
   
    //Solucion Iterativa.
    public static int div(int dividendo, int divisor){
        if(divisor==0)return -1;//En caso de que la division no sea factible.
        int cociente = 0;
        while(dividendo >= divisor){
                dividendo = dividendo - divisor;
                cociente++;
        }
        return cociente;
    }
    //-------------------------------------------------------------------------
        //Solucion Recursiva.
        public static short div(short dividendo, short divisor) {
            if (divisor == 0) return -1;//En caso de que la division no sea factible.
            short cociente = 0;
            //Cuerpor principal de la funcion
            cociente++;
            dividendo = (short)(dividendo - divisor);
            //------------------------------
            if (divisor < dividendo){
                cociente = (short) (cociente + div(dividendo, divisor));
            }else{
                return cociente;//La funcion devuelve solamente atravez de esta linea.
            }
            return 1;//Para evitar error de compilacion
        }
        //-------------------------------------------------------------------------
    
    //Ejecucion
    public static void main(String args[]){
        
        int num,denom,aux=0;
        
        while(aux<=100){
            
            num=(short)(Math.random()*10)+9;
            denom=(short)(Math.random()*10);
            
                //Solucion Iterativa
                int resultado1 = div(num, denom);
                System.out.println("Solucion Iterativa");
                if(resultado1 < 0){
                    System.out.println("//Divsion por cero, o numerador menor al denominador//");
                }else{
                    System.out.println(num+"/"+denom+" = "+resultado1);
                }

                    //Solucion Recursiva
                    int resultado2 = div(num, denom);
                    System.out.println("Solucion Recursiva");
                    if(resultado2 < 0){
                        System.out.println("//Divsion por cero, o numerador menor al denominador//");
                    }else{
                        System.out.println(num+"/"+denom+" = "+resultado2);
                    }
                    aux++;
                    System.out.println("\n\n");
                    if(resultado1!=resultado2){
                        System.out.println(">>>ERROR<<<");
                        break;
                    }
        }
    }
    //----------------------------------------------------------------------------------------------------
}
