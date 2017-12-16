/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.EJB;
import modelo.Automovel;
import modelo.Avaliacao;
import modelo.Cliente;
import modelo.Usuario;
import servico.AvaliacaoServico;
import servico.ClienteServico;

/**
 *
 * @author Matheus Levi
 */
public class AvaliacaoBean{

   
    Integer nota;
    String comentario;
    
    List<Avaliacao> listaAvaliacoes;
    List<Avaliacao> listaAvaliacoesAutomovel;
    
    @EJB
    private AvaliacaoServico avaliacaoServico;
    
    @EJB
    private ClienteServico clienteServico;
    
    public AvaliacaoBean()
    {
        
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public void setListaAvaliacoes(List<Avaliacao> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }

    public List<Avaliacao> getListaAvaliacoesAutomovel(Automovel automovel) {
        listaAvaliacoesAutomovel = this.avaliacaoServico.getAvaliacoesAutomovel(automovel);
        return listaAvaliacoesAutomovel;
    }

    public void setListaAvaliacoesAutomovel(List<Avaliacao> listaAvaliacoesAutomovel) {
        this.listaAvaliacoesAutomovel = listaAvaliacoesAutomovel;
    }

    public AvaliacaoServico getAvaliacaoServico() {
        return avaliacaoServico;
    }

    public void setAvaliacaoServico(AvaliacaoServico avaliacaoServico) {
        this.avaliacaoServico = avaliacaoServico;
    }

    public ClienteServico getClienteServico() {
        return clienteServico;
    }

    public void setClienteServico(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }
    
    public Long calcularMediaAvaliacaoAutomovel(Automovel automovel)
    {
        Double media = this.avaliacaoServico.getAvgAvaliacaoAutomovel(automovel);
        
        Long mediaRound = Math.round(media);
        
        return mediaRound;
    }
    
    public Long countAvaliacoesAutomovel(Automovel automovel)
    {
        return this.avaliacaoServico.getCountAvaliacoesAutomovel(automovel);
    }
    
    public String getCorAvaliacao(int nota)
    {
        String cor="";
        
        if(nota>=100)
        {
           cor = "darkblue";
        }
        else if(nota>=95)
        {
            cor = "darkgreen";
        }
        else if(nota>=85)
        {
            cor =  "green";
        }
        else if(nota>=80)
        {
            cor = "#0a0";
        }
        else if(nota>=75)
        {
            cor = "#0b0";
        }
        else if(nota>=70)
        {
            cor = "greenyellow";
        }
        else if(nota>=50)
        {
            cor = "yellow";
        }
        else if(nota>=30)
        {
            cor = "orange";
        }
        else if(nota>=30)
        {
            cor = "darkorange";
        }
        else if(nota>=20)
        {
            cor = "#FF3603";
        }
        else if(nota>=10)
        {
            cor = "red";
        }
        else if(nota>=5)
        {
            cor = "#8F1502";
        }
        else if(nota>=0)
        {
            cor = "black";
        }
        
        return cor;
    }
    
    public String getNominalNota(int nota, Automovel automovel)
    {
        String valor="";
        
        long cont=this.countAvaliacoesAutomovel(automovel);
        
        if(cont==0)
        {
            valor = "Nenhuma avaliação";
        }
        else
        {
            if(nota==100)
            {
                valor = "Perfeito ("+cont+" Avaliações)";
            }
            else if(nota>=90)
            {
                valor = "Excelente ("+cont+" Avaliações)";
            }
            else if(nota>=85)
            {
                valor = "Ótimo ("+cont+" Avaliações)";
            }
            else if(nota>=80)
            {
                valor = "Muito bom ("+cont+" Avaliações)";
            }
            else if(nota>=70)
            {
                valor = "Bom ("+cont+" Avaliações)";
            }
            else if(nota>=50)
            {
                valor = "Regular ("+cont+" Avaliações)";
            }
            else if(nota>=40)
            {
                valor = "Ruim ("+cont+" Avaliações)";
            }
            else if(nota>=30)
            {
                valor = "Muito Ruim ("+cont+" Avaliações)";
            }
            else if(nota>=25)
            {
                valor = "Pessimo ("+cont+" Avaliações)";
            }
            else if(nota>=10)
            {
                valor = "Terrível ("+cont+" Avaliações)";
            }
            else if(nota>=0)
            {
                valor = "Inútil ("+cont+" Avaliações)";
            }
        }
        
        return valor;
    }
    
    public String salvar(Automovel automovel, Usuario usr)
    {
        Avaliacao avaliacao = new Avaliacao();
        
        Cliente cliente = this.clienteServico.getClientePorUsuario(usr);
        
        avaliacao.setCliente(cliente);
        avaliacao.setIdAutomovel(automovel);
        avaliacao.setNota(nota);
        avaliacao.setComentario(comentario);
        
        this.avaliacaoServico.salvar(avaliacao);
        
        return "fazerAvaliacao.xhtml?faces-redirect=true";
    }
    
    
    
}
