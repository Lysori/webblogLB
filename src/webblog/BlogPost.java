package webblog;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BlogPost {

	public static void main(String[] args) {

		System.out.println("Herzlich willkommen - Dies ist der upgegradete ehemalige One-Word-Blog "
				+ "von Indu, Laura, Julia und Lisa\n");
		
		//2 Scanner: da mit String und int als Datentypen gearbeitet wird, 1 Scanner wirft fehler
		//scan für Strings
		Scanner scan= new Scanner (System.in); 
		
		//scan2 für int
		Scanner scan2 = new Scanner (System.in); 
		
		ArrayList<Blog> blogArray = new ArrayList<>();
		//Blog[] blogs = new Blog[anzahl];
		System.out.println("Neue Blog-Regeln: Diesesmal dürfen so viele Beiträge geschrieben werden bis die Tastatur qualmt!"
				+ "\nGANZ WICHTIG: Bitte lies aufmerksam die Anweisungen des Blogs und befolge diese. \n");
		
		boolean beitraegeSchreiben = true;
		while (beitraegeSchreiben) {
			System.out.println("Sollen Beiträge geschrieben werden? 1 = Ja, 2 = Nein");
			int blogge = scan2.nextInt();
			
			if(blogge == 1 ) {
			
				System.out.println("Bitte gib deinen Namen ein: ");
				String bloggerName = scan.nextLine();
			
				System.out.println("Füge bitte deinen Post hier ein: ");
				String blogEingabe = scan.nextLine();

				Blog beitrag = new Blog(bloggerName ,blogEingabe, LocalDate.now(), LocalTime.now());
			
				blogArray.add(beitrag);
			
			} else if (blogge == 2) {
				beitraegeSchreiben = false;
			}
		}
		
		//Bedingung falls keine Beiträge geschrieben werden
		if (blogArray.isEmpty()) {
			System.out.println("Der Blog wird beendet bis zum nächsten Mal.");
		
		//Nur wenn es beiträge gibt, machen kommentare Sinn
		} else {
		
			System.out.println("\nÜbersicht aller Beiträge: \n");
		
			/**Schleife gibt die Blog Objekte, die in einem Array gespeichert sind aus
			* die ToString - Methode der Klasse Blog wird automatisch aufgerufen
			* (blogArray.indexOf(b) + 1) entspricht der Nummer jedes Beitrages, +1 daher, weil auch ArrayListen von 0 an zählen
			* und b ruft automatisch die ToString-Methode der Klasse Blog auf
			*/
			for(Blog b : blogArray) {
			System.out.println("Beitrag-Nr.: " + (blogArray.indexOf(b) + 1)  + b);
			}
			boolean kommentieren = true;
			while (kommentieren) {
			
				System.out.println("Sollen Beiträge kommentiert werden? 1 = Ja, 2 = Nein");
				int kommentiere = scan2.nextInt();
				
				if (kommentiere == 1) {
					
					//Einlesen der Beitragnummer
					System.out.println("Welcher Beitrag soll kommentiert werden?");
					int beitragNummer = scan2.nextInt();
					
					//Name des Kommentators wird eingelesen
					System.out.println("Bitte gib deinen Namen ein:");
					String nameKommentator = scan.nextLine();
					
					//Einlesen des Kommentartextes
					System.out.println("Schreibe dein Kommentar:");
					String kommentarEingabe = scan.nextLine();
					
					
					/**Kommentar Objekt wird erzeugt:
					 * Methoden LocalDate.now() bzw. LocalTime.now() sind bestandteile der zugehörigen Klassen aus der 
					 * Java Bibliothek und können direkt aufgerufen und an den Kommentar übergeben werden
					 */
					Kommentar kommentar = new Kommentar(nameKommentator, kommentarEingabe, LocalDate.now() , LocalTime.now());
					
					/**Jedes Blog Objekt enthält Liste mit Kommentaren -> geschriebener Kommentar 
					 * wird mit der Methode kommentarHinzufuegen aus der Klasse Blog in eine ArrayListe mit Kommentaren gepackt
					 * [beitrag -1] als index -> wichtig, da Array immer von 0 an zählt
					 */	
					
					blogArray.get(beitragNummer -1).kommentarHinzufuegen(kommentar);
					//blogs[beitragNummer - 1].kommentarHinzufuegen(kommentar); 
					
					System.out.println("Übersicht aller Posts und Kommentare: \n");
					
					/**Schleife gibt die Blog Objekte, die in einem Array gespeichert sind aus
					 * wichtig: jedes Blog-Objekt im Array hat eine ArrayListe mit Kommentaren,
					 * welche durch die ToString-Methode ebenfalls ausgegeben wird
					 */
					for(int i = 0; i < blogArray.size(); i++) {
						
						//ToString-Methode des blog objektes wird aufgerufen und ausgegeben
						//(i+1) -> über Laufvariable BeitragNummer ausgeben, daher keine for-each Schleife
						System.out.println("Beitrag-Nr.: " + (i + 1)  + blogArray.get(i));
					}
				
				}
				else if (kommentiere ==2) {
					kommentieren = false;

				}
			} 
			
			System.out.println ("Ende des Webblogs");
			scan.close();
			scan2.close();
		}
				
		
	}
}
