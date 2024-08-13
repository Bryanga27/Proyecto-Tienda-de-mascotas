
package proyectotiendademascotas;

import java.util.Scanner;


public class Proyectotiendademascotas {

    public static void main(String[] args) {
        Scanner numeros = new Scanner(System.in);
        Scanner letras  = new Scanner(System.in);
        mascotas datos[] = new mascotas[15];
        
        int op = 0;
        
        while(op != 5){
            System.out.println("--------MENU----------");
            System.out.println("1. Guardar");
            System.out.println("2. Buscar individual");
            System.out.println("3. Ver todos");
            System.out.println("4. Modificar");
            System.out.println("5. Salir");
            
            op = numeros.nextInt();
            System.out.println("------------------------------------------------");
            if(op == 1){
                System.out.println("Ingrese el id");
                int id = numeros.nextInt();
                System.out.println("Ingrese el nombre de la mascota");
                String nombrem = letras.nextLine();
                System.out.println("Ingrese el tipo de la mascota");
                String tipo = letras.nextLine();
                System.out.println(nuevamascota(id, nombrem, tipo, datos));
            
            }else if( op == 2){
                System.out.println("Ingrese el id");
                int id = numeros.nextInt();
                System.out.println(buscarmascota(id, datos));
            }else if(op == 3){
                System.out.println(vertodomascotas(datos));
            }else if(op == 4){
                System.out.println("Ingrese el id");
                int id = numeros.nextInt();
                if(modmascota(id, datos))
                    System.out.println("Ingrese nombre");
                    String nombre = letras.nextLine();
                    System.out.println("Ingrese tipo");
                    String tipo = letras.nextLine();
                    System.out.println(modificarmascota(id, nombre, tipo, datos));
            }
            
        }
        
    }
    public static String nuevamascota(int id,String nombre, String tipo, mascotas arreglo[]){
        boolean entero = true;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == null){
                arreglo[i] = new mascotas(id, nombre, tipo);
                entero = false;
                break;
            }else if(arreglo[i].getId() == id){
                return "el id ingresado ya existe en el sistema";
            }
        }
        if(!entero){
            return "se guardo exito";
        }else{
            return "nuestro sistema se ha completado";
        }
    }
    public static String buscarmascota(int clave, mascotas arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getId() == clave) {
                return "Los datos de la mascota son:" + "\n nombre:" + arreglo[i].getNombre() + "\n" + "tipo:" + arreglo[i].getTipo();

            }
        }
        return "No existe en nuestro sistema";
    }
    public static String vertodomascotas(mascotas arreglo[]){
        String espacio = "";
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] != null){
                espacio = espacio + arreglo[i].getId() + "|" + arreglo[i].getNombre() + "|" + arreglo[i].getTipo() + "\n";
            }
        }
        return espacio;
    }
    public static boolean modmascota(int id, mascotas arreglo[]){
         for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
     public static String modificarmascota(int id, String nombre, String tipo, mascotas arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getId() == id) {
                arreglo[i].setNombre(nombre);
                arreglo[i].setTipo(tipo);
                return "Los datos del sistema se han actualizado correctamente";
            }
        }
        return "";
    }
}
