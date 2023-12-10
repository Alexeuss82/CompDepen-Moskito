import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.compdependmockito.Film;
import ru.netology.compdependmockito.FilmManager;

public class FilmManagerTest {

    @Test
    public void testAddFilm() {
        FilmManager manager = new FilmManager();
        Film film = new Film("Film 1");
        manager.addFilm(film);
        Film[] result = manager.findAll();
        Assertions.assertArrayEquals(new Film[]{film}, result);
    }

    @Test
    public void testFindAll() {
        FilmManager manager = new FilmManager();
        Film film1 = new Film("Film 1");
        Film film2 = new Film("Film 2");
        manager.addFilm(film1);
        manager.addFilm(film2);
        Film[] result = manager.findAll();
        Assertions.assertArrayEquals(new Film[]{film1, film2}, result);
    }

    @Test
    public void testFindLastDefaultLimit() {
        FilmManager manager = new FilmManager();
        Film film1 = new Film("Film 1");
        Film film2 = new Film("Film 2");
        Film film3 = new Film("Film 3");
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        Film[] result = manager.findLast();
        Assertions.assertArrayEquals(new Film[]{film3, film2, film1}, result);
    }

    @Test
    public void testFindLastCustomLimit() {
        FilmManager manager = new FilmManager(2);
        Film film1 = new Film("Film 1");
        Film film2 = new Film("Film 2");
        Film film3 = new Film("Film 3");
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        Film[] result = manager.findLast();
        Assertions.assertArrayEquals(new Film[]{film3, film2}, result);
    }
}