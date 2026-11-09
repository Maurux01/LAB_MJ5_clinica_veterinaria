public abstract class Animal {
    protected String nombre;
    protected int edad;
    protected String nombreDueno;

    public Animal(String nombre, int edad, String nombreDueno) {
        this.nombre = nombre;
        this.edad = edad;
        this.nombreDueno = nombreDueno;
    }

    public abstract double calcularCostoConsulta();

    public void imprimirFicha() {
        System.out.println("=== Ficha de " + nombre + " ===");
        System.out.println("Edad: " + edad);
        System.out.println("Dueno: " + nombreDueno);
        System.out.println("Costo de consulta: " + calcularCostoConsulta());
    }
}