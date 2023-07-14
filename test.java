import java.util.Random;
public class test {
        public static void main(String[] args) throws Exception {
        // Random r1 = new Random();
        // Random r2 = new Random(47);
        // Random r3 = new Random(47); // r2 y r3 darán la misma secuencia.
        
        

        
        // int n1 = r1.nextInt();
        // int n2 = r2.nextInt(10); // número aleatorio entre 0 y 9 (el 10 es exclusive)
        // int n3 = r3.nextInt(10); // obtendremos el mismo número aleatorio que n2, ya que ambos usan la misma semilla
                
        // System.out.println("n1: " + n1);
        // System.out.println("n2: " + n2);
        // System.out.println("n3: " + n3);
    

   
    
        // String str = "C";
        // char ch = '+';
 
        // str = new StringBuilder(str).append(ch).append(ch).toString();
 
        // System.out.println(str);            // C++

        // String str = "";
        // int ch = 1;
 
        // str = new StringBuilder(str).append(ch).append(ch).toString();
 
        // System.out.println(str);            // C++

        // String dni = "";
        // for (int i=0; i<8; i++){
        //     Random random = new Random();
        //     int digito = random.nextInt(10);
        //     dni = new StringBuilder(dni).append(digito).toString();

        // }
        // int number = Integer.parseInt(dni);
        // System.out.println(dni);            
        // System.out.println(number);            

        String dni = "";
        for (int i=0; i<8; i++){
            Random random = new Random();
            int digito = random.nextInt(10);
            dni = new StringBuilder(dni).append(digito).toString();
        }
        int dniNumber = Integer.parseInt(dni);
        int modulo = dniNumber%23;
        System.out.println("primer dni"+ dni);            

        System.out.println("modulo "+ modulo);            

        switch (dniNumber%23){
            case 0: dni = new StringBuilder(dni).append('T').toString();
                    break;
            case 1: dni = new StringBuilder(dni).append('R').toString();
                    break;
            case 2: dni = new StringBuilder(dni).append('W').toString();
                    break;
            case 3: dni = new StringBuilder(dni).append('A').toString();
                    break;
            case 4: dni = new StringBuilder(dni).append('G').toString();
                    break;
            case 5: dni = new StringBuilder(dni).append('M').toString();
                    break;
            case 6: dni = new StringBuilder(dni).append('Y').toString();
                    break;
            case 7: dni = new StringBuilder(dni).append('F').toString();
                    break;
            case 8: dni = new StringBuilder(dni).append('P').toString();
                    break;
            case 9: dni = new StringBuilder(dni).append('D').toString();
                    break;
            case 10: dni =new StringBuilder(dni).append('X').toString();
                    break;
            case 11: dni = new StringBuilder(dni).append('B').toString();
                    break;
            case 12: dni = new StringBuilder(dni).append('N').toString();
                    break;
            case 13: dni = new StringBuilder(dni).append('J').toString();
                    break;
            case 14: dni = new StringBuilder(dni).append('Z').toString();
                    break;
            case 15: dni = new StringBuilder(dni).append('S').toString();
                    break;
            case 16: dni = new StringBuilder(dni).append('Q').toString();
                    break;
            case 17: dni = new StringBuilder(dni).append('V').toString();
                    break;
            case 18: dni = new StringBuilder(dni).append('H').toString();
                    break;
            case 19: dni = new StringBuilder(dni).append('L').toString();
                    break;
            case 20: dni = new StringBuilder(dni).append('C').toString();
                    break;
            case 21: dni = new StringBuilder(dni).append('K').toString();
                    break;
            case 22: dni = new StringBuilder(dni).append('E').toString();
                    break;
            default: 
                    break;
        }
        System.out.println("dn1 con letra "+dni);            

    }
}

