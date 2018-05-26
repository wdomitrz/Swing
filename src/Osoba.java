
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author witek
 */
public class Osoba {

    private String imie;
    private String nazwisko;
    private String pesel;
    private String rokUrodzeina;

    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    public void addPropertyChangeListener(PropertyChangeListener listener){
        changeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener){
        changeSupport.removePropertyChangeListener(listener);
    }
    
    @Override
    public String toString(){
        return "Osoba: {"+
                "Imię: "+ imie+", "+
                "Nazwisko: "+ nazwisko+", "+
                "Pesel: "+ pesel+", "+
                "Rok Urodzenia: "+ rokUrodzeina+
                "}";
    }
    
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
        if(pesel.length() >= 2)
            odczytajRokUrodzenia();
    }

    public String getPesel() {
        return pesel;
    }

    public String getRokUrodzeina() {
        return rokUrodzeina;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setRokUrodzeina(String rokUrodzeina) {
        String old = this.rokUrodzeina;
        this.rokUrodzeina = rokUrodzeina;
        
        changeSupport.firePropertyChange("rokUrodzeina",old,this.rokUrodzeina);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.pesel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Osoba other = (Osoba) obj;
        if (!Objects.equals(this.pesel, other.pesel)) {
            return false;
        }
        return true;
    }

    private void odczytajRokUrodzenia(){
        setRokUrodzeina("19" + pesel.substring(0, 2));
    }
}
