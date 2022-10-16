package clases;

public class DT extends Persona{
    @Override // se sobrescribe la clase dt
    public String toString() {
        return super.toString();
    }

    public DT(){}; // constructor vacio

    public DT(String pNombre, String pApellido, byte pEdad) {
        super(pNombre, pApellido, pEdad);
    } //constructor que recibe de herencia y usamos en lugar de this usamos super
}
