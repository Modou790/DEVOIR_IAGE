package model;


public class Directeur extends Personne {
    private String Matricule;

    public Directeur(int id, String nom, String prenom, String adresse, String matricule) {
        super(id, nom, prenom, adresse);
        Matricule = matricule;
    }

    public String getMatricule() {
        return Matricule;
    }

    private String generateMatricule() {
        return getPrenom().substring(0, 1) + "0000" + getNom().length();
    }

    @Override
    public String toString() {
        return "Directeur{" +
                "Matricule='" + generateMatricule() + '\'' +
                '}';
    }
}
