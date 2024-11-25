import java.time.Duration;
import java.time.LocalDate;

public class Revista extends ItemBiblioteca implements Catalogable{
    private int nroEdicion;
    public static int cantidadEjemplares = 10;
    private String nombreRevista;

    public Revista() {
    }
    public Revista(int nroEdicion, String nombreRevista) {
        this();
        this.nroEdicion = nroEdicion;
        this.nombreRevista = nombreRevista;
    }

    public int getNroEdicion() {
        return nroEdicion;
    }
        public String getNombreRevista() {
            return this.nombreRevista;
        }

    public void setNroEdicion(int nroEdicion) {
        this.nroEdicion = nroEdicion;
    }
        public void setNombreRevista(String nombreRevista) {
            this.nombreRevista = nombreRevista;
        }

    @Override
    public void prestar() {
        if (cantidadEjemplares <= 0) {
            System.out.println("Ah, F.");
        } else {
            cantidadEjemplares--;
        }
    }

    @Override
    public void devolver() {
        if (cantidadEjemplares > 10) {
            System.out.println("Ah, F...");
        } else {
            cantidadEjemplares++;
        }
    }

    @Override
    public void calcularMultas(LocalDate fechaPrestamo) {
        Duration retraso = Duration.between(fechaPrestamo, LocalDate.now());
        int diasRetraso = (int)Math.ceil(retraso.getSeconds()/(3600*24));
    }

    @Override
    public void obtenerInformacion() {
        System.out.printf("Nombre de revista: %s%nNúmero de edición: %d%nCantidad de ejemplares: %d%n", this.nombreRevista,
                this.nroEdicion, cantidadEjemplares);
    }
}
