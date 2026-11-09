import java.util.ArrayList;
import java.util.List;

public class Perro extends Animal implements Vacunable, Asegurable {
    private String raza;
    private List<String> vacunas = new ArrayList<>();

    public Perro(String nombre, int edad, String nombreDueño, String raza) {
        super(nombre, edad, nombreDueño);
        this.raza = raza;
    }

    @Override
    public double calcularCostoConsulta() { return 45000 + 3000 * edad; }

    @Override
    public void registrarVacuna(String nombre) { vacunas.add(nombre); }

    @Override
    public int getVacunasAplicadas() { return vacunas.size(); }

    @Override
    public double calcularPrimaSeguro() { return 80000.0 * edad; }

    @Override
    public String obtenerNumeroPoliza() { return "POL-PERRO-" + nombre; }
}