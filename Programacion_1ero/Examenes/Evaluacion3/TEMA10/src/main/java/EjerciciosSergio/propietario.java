package EjerciciosSergio;


public class propietario {
    
    int contadorId;
    int id;
    String nombre;
    int edad;
    double gastoMensual;

    public propietario() {
    }

    public propietario(String nombre, int edad, double gastoMensual) {
        this.id = contadorId;
        this.nombre = nombre;
        this.edad = edad;
        this.gastoMensual = gastoMensual;
    }

    public int getContadorId() {
        return contadorId;
    }

    public void setContadorId(int contadorId) {
        this.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getGastoMensual() {
        return gastoMensual;
    }

    public void setGastoMensual(double gastoMensual) {
        this.gastoMensual = gastoMensual;
    }

    @Override
    public String toString() {
        return "propietario{" + "contadorId=" + contadorId + ", id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", gastoMensual=" + gastoMensual + '}';
    }
    
    
    
    
    
    
}
