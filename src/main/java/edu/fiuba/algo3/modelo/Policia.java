package edu.fiuba.algo3.modelo;

public class Policia {
    private GradoDePolicia grado;
    private Ladron sospechoso;
    private Ciudad ciudadActual;
    private int cantLugaresVisitados;
    private int cantidadArrestos;
    public Policia(String objetoRobado, int cantidadArrestos, Ciudad ciudadInicial){
        this.grado = new Novato();
        this.sospechoso = new Ladron(objetoRobado,cantidadArrestos);
        this.ciudadActual = ciudadInicial;
        this.cantLugaresVisitados = 0;
        this.cantidadArrestos = cantidadArrestos;
    }

    public int obtenerArrestos(){
        return (this.cantidadArrestos);
    }

    public void anotarGenero(String genero){
        this.sospechoso.anotarGenero(genero);
    }

    public String entrarEdificio(String lugarSeleccionado){
        return (this.ciudadActual.visitar(lugarSeleccionado,this.grado));
    }

    public void viajar(Ciudad ciudadSeleccionada){
        this.ciudadActual = ciudadSeleccionada;
    }
    public String mostrarCiudadActual(){
        return (this.ciudadActual.nombre());
    }
    public int recibirCuchillazo(){
        return 1;
    }
    public int dormir(){
        return 8;
    }
}
