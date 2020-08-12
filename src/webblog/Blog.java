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
	
	/*Kommentarresult muss zunächst initialisiert werden, damit sie später überschrieben 
	 * bzw. die kommentare angehängtwerden können
	 */
	String kommentarResult = "\n";
		
	/*Prüft ob es überhaupt Kommentare zum Beitrag gibt
	 * wenn es keine Kommentare gibt soll ToString Methode diesen result String anhängen
	 */
	if(kommentarArray.isEmpty()) {
		kommentarResult = "\nKeine Kommentare vorhanden\n";
	} else {
	
		/*Ausgabe für die Kommentarliste: 
		 * alle kommentare werden untereinander aufgelistet, Kommentarnummer entspricht (kommentarArray.indexOf(k) + 1)
		 * + 1 hier wichtig, da ArrayList von 0 an zaehlt
		 */
		for(Kommentar k : kommentarArray) {
			kommentarResult += "Kommentar Nr.: " + (kommentarArray.indexOf(k) + 1)  + "\n" + k + "\n";
		
		}
	}
	//Ausgabe für die Beiträge 
	String blog = "\n" + bloggerName + " schrieb am " + date.format(jetztDatum) + " um " + 
			time.format(jetztUhrzeit) + " Uhr: \n" +  blogEingabe + "\n";
			
	//Beiträge und Kommentare werden aneinander gehängt
	return blog + kommentarResult;
	
	}
	
	
	
}