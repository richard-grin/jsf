package fr.rgrin.projetqcm.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Une question du QCM
 */
@Entity
public class Question implements Serializable {
  @Id
  @GeneratedValue
  private Long id;
  /**
   * Enoncé de la question
   */
  private String enonce;
  /**
   * Indique si l'utilisateur peut donner plusieurs réponses.
   * Vrai par défaut.
   */
  private boolean reponsesMultiples = true;
  /**
   * Mots-clés pour la recherche de questions. Pratique quand on voudra ajouter
   * des questions à un questionnaire. Séparateur : le point virgule.
   */
  private String motsCles;
  /**
   * Les réponses possibles aux questions. Elles sont chargées en mémoire
   * lorsque la question l'est. Elles sont rendues persistantes lorsque la
   * question l'est. Elles sont supprimées si on les enlève de la question.
   */
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
  orphanRemoval = true)
  private List<Reponse> reponses = new ArrayList<>();

  public Question() {
  }

  /**
   * Crée une nouvelle question.
   *
   * @param enonce énoncé de la question.
   * @param reponsesMultiples vrai si et seulement si plusieurs réponses sont
   * acceptées.
   */
  public Question(String enonce, boolean reponsesMultiples) {
    this.enonce = enonce;
    this.reponsesMultiples = reponsesMultiples;
  }

  /**
   * Crée une nouvelle question qui accepte les réponses multiples.
   * @param enonce 
   */
  public Question(String enonce) {
    this.enonce = enonce;
  }

  public String getEnonce() {
    System.out.println("getEnonce");
    return enonce;
  }

  public void setEnonce(String enonce) {
    this.enonce = enonce;
  }

  public boolean isReponsesMultiples() {
    System.out.println("isReponsesMultiples");
    return reponsesMultiples;
  }

  public void setReponsesMultiples(boolean reponsesMultiples) {
    this.reponsesMultiples = reponsesMultiples;
  }

  public String getMotsCles() {
    System.out.println("getMotsCles");
    return motsCles;
  }

  public void setMotsCles(String motsCles) {
    this.motsCles = motsCles;
  }

  public Long getId() {
    System.out.println("getId");
    return id;
  }

  public List<Reponse> getReponses() {
    System.out.println("getReponses");
    return reponses;
  }
  
  public void setReponses(List<Reponse> reponses) {
    this.reponses = reponses;
  }

  /**
   * Ajoute une réponse possible à la question.
   *
   * @param reponse
   * @param bon true si c'est une bonne réponse.
   */
  public void ajouterReponse(String reponse, boolean bon) {
    this.reponses.add(new Reponse(reponse, bon));
  }
  
  public void ajouterReponse(Reponse reponse) {
    this.reponses.add(reponse);
  }

//  void mettreDansQuestionnaire(Questionnaire questionnaire) {
//    questionnaires.add(questionnaire);
//  }
  /**
   * Affiche la question sur l'écran.
   *
   * @param enteteQuestion ce qu'il faut afficher juste avant d'afficher la
   * question.
   */
  public void afficher(String enteteQuestion) {
    System.out.println("-------------");
    System.out.println(enteteQuestion + " " + enonce);
    for (int i = 0; i < reponses.size(); i++) {
      System.out.println((i + 1) + ". " + reponses.get(i).getIntitule());
    }
  }

  @Override
  public String toString() {
    return "Question [id=" + id + ", enonce=" + enonce 
            + ", reponses=" + reponses 
            + ", adresse=" + super.toString() + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Question other = (Question) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.id);
    return hash;
  }
}
