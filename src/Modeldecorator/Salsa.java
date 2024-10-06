/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modeldecorator;

import Abstraccion.Hamburguesa;
import Abstraccion.HamburguesaDecorador;

/**
 *
 * @author jhona
 */
public class Salsa extends HamburguesaDecorador {
    public Salsa(Hamburguesa hamburguesa) {
        super(hamburguesa);
    }

    @Override
    public String getDescripcion() {
        return hamburguesa.getDescripcion() + ", Salsa";
    }

    @Override
    public double getCosto() {
        return hamburguesa.getCosto() + 0.75;
    }
}

