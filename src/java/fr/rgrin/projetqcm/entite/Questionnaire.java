package fr.rgrin.projetqcm.entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Un QCM.
 */
@Entity
public class Questionnaire {
  @Id
  @GeneratedValue
  private Long id;
  /**
   * Les questions du QCM.
   */
  @ManyToMany
  private List<Question> questions = new ArrayList<>();
  /**
   * Le titre du Questionnaire.
   */
  private String titre;
  /**
   * Le thème du questionnaire. Permet de classer les questionnaires.
   */
  private String theme;

  public Questionnaire() {
  }
  
  /**
   * Crée un questionnaire avec un titre.
   * @param titre titre du questionnaire.
   */
  public Questionnaire(String titre) {
    this.titre = titre;
  }

  public Long getId() {
    return id;
  }
  
  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getTheme() {
    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  /**
   * Ajoute une question au questionnaire.
   * Gère les 2 bouts de l'association.
   * @param question question qui est ajoutée.
   */
  public void ajouterQuestion(Question question) {
    this.questions.add(question);
//    question.mettreDansQuestionnaire(this);
  }

  @Override
  public String toString() {
    return "Questionnaire{" + "questions=" + questions + ", titre=" + titre + ", theme=" + theme + '}';
  }

  public List<Question> getQuestions() {
    return questions;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Questionnaire other = (Questionnaire) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

}
