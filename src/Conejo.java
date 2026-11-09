public class Conejo extends Animal {
    public Conejo(String nombre, int edad, String nombreDueño) {
        super(nombre, edad, nombreDueño);
    }

    @Override
    public double calcularCostoConsulta() { return 35000; }
}
