package webblog;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Kommentar {
	
	// Instanzvariablen: Diese Eigenschaften besitzt die Klasse Comment
	private String kommentar;
	private String nameKommentator;
	private LocalDate jetztDatum;
	private LocalTime jetztUhrzeit;
	
	// Standardkonstruktor
	public Kommentar() {}
	
	//Parametrisierter Konstruktor zur erstellung eines Kommentarobjektes
	public Kommentar(String nameKommentatorParam, String kommentarParam, 
			LocalDate jetztDatumParam, LocalTime jetztZeitParam ) {
	
	this.kommentar = kommentarParam;
	this.nameKommentator = nameKommentatorParam;
	this.jetztDatum = jetztDatumParam;
	this.jetztUhrzeit = jetztZeitParam;
	
	}
	
	//Getter und Setter

	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentarParam) {
		this.kommentar = kommentarParam;
	}
	public String getNameKommentator() {
		return nameKommentator;
	}
	public void setNameKommentator(String nameKommentatorParam) {
		this.nameKommentator = nameKommentatorParam;
	}
	public LocalDate getJetztDatum() {
		return jetztDatum;
	}
	public void setJetztDatum(LocalDate jetztDatumParam) {
		this.jetztDatum = jetztDatumParam;
	}
	public LocalTime getJetztUhrzeit() {
		return jetztUhrzeit;
	}
	public void setJetztUhrzeit(LocalTime jetztZeitParam) {
		this.jetztUhrzeit = jetztZeitParam;
	}
	
	//ToString Methode überschreiben für die Ausgabe
	@Override
	public String toString() {
	
	//Formatierung der Datum und Zeit objekte mit der DateTimeFormatter Klasse aus der Java Bibliothek
	DateTimeFormatter date = DateTimeFormatter.ofPattern("dd.MM.YY");
	DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
	
	String ausgabe =  "Kommentar von " + nameKommentator + " am " + date.format(jetztDatum) + " um " + time.format(jetztUhrzeit) 
	+ " Uhr : \n" + kommentar + "\n";
	
	return ausgabe;
		}
	}


