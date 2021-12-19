package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Sospechoso;
import edu.fiuba.algo3.modelo.grados.GradoDePolicia;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class ObjetoMuyValioso implements ObjetoRobado {

    private final int cantidadPaises = 7;
    private final String nombre;
    private Ciudad ciudad;
    private final String rareza = "muy valioso";

    public ObjetoMuyValioso(String nombre, Ciudad ciudad){

        this.nombre = nombre;
        this.ciudad = ciudad;

    }


    public int cantidadPaises(){return this.cantidadPaises;}

    @Override
    public Policia crearPoliciaConCiudadInicial(GradoDePolicia grado){
        return (new Policia(new Sospechoso(),grado));
    }

    @Override
    public Queue<Ciudad> setearRutaLadron(List<String> nombresDeCiudades, Map<String, Ciudad> ciudades, Random dado, Queue<Ciudad> rutaLadron) {
        rutaLadron.add(this.ciudad);
        nombresDeCiudades.remove(this.ciudad.ciudad());
        for (int i = 1;i<=this.cantidadPaises;i++){
            int numeroCiudadSorteada = dado.nextInt(nombresDeCiudades.size());
            Ciudad ciudadSorteada = ciudades.get(nombresDeCiudades.get(numeroCiudadSorteada));
            nombresDeCiudades.remove(numeroCiudadSorteada);
            rutaLadron.add(ciudadSorteada);
        }
        return rutaLadron;
    }

    @Override
    public String rareza(){
        return this.rareza;
    }
    @Override
    public boolean verificarLimitePaises(int cantidadDePaisesVisitados){
        return (cantidadDePaisesVisitados == this.cantidadPaises);
    }


}
