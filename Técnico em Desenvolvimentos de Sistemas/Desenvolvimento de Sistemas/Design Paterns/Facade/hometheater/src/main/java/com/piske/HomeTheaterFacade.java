package com.piske;

import com.piske.Sistema.BluRay;
import com.piske.Sistema.Luz;
import com.piske.Sistema.Projetor;
import com.piske.Sistema.Som;

class HomeTheaterFacade {
    private Projetor projetor;
    private Som som;
    private BluRay bluRay;
    private Luz luz;

    public HomeTheaterFacade() {
        Sistema sistema = new Sistema();
        this.projetor = sistema.new Projetor();
        this.som = sistema.new Som();
        this.bluRay = sistema.new BluRay();
        this.luz = sistema.new Luz();
    }

    void assistirFilme() {
        luz.escurecer();
        projetor.ligar();
        som.ligar();
        bluRay.reproduzirFilme();
    }

    void acabouFilme(){
        luz.acender();
        projetor.desligar();
        som.desligar();
        bluRay.pausarFilme();
    }
}
