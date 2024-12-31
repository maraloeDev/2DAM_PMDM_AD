package App;

public class Cliente {

    public static int codigoCliente = 1;
    //Creacion de atributos para darles valor mas adelante
    private int codigo_Cliente;
    private String dni_Cliente;
    private String nombre_Apellidos;
    private String direccion_Completa;
    private String telefono_Contacto;

    public Cliente() {
    }

    //Creacion de un constructor que da valor a cada atributo de la clase
    public Cliente(String dni_Cliente, String nombre_Apellidos) {
        this.codigo_Cliente = codigoCliente++; //Incremento el codigo de cliente
        this.dni_Cliente = dni_Cliente;
        this.nombre_Apellidos = nombre_Apellidos;
    }

    //Metodos para recoger o modificar los atributos
    public String getDni_Cliente() {
        return dni_Cliente;
    }

    public void setDni_Cliente(String dni_Cliente) {
        this.dni_Cliente = dni_Cliente;
    }

    public String getNombre_Apellidos() {
        return nombre_Apellidos;
    }

    public void setNombre_Apellidos(String nombre_Apellidos) {
        this.nombre_Apellidos = nombre_Apellidos;
    }

    public String getDireccion_Completa() {
        return direccion_Completa;
    }

    public void setDireccion_Completa(String direccion_Completa) {
        this.direccion_Completa = direccion_Completa;
    }

    public String getTelefono_Contacto() {
        return telefono_Contacto;
    }

    public void setTelefono_Contacto(String telefono_Contacto) {
        this.telefono_Contacto = telefono_Contacto;
    }

    //Metodo toString, que muestra los datos que se van a visualizar
    @Override
    public String toString() {
        return "Datos del Cliente :"
                + "\nCodigo del cliente: " + codigo_Cliente
                + "\nDNI: "+ dni_Cliente
                + "\nNombre y apellidos: "+ nombre_Apellidos;
    }
}
