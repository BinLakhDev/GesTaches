package com.gestaches.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Tache implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titre;
    private String description;
    private boolean statut;
    private Date dateEcheance;

    public Tache() {

    }


    public Tache(String titre, String description, boolean statut, Date dateEcheance) {
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.dateEcheance = dateEcheance;
    }


    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isStatut() {
        return statut;
    }
    public void setStatut(boolean statut) {
        this.statut = statut;
    }
    public Date getDateEcheance() {
        return dateEcheance;
    }
    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }



}
