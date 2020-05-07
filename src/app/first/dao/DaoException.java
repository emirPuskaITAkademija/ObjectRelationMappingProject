package app.first.dao;


public class DaoException extends Exception{

    public DaoException(String message) {
        super("Data Access Object exception : " + message);
    }
}
