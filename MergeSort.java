
import java.util.Random;

public class MergeSort {

    public static void mergeSort(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) { // se valida si el arreglo es nulo o si es menor o igual a 1, si
                                                      // es asi regresa el unico numero
            return;
        }

        int[] depositoArreglo = new int[arreglo.length]; // se crea el segundo arreglo que servira para almacenar los
                                                         // datos ordenados
        mergeSortReordenamiento(arreglo, depositoArreglo, 0, arreglo.length - 1); // se llama al metodo que se encargara
                                                                                  // del reordenamiento y la divison del
                                                                                  // arreglo ori se pasa como parametro
                                                                                  // el arreglo original, el deposito
                                                                                  // temporal de ordenamiento, el indice
                                                                                  // donde inicia y el indice donde
                                                                                  // finaliza
    }

    private static void mergeSortReordenamiento(int[] originalArreglo, int[] depositoArreglo, int indiceInicio,
            int indiceFin) { // metodo que se encarga de dividir y ordenar
        if (indiceInicio >= indiceFin) { // si, "indiceInicio" es igual a "indiceFin" ya esta ordenado
            return;
        }

        int mitadArreglo = indiceInicio + (indiceFin - indiceInicio) / 2; // calcula el índice de la mitad del arreglo,
                                                                          // [10] 0 + (9 - 0) / 2 (indiceInicio es 0 ya
                                                                          // que es el indice incial);
        mergeSortReordenamiento(originalArreglo, depositoArreglo, indiceInicio, mitadArreglo); // se llama el metodo
                                                                                               // para ordenar el primer
                                                                                               // arreglo de forma
                                                                                               // inversa
        mergeSortReordenamiento(originalArreglo, depositoArreglo, mitadArreglo + 1, indiceFin); // se llama el metodo
                                                                                                // para ordenar el
                                                                                                // segundo arreglo de
                                                                                                // forma inversa
        merge(originalArreglo, depositoArreglo, indiceInicio, mitadArreglo, indiceFin); // se llama el metodo encargado
                                                                                        // de combinar los dos arreglos
                                                                                        // ordenados y los pone en una
                                                                                        // seccion


        //Imprime el proceso de division
        System.out.println("Proceso de ordenamiento en subarreglo: " + indiceInicio + " a " + indiceFin);
        for (int i = indiceInicio; i <= indiceFin; i++) {
            System.out.print(originalArreglo[i] + " ");
        }
        System.out.println();
    }

    private static void merge(int[] originalArreglo, int[] depositoArreglo, int indiceInicio, int mitadArreglo,
            int indiceFin) { // metodo que se encarga de combinar los dos arreglos ordenados en una seccion
        for (int i = indiceInicio; i <= indiceFin; i++) { // ciclo que sirve para indicar que el contador sera igual a
                                                          // indiceInicio y stede debe ser menor o igual a indiceFin y
                                                          // sumar un campo
            depositoArreglo[i] = originalArreglo[i]; // se copia el contenido de la seccion del arreglo uno al dos
        }

        // durante el indiceInicio se comparan las posiciones del arregloUno con el
        // arregloDos, y se colocan en acopladorArreglo y se suma el indice

        int contadorPrimerArreglo = indiceInicio; // indice para recorrer la primera mitad del arreglo ordenado, este
                                                  // inicia en "indiceInicio" y llega hasta "mitadArreglo"
        int contadorSegundoArreglo = mitadArreglo + 1; // indice para recorrer la segunda mitad del arreglo ordenado,
                                                       // incia en "mitadArreglo" + 1 y avanza hasta indiceFin
        int acompladorArreglos = indiceInicio; // indice para recorrer el arreglo original y colocar los elementos
                                               // combinados en orden correcto, comienza desde "indiceInicio" hasta
                                               // "indiceFin"

        while (contadorPrimerArreglo <= mitadArreglo && contadorSegundoArreglo <= indiceFin) { // mientras arregloUno y
                                                                                               // arregloDos tengan
                                                                                               // elementos
            if (depositoArreglo[contadorPrimerArreglo] <= depositoArreglo[contadorSegundoArreglo]) { // se compara los
                                                                                                     // elementos de
                                                                                                     // cada arreglo
                                                                                                     // para ver cual es
                                                                                                     // menor
                originalArreglo[acompladorArreglos] = depositoArreglo[contadorPrimerArreglo]; // se coloca el elemento
                                                                                              // del primer arreglo en
                                                                                              // la posicion
                                                                                              // correspondiente
                contadorPrimerArreglo++;
            } else {
                originalArreglo[acompladorArreglos] = depositoArreglo[contadorSegundoArreglo]; // se coloca el elemento
                                                                                               // del segundo arreglo en
                                                                                               // la posicion
                                                                                               // correspondiente
                contadorSegundoArreglo++;
            }
            acompladorArreglos++;
        }

        while (contadorPrimerArreglo <= mitadArreglo) { // mientras el contador sea menor o igual a la "mitadArreglo"
            originalArreglo[acompladorArreglos] = depositoArreglo[contadorPrimerArreglo]; // en cada ciclo se coloca el
                                                                                          // elemento del arregloUno en
                                                                                          // el arreglo orginal
            contadorPrimerArreglo++;
            acompladorArreglos++;
        }
    }

    public static void main(String[] args) {

        
          int[] originalArreglo = {10,5,8,9,2,3,1,6};
          
          mergeSort(originalArreglo);
          
          for (int num : originalArreglo) {
          System.out.print(num + " ");
         
          }       

        /* Random numAzar = new Random();
        int cantidadElementos = numAzar.nextInt(10) + 1; // genera un número numAzar entre 1 y 10
        int[] arreglo = new int[cantidadElementos]; // se crea la cantidad de elementos que tendra el arreglo
        for (int i = 0; i < cantidadElementos; i++) {
            arreglo[i] = numAzar.nextInt(100) + 1; // genera los número que estaran dentro del arreglo entre 0 y 99
        }

        // Mostrar el arreglo antes de ordenarcls
        System.out.println("Arreglo original:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Ordenar el arreglo
        mergeSort(arreglo);

        // Mostrar el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        } */
    }
}
