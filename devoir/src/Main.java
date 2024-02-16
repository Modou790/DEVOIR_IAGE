import Metier.fonctionalite;
import model.BD;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)
    {
        System.out.println(
                "Personne id nom prenom adresse(c'est [Dakar, Thies, Louga] Ennumeration)" +
                "Employe salaire zone(c'est PA , Mbao)" +
                "Directeur  Matricule(c'est premiere caractere du prenom +0000+ taille du nom) enume" +
                "pour IOperaion : getAllEmploye , getAllDirecteur, addPersonne, DeleteByMatricule ,UpdatePersonne" );
        BD db = new BD();
        db.getConnection();


        int choix;

        fonctionalite fonctionnalite = new fonctionalite();

        do {
            choix = fonctionnalite.menu();

            try {
                switch (choix) {
                    case 1:
                        fonctionnalite.ajoutPersonne();
                        break;
                    case 2:
                        fonctionnalite.printAllPersonne();
                        break;
                    case 3:
                        fonctionnalite.searchBymatricule();
                        break;
                    case 4:
                        fonctionnalite.deletePersonne();
                        break;
                    case 5:
                        fonctionnalite.updatePersonne();
                        break;
                    default:
                        System.out.println("Ciao Ciao !!!");
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de l'exécution de l'opération : " + e.getMessage());
            }
        } while (choix != 6);

    }
}