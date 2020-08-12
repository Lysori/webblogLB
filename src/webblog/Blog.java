package webblog;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;




public class Blog {
	// Instanzvariablen

	private String blogEingabe;
	private String bloggerName;
	private LocalDate jetztDatum;
	private LocalTime jetztUhrzeit;
	private ArrayList<Kommentar> kommentarArray = new ArrayList<>();


	// Standardkonstruktor
	public Blog() {}
	
	//Konstruktor mit Parametern
	public Blog(String bloggerNameParam, String blogEingabeParam, LocalDate jetztDatumParam, LocalTime jetztUhrzeitParam) {
	
	this.blogEingabe = blogEingabeParam;
	this.bloggerName = bloggerNameParam;
	this.jetztDatum = jetztDatumParam;
	this.jetztUhrzeit = jetztUhrzeitParam;
	}

	//Getter und Setter
	public String getBlogEingabe() {
	return blogEingabe;
	}
	
	public void setBlogEingabe(String blogEingabeParam) {
	this.blogEingabe = blogEingabeParam;
	}
	
	public String getBloggerName() {
		return bloggerName;
	}
	public void setBloggerName(String bloggerNameParam) {
		this.bloggerName = bloggerNameParam;
	}

	public LocalTime getJetztUhrzeit() {
		return jetztUhrzeit;
	}
	
	public void setJetztUhrzeit(LocalTime jetztUhrzeitParam) {
		this.jetztUhrzeit = jetztUhrzeitParam;
	}
	
	public LocalDate getJetztDatum() {
		return jetztDatum;
	}
	
	public void setJetztDatum(LocalDate jetztDatumParam) {
		this.jetztDatum = jetztDatumParam;
	}
	
	public ArrayList<Kommentar> getKommentarArray() {
		return kommentarArray;
	}
	
	/*Methode fuegt der ArrayList kommentare hinzu*/
	public void kommentarHinzufuegen(Kommentar k) {
		this.kommentarArray.add(k);	
	}
	
	@Override
	public String toString() {
	
	DateTimeFormatter date = DateTimeFormatter.ofPattern("dd.MM.YY");
	DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
	
	/*Kommentarresult muss zun�chst initialisiert werden, damit sie sp�ter �berschrieben 
	 * bzw. die kommentare angeh�ngtwerden k�nnen
	 */
	String kommentarResult = "\n";
		
	/*Pr�ft ob es �berhaupt Kommentare zum Beitrag gibt
	 * wenn es keine Kommentare gibt soll ToString Methode diesen result String anh�ngen
	 */
	if(kommentarArray.isEmpty()) {
		kommentarResult = "\nKeine Kommentare vorhanden\n";
	} else {
	
		/*Ausgabe f�r die Kommentarliste: 
		 * alle kommentare werden untereinander aufgelistet, Kommentarnummer entspricht (kommentarArray.indexOf(k) + 1)
		 * + 1 hier wichtig, da ArrayList von 0 an zaehlt
		 */
		for(Kommentar k : kommentarArray) {
			kommentarResult += "Kommentar Nr.: " + (kommentarArray.indexOf(k) + 1)  + "\n" + k + "\n";
		
		}
	}
	//Ausgabe f�r die Beitr�ge 
	String blog = "\n" + bloggerName + " schrieb am " + date.format(jetztDatum) + " um " + 
			time.format(jetztUhrzeit) + " Uhr: \n" +  blogEingabe + "\n";
			
	//Beitr�ge und Kommentare werden aneinander geh�ngt
	return blog + kommentarResult;
	
	}
	
	
	
}