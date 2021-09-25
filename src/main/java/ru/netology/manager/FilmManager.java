package ru.netology.manager;

import ru.netology.domain.FilmItem;

public class FilmManager {
    private FilmItem[] items = new FilmItem[0];
    int currentLength = 10;
    int newLength;

    public FilmManager(int newLength) {
        this.newLength = newLength;
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
        if (newLength > currentLength) {
            newLength = currentLength;
        }
        if (newLength < 0) {
            newLength = 0;
        }
        if (items.length < newLength) {
            newLength = items.length;
        }

        // создание массива для хранения результата
        FilmItem[] result = new FilmItem[newLength];

        // выдаём массив в обратном порядке
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
