package com.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asouqi on 3/13/18.
 */
public class FilmDAO {
    private String url;
    private String userName;
    private String passWord;

    public FilmDAO(String url, String userName, String passWord) {
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
    }

    public List<Film> getFilms(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,userName,passWord);
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery(
                    "select film_id,title,description,release_year from sakila.film;");
            List<Film> films=new ArrayList<>();

            while (set.next()){
                films.add( new Film(set.getLong(1),set.getString(2),
                                    set.getString(3),set.getInt(4)));
            }
            return films;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addFilm(Film film){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,userName,passWord);
            PreparedStatement ps=connection.prepareStatement("INSERT INTO sakila.film" +
                                   "(film_id,title,description,release_year,language_id) VALUE(?,?,?,?,1)");

            ps.setLong(1,film.getId());
            ps.setString(2,film.getTitle());
            ps.setString(3,film.getDescription());
            ps.setInt(4,film.getRelease_year());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void editFilm(Film film){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,userName,passWord);
            PreparedStatement ps=connection.prepareStatement("update sakila.film set  " +
                                      "film_id=?, title=?, description=?, release_year=?   " +
                                       "where film_id=?;");

            ps.setLong(1,film.getId());
            ps.setString(2,film.getTitle());
            ps.setString(3,film.getDescription());
            ps.setInt(4,film.getRelease_year());
            ps.setLong(5,film.getId());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteFilm(long id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,userName,passWord);
            PreparedStatement ps=connection.prepareStatement("DELETE FROM sakila.film WHERE film_id=?");

            ps.setLong(1,id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
