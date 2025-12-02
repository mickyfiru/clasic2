package cl.profemariostomas.classicmodels.models;

public class AulaModel {

    private int aulaId;
    private String nombre;
    private int capacidad;

    public AulaModel(int aulaId, String nombre, int capacidad) {
        this.aulaId = aulaId;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public int getAulaId() {
        return aulaId;
    }

    public void setAulaId(int aulaId) {
        this.aulaId = aulaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return this.nombre + " (#" + this.aulaId + ")";
    }
}
