package model;
import java.sql.SQLException;
import java.util.List;
public interface IPersonne<T>{
    void getAllPersonne(T t) throws SQLException;
    void getAllDirecteur(T t) throws SQLException;
    void AddPersonne(T t) throws SQLException;
    void DeleteByMatricule(T t)throws SQLException;
    void UpdatePersonne(T t)throws SQLException;
}
