import java.util.*;
/* 
Para recibir un dato por consola JAVA hace uso de la libreria Scanner, por lo que 
se instancia un objeto de esta clase y se hace la lectura por consola.
Se debe tener presente el tipo de dato que se esta ingresando por teclado.

Para imprimir se hace uso de la función System.out.println()
*/
public class Lectura_escritura {
    
    public static void main(String[] args) throws Exception {
        //declaración de variables
        int n1, n2;
        Scanner sc = new Scanner(System.in);
        //leer el primer número 
        System.out.println("Introduce un número entero: ");                                                       
        n1 = sc.nextInt();      //lee un entero por teclado
        
        System.out.println("El número ingresado fue: ");                                                       
        System.out.println(n1);                                                       

        

    }
    
    
}