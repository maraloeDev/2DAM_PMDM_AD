package Ejercicios.Ejercicio3;

import com.opencsv.bean.CsvBindByName;


public class Ejercicio03_opcionesEncuesta {
    
    @CsvBindByName(column = "Si")
    int si;
    
    @CsvBindByName(column = "No")
    int no;
    
    @CsvBindByName(column = "NS/NC")
    int nSnC;

    public Ejercicio03_opcionesEncuesta() {
    }

    public Ejercicio03_opcionesEncuesta(int si, int no, int nSnC) {
        this.si = si;
        this.no = no;
        this.nSnC = nSnC;
    }

    @Override
    public String toString() {
        return si + "," + no + "," + nSnC;
    }
    
    public String[] toArray(){
            
        String[] datosEncuesta ={"Si", "No", "NS/NC"};
        return datosEncuesta;
    
    }
    
    public int calcularTotal(){
        
        return si+no+nSnC;
    }
    public double porcentajeSi(){
        
        return (si*100)/calcularTotal();
    }
    
    public double porcentajeNo(){
        
        return (no*100)/calcularTotal();
    }
    
    public double porcentajeNsNc(){
        
        return (nSnC * 100)/calcularTotal();
    }
    
    
    
}
