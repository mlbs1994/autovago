/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import modelo.Categoria;
import modelo.Fabricante;

/**
 *
 * @author Matheus Levi
 */
public class Filtro implements Serializable
{
    public String palavraChave="";
    public Categoria categoriaFiltro;
    public Fabricante fabricanteFiltro;
    public Integer anoFiltro=0;
    public Double precoMinFiltro=0.0;
    public Double precoMaxFiltro=0.0;
    public Integer numEstrelasFiltro=0;
    public String notaIntervalFiltro="";
    public boolean zeroKmFiltro=false;
    public boolean cambioAutomaticoFiltro=false;
    public boolean eh4PortasFiltro=false;
    public boolean ehDirecaoHidraulicaFiltro=false;
    public boolean temComputadorBordoFiltro=false;
    public boolean temSistemaAntirouboFiltro=false;
    
    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public Categoria getCategoriaFiltro() {
        return categoriaFiltro;
    }

    public void setCategoriaFiltro(Categoria categoriaFiltro) {
        this.categoriaFiltro = categoriaFiltro;
    }

    public Fabricante getFabricanteFiltro() {
        return fabricanteFiltro;
    }

    public void setFabricanteFiltro(Fabricante fabricanteFiltro) {
        this.fabricanteFiltro = fabricanteFiltro;
    }

    public Integer getAnoFiltro() {
        return anoFiltro;
    }

    public void setAnoFiltro(Integer anoFiltro) {
        this.anoFiltro = anoFiltro;
    }

    public Double getPrecoMinFiltro() {
        return precoMinFiltro;
    }

    public void setPrecoMinFiltro(Double precoMinFiltro) {
        this.precoMinFiltro = precoMinFiltro;
    }

    public Double getPrecoMaxFiltro() {
        return precoMaxFiltro;
    }

    public void setPrecoMaxFiltro(Double precoMaxFiltro) {
        this.precoMaxFiltro = precoMaxFiltro;
    }

    public Integer getNumEstrelasFiltro() {
        return numEstrelasFiltro;
    }

    public void setNumEstrelasFiltro(Integer numEstrelasFiltro) {
        this.numEstrelasFiltro = numEstrelasFiltro;
    }

    public String getNotaIntervalFiltro() {
        return notaIntervalFiltro;
    }

    public void setNotaIntervalFiltro(String notaIntervalFiltro) {
        this.notaIntervalFiltro = notaIntervalFiltro;
    }

    public boolean isZeroKmFiltro() {
        return zeroKmFiltro;
    }

    public void setZeroKmFiltro(boolean zeroKmFiltro) {
        this.zeroKmFiltro = zeroKmFiltro;
    }

    public boolean isCambioAutomaticoFiltro() {
        return cambioAutomaticoFiltro;
    }

    public void setCambioAutomaticoFiltro(boolean cambioAutomaticoFiltro) {
        this.cambioAutomaticoFiltro = cambioAutomaticoFiltro;
    }

    public boolean isEh4PortasFiltro() {
        return eh4PortasFiltro;
    }

    public void setEh4PortasFiltro(boolean eh4PortasFiltro) {
        this.eh4PortasFiltro = eh4PortasFiltro;
    }

    public boolean isEhDirecaoHidraulicaFiltro() {
        return ehDirecaoHidraulicaFiltro;
    }

    public void setEhDirecaoHidraulicaFiltro(boolean ehDirecaoHidraulicaFiltro) {
        this.ehDirecaoHidraulicaFiltro = ehDirecaoHidraulicaFiltro;
    }

    public boolean isTemComputadorBordoFiltro() {
        return temComputadorBordoFiltro;
    }

    public void setTemComputadorBordoFiltro(boolean temComputadorBordoFiltro) {
        this.temComputadorBordoFiltro = temComputadorBordoFiltro;
    }

    public boolean isTemSistemaAntirouboFiltro() {
        return temSistemaAntirouboFiltro;
    }

    public void setTemSistemaAntirouboFiltro(boolean temSistemaAntirouboFiltro) {
        this.temSistemaAntirouboFiltro = temSistemaAntirouboFiltro;
    }
    
    public boolean verificarSeVazio()
    {
        boolean vazio=false;
        
        if(palavraChave.isEmpty() &&
                categoriaFiltro==null && 
                fabricanteFiltro==null && 
                anoFiltro==0 &&
                precoMinFiltro==0.0 &&
                precoMaxFiltro==0.0 &&
                numEstrelasFiltro==0 &&
                notaIntervalFiltro.isEmpty() &&
                zeroKmFiltro==false &&
                cambioAutomaticoFiltro==false &&
                eh4PortasFiltro==false &&
                ehDirecaoHidraulicaFiltro==false &&
                temComputadorBordoFiltro==false &&
                temSistemaAntirouboFiltro==false)
        {
            vazio=true;
        }
        
        return vazio;
    }
    
    public void resetarFiltro()
    {
        palavraChave="";
        categoriaFiltro=null;
        fabricanteFiltro=null;
        anoFiltro=0;
        precoMinFiltro=0.0;
        precoMaxFiltro=0.0;
        numEstrelasFiltro=0;
        notaIntervalFiltro="";
        zeroKmFiltro=false;
        cambioAutomaticoFiltro=false;
        eh4PortasFiltro=false;
        ehDirecaoHidraulicaFiltro=false;
        temComputadorBordoFiltro=false;
        temSistemaAntirouboFiltro=false;
    }

   
    
    
}
