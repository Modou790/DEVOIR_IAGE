package repository;

import model.BD;
import model.IPersonne;
import model.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Impl_mysql implements IPersonne<Personne> {
    private Connection connection;

    public Impl_mysql() {
        this.connection = new BD().getConnection();
    }

    @Override
    public void getAllPersonne(Personne personne) throws SQLException {
        List<Personne> personnes = new ArrayList<>();

        // Récupérer tous les employés
        String sqlEmployes = "SELECT * FROM employe";
        PreparedStatement statementEmployes = connection.prepareStatement(sqlEmployes);
        ResultSet resultSetEmployes = statementEmployes.executeQuery();
        while (resultSetEmployes.next()) {
            int id = resultSetEmployes.getInt("id");
            String nom = resultSetEmployes.getString("nom");
            String prenom = resultSetEmployes.getString("prenom");
            String adresse = resultSetEmployes.getString("adresse");
            int salaire = resultSetEmployes.getInt("salaire");
            String zone = resultSetEmployes.getString("zone");
            Employe employe = new Employe(id, nom, prenom, adresse, salaire, zone);
            personnes.add(employe);
        }

        // Récupérer tous les directeurs
        String sqlDirecteurs = "SELECT * FROM directeur";
        PreparedStatement statementDirecteurs = connection.prepareStatement(sqlDirecteurs);
        ResultSet resultSetDirecteurs = statementDirecteurs.executeQuery();
        while (resultSetDirecteurs.next()) {
            int id = resultSetDirecteurs.getInt("id");
            String nom = resultSetDirecteurs.getString("nom");
            String prenom = resultSetDirecteurs.getString("prenom");
            String adresse = resultSetDirecteurs.getString("adresse");
            String matricule = resultSetDirecteurs.getString("matricule");
            Directeur directeur = new Directeur(id, nom, prenom, adresse, matricule);
            personnes.add(directeur);
        }

        // Utiliser la liste de personnes récupérées comme nécessaire
        for (Personne p : personnes) {
            System.out.println(p);
        }
    }
    }

    @Override
    public void getAllDirecteur(Personne personne) {

    }

    @Override
    public void AddPersonne(Personne personne) {

    }

    @Override
    public void DeleteByMatricule(Personne personne) throws SQLException {

    }

    @Override
    public void UpdatePersonne(Personne personne) throws SQLException {
        try {
            String query = "UPDATE personne SET nom = ?, prenom = ?, adresse = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, personne.getNom());
            preparedStatement.setString(2, personne.getPrenom());
            preparedStatement.setString(3, personne.getAdresse());
            preparedStatement.setInt(4, personne.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }


}
