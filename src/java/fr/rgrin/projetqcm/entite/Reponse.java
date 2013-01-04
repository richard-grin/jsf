package fr.rgrin.projetqcm.entite;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Une réponse possible pour une question
 */
@Entity
public class Reponse implements Serializable {
  @Id
  @GeneratedValue
  private Long id;
  
  /**
   * Intitulé de cette réponse.
   */
  private String intitule;
  /**
   * Vrai si et seulement si la réponse doit être "cochée" pour donner
   * une bonne réponse à la question.
   * Un bug de Java DB (ou du driver pour Java DB) 
   * fait que ça ne marche pas avec boolean.
   */
//  private boolean ok;
  private char ok;
  
  public Reponse() {
  }

  public Reponse(String intitule, boolean ok) {
    super();
//    this.question = question;
    this.intitule = intitule;
    setOk(ok);
  }
  
  public Long getId() {
    return id;
  }
  
  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    this.intitule = intitule;
  }

  public void setOk(boolean ok) {
    this.ok = (ok == true) ? 'o' : 'n';
  }
  
  public boolean isOk() {
    return ok == 'o';
  }
  
  @Override
  public String toString() {
    return "Reponse [intitule=" + intitule + ", ok=" + ok + "]";
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 47 * hash + Objects.hashCode(this.id);
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
    final Reponse other = (Reponse) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }
}
