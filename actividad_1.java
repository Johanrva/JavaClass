import java.util.Random;
import java.util.Scanner;

public class actividad_1 {
    public static void main(String[] args) {
        String nombre = "";
        short edad = 0;
        String sex = "";
        double peso = 0;
        double altura = 0;

        Scanner in = new Scanner( System.in );

        System.out.print("Ingrese el nombre : ");                                              
        nombre = in.next();

        System.out.print("Ingrese la edad : ");                                              
        edad = in.nextShort();

        System.out.print("Ingrese el sexo (H o M): ");                                              
        sex = in.next();

        char sexo;
        if (sex == "H"){
            sexo = 'H';
        } else if (sex == "M"){
            sexo = 'M';
        } else {
            sexo='H';
        }
        System.out.print("Ingrese el peso en kg : ");                                              
        peso = in.nextDouble();

        System.out.print("Ingrese la altura en m : ");                                              
        altura = in.nextDouble();

        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();
        persona3.setNombre("Nathalia");
        short edad2=21;
        persona3.setEdad(edad2);
        persona3.setSexo('M');
        persona3.setPeso(60);
        double altura2 = 1.60; 
        persona3.setAltura(altura2);

        int masaCorporal1 = persona1.calcularMC();
        switch (masaCorporal1){
            case -1: System.out.println("Persona 1 esta en su peso ideal");   
                break;
            case 0: System.out.println("Persona 1 esta bajo de peso");   
                break;
            case 1: System.out.println("Persona 1 esta en sobrepeso");   
                break;
            default: System.out.println("Fallo al calcular MC");   
                break;
        }
        int masaCorporal2 = persona2.calcularMC();
        switch (masaCorporal2){
            case -1: System.out.println("Persona 2 esta en su peso ideal");   
                break;
            case 0: System.out.println("Persona 2 esta bajo de peso");   
                break;
            case 1: System.out.println("Persona 2 esta en sobrepeso");   
                break;
            default: System.out.println("Fallo al calcular MC");   
                break;
        }
        int masaCorporal3 = persona3.calcularMC();
        switch (masaCorporal3){
            case -1: System.out.println("Persona 3 esta en su peso ideal");   
                break;
            case 0: System.out.println("Persona 3 esta bajo de peso");   
                break;
            case 1: System.out.println("Persona 3 esta en sobrepeso");   
                break;
            default: System.out.println("Fallo al calcular MC");   
                break;
        }

        System.out.println("¿Persona 1 es mayor de edad?"+persona1.esMayorDeEdad());   
        System.out.println("¿Persona 2 es mayor de edad?"+persona2.esMayorDeEdad());   
        System.out.println("¿Persona 3 es mayor de edad?"+persona3.esMayorDeEdad());   


        persona1.toString();
        persona2.toString();
        persona3.toString();
    }
}    

class Persona {
    // Atributos
    private String nombre = "";
    private short edad = 0;
    private String DNI="";
    private char sexo;
    private double peso = 0;
    private double altura = 0;
    
    // constante 
static final char sexodefault = 'H'; 

// multiples constructores
public Persona (){
        this.sexo = sexodefault;
        this.DNI = generaDNI();

    }

    public Persona (String nombre, short edad, char sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexodefault;
        this.DNI = generaDNI();

    }

    public Persona (String nombre, short edad, char sexo, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = generaDNI();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    // Metodos
    public int calcularMC () {
        final short pesoIdeal = -1;
        final short bajoPeso = 0;
        final short sobrePeso = 1;

        double calculadora = (this.peso)/(this.altura*this.altura); 
        
        if (calculadora < 20){
            return pesoIdeal;
        } else if (calculadora <=25 ){
            return bajoPeso;
        } else {
            return sobrePeso;
        }
    }

    public boolean esMayorDeEdad (){
        if (this.edad >=18){
            return true;
        } else{
            return false;
        }
    }

    public void comprobarSexo(char sexo){
        if (sexo != this.sexo){
            this.sexo = sexodefault;
        }
    }

    public String toString(){
        System.out.println("Nombre: "+this.nombre); 
        System.out.println("Edad: "+this.edad); 
        System.out.println("Sexo: "+this.sexo); 
        System.out.println("DNI: "+this.DNI); 
        System.out.println("Peso: "+this.peso); 
        System.out.println("Altura: "+this.altura); 
        return "." ;                                          
    }

    private String generaDNI(){
        String dni = "";
        for (int i=0; i<8; i++){
            Random random = new Random();
            int digito = random.nextInt(10);
            dni = new StringBuilder(dni).append(digito).toString();
        }
        int dniNumber = Integer.parseInt(dni);
        
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

        return dni;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    
    public void setEdad(short edad){
        this.edad=edad;
    }

    
    public void setSexo(char sexo){
        this.sexo=sexo;
    }
    
    public void setPeso(double peso){
        this.peso=peso;
    }
    
    public void setAltura(double altura){
        this.altura=altura;
    }

}