package clases;

public class Arbitro { // clase arbitro donde tendra los atributos que pide la letra
    private String _nombre;
    private String _apellido;
    private String _puesto;

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public String get_puesto() {
        return _puesto;
    }

    public void set_puesto(String _puesto) {
        this._puesto = _puesto;
    }

    @Override
    public String toString() { //se sobrescribe el toString en la clase Arbitro
        return
                "Nombre: '" + _nombre + '\'' +
                        ", Apellido: '" + _apellido + '\'' +
                        ", Puesto: '" + _puesto + '\'';
    }

    public Arbitro(){}; // constructor vacio

    public Arbitro(String pNombre, String pApellido, String pPuesto) { // constructor con los atributos de la clase
        this._nombre = pNombre;
        this._apellido = pApellido;
        this._puesto = pPuesto;
    }
}
