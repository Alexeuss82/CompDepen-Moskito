package ru.netology.compdependmockito;

public class FilmManager {
    private Film[] films;
    private final int limit;

    // Конструктор без параметров, устанавливающий лимит в 5
    public FilmManager() {
        this.limit = 5;
        this.films = new Film[0];
    }

    // Конструктор с параметром для задания лимита
    public FilmManager(int limit) {
        this.limit = limit;
        this.films = new Film[0];
    }

    // Метод добавления нового фильма
    public void addFilm(Film movie) {
        Film[] newArray = new Film[films.length + 1];
        System.arraycopy(films, 0, newArray, 0, films.length);
        newArray[films.length] = movie;
        films = newArray;
    }

    // Метод вывода всех фильмов в порядке добавления
    public Film[] findAll() {
        return films;
    }

    // Метод вывода последних фильмов в обратном порядке
    public Film[] findLast() {
        int resultLength = Math.min(limit, films.length);
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - i - 1];
        }
        return result;
    }
}
