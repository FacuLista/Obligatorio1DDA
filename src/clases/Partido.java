package clases;

public class Partido { // aca lo que creamos es la clase Partido donde estaran todos los para llevar a cabo una parte del partido
    private String _estadio; //atributos
    private String _dia;
    private String _hora;
    private String _clima;
    private String _minutosJugados;

    public String get_estadio() {
        return _estadio;
    } // metodo para obtener el estadio

    public void set_estadio(String _estadio) { // metodo para establecer el estadio

        this._estadio = _estadio;
    }

    public String get_dia() {
        return _dia;
    }// metodo para obtener el dia

    public void set_dia(String _dia) {
        this._dia = _dia;
    } // metodo para obtener el nombre

    public String get_hora() {
        return _hora;
    } // metodo para obtener la hora

    public void set_hora(String _hora) {
        this._hora = _hora;
    } // metodo para establecer la hora

    public String get_clima() {
        return _clima;
    } // metodo para obtener el clima

    public void set_clima(String _clima) {
        this._clima = _clima;
    } // metodo para establecer el clima

    public String get_minutosJugados() {
        return _minutosJugados;
    } //Método para obtener los minutos jugados

    public void set_minutosJugados(String _minutosJugados) {
        this._minutosJugados = _minutosJugados;
    } // metodo para establecer los minutos jugados

    @Override
    public String toString() { //se sobrescribe el toString de la clase Partido
        return "Partido{" +
                "_estadio='" + _estadio + '\'' +
                ", _dia='" + _dia + '\'' +
                ", _hora='" + _hora + '\'' +
                ", _clima='" + _clima + '\'' +
                ", _minutosJugados='" + _minutosJugados + '\'' +
                '}';
    }

    public  Partido() { } // constructor vacio

    public Partido(String Estadio, String Dia, String Hora, String Clima, String MinutosJugados) { // constructor con los atributos del objeto
        this._estadio = Estadio;
        this._dia = Dia;
        this._hora = Hora;
        this._clima = Clima;
        this._minutosJugados = MinutosJugados;
    }
}
