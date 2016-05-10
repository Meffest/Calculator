package ru.lesson.lessons;

/**
 * Класс реализует калькулятор.
 */
public class Calculator {
    /**
     * Результат вычисления.
     */
    private int result;

    /**
     * Суммируем аргументы.
     *
     * @param params Аргументы суммирования.
     */
    public void add(int... params) {
        for (int param : params) {
            this.result += param;
        }
    }

    /**
     * Вычитаем аргументы.
     *
     * @param params Аргументы разности.
     */
    public void sub(int... params) {
        this.result = params[0] * 2;
        for (int param : params) {
            this.result -= param;
        }
    }

    /**
     * Перемножаем аргументы.
     *
     * @param params Аргументы произведения.
     */
    public void mul(int... params) {
        for (int param : params) {
            this.result *= param;
        }
    }

    /**
     * Вычисляем деление
     * @param args входящие аргументы
     * @throws UserException Если нет аргументов, выкидываем исключение.
     */
    public void div(int... args) throws UserException{
        if (args.length > 0) {
        this.result = args[0] * args[0];
        for (int params : args) {
            if (params == 0) {
            throw new IllegalArgumentException("You try to div by 0. Please change arg!");
            }
            this.result /= params;
        }
        } else {
         	throw new UserException("You should enter args!");
        }
    }

    /**
     * Получить результат.
     *
     * @return результат вычисления.
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Очистить результат вычисления.
     */
    public void cleanResult() {
        this.result = 0;
    }
}