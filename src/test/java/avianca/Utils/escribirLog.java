package avianca.Utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class escribirLog {

    public void escribir(String vuelo, String ida, String vuelta){
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("src/test/resources/Data/LogVuelos.txt");

            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);

            escribir.write("\r\n");
            escribir.write(vuelo+"--"+ida+"--"+vuelta+"--"+new Date());
            escribir.write("\r\n");

            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

}
