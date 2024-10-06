/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstraccion;

/**
 *
 * @author jhona
 */
public abstract class HamburguesaDecorador implements Hamburguesa {
    protected Hamburguesa hamburguesa;

    public HamburguesaDecorador(Hamburguesa hamburguesa) {
        this.hamburguesa = hamburguesa;
    }

    @Override
    public String getDescripcion() {
        return hamburguesa.getDescripcion();
    }

    @Override
    public double getCosto() {
        return hamburguesa.getCosto();
    }
}

