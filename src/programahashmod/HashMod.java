/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programahashmod;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.util.Arrays;

public class HashMod {

    public String[] array;
    public int size, count;

    public HashMod(int tam) {
        this.size = tam;
        array = new String[tam];
        Arrays.fill(array, "-1");
    }           

    public void functionModHash(String[] Sarray, String[] array) throws FileNotFoundException, UnsupportedEncodingException {
        for (String Sarray1 : Sarray) {
            //Aplicando funcion Hash "Modulo" H(K) = (K mod N) + 1
            int indexArray = (Integer.parseInt(Sarray1) % (Sarray.length - 1)) + 1;
            //Tratamiento de colisiones
            while (!"-1".equals(array[indexArray])) {
                System.out.println("Colisión -> dirección "+indexArray+" ocupada usar la dirección "+(indexArray+1));
                indexArray++;
                indexArray %= size;
            }
            System.out.println("La clave " + Sarray1 + " se asigno la dirección " + indexArray);
            array[indexArray] = Sarray1;
        }
        //Mostrando direcciones de las claves
        System.out.println("\n\nDirección\t|\t\tClave");
        PrintWriter writer = new PrintWriter("ClavesDireccion.txt", "w");
        for (int auxShow = 0; auxShow < Sarray.length; auxShow++ ){
            writer.println(auxShow  + "," + array[auxShow]);
            System.out.println(auxShow + "\t\t|\t\t" + array[auxShow]);    
            }
        writer.close();
    }
}
