public class Main {
    public static void main(String[] args) {
        // 1 - Fichas polimorficas
        Animal[] animales = {
            new Perro("Firulais", 5, "Carlos", "Labrador"),
            new Gato("Michi", 3, "Ana", true),
            new Ave("Piolin", 1, "Luis", 150.0)
        };
        for (Animal a : animales) { a.imprimirFicha(); System.out.println(); }

        // 2 - Vacunacion
        Perro perro = new Perro("Rex", 4, "Pedro", "Beagle");
        Gato gato = new Gato("Luna", 2, "Maria", false);
        perro.registrarVacuna("Rabia");
        perro.registrarVacuna("Parvovirus");
        gato.registrarVacuna("Triple felina");
        System.out.println("Perro vacunas: " + perro.getVacunasAplicadas());
        System.out.println("Gato vacunas: " + gato.getVacunasAplicadas());
        System.out.println();

        // 3 - Polizas
        Clinica clinica = new Clinica("VetCare", "Calle 123");
        Asegurable[] aseg = { perro, gato, clinica };
        for (Asegurable a : aseg)
            System.out.println(a.obtenerNumeroPoliza() + " -> " + a.calcularPrimaSeguro());
        System.out.println();

        // 4 - Conejo (sin tocar otras clases)
        Animal[] animales2 = {
            new Perro("Firulais", 5, "Carlos", "Labrador"),
            new Gato("Michi", 3, "Ana", true),
            new Ave("Piolin", 1, "Luis", 150.0),
            new Conejo("Bugs", 2, "Sofia")
        };
        for (Animal a : animales2) { a.imprimirFicha(); System.out.println(); }
    }
}
