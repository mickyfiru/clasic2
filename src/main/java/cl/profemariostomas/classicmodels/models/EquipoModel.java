package cl.profemariostomas.classicmodels.models;

public class EquipoModel {

    private int equipoId;
    private String descripcion;
    private String numeroSerie;
    private int aulaAsignadaId;

    public EquipoModel(int equipoId, String descripcion, String numeroSerie, int aulaAsignadaId) {
        this.equipoId = equipoId;
        this.descripcion = descripcion;
        this.numeroSerie = numeroSerie;
        this.aulaAsignadaId = aulaAsignadaId;
    }

    public int getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getAulaAsignadaId() {
        return aulaAsignadaId;
    }

    public void setAulaAsignadaId(int aulaAsignadaId) {
        this.aulaAsignadaId = aulaAsignadaId;
    }
}
