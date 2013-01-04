package fr.rgrin.projetqcm.jsf;

import fr.rgrin.projetqcm.ejb.QuestionFacade;
import fr.rgrin.projetqcm.entite.Question;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Backing bean pour la liste des questions.
 * @author richard
 */
@Named
@RequestScoped
public class ListeQuestions {
  @EJB
  private QuestionFacade questionFacade;
  private List<Question> questions;
  
  

  public List<Question> getQuestions() {
    if (questions == null) {
      questions = questionFacade.findAll();
    }
    return questions;
  }
  
  
}
