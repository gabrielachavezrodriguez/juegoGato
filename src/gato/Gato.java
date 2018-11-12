/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *    
 * @author Gala
 */
public class Gato {

    public static String p11 = " ", p21 = " ", p31 = " ",
            p12 = " ", p22 = " ", p32 = " ",
            p13 = " ", p23 = " ", p33 = " ";
    public static Random r;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        r = new Random();
        boolean fin = false, primeroUsuario = r.nextBoolean();
        imprimir();
        while (!fin) {
            if (primeroUsuario) {
                tirar(true);
                fin = comprobarFin();
                if (!fin) {
                    tirar(false);
                }
            } else {
                tirar(false);
                fin = comprobarFin();
                if (!fin) {
                    tirar(true);
                }
            }
        }
    }

    public static void tirar(boolean usuario) {
        String pos, simbolo;
        boolean tiroInvalido = false;
        do {
            if (usuario) {
                pos = JOptionPane.showInputDialog("Ingrese la coordenada x")
                        + JOptionPane.showInputDialog("Ingrese la coordenada y");
                simbolo = "x";
            } else {
                pos = String.valueOf(r.nextInt(3) + 1) + String.valueOf(r.nextInt(3) + 1);
                simbolo = "o";
            }
            switch (pos) {
                case "11":
                    if (p11.equals(" ")) {
                        p11 = simbolo;
                        tiroInvalido = false;
                    } else {
                        tiroInvalido = true;
                    }
                    break;
                case "12":
                    if (p12.equals(" ")) {
                        p12 = simbolo;
                        tiroInvalido = false;
                    } else {
                        tiroInvalido = true;
                    }
                    break;
                case "13":
                    if (p13.equals(" ")) {
                        p13 = simbolo;
                        tiroInvalido = false;
                    } else {
                        tiroInvalido = true;
                    }
                    break;
                case "21":
                    if (p21.equals(" ")) {
                        p21 = simbolo;
                        tiroInvalido = false;
                    } else {
                        tiroInvalido = true;
                    }
                    break;
                case "22":
                    if (p22.equals(" ")) {
                        p22 = simbolo;
                        tiroInvalido = false;
                    } else {
                        tiroInvalido = true;
                    }
                    break;
                case "23":
                    if (p23.equals(" ")) {
                        p23 = simbolo;
                        tiroInvalido = false;
                    } else {
                        tiroInvalido = true;
                    }
                    break;
                case "31":
                    if (p31.equals(" ")) {
                        p31 = simbolo;
                        tiroInvalido = false;
                    } else {
                        tiroInvalido = true;
                    }
                    break;
                case "32":
                    if (p32.equals(" ")) {
                        p32 = simbolo;
                        tiroInvalido = false;
                    } else {
                        tiroInvalido = true;
                    }
                    break;
                case "33":
                    if (p33.equals(" ")) {
                        p33 = simbolo;
                        tiroInvalido = false;
                    } else {
                        tiroInvalido = true;
                    }
                    break;
            }
            if (tiroInvalido && usuario) {
                JOptionPane.showMessageDialog(null, "casilla ya seleccionada, por favor tire de nuevo");
            }
        } while (tiroInvalido);
        imprimir();
    }

    public static void imprimir() {
        String mensaje
                = "|" + p11 + "|" + p21 + "|" + p31 + "|" + "\n"
                + "|" + p12 + "|" + p22 + "|" + p32 + "|" + "\n"
                + "|" + p13 + "|" + p23 + "|" + p33 + "|" + "\n";
        System.out.println(mensaje);
    }

    public static boolean comprobarFin() {
        if (!p11.equals(" ") && p11.equals(p21) && p11.equals(p31)) {//filas
            if (p11.equals("x")) {
                JOptionPane.showMessageDialog(null, "gana (x) usuario fila 1");
            } else {
                JOptionPane.showMessageDialog(null, "gana (o) sistema fila 1");
            }
            return true;
        } else if (!p12.equals(" ") && p12.equals(p22) && p12.equals(p32)) {
            if (p12.equals("x")) {
                JOptionPane.showMessageDialog(null, "gana (x) usuario fila 2");
            } else {
                JOptionPane.showMessageDialog(null, "gana (o) sistema fila 2");
            }
            return true;
        } else if (!p13.equals(" ") && p13.equals(p23) && p13.equals(p33)) {
            if (p13.equals("x")) {
                JOptionPane.showMessageDialog(null, "gana (x) usuario fila 3");
            } else {
                JOptionPane.showMessageDialog(null, "gana (o) sistema fila 3");
            }
            return true;
        } else if (!p11.equals(" ") && p11.equals(p12) && p11.equals(p13)) {//columnas
            if (p11.equals("x")) {
                JOptionPane.showMessageDialog(null, "gana (x) usuario columna 1");
            } else {
                JOptionPane.showMessageDialog(null, "gana (o) sistema columna 1");
            }
            return true;
        } else if (!p21.equals(" ") && p21.equals(p22) && p21.equals(p23)) {
            if (p21.equals("x")) {
                JOptionPane.showMessageDialog(null, "gana (x) usuario columna 2");
            } else {
                JOptionPane.showMessageDialog(null, "gana (o) sistema columna 2");
            }
            return true;
        } else if (!p31.equals(" ") && p31.equals(p32) && p31.equals(p33)) {
            if (p31.equals("x")) {
                JOptionPane.showMessageDialog(null, "gana (x) usuario columna 3");
            } else {
                JOptionPane.showMessageDialog(null, "gana (o) sistema columna 3");
            }
            return true;
        } else if (!p11.equals(" ") && p11.equals(p22) && p11.equals(p33)) {//diagonales
            if (p11.equals("x")) {
                JOptionPane.showMessageDialog(null, "gana (x) usuario diagonal 1");
            } else {
                JOptionPane.showMessageDialog(null, "gana (o) sistema diagonal 1");
            }
            return true;
        } else if (!p31.equals(" ") && p31.equals(p22) && p31.equals(p13)) {
            if (p31.equals("x")) {
                JOptionPane.showMessageDialog(null, "gana (x) usuario diagonal 2");
            } else {
                JOptionPane.showMessageDialog(null, "gana (o) sistema diagonal 2");
            }
            return true;
        } else if (!p11.equals(" ") && !p21.equals(" ") && !p31.equals(" ")
                && !p12.equals(" ") && !p22.equals(" ") && !p32.equals(" ")
                && !p13.equals(" ") && !p23.equals(" ") && !p33.equals(" ")) {
            JOptionPane.showMessageDialog(null, "empate");
            return true;
        }
        return false;
    }
}
