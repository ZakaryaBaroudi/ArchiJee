package com.infotel.dao;

import java.util.List;

import com.infotel.metier.Personne;


public interface Idao {

	public String creerPersonne (Personne p);
	public Personne modifier (Personne p);
	public void supprimer (Personne p);
	public List<Personne> lister();
}
