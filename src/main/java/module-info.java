module com.jvclasses.flaudantoinelpconjugaison {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.jvclasses.client to javafx.fxml;
    exports com.jvclasses.client;
    exports com.jvclasses.serveur;
}