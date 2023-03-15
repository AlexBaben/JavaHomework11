package ru.netology.managers;

import ru.netology.data.PosterItem;

public class FilmManager {
    private PosterItem[] items = new PosterItem[0];
    private int boardLimit = 5;

    public FilmManager(int boardLimit) {
        this.boardLimit = boardLimit;
    }
    public FilmManager() {
    }

    public PosterItem[] addNewFilm(PosterItem item) {
        PosterItem[] tmp = new PosterItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
        return items;
    }

    public PosterItem[] findAll() {
        return items;
    }

    public PosterItem[] findLast() {
        PosterItem[] tmp = new PosterItem[boardLimit];
        for (int i = 0; i < boardLimit; i++) {
            tmp[i] = items[items.length - 1 - i];
        }
        items = tmp;
        return items;
    }
}
