# Abitur Preparation

![Java CI with Maven](https://github.com/Chromecube/abi-preparation/workflows/Java%20CI%20with%20Maven/badge.svg)

_Warning non-German speakers: All of the comments in this repository
are written in German, as my classmates may also have a look at this project. Sorry!_

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

_Hinweis: Es wurde kein Multithreading angewendet, daher könnten einige Alogrithmen dadurch schneller sein. Auf Optimierungen wurde weitesgehend verzichtet (bspw. Prüfung ob Sortierung abgeschlossen ist)._

**Simple Verschlüsselungsverfahren (Cäsar, ROT13 und Vigenére-Chiffre)**

Benchmark mit 1.000.000 Zeichen: 

Verfahren | Execution time
--- | ---
Caesar & ROT13 | 30-50ms
Vigenere (Key: ABC) | 40-60ms