package ram;

public class User {

	/**
	 * Die main-Methode, die das Programm startet.
	 *
	 * @param args Die Befehlszeilenargumente (nicht verwendet).
	 */
	public static void main(String[] args) {

		// TESTING START
		String[] cmdsAddition = { "HLT 0", "LDA 2", // Lade die Zahl 10 in den Akkumulator
				"ADD 3", // Addiere die Zahl 25 zum Akkumulator
				"STA 4", // Speichere das Ergebnis im Speicherplatz 4
				"HLT 0" // Halte das Programm
		};
		String[] memAddition = { "10", "25", "10", "25", "0" };

		Program additionProgram = new Program("addition.txt", cmdsAddition, memAddition);

		// TESTING ENDE

		// DIVISON START
		String[] cmdsDivision = { "LDA 1", // Laden der Dividend (21)
				"STA 0", // Speichern des Dividenden im Speicher (Adresse 0)
				"LDA 2", // Laden des Divisors (7)
				"STA 1", // Speichern des Divisors im Speicher (Adresse 1)
				"LDA 0", // Laden des Dividenden aus dem Speicher
				"SUB 1", // Subtrahieren des Divisors vom Dividenden
				"JMZ 12", // Springen zur Adresse 12, wenn das Ergebnis 0 ist (Division abgeschlossen)
				"LDA 3", // Laden des Zwischenergebnisses (Quotient)
				"ADD 4", // Addieren 1 zum Zwischenergebnis
				"STA 3", // Speichern des aktualisierten Zwischenergebnisses (Quotient)
				"JMP 5", // Springen zur Adresse 5 (erneute Durchführung der Division)
				"HLT 0" // Beenden des Programms
		};
		String[] memDivision = { "21", "7", "0", "0", "0" };

		Program divisionProgram = new Program("division.txt", cmdsDivision, memDivision);
		;

		// DIVISON ENDE

		// Multiplikation Start

		String[] cmdsMultiplication = {
			    "LDA 1",      // Laden des Multiplikator (2)
			    "STA 0",      // Speichern des Multiplikators im Speicher (Adresse 0)
			    "LDA 2",      // Laden des Multiplikanden (3)
			    "STA 1",      // Speichern des Multiplikanden im Speicher (Adresse 1)
			    "LDA 0",      // Laden des Multiplikators aus dem Speicher
			    "SUB 3",      // Überprüfen, ob der Multiplikator 0 ist
			    "JMZ 9",      // Springen zur Adresse 9, wenn der Multiplikator 0 ist (Multiplikation abgeschlossen)
			    "LDA 4",      // Laden des Zwischenergebnisses (Produkt)
			    "ADD 1",      // Addieren des Multiplikanden zum Zwischenergebnis
			    "STA 4",      // Speichern des aktualisierten Zwischenergebnisses (Produkt)
			    "LDA 0",      // Laden des Multiplikators aus dem Speicher
			    "SUB 5",      // Subtrahieren 1 vom Multiplikator
			    "STA 0",      // Speichern des aktualisierten Multiplikators im Speicher
			    "JMP 5",      // Springen zur Adresse 5 (erneute Durchführung der Multiplikation)
			    "HLT 0"       // Beenden des Programms
			};
			String[] memMultiplication = { "2", "3", "0", "0", "0", "1" };

			Program multiplicationProgram = new Program("multiplication.txt", cmdsMultiplication, memMultiplication);

		// Multiplikation Ende

		// FIBONACCCI START
		String[] cmdsFibonacci = { "LDA 2", // Lade den ersten Fibonacci-Wert (6) in den Akkumulator
				"ADD 3", // Addiere den zweiten Fibonacci-Wert (1) zum Akkumulator
				"STA 4", // Speichere das Ergebnis im Speicherplatz für das nächste Fibonacci-Paar
				"LDA 3", // Lade den zweiten Fibonacci-Wert (1) in den Akkumulator
				"STA 2", // Speichere den zweiten Fibonacci-Wert im Speicherplatz für das nächste
							// Fibonacci-Paar
				"LDA 4", // Lade das nächste Fibonacci-Paar in den Akkumulator
				"STA 3", // Speichere das nächste Fibonacci-Paar im Speicherplatz für das aktuelle
							// Fibonacci-Paar
				"LDA 0", // Lade den Zähler für die Fibonacci-Berechnung (0) in den Akkumulator
				"SUB 1", // Verringere den Zähler um 1
				"STA 0", // Speichere den neuen Zählerwert im Speicherplatz
				"JMZ 12", // Wenn der Zähler 0 ist, springe zu Anweisung 12 (Programmende)
				"JMP 0", // Springe zu Anweisung 0 (nächster Fibonacci-Schritt)
				"HLT 0" // Halte das Programm
		};
		String[] memFibonacci = { "6", "1", "1", "0", "0" }; // Speicherplatz 0 für den Zähler reservieren

		Program fibonacciProgram = new Program("fibonacci.txt", cmdsFibonacci, memFibonacci);
		// FIBONACCCI START

	}

}
