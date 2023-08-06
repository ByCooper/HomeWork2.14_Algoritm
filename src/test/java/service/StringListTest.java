package service;

import exception.NotFoundElementException;
import exception.NullValueFindException;
import exception.OutsideSelectException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {
    StringList actualList = new StringList();
    StringList expectedList = new StringList();
    @Test
    void addSucces() {
        //Подготовка входных данных
        String actual = actualList.add("Test");
        //Подготовка ожидаемого результата
        String expected = "Test";
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void addSuccesIndex() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        String actual = actualList.add(2,"Test");
        //Подготовка ожидаемого результата
        String expected = "Test";
        expectedList.add("Lexus");
        expectedList.add("Audi");
        expectedList.add(expected);
        expectedList.add("Porsche");
        //Начало теста
        assertEquals(expected, actual);
        assertEquals(expectedList.repository.toString(), actualList.repository.toString());
    }
    @Test
    void addExceptionIndex() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        Exception exception = assertThrows(OutsideSelectException.class, () -> {
            actualList.add(4,"Test");
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "Вы выбрали индекс, который находится за пределами массива";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void set() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        String actual = actualList.set(1, "BMW");
        //Подготовка ожидаемого результата
        expectedList.add("Lexus");
        expectedList.add("BMW");
        expectedList.add("Porsche");
        String expected = "BMW";
        //Начало теста
        assertEquals(expected, actual);
        assertEquals(expectedList.repository.toString(), actualList.repository.toString());
    }
    @Test
    void setEcxeption() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        Exception exception = assertThrows(OutsideSelectException.class, () ->{
            actualList.set(3, "BMW");
        });
        String actual = actualList.set(1, "BMW");
        //Подготовка ожидаемого результата
        String expectedMessage = "Вы выбрали индекс, который находится за пределами массива";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void remove() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        String actual = actualList.remove("Audi");
        //Подготовка ожидаемого результата
        String expected = "Элемент Audi удален";
        expectedList.add("Lexus");
        expectedList.add("Porsche");
        //Начало теста
        assertEquals(expected, actual);
        assertEquals(expectedList.repository.toString(), actualList.repository.toString());
    }
    @Test
    void removeException() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        Exception exception = assertThrows(NotFoundElementException.class, () -> {
            actualList.remove("Mazda");
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "Элемент не найден";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void removeIndex() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        String actual = actualList.remove(2);
        //Подготовка ожидаемого результата
        String expected = "Элемент Porsche удален";
        expectedList.add("Lexus");
        expectedList.add("Audi");
        //Начало теста
        assertEquals(expected, actual);
        assertEquals(expectedList.repository.toString(), actualList.repository.toString());
    }
    @Test
    void removeIndexException() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        Exception exception = assertThrows(OutsideSelectException.class, () -> {
            actualList.remove(3);
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "Вы выбрали индекс, который находится за пределами массива";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void contains() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        boolean actual = actualList.contains("Audi");
        //Начало теста
        assertTrue(actual);
    }
    @Test
    void containsException() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add(null);
        actualList.add("Porsche");
        Exception exception = assertThrows(NullValueFindException.class, () -> {
            actualList.contains(null);
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "В списке недопустимое значение=null";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void indexOfSuccess() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        int actual = actualList.indexOf("Porsche");
        //Подготовка ожидаемого результата
        int expected = 2;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void indexOfNegative() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        int actual = actualList.indexOf("BMW");
        //Подготовка ожидаемого результата
        int expected = - 1;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void lastIndexOfSuccess() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        int actual = actualList.indexOf("Porsche");
        //Подготовка ожидаемого результата
        int expected = 2;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void lastIndexOfNegative() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        int actual = actualList.indexOf("BMW");
        //Подготовка ожидаемого результата
        int expected = - 1;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void getSuccess() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        String actual = actualList.get(1);
        //Подготовка ожидаемого результата
        String expected = "Audi";
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void getException() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        Exception exception = assertThrows(OutsideSelectException.class, () -> {
            actualList.get(3);
        });
        //Подготовка ожидаемого результата
        String expectedMessage = "Вы выбрали индекс, который находится за пределами массива";
        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void testEqualsTrue() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        //Подготовка ожидаемого результата
        expectedList.add("Lexus");
        expectedList.add("Audi");
        expectedList.add("Porsche");
        //Начало теста
        assertTrue(expectedList.equals(actualList));
    }
    @Test
    void testEqualsFalse() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        //Подготовка ожидаемого результата
        expectedList.add("BMW");
        expectedList.add("Audi");
        expectedList.add("Porsche");
        //Начало теста
        assertFalse(expectedList.equals(actualList));
    }
    @Test
    void size() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        int actual = actualList.size();
        //Подготовка ожидаемого результата
        int expected = 3;
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void isEmptyTrue() {
        //Начало теста
        assertTrue(actualList.isEmpty());
    }
    @Test
    void isEmptyFalse() {
        //Подготовка входных данных
        actualList.add("Audi");
        //Начало теста
        assertFalse(actualList.isEmpty());
    }
    @Test
    void clear() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        actualList.clear();
        int actual = actualList.size();
        //Подготовка ожидаемого результата
        int expected = expectedList.size();
        //Начало теста
        assertEquals(expected, actual);
    }
    @Test
    void toArray() {
        //Подготовка входных данных
        actualList.add("Lexus");
        actualList.add("Audi");
        actualList.add("Porsche");
        String[] actual = actualList.toArray();
        //Подготовка ожидаемого результата
        expectedList.add("Lexus");
        expectedList.add("Audi");
        expectedList.add("Porsche");
        String[] expected = expectedList.toArray();
        //Начало теста
        assertArrayEquals(expected, actual);
    }
}