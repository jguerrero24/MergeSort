import java.util.Random;

public class MergeSort {
    
    public static void mergeSort(int[] arreglo) { 
        if (arreglo == null || arreglo.length <= 1) { // se valida si el arreglo es nulo o si es menor o igual a 1, si es asi regresa el unico numero 
            return;
        }
        
        int[] arregloTempoDos = new int[arreglo.length]; // se crea el segundo arreglo que servira para la segunda matriz
        mergeSortReordenamiento(arreglo, arregloTempoDos,0, arreglo.length - 1); // se llama al metodo que se encargara del reordenamiento y la divison
    }
    
    private static void mergeSortReordenamiento(int[] arregloTempoUno, int[] arregloTempoDos, int proceso, int inverso) {  //metodo que se encarga de dividir y ordenar
        if  (proceso >= inverso) { // si, proceso es igual a inverso ya esta ordenado
            return;
        }
        
        int mitadArreglo = proceso + (inverso - proceso) / 2; // proceso sera la cantidad de elementos que quede de la resta del arreglo inverso y proceso, este se divide entre 2
        mergeSortReordenamiento(arregloTempoUno, arregloTempoDos, proceso, mitadArreglo); // se llama el metodo para ordenar el primer arreglo de forma inversa
        mergeSortReordenamiento(arregloTempoUno, arregloTempoDos, mitadArreglo + 1, inverso); // se llama el metodo para ordenar el segundo arreglo de forma inversa
        merge(arregloTempoUno, arregloTempoDos, proceso, mitadArreglo, inverso); // se llama el metodo encargado de combinar los dos arreglos ordenados y los pone en una seccion
    }
    
    
    private static void merge(int[] arregloTempoUno, int[] arregloTempoDos, int proceso, int mitadArreglo, int inverso) { //metodo que se encarga de combinar los dos arreglos ordenados en una seccion
        for (int i = proceso; i <= inverso; i++) { // ciclo que sirve para indicar que el contador sera igual a proceso y stede debe ser menor o igual a inverso y sumar un campo
            arregloTempoDos[i] = arregloTempoUno[i]; // se copia el contenido de la seccion del arreglo uno al dos
        }
        
        //durante el proceso se comparan las posiciones del arregloUno con el arregloDos, y se colocan en acopladorArreglo y se suma el indice

        int contadorPrimerArreglo = proceso; //indice para recorrer la primera mitad del arreglo ordenado, este inicia en "proceso" y llega hasta "mitadArreglo"
        int contadorSegundoArreglo = mitadArreglo + 1; //indice para recorrer la segunda mitad del arreglo ordenado, incia en "mitadArreglo" + 1 y avanza hasta inverso
        int acompladorArreglos = proceso; //indice para recorrer el arreglo original y colocar los elementos combinados en orden correcto, comienza desde "proceso" hasta "inverso" 
        


        while (contadorPrimerArreglo <= mitadArreglo && contadorSegundoArreglo <= inverso) { // mientras arregloUno y arregloDos tengan elementos
            if (arregloTempoDos[contadorPrimerArreglo] >= arregloTempoDos[contadorSegundoArreglo]) { //se compara los elementos de cada arreglo para ver cual es menor
                arregloTempoUno[acompladorArreglos] = arregloTempoDos[contadorPrimerArreglo]; // se coloca el elemento del primer arreglo en la posicion correspondiente
                contadorPrimerArreglo++;
            } else {
                arregloTempoUno[acompladorArreglos] = arregloTempoDos[contadorSegundoArreglo]; // se coloca el elemento del segundo arreglo en la posicion correspondiente
                contadorSegundoArreglo++;
            }
            acompladorArreglos++;
        }
        
        while (contadorPrimerArreglo <= mitadArreglo) { //mientras el contador sea menor o igual a la "mitadArreglo"
            arregloTempoUno[acompladorArreglos] = arregloTempoDos[contadorPrimerArreglo]; // en cada ciclo se coloca el elemento del arregloUno en el arreglo orginal
            contadorPrimerArreglo++;
            acompladorArreglos++;
        }
    }
    
    public static void main(String[] args) {
        
        /* 
        int[] arregloTempoUno = {10,5,8};
        
        mergeSort(arregloTempoUno);
        
        for (int num : arregloTempoUno) {
            System.out.print(num + " ");
            
        }
        */


        Random numAzar = new Random();
        int cantidadElementos = numAzar.nextInt(10) + 1; // genera un número numAzar entre 1 y 10
        int[] arregloTempoUno = new int[cantidadElementos]; // se crea la cantidad de elementos que tendra el arreglo
        for (int i = 0; i < cantidadElementos; i++) {
            arregloTempoUno[i] = numAzar.nextInt(100); // genera los número que estaran dentro del arreglo entre 0 y 99
        }
        
        // Mostrar el arreglo antes de ordenar
        System.out.println("Arreglo original:");
        for (int num : arregloTempoUno) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Ordenar el arreglo
        mergeSort(arregloTempoUno);
        
        // Mostrar el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int num : arregloTempoUno) {
            System.out.print(num + " ");
        }
    }
}
