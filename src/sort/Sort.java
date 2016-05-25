package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {

    /**
     * @param args the command line arguments
     */
    
    private int[] array;
    private int[] tempMergArr;
    private int length;
    
    private void mainMenue() {
        int eingabe = 0;
        boolean menuewechsel = false;
        
        do {
            System.out.println("Nach welchem Sortierverfahren soll vorgegangen werden?");
            System.out.println("[1] Mergesort");
            System.out.println("[2] Quicksort");
            System.out.println("[3] Bubblesort");
            System.out.println("[4] Beenden");

            Scanner scannerVar = new Scanner(System.in);

            System.out.println("Bitte treffen Sie eine Auswahl: ");
            try {
                eingabe = scannerVar.nextInt();
            }
            catch(Exception e) {
                System.out.println("keine gültige Eingabe");
            }

            switch (eingabe) {
                case 1: mergesort();
                        break;
                case 2: quicksort();
                        break;
                case 3: bubblesort();
                        break;
                case 4: System.exit(0); 
                        break;
                default: System.out.println("Eingabefehler");
            }
        } while (!menuewechsel);
    }

    
    // Aufruf des Quicksort Algorithmus
    private void quicksort() {
        Sort sorter = new Sort();
        Scanner scan = new Scanner( System.in );
        int i = 0;
        System.out.println("Wie viele Zahlen möchten Sie sortieren? ");
        int anzahl = scan.nextInt();
        int array[] = new int[anzahl];
        while(i<anzahl) {
            System.out.println("Bitte geben Sie die nächste Zahl ein: ");
            int wert = scan.nextInt();
            array[i] = wert;
            i++;
        }
        
        System.out.println("\nZu sortierendes Array: \n" + Arrays.toString(array));
        System.out.println("Schrittweise Sortierung: \n");
        sorter.quick(array);
        System.out.println("Sortiertes Array: " + Arrays.toString(array));  
    }
    
    // Aufruf des Bubblesort Algorithmus
    private void bubblesort() {
        Sort sorter = new Sort();
        Scanner scan = new Scanner( System.in );
        int i = 0;
        System.out.println("Wie viele Zahlen möchten Sie sortieren? ");
        int anzahl = scan.nextInt();
        int array[] = new int[anzahl];
        while(i<anzahl) {
            System.out.println("Bitte geben Sie die nächste Zahl ein: ");
            int wert = scan.nextInt();
            array[i] = wert;
            i++;
        }
        
        System.out.println("\nZu sortierendes Array: \n" + Arrays.toString(array));
        System.out.println("Schrittweise Sortierung: \n");
        sorter.bubble(array);
        System.out.println("Sortiertes Array: " + Arrays.toString(array));  
    }
    
    // Aufruf des Mergesort Algorithmus
    private void mergesort() {
        Sort sorter = new Sort();
        Scanner scan = new Scanner( System.in );
        int i = 0;
        System.out.println("Wie viele Zahlen möchten Sie sortieren? ");
        int anzahl = scan.nextInt();
        int array[] = new int[anzahl];
        while(i<anzahl) {
            System.out.println("Bitte geben Sie die nächste Zahl ein: ");
            int wert = scan.nextInt();
            array[i] = wert;
            i++;
        }
        
        System.out.println("\nZu sortierendes Array: \n" + Arrays.toString(array));
        System.out.println("Schrittweise Sortierung: \n");
        sorter.merge(array);
        System.out.println("Sortiertes Array: " + Arrays.toString(array));  
    }
    
    
    /***********************************************************************************/
    /*****************************Quicksort Algorithm***********************************/
    /***********************************************************************************/
    
    public void quick(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
            
    }
    
    // SWAP Funktion von Quicksort
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        System.out.println(Arrays.toString(array));
        System.out.println("");
    }
    
    /***********************************************************************************/
    /****************************Bubblesort Algorithm***********************************/
    /***********************************************************************************/
    public void bubble(int[] inputArr) {
       boolean unsortiert=true;
       int temp;

       while (unsortiert){
          unsortiert = false;
          for (int i=0; i < inputArr.length-1; i++) 
             if (inputArr[i] > inputArr[i+1]) {                      
                temp          = inputArr[i];
                inputArr[i]   = inputArr[i+1];
                inputArr[i+1] = temp;
                unsortiert = true;
             } 
          System.out.println(Arrays.toString(inputArr));
          System.out.println("");
       } 
    }
    
    /***********************************************************************************/
    /****************************Mergesort Algorithm************************************/
    /***********************************************************************************/
    public void merge(int[] inputArr) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        mergeSort(0, length - 1);
    }
 
    private void mergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            mergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            mergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("");
    }
   
    /***********************************************************************************/
    /********************************MAIN FUNKTION**************************************/
    /**
     * @param args*********************************************************************************/
    
    public static void main(String[] args) {
        Sort s = new Sort();
        s.mainMenue();
    }
}
