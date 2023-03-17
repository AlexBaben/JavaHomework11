package ru.netology.managers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.PosterItem;

public class FilmManagerTest {
    PosterItem item1 = new PosterItem("Бладшот", "", "боевик", 112);
    PosterItem item2 = new PosterItem("Вперед", "", "мультфильм", 113);
    PosterItem item3 = new PosterItem("Отель Белград", "", "комедия", 114);
    PosterItem item4 = new PosterItem("Джентельмены", "", "боевик", 115);
    PosterItem item5 = new PosterItem("Человек-неведимка", "", "ужасы", 116);
    PosterItem item6 = new PosterItem("Тролли. Мировой тур", "", "мультфильм", 117);

    @Test
    public void ShouldAddFilmAndShowAll () {
        FilmManager manager = new FilmManager();
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);
        manager.addNewFilm(item3);

        PosterItem[] expected = {item1,item2,item3};
        PosterItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void ShouldShowLastWhenMore () {
        FilmManager manager = new FilmManager(3);
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);
        manager.addNewFilm(item3);
        manager.addNewFilm(item4);
        manager.addNewFilm(item5);
        manager.addNewFilm(item6);

        PosterItem[] expected = {item6,item5,item4};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void ShouldShowLastWhenLess () {
        FilmManager manager = new FilmManager();
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);

        PosterItem[] expected = {item2,item1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void ShouldShowLastWhenEqual () {
        FilmManager manager = new FilmManager(4);
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);
        manager.addNewFilm(item3);
        manager.addNewFilm(item4);

        PosterItem[] expected = {item4,item3,item2,item1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected,actual);
    }

}
