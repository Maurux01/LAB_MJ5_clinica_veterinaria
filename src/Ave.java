public class Ave extends Animal {
    private double pesoGramos;

    public Ave(String nombre, int edad, String nombreDueño, double pesoGramos) {
        super(nombre, edad, nombreDueño);
        this.pesoGramos = pesoGramos;
    }

    @Override
    public double calcularCostoConsulta() {
        return 28000 + 100 * pesoGramos;
    }
}