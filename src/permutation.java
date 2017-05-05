import java.util.Arrays;

/**
 * Created by Rackenrotz on 19.11.15.
 */
public class permutation {


    private int[] p;

    //Konstruktor
    public permutation(int p) {
        this.p = new int[p]; // größe des Arrays
        fillP(); // füllt den Array aufsteigend von 1 - n
        fac(); //berechnet die Anzahl der Permutationen und führt diese aus
    }

    //berechnet die Anzahl der Permutationen
    private void fac() {
        int fakultät = this.p.length;
        for (int j = 1; j <= this.p.length - 1; j++) {
            fakultät = fakultät * j;
        }


        //Alle Möglichkeiten
        for (int i = 0; i < fakultät; i++) {
            System.out.println(Arrays.toString(this.p));
            perm();
        }

        System.out.println("");
        System.out.println(fakultät + " Permutationen");


    }

    // füllt den Array von 1-n
    private void fillP() {
        for (int i = 0; i < p.length; i++) {
            p[i] = i + 1;
        }
    }

    // führt die permutation durch
    private void perm() {

        int biggest = 0;
        int smallest = 0;
        int smallestvalue = Integer.MAX_VALUE;

        //1.Schritt
        for (int i = 0; i < p.length - 1; i++) {

            if (p[i] < p[i + 1]) {

                if (biggest < i) {
                    biggest = i;
                }
            }


        }

        // 2.Schritt
        for (int j = biggest + 1; j < p.length; j++) {

            if (p[biggest] < p[j]) {
                if (smallestvalue > p[j]) {
                    smallestvalue = p[j];
                    smallest = j;

                }
            }

        }
        //3.Schritt
        switching(biggest, smallest);

        //4.Schritt
        sort(biggest);

    }


    // Methode die bestimmte Arraystellen tauscht
    private void switching(int a, int b) {
        // Tauschvariablen
        int switch1 = p[a];
        int switch2 = p[b];
        // Tausch
        p[a] = switch2;
        p[b] = switch1;

    }

    //Sortiert nach Aufgabenstellung immer i+1 und n-1 usw.
    private void sort(int biggest) {
        // berechent die Mitte zwischen biggest und n
        int border = (p.length - biggest) / 2;
        // verechnet welche Werte miteinander getauscht werden müssen
        int counter = 0;
        for (int i = biggest + 1; i < p.length - border; i++) {
            switching(i, p.length - 1 - counter);
            counter++;

        }
    }

    public static void main(String[] args) {

        /* 9 stellen sind noch machbar, ab 10 wird es deutlich aufwendiger
           da hier bereits das 10 Fache zur 9 berechnet werden muss! allderings
           noch möglich. Ab 11 nur mit großem Zeitaufwand darstellbar (110 Fache gegenüber 9).
        */

        long startTime = System.currentTimeMillis();
        permutation a = new permutation(10);
        long endTime   = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        System.out.println(totalTime/1000);



    }
}
