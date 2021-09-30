package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class FilmManagerTest {

    private FilmManager manager;
    private FilmItem first = new FilmItem(1, "Дюна", "фантастика");
    private FilmItem second = new FilmItem(2, "My little pony", "мультфильм");
    private FilmItem third = new FilmItem(3, "После пробуждения", "комедия");
    private FilmItem fourth = new FilmItem(4, "Босс-молокосос", "мультфильм");
    private FilmItem fifth = new FilmItem(5, "Фиксикино", "мультфильм");
    private FilmItem sixth = new FilmItem(6, "Главный герой", "комедия");
    private FilmItem seventh = new FilmItem(7, "Крепкий орешек", "боевик");
    private FilmItem eighth = new FilmItem(8, "Тачки", "мультфильм");
    private FilmItem ninth = new FilmItem(9, "Махнемся телами", "комедия");
    private FilmItem tenth = new FilmItem(10, "Злое", "ужасы");
    private FilmItem eleventh = new FilmItem(11, "Не время умирать", "драма");
    private FilmItem twelvth = new FilmItem(12, "Тест", "триллер");

    @Test
    void ShouldShowWithoutParam() {
        manager = new FilmManager();
    }

    @Test
    void ShouldResultLengthMoreThanLimit() {

        manager = new FilmManager(11);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);

        FilmItem[] expected = new FilmItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, manager.getAll());

    }

    @Test
    void ShouldShowOnlyLast10WhenAddedMore() {

        manager = new FilmManager(10);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void ShouldShowOnlyLast10WhenInRequestMore() {

        manager = new FilmManager(11);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void ShouldShowOnlyLast5WhenAdded10() {

        manager = new FilmManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth};

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldMinusEmpty() {

        manager = new FilmManager(-2);

        FilmItem[] expected = new FilmItem[]{};

        assertArrayEquals(expected, manager.getAll());

//        System.out.println(Arrays.toString(items));
    }
}