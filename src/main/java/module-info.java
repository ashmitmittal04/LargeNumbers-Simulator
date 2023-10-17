module simulator.largenumberssim {
    requires javafx.controls;
    requires javafx.fxml;


    opens simulator.largenumberssim to javafx.fxml;
    exports simulator.largenumberssim;
}