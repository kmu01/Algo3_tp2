package edu.fiuba.algo3.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.fiuba.algo3.App;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ControladorAudio {

    private static ControladorAudio controladorAudio;
    private final List<MediaPlayer> reproductores = new ArrayList<>();
    private MediaPlayer repActual;
    private boolean reproduciendo;


    private ControladorAudio(){
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/simuladores.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/12monos.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/carmenSanDiego1.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/carmenSanDiego2.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/carmenSanDiego3.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/carmenSanDiego4.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/carmenSanDiego5.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/carmenSanDiego6.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/carmenSanDiego7.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/codbo1.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/codbo2.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/codbo3.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/codbo4.mp3")).toString())));
        reproductores.add(new MediaPlayer(new Media(Objects.requireNonNull(App.class.getResource("/musica/codbo5.mp3")).toString())));


        /*Le seteo a cada media player la proxima cancion*/
        for (int i = 0; i < reproductores.size(); i++) {
            final MediaPlayer player     = reproductores.get(i);
            final MediaPlayer nextPlayer = reproductores.get((i + 1) % reproductores.size());
            player.setOnEndOfMedia(() -> {
                nextPlayer.play();
                repActual = nextPlayer;
            });
        }

        /* Seteo el reproductor actual y lo pongo a reproducir*/
        repActual = reproductores.get(0);
        repActual.play();
        reproduciendo = true;
    }

    public static ControladorAudio getInstance(){
        if(controladorAudio == null){
            controladorAudio = new ControladorAudio();
        }
        return  controladorAudio;
    }


    /* Reproduce o para la cancion de reproductor actual*/
    public void play(){
        if(reproduciendo){
            repActual.stop();
            reproduciendo = false;
        }else{
            repActual.play();
            reproduciendo = true;
        }
    }

    /* Saltea a la proxima cancion de la play list si llega al final vuelve al principio*/
    public void skip(){
        if(reproduciendo) repActual.stop();

        repActual = reproductores.get((reproductores.indexOf(repActual)+1)%reproductores.size());
        repActual.play();
        reproduciendo = true;
    }

    /* Vuelve para atras una cancion de la play list si llega al principio va al final */
    public void back() {
        if(reproduciendo) repActual.stop();

        int pos = (reproductores.indexOf(repActual)-1);

        if(pos < 0) pos = reproductores.size() - 1;

        repActual = reproductores.get(pos);
        repActual.play();
        reproduciendo = true;
    }
}
