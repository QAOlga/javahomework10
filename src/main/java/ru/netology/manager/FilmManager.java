package ru.netology.manager;

import ru.netology.domain.FilmItem;

public class FilmManager {
    private FilmItem[] items = new FilmItem[0];
    private int limit = 10;

    //конструктор без параметров
    public FilmManager() {
    }

    //конструктор с одним параметром
    public FilmManager(int limit) {
        if (limit > 10) {
            return;
        }
        this.limit = limit;
    }

    //Добавление фильма
    public void add(FilmItem item) {
        // создаем новый массив на единицу больше размером
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        // копируем поэлементно
        System.arraycopy(items, 0, tmp, 0, items.length);

        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    // определение количества фильмов
    public FilmItem[] getAll() {
        int resultLength = items.length;
        if (resultLength > limit) {
            resultLength = limit;
        }
        if (resultLength < 0) {
            resultLength = 0;
        }

        // создание массива для хранения результата
        FilmItem[] result = new FilmItem[resultLength];

        // выдаём массив в обратном порядке
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
