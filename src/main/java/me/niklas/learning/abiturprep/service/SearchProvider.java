package me.niklas.learning.abiturprep.service;

import org.springframework.stereotype.Service;

/**
 * Created by Niklas on 2020/03/31
 */
@Service
public class SearchProvider {

    public int linearSearch(int[] array, int search) { //Sortierung egal, Array wird von vorne nach hinten überprüft
        for (int i = 0; i < array.length; i++) {
            if (array[i] == search) return i;
        }
        return -1;
    }

    public int reverseLinearSearch(int[] array, int search) { //Sortierung egal, Array wird von hinten nach vorne überprüft
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == search) return i;
        }
        return -1;
    }

    public int binarySearch(int[] array, int search) { //Voraussetzung: Sortierter Array! (aufsteigend von -undendlich zu +unendlich)
        int left = 0; //Linke Grenze
        int right = array.length - 1; //Rechte Grenze

        while (left < right) { //Grenzen nähern sich an; bei Überschneidung entweder Zahl gefunden oder gesamtes Array durchsucht!
            int middle = (left + right) / 2; //Mitte des Arrays bestimmen (es wird standardmäßig abgerundet)

            if (array[middle] < search)
                left = middle + 1; //Die gesuchte Zahl ist größer als die aktuelle Mitte -> Suche nach rechts
            else if (array[middle] > search)
                right = middle - 1; //Die gesuchte Zahl ist kleiner als die aktuelle Mitte -> Suche nach links
            else return middle; //array[mitte] == search -> Gefunden
        }
        return array[left] == search ? left : -1; //Wenn getroffener Index = gesuchter Zahl -> Index, ansonsten -1 (=nicht gefunden)
    }
}
