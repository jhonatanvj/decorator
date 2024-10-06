/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concreta;

import Abstraccion.Hamburguesa;

/**
 *
 * @author jhona
 */
public class HamburguesaBasica implements Hamburguesa {
    @Override
    public String getDescripcion() {
        return "Hamburguesa Básica";
    }

    @Override
    public double getCosto() {
        return 5.00;
    }
}

