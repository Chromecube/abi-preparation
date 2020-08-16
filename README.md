# Abitur Preparation

![Java CI with Maven](https://github.com/Chromecube/abi-preparation/workflows/Java%20CI%20with%20Maven/badge.svg)

_Information for everyone who doesn't speak German: The entire content of this repository
is written in German (except class/method/attribute names), as this is meant to be for my graduation exam preparation only. Sorry about that! 
However, you still might find this code to be useful for you. Have fun exploring this repo!_

## Inhaltsverzeichnis

_Hier sind auch viele Benchmarks aufgelistet. Die Zeiten können von
Computer zu Computer unterschiedlich sein, jedoch sollte das Verhältnis
stets gleich bleiben._

**Suchalgorithmen (linear und binär):**

Benchmark mit 1.000.000 Integern

Suchverfahren | Execution time
--- | ---
Lineare Suche | 8-12ms
Binäre Suche | <1ms (+150-180ms Sortierzeit mit Merge Sort)

_Je größer der Datensatz, desto vorteilhafter wird die binäre Suche.
Jedoch ist diese insgesamt sehr langsam, wenn vorher noch sortiert werden muss!_

**Sortieralgorithmen (Selection, Insertion, Bubble, Quick, Merge)**

Benchmark mit 100.000 Integern

Algorithmus | Execution time
--- | ---
Selection Sort | 5.826s
Insertion Sort | 8.316s
Bubble Sort | 15.485s
Quick Sort | 0.309s
Merge Sort | 0.041s

_Hinweis: Es wurde kein Multithreading angewendet, daher könnten einige Algorithmen dadurch schneller sein. Auf Optimierungen wurde weitesgehend verzichtet (bspw. Prüfung ob Sortierung abgeschlossen ist)._

**Simple Verschlüsselungsverfahren (Cäsar, ROT13 und Vigenére-Chiffre)**

Benchmark mit 1.000.000 Zeichen: 

Verfahren | Execution time
--- | ---
Caesar & ROT13 | 30-50ms
Vigenere (Key: ABC) | 40-60ms
