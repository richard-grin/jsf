package fr.rgrin.projetqcm.ejb;

import fr.rgrin.projetqcm.entite.Reponse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author richard
 */
@Stateless
public class ReponseFacade extends AbstractFacade<Reponse> {
  @PersistenceContext(unitName = "qcmPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ReponseFacade() {
    super(Reponse.class);
  }
  
}
