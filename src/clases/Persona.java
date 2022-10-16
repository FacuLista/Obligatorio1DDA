package clases; // se declara un paquete

public abstract class Persona {// clase Persona serà de quienes hereden dichos atributos arbitro/jugador/dt/
    // y es abstracta osea no puede ser instanciada
    private String _nombre; //atributos de la clase persona
    private String _apellido;
    private byte _edad;

    public String get_nombre() {
        return _nombre;
    } // metodo para obtener el nombre

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    } //Método para establecer el nombre

    public String get_apellido() {
        return _apellido;
    } // metodo para obtener el apellido

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    } //Método para establecer el apellido

    public byte get_edad() {
        return _edad;
    } // metodo para obtener la edad

    public void set_edad(byte _edad) {
        this._edad = _edad;
    } //Método para establecer la edad

    public String toString() { // se sobrescribe el toString de la clase Persona
        return
                "Nombre: '" + _nombre + '\'' +
                ", Apellido: '" + _apellido + '\'' +
                ", Edad: " + _edad;
    }

    public Persona(){}; // constructor vacìo para utilizar de ser necesario

    public Persona(String pNombre, String pApellido, byte pEdad) { //constructor parta controlar como se inicializa una instancia
        this._nombre = pNombre; // con this lo que hacemos es usarlo para conseguir una referencia al objeto asociado
        this._apellido = pApellido;
        this._edad = pEdad;
    }
}
