package clases;
import java.util.List;

public class Equipo {
    private byte _id; //atributos de equipo
    private String _nombre;
    private List<Jugador> _listaTitulares; // lista de jugadores titulares
    private List<Jugador> _listaSuplentes; // lista jugadores suplentes
    private DT _tecnico; //el tecnico que es la otra clase

    public byte get_id() {
        return _id;
    } //obtiene el id

    public void set_id(byte _id) {
        this._id = _id;
    } // lo establece

    public String get_nombre() {
        return _nombre;
    } //obtiene el nombre

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    } // establece el nombre

    public List<Jugador> get_listaTitulares() {
        return _listaTitulares;
    }//obtiene la lista de titulares

    public void set_listaTitulares(List<Jugador> _listaTitulares) { // establece la lista de jugadores
        this._listaTitulares = _listaTitulares;
    } // obtiene la lista de titulares

    public List<Jugador> get_listaSuplentes() { // obtiene la lista de suplentes
        return _listaSuplentes;
    }

    public void set_listaSuplentes(List<Jugador> _listaSuplentes) {
        this._listaSuplentes = _listaSuplentes;
    } // establece la lista de suplentes

    public DT get_tecnico() {
        return _tecnico;
    } //obtiene el tecnico que viene de otra clase

    public void set_tecnico(DT _tecnico) {
        this._tecnico = _tecnico;
    } // establece el tecnico

    @Override // se sobrescribe el toString
    public String toString() {
        return "Equipo{" +
                "_id=" + _id +
                ", _nombre='" + _nombre + '\'' +
                ", _listaTitulares=" + _listaTitulares +
                ", _listaSuplentes=" + _listaSuplentes +
                ", _tecnico=" + _tecnico +
                '}';
    }

    public Equipo() { } // declaramos un constructor vacio

    public Equipo(byte Id, String Nombre, List<Jugador> ListaTitulares, List<Jugador> ListaSuplentes, DT Tecnico) { // constructor con sus atributos
        this._id = Id;
        this._nombre = Nombre;
        this._listaTitulares = ListaTitulares;
        this._listaSuplentes = ListaSuplentes;
        this._tecnico = Tecnico;
    }
}
