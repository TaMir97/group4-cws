package org.example;

import org.example.entity.Film;
import org.example.repository.FilmRepository;

import java.util.List;
import java.util.logging.Level;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Film film = new Film(null,"asd","ali","gfds",3150,"farsi",9);
        FilmRepository filmRepository = new FilmRepository();
        filmRepository.save(film);
        String byDirector = filmRepository.DirectorNameOfLongestMovie();
        System.out.println(byDirector);
    }
}
