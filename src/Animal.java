public abstract class Animal {
    protected String nombre;
    protected int edad;
    protected String nombreDueño;

    public Animal(String nombre, int edad, String nombreDueño) {
        this.nombre = nombre;
        this.edad = edad;
        this.nombreDueño = nombreDueño;
    }

    public abstract double calcularCostoConsulta();

    public void imprimirFicha() {
        System.out.println("=== Ficha de " + nombre + " ===");
        System.out.println("Edad: " + edad);
        System.out.println("Dueno: " + nombreDueño);
        System.out.println("Costo de consulta: " + calcularCostoConsulta());
    }
}