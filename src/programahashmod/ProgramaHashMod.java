/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programahashmod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class ProgramaHashMod {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        RandomAccessFile archivo = new RandomAccessFile("Claves.txt", "r");
        String[] info = null;
        String cadena = archivo.readLine();
        //Obteniendo la información del archivo
        while (cadena != null) {
            StringTokenizer tokens = new StringTokenizer(cadena, ",");
            info = new String[tokens.countTokens()];
            int aux = 0;
            while (tokens.hasMoreTokens()) {
                info[aux] = tokens.nextToken();
                aux++;
            }
            cadena = archivo.readLine();
        }
        archivo.close();
        //Obteniendo el tamaño del arreglo
        HashMod crearTablaHash = new HashMod(info.length);
        //Generando direcciones
        crearTablaHash.functionModHash(info, crearTablaHash.array);
        
    }

}
