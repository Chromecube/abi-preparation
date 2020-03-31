package me.niklas.learning.abiturprep.service;

import org.springframework.stereotype.Service;

/**
 * Created by Niklas on 2020/03/31
 */
@Service
public class EncryptionProvider {

    public String caesar(String text, int rotation) {
        rotation = rotation % 27; //Nur Zahlen von 0-26 zugelassen

        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            char left;
            if (c >= 'A' && c <= 'Z') { //Groß geschrieben
                left = 'A';
            } else if (c >= 'a' && c <= 'z') { //Klein geschrieben
                left = 'a';
            } else continue;

            //1. Schritt: Rotation relativ zu a/A ausrechnen: Buchstabendindex+Rotation -> charIndex(c)+rotation
            //2. Schritt: Sicherstellen, dass Alphabetsgrenze nicht überschritten wird -> %26, bei Überschreitung wird von a/A wieder weitergezählt
            //3. Schritt: Buchstabe relativ zu a/A bestimmen -> +left
            chars[i] = (char) ((charIndex(c) + rotation) % 26 + left);
        }
        return new String(chars);
    }

    public String vigenere(String text, String key) {
        char[] chars = text.toCharArray();
        char[] keys = key.replaceAll("[^a-zA-Z]", "").toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            char left;
            if (c >= 'A' && c <= 'Z') { //Groß geschrieben
                left = 'A';
            } else if (c >= 'a' && c <= 'z') { //Klein geschrieben
                left = 'a';
            } else continue;

            //1. Schritt: Rotation relativ zu a/A ausrechnen: Buchstabenindex + Index des Schlüsselbuchstaben
            //2. Schritt: Sicherstellen, dass Alphabetsgrenze nicht überschritten wird -> %26, bei Überschreitung wird von a/A wieder weitergezählt
            //3. Schritt: Buchstabe relativ zu a/A bestimmen -> +left
            chars[i] = (char) ((charIndex(c) + charIndex(keys[i % keys.length])) % 26 + left);
        }
        return new String(chars);
    }

    private int charIndex(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return c - 'A';
        return -1;
    }
}
