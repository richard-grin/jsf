package fr.rgrin.projetqcm.jsf;

import fr.rgrin.projetqcm.entite.Question;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author richard
 */
@ManagedBean
@ViewScoped
public class AjoutQuestion {

  private Question questionEnCours;

  public Question getQuestionEnCours() {
    return questionEnCours;
  }

  public void setQuestionEnCours(Question questionEnCours) {
    this.questionEnCours = questionEnCours;
  }

  public void initQuestion() {
    // Le if pour permettre d’ajouter une question
    // en tapant directement l’URL de la page,
    // et aussi pour utiliser la même page pour
    // ajouter une nouvelle question et pour en modifier une.
    if (questionEnCours == null) {
      questionEnCours = new Question();
    }
  }
}
