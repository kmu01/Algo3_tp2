package edu.fiuba.algo3.modelo;

public class Policia {
    private GradoDePolicia grado;
    private Ladron sospechoso;
    private Ciudad ciudadActual;
    private int cantLugaresVisitados;
    private int cantidadArrestos;
    private Mapa mapa;
    public Policia(String objetoRobado, int cantidadArrestos, Ciudad ciudadInicial,Mapa mapa){
        asignarGrado(cantidadArrestos);
        this.sospechoso = new Ladron(objetoRobado);
        this.ciudadActual = ciudadInicial;
        this.cantLugaresVisitados = 0;
        this.cantidadArrestos = cantidadArrestos;
        this.mapa = mapa;
    }

    private void asignarGrado(int cantidadArrestos){
        if (cantidadArrestos >= 0 && cantidadArrestos <= 5){
            this.grado =  new Novato();
        } else if (cantidadArrestos <= 10){
            this.grado = new Detective();
        }else if (cantidadArrestos <= 15){
            this.grado = new Investigador();
        }else{
            this.grado = new Sargento();
        }
    }

    public int obtenerArrestos(){
        return (this.cantidadArrestos);
    }

    public void anotarGenero(String genero){
        this.sospechoso.anotarGenero(genero);
    }

    public int entrarEdificio(Lugar lugarSeleccionado){
        this.ciudadActual.visitar(lugarSeleccionado,this.grado);
        return (this.cantLugaresVisitados < 3 ? ++this.cantLugaresVisitados : this.cantLugaresVisitados);
    }

    public float viajar(Ciudad ciudadSeleccionada){

        this.ciudadActual = ciudadSeleccionada;
        int distancia = mapa.calcularDistancia(ciudadSeleccionada.nombre(),this.ciudadActual.nombre());
        float tiempoDeViaje = grado.calcularTiempoDeViaje(distancia);
        return tiempoDeViaje;
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
