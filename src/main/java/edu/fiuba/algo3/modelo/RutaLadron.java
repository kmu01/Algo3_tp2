package edu.fiuba.algo3.modelo;

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
        if ((ciudades.get(ciudadSeleccionada) == this.ciudadSiguiente)){
            if(!destinosEquivocados.isEmpty()){
                destinosEquivocados.pop();
            }
            this.ciudadActual = ciudades.get(ciudadSeleccionada);
            this.ciudadSiguiente = this.rutaLadron.poll();
        }else{
            this.destinosEquivocados.add(this.ciudadActual.ciudad());
            // ciudadSiguiente vuelve a la ciudadAnterior
            this.ciudadSiguiente = this.ciudadActual;
            this.ciudadSiguiente.setearPistasFalsas();
            this.ciudadActual = ciudades.get(ciudadSeleccionada);
        }
    }

    public List<String> verificarDestinos(List<String> destinos,Random dado){
        int eliminarOpcionAlAzar = dado.nextInt(destinos.size());
        destinos.remove(eliminarOpcionAlAzar);
        destinos.add(ciudadSiguiente.ciudad());
        if (!destinosEquivocados.isEmpty() && (!destinos.contains(destinosEquivocados.peek()))){
            destinos.remove(eliminarOpcionAlAzar);
            destinos.add(destinosEquivocados.pop());
        }
        return destinos;
    }
}
