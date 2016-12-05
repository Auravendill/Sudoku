// Kompletter Beispielbefehl fuer Eingabe-Test in der Kommandozeile:
// -c10 -l3 -oLokalesVerzeichnis -h -s -dStandarddrucker -f

// Optionen der Kommandozeileneingabe:
	// -c: Anzahl der Sudokus
	// -l: Schwierigkeitsstufe
	// -o: Speicherort
	// -h: Hilfe anzeigen
	// -s: Regeln anzeigen
	// -d: Standarddrucker
	// -f: beschreibbares Formular ausgeben

//package Sudoku;

// Import fuer die einzelnen Sudokus
import java.util.ArrayList;

// Importe fuer die Ausgabe der Hilfe- bzw. Regel-Datei
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class SudokuMain {

  public static void main(String args[]) {

// ============================================================================

// Variablen fuer die einzelnen Programmoptionen

		// Variable fuer die Anzahl der zu erstellenden Sudokus; standardmaessig 1
    int cnt = 0;
		// Variable fuer die Schwierigkeitsstufe
    int lvl = 0;
    // Variable fuer den Speicherort des/der Sudokus
    String slc = "Kein Speicherverzeichnis";
    // Variable fuer die Ausgabe der Hilfe
    boolean hlp = false;
    // Variable fuer die Ausgabe der Sudoku-Regeln
    boolean rls = false;
    // Variable fuer den Drucker
    String prt = "Keine Druckoption";
    // Variable fuer die Ausgabe als beschreibbares Formular
    boolean pdf = false;

// Ende von: Variablen fuer die einzelnen Programmoptionen

// ============================================================================


// ============================================================================

// Abfrage auf die Optionen in der Kommandozeile

    for( int i = 0; i < args.length; i++ ) {
			// Abfrage auf die Anzahl der Sudokus
			if(args[i].contains("-c")) {
				if((args[i].charAt(2) >= 49) && (args[i].charAt(2) <= 57)) {
					if(args[i].length() == 3) {
						cnt = args[i].charAt(2) - '0';
					}
					else {
						if((args[i].charAt(2) == '1') && (args[i].charAt(3) <= '0')) {
							cnt = 10;
						}
					}
				}
			}

			// Abfrage auf die Schwierigkeitsstufe
			if(args[i].contains("-l")) {
				if((args[i].charAt(2) >= 49) && (args[i].charAt(2) <= 51)) {
					lvl = args[i].charAt(2) - '0';
				}
			}

			// Abfrage auf den Speicherort
			if(args[i].contains("-o")) {
				slc = args[i].substring(2);
			}

			// Abfrage auf die Anzeige der Hilfe
			if(args[i].contains("-h")) {
				hlp = true;
			}

			// Abfrage auf die Anzeige der Sudoku-Regeln
			if(args[i].contains("-s")) {
				rls = true;
			}
			// Abfrage auf den Drucker
			if(args[i].contains("-d")) {
				prt = args[i].substring(2);
			}

			// Abfrage auf das Speichern als beschreibbares Formular
			if(args[i].contains("-f")) {
				pdf = true;
			}
		}

// Ende von: Abfrage auf die Optionen in der Kommandozeile

// ============================================================================
// ============================================================================


// ============================================================================
// ============================================================================


// Abfragen auf gefundene Optionen und dementsprechend verschiedene Ablaeufe


// ============================================================================

// Abfrage auf die Ausgabe der Hilfe

		if(hlp == true) {
			BufferedReader br = null;
			try {
				String str = "";
				br = new BufferedReader(new FileReader("Hilfe.txt"));
				System.out.println("\n");
				while((str = br.readLine()) != null) {
					System.out.println(str);
				}
				System.out.println("\n");
			}
			catch (IOException e) {
				System.out.println(e.getMessage() + "\nDie Hilfe-Datei wurde nicht gefunden!");
			}
			finally {
				try {
					if (br != null) br.close();
				}
				catch (IOException e) {
					System.out.println(e.getMessage() + "\nDie Hilfe-Datei wurde nicht gefunden!");
				}
			}
		}

// Ende von: Abfrage auf die Ausgabe der Hilfe

// ============================================================================


// ============================================================================

// Abfrage auf die Ausgabe der Regeln

		if(rls == true) {
			BufferedReader br = null;
			try {
				String str = "";
				br = new BufferedReader(new FileReader("Regeln.txt"));
				System.out.println("\n");
				while((str = br.readLine()) != null) {
					System.out.println(str);
				}
				System.out.println("\n");
			}
			catch (IOException e) {
				System.out.println(e.getMessage() + "\nDie Regel-Datei wurde nicht gefunden!");
			}
			finally {
				try {
					if (br != null) br.close();
				}
				catch (IOException e) {
					System.out.println(e.getMessage() + "\nDie Regel-Datei wurde nicht gefunden!");
				}
			}
		}

// Ende von: Abfrage auf die Ausgabe der Regeln

// ============================================================================


// ============================================================================

// Weder Hilfe noch Regeln sollen ausgegeben werden: Sudokus erstellen

		if((rls == false) && (hlp == false)) {
			// Liste fuer die zu erstellenden Spiele
			ArrayList<Sudoku> list = new ArrayList<Sudoku>();
			// Sudoku-Variable fuer die Iteration
			Sudoku sud = null;
			for(int i = 0; i < cnt; i++) {
				sud = new Sudoku();
				list.add(sud);
			}

// Ende von: Weder Hilfe noch Regeln sollen ausgegeben werden: Sudokus erstellen

// ============================================================================


// ============================================================================

// DEBUGGING: sind die Sudokus korrekt gefuellt worden?

			// Dazu statt "cnt" (5 Zeilen hier drueber) eine Zahl eingeben
			for(Sudoku s : list) {
				System.out.println(s.toString() + "\n\n");
			}

// Ende von: DEBUGGING: sind die Sudokus korrekt gefuellt worden?

// ============================================================================


// ============================================================================

// Code fuer die Reduktion auf die Schwierigkeitsstufe


// Ende von: Code fuer die Reduktion auf die Schwierigkeitsstufe

// ============================================================================



// ============================================================================

// Code fuer die Ausgabe der Sudokus als pdf

// Ende von: Code fuer die Ausgabe der Sudokus als pdf

// ============================================================================


// ============================================================================

// Code fuer das Drucken der Sudokus

// Ende von: Code fuer das Drucken der Sudokus

// ============================================================================


// ============================================================================

// Code fuer die Ausgabe der Sudokus als beschreibbares Formular

// Ende von: Code fuer die Ausgabe der Sudokus als beschreibbares Formular

// ============================================================================


		}


// Ende von: Weder Hilfe noch Regeln sollen ausgegeben werden: Sudokus erstellen

// ============================================================================		
// ============================================================================		


// ============================================================================

// DEBUGGING der Eingabe/des Parsers

		/*System.out.println("");
		System.out.println("Anzahl Sudokus:          " + cnt + "\n" +
											 "Schwierigkeitsgrad:      " + lvl + "\n" +
											 "Speicherort:             " + slc + "\n" +
											 "Hilfe anzeigen:          " + hlp + "\n" +
											 "Regeln anzeigen:         " + rls + "\n" +
											 "Beschreibbares Formular: " + pdf + "\n" +
											 "Ausdrucken:              " + prt + "\n");*/

// Ende von: DEBUGGING der Eingabe/des Parsers

// ============================================================================


// ============================================================================

// Test fuer die Ausgabe eines geloesten Sudokus
		
		/*
		
		Sudoku sud_1 = new Sudoku();
		Solver test = new SolverEasy();
		System.out.println("Solvable: "+test.solvable(sud_1));
		System.out.println("\nOriginal:\n" + sud_1 + "\n\n");
		
		*/				

// Ende von: Test fuer die Ausgabe eines geloesten Sudokus

// ============================================================================


// ============================================================================

// Test fuer die Ausgabe eines gefuellten Sudokus

		
    /*
		Sudoku sud_1 = new Sudoku();
    System.out.println("\n" + sud_1.toString() + "\n\n");

	*/

// Ende von: Test fuer die Ausgabe eines gefuellten Sudokus

// ============================================================================

  }
}
