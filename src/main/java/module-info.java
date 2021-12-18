module edu.fiuba.algo3 {
    requires javafx.controls;
    requires commons.csv;
    requires javafx.fxml;
    requires javafx.media;

    exports edu.fiuba.algo3;
    opens edu.fiuba.algo3.modelo;
    opens edu.fiuba.algo3.modelo.ordenDeArresto;
    opens edu.fiuba.algo3.modelo.objetos;
    opens edu.fiuba.algo3.modelo.grados;
    opens edu.fiuba.algo3.modelo.excepciones;
    opens edu.fiuba.algo3.controllers to javafx.fxml;
    exports edu.fiuba.algo3.controllers;
}