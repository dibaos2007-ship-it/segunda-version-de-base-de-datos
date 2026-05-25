package modelo;

public class Planeta {
    private int id;
    private String nombre;
    private String fechaDescubrimiento;
    private String tipo;
    private int numeroSatelites;
    private boolean tieneAnillos;
    private String galaxia;
    private boolean posibleVida;
    private double temperaturaMedia;
    private double periodoOrbital;
    private double distanciaAniosLuz;

    // Constructores
    public Planeta() {}

    public Planeta(int id, String nombre, String fechaDescubrimiento, String tipo, int numeroSatelites, boolean tieneAnillos, String galaxia, boolean posibleVida, double temperaturaMedia, double periodoOrbital, double distanciaAniosLuz) {
        this.id = id;
        this.nombre = nombre;
        this.fechaDescubrimiento = fechaDescubrimiento;
        this.tipo = tipo;
        this.numeroSatelites = numeroSatelites;
        this.tieneAnillos = tieneAnillos;
        this.galaxia = galaxia;
        this.posibleVida = posibleVida;
        this.temperaturaMedia = temperaturaMedia;
        this.periodoOrbital = periodoOrbital;
        this.distanciaAniosLuz = distanciaAniosLuz;
    }

    // Getters y Setters (para acceder a los datos)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getFechaDescubrimiento() { return fechaDescubrimiento; }
    public void setFechaDescubrimiento(String fechaDescubrimiento) { this.fechaDescubrimiento = fechaDescubrimiento; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getNumeroSatelites() { return numeroSatelites; }
    public void setNumeroSatelites(int numeroSatelites) { this.numeroSatelites = numeroSatelites; }
    public boolean isTieneAnillos() { return tieneAnillos; }
    public void setTieneAnillos(boolean tieneAnillos) { this.tieneAnillos = tieneAnillos; }
    public String getGalaxia() { return galaxia; }
    public void setGalaxia(String galaxia) { this.galaxia = galaxia; }
    public boolean isPosibleVida() { return posibleVida; }
    public void setPosibleVida(boolean posibleVida) { this.posibleVida = posibleVida; }
    public double getTemperaturaMedia() { return temperaturaMedia; }
    public void setTemperaturaMedia(double temperaturaMedia) { this.temperaturaMedia = temperaturaMedia; }
    public double getPeriodoOrbital() { return periodoOrbital; }
    public void setPeriodoOrbital(double periodoOrbital) { this.periodoOrbital = periodoOrbital; }
    public double getDistanciaAniosLuz() { return distanciaAniosLuz; }
    public void setDistanciaAniosLuz(double distanciaAniosLuz) { this.distanciaAniosLuz = distanciaAniosLuz; }
}
