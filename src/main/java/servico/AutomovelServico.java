/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import modelo.Automovel;
import modelo.Categoria;
import modelo.Fabricante;
import modelo.Oferta;
import org.eclipse.persistence.jpa.JpaQuery;
import util.Filtro;

/**
 *
 * @author Matheus Levi
 */
@Stateless
public class AutomovelServico {

    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;

    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<Automovel> getListaAutomoveis() {
        List<Automovel> listaAutomoveis = null;

        Query q = em.createQuery("SELECT a FROM Automovel a");
        listaAutomoveis = q.getResultList();

        return listaAutomoveis;
    }

    public Automovel getAutomovel(int idAutomovel) {
        return this.em.find(Automovel.class, idAutomovel);
    }

    public void salvar(Automovel automovel) {
        this.em.persist(automovel);
    }

    public List<Automovel> getListaAutomoveisFiltro(Filtro filtro) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
        Root<Automovel> automovel = criteriaQuery.from(Automovel.class);
        //Join<Automovel,Oferta> oferta = automovel.join("ofertaList",JoinType.LEFT);
        Join<Automovel,Oferta> oferta = null;
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        Predicate predicateLike=null;
        Predicate predicateFab=null;
        Predicate predicateCat=null;
        Predicate predicateAno=null;
        Predicate predicatePrecoMin=null;
        Predicate predicatePrecoMax=null;
        Predicate predicateNumEstrelas=null;
        Predicate predicateZeroKm=null;
        Predicate predicateCambioAutomatico=null;
        Predicate predicate4Portas=null;
        Predicate predicateDirecaoHidraulica=null;
        Predicate predicateComputadorBordo=null;
        Predicate predicateSistemaAntiRoubo=null;

        //automovel.nomeModelo LIKE %palavraChave%
        if (!filtro.palavraChave.equals("")) {
            predicateLike = criteriaBuilder.and(criteriaBuilder.like
                    (automovel.<String>get("nomeModelo"), "%" + filtro.palavraChave + "%"));
            predicates.add(predicateLike);
        }
        
        //automovel.idCategoria=idCategoria
        if(filtro.categoriaFiltro!=null)
        {
            predicateCat = criteriaBuilder.and(criteriaBuilder.equal
                            (automovel.<String>get("idCategoria"), filtro.categoriaFiltro));
            predicates.add(predicateCat);
        }
        
        
        //automovel.idFabricante=idFabricante
        if(filtro.fabricanteFiltro!=null)
        {
            predicateFab = criteriaBuilder.and(criteriaBuilder.equal
                            (automovel.<String>get("idFabricante"), filtro.fabricanteFiltro));
            predicates.add(predicateFab);
        }
        //automovel.ano = ano
        if(filtro.anoFiltro!=0)
        {
            predicateAno = criteriaBuilder.and(criteriaBuilder.equal
                            (automovel.<String>get("ano"), filtro.anoFiltro));
            predicates.add(predicateAno);
        }
        
        //oferta.preco >= precoMin 
        if(filtro.precoMinFiltro!=0.0)
        {
            oferta = automovel.join("ofertaList",JoinType.LEFT);
            
            predicatePrecoMin = criteriaBuilder.and(criteriaBuilder.ge
                            (oferta.<Double>get("preco"), filtro.precoMinFiltro));
            predicates.add(predicatePrecoMin);
        }
        // oferta.preco < precoMax)
        if(filtro.precoMaxFiltro!=0.0)
        {
            if(oferta==null)
            {
                oferta = automovel.join("ofertaList",JoinType.LEFT);
            }
            
            predicatePrecoMax = criteriaBuilder.and(criteriaBuilder.le
                            (oferta.<Double>get("preco"), filtro.precoMaxFiltro));
            predicates.add(predicatePrecoMax);
        }
        //automovel.numEstrelas = numEstrelas
        if(filtro.numEstrelasFiltro!=0)
        {
            predicateNumEstrelas = criteriaBuilder.and(criteriaBuilder.equal
                            (automovel.<Integer>get("numEstrelas"), filtro.numEstrelasFiltro));
            predicates.add(predicateNumEstrelas);
        }
        //(SELECT avg(avaliacao.nota) FROM avaliacao WHERE avaliacao.idAutomovel=) > 10 - Não pode
        //oferta.ehZeroKm = ehZeroKm
        if(filtro.zeroKmFiltro!=false)
        {
            if(oferta==null)
            {
                oferta = automovel.join("ofertaList",JoinType.LEFT);
            }
            
            predicateZeroKm = criteriaBuilder.and(criteriaBuilder.equal
                            (oferta.<Boolean>get("ehZeroKm"), filtro.zeroKmFiltro));
            predicates.add(predicateZeroKm);
        }
        //oferta.ehAutomatico= ehAutomatico
        if(filtro.cambioAutomaticoFiltro!=false)
        {
            if(oferta==null)
            {
                oferta = automovel.join("ofertaList",JoinType.LEFT);
            }
            
            predicateCambioAutomatico = criteriaBuilder.and(criteriaBuilder.equal
                            (oferta.<Boolean>get("ehAutomatico"), filtro.cambioAutomaticoFiltro));
            predicates.add(predicateCambioAutomatico);
        }
        //oferta.eh4Portas= eh4Portas
        if(filtro.eh4PortasFiltro!=false)
        {
            if(oferta==null)
            {
                oferta = automovel.join("ofertaList",JoinType.LEFT);
            }
            
            predicate4Portas = criteriaBuilder.and(criteriaBuilder.equal
                            (oferta.<Boolean>get("eh4Portas"), filtro.eh4PortasFiltro));
            predicates.add(predicate4Portas);
        }
        //oferta.ehDirecaoHidraulica = ehDirecaoHidraulica
        if(filtro.ehDirecaoHidraulicaFiltro!=false)
        {
            if(oferta==null)
            {
                oferta = automovel.join("ofertaList",JoinType.LEFT);
            }
            
            predicateDirecaoHidraulica = criteriaBuilder.and(criteriaBuilder.equal
                            (oferta.<Boolean>get("ehDirecaoHidraulica"), filtro.ehDirecaoHidraulicaFiltro));
            predicates.add(predicateDirecaoHidraulica);
        }
        //oferta.temComputadorBordo= temComputadorBordo
        if(filtro.temComputadorBordoFiltro!=false)
        {
            if(oferta==null)
            {
                oferta = automovel.join("ofertaList",JoinType.LEFT);
            }
            
            predicateComputadorBordo = criteriaBuilder.and(criteriaBuilder.equal
                            (oferta.<Boolean>get("temComputadorBordo"), filtro.temComputadorBordoFiltro));
            predicates.add(predicateComputadorBordo);
        }
        //oferta.temSistemaAntiRoubo=temSistemaAntiRoubo
        if(filtro.temSistemaAntirouboFiltro!=false)
        {
            if(oferta==null)
            {
                oferta = automovel.join("ofertaList",JoinType.LEFT);
            }
            
            predicateSistemaAntiRoubo = criteriaBuilder.and(criteriaBuilder.equal
                            (oferta.<Boolean>get("temSistemaAntiRoubo"), filtro.temSistemaAntirouboFiltro));
            predicates.add(predicateSistemaAntiRoubo);
        }
        
        
        
        TypedQuery<Automovel> typedQuery = em.createQuery(
                criteriaQuery.select(automovel)
                .where(criteriaBuilder.and(predicates.toArray(new Predicate[]{})))
                .orderBy(criteriaBuilder.asc(automovel.get("nomeModelo"))).distinct(true)
        );
         
        List<Automovel> listaAutomoveisFiltro = typedQuery.getResultList();
        
        String sqlString = typedQuery.unwrap(JpaQuery.class).getDatabaseQuery().getSQLString();

        System.out.println("sqlString = "+sqlString);
        
        return listaAutomoveisFiltro;

    }

}
