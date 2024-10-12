package Ejercicios;


public class tiposproducto {
    
    int idTipo;
    int tipo;

    public tiposproducto() {
    }

    public tiposproducto(int idTipo, int tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "tiposproducto{" + "idTipo=" + idTipo + ", tipo=" + tipo + '}';
    }
    
    
    
}
