package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.ubicacion.Ciudad;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

import java.util.*;

public class RutaLadron {
    private Queue<Ciudad> rutaLadron;
    private Stack<String> destinosEquivocados;
    private Ciudad ciudadActual;
    private Ciudad ciudadSiguiente;

    public RutaLadron(){
        this.rutaLadron = new LinkedList<>();
        this.destinosEquivocados = new Stack<>();
        this.ciudadActual = null;
        this.ciudadSiguiente = null;
    }

    public Queue<Ciudad> establecerRutaLadron(ObjetoRobado objetoRobado,List<String> nombresDeCiudades, Map<String,Ciudad> ciudades, Random dado){

        objetoRobado.setearRutaLadron(nombresDeCiudades,ciudades,dado,this.rutaLadron);
        this.ciudadActual = this.rutaLadron.poll();
        this.ciudadSiguiente = this.rutaLadron.poll();
        return this.rutaLadron;
    }

    public Ciudad obtenerCiudadSiguiente(){
        return this.ciudadSiguiente;
    }

    public Ciudad obtenerCiudadActual(){
        return this.ciudadActual;
    }

    public List<String> obtenerDestinosEquivocados(){
        return this.destinosEquivocados;
    }

    public void verificarSiEligioElDestinoCorrecto(Map<String,Ciudad>ciudades, String ciudadSeleccionada){
        if(this.ciudadActual == null){
            this.ciudadActual = this.rutaLadron.poll();
            this.ciudadSiguiente = this.rutaLadron.poll();
        }
        // elegiste la correcta
        if ((ciudades.get(ciudadSeleccionada) == this.ciudadSiguiente)){
            // si la pila no esta vacia(osea tengo que volver porque me equivoque)
            if(!destinosEquivocados.isEmpty()){
                this.ciudadSiguiente = ciudades.get(destinosEquivocados.pop());
            }else{
                this.ciudadSiguiente = this.rutaLadron.poll();
            }
            this.ciudadActual = ciudades.get(ciudadSeleccionada);

        }else{
            this.destinosEquivocados.add(this.ciudadSiguiente.ciudad());
            // ciudadSiguiente vuelve a la ciudadAnterior
            this.ciudadSiguiente = this.ciudadActual;
            this.ciudadSiguiente.setearPistasFalsas();
            this.ciudadActual = ciudades.get(ciudadSeleccionada);
        }
    }

    public List<String> verificarDestinos(List<String> destinos,Random dado){
        int eliminarOpcionAlAzar = dado.nextInt(destinos.size());
        if(!destinos.stream().anyMatch(destino->destino.equals(this.ciudadSiguiente.ciudad()))){
            destinos.remove(eliminarOpcionAlAzar);
            destinos.add(ciudadSiguiente.ciudad());
        }
        return destinos;
    }

    public boolean estamosEnUltimaCiudad() {
        return (this.rutaLadron.isEmpty());
    }
}
