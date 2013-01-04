/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rgrin.projetqcm.ejb;

import fr.rgrin.projetqcm.entite.Question;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author richard
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question> {
  @PersistenceContext(unitName = "qcmPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public QuestionFacade() {
    super(Question.class);
  }
  
}
