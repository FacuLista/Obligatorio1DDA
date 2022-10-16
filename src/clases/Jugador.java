package clases;

public class Jugador extends Persona{ // jugador recibe como herencia de la clase
    // padre Persona los atribuitos : nombre, apellido, edad
    private String _puesto; //atributos Jugador
    private byte _numero;

    private byte _goles;

    public String get_puesto() {
        return _puesto;
    } //obtiene el puesto

    public void set_puesto(String _puesto) {
        this._puesto = _puesto;
    } // establece el puesto

    public byte get_numero() {
        return _numero;
    } //obtiene el numero

    public void set_numero(byte _numero) {
        this._numero = _numero;
    } // establece el numero

    public byte get_goles() {
        return _goles;
    } //obtiene los goles

    public void set_goles(byte _goles) {
        this._goles = _goles;
    } //establece los goles

    @Override //sobrescribe el toString
    public String toString() {
        return super.toString() + //super hace referencia a los atributos heredados
                " Puesto: '" + _puesto + '\'' +
                ", Numero: " + _numero +
                ", Goles: " + _goles +
                '}';
    }

    public Jugador(){}; // constructor vacio

    public Jugador(String pNombre, String pApellido, byte pEdad, String pPuesto, byte pNumero, byte pGoles) { // constructor que inicializa el objeto
        super(pNombre, pApellido, pEdad);
        this._puesto = pPuesto;
        this._numero = pNumero;
        this._goles = pGoles;
    }
}
