import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test //===
    public void testFullSizeStations() {   // Граници номеров полного диапазона радиостанций (метод size)
        Radio radio = new Radio(9);
        Assertions.assertEquals(0, radio.getMinCarrentStation());
        Assertions.assertEquals(0, radio.getCarrentStation());
        Assertions.assertEquals(9, radio.getMaxCarrentStation());
    }

    @Test
    public void testMinMaxStations() { // Установка рабочего диапазона станций внутри допустимых значений их номеров
        Radio radio = new Radio(2, 7);
        Assertions.assertEquals(2, radio.getMinCarrentStation());
        Assertions.assertEquals(2, radio.getCarrentStation());
        Assertions.assertEquals(7, radio.getMaxCarrentStation());
    }

    @Test
    public void test0Stations() {      // Минимальное число и номер радиостанции в диапазоне
        Radio radio = new Radio(0);
        Assertions.assertEquals(0, radio.getMinCarrentStation());
        Assertions.assertEquals(0, radio.getCarrentStation());
        Assertions.assertEquals(0, radio.getMaxCarrentStation());
    }

    @Test
    public void testPrevStationsLouHi() {  // Перехода через нижнее значение номера радиостанции ввниз
        Radio radio = new Radio(0, 9);
        radio.prev();
        int actual = radio.getCarrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevStationsHiLou() {    // Переход через верхнее значение номера радиостанции вверх
        Radio radio = new Radio(9);
        radio.setCarrentStation(9);
        radio.next();
        int actual = radio.getCarrentStation();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextStationsInside() { // Переключение с указанного номера вверх на границу указанного диапазона
        Radio radio = new Radio(3);
        radio.setCarrentStation(2);
        radio.next();
        int actual = radio.getCarrentStation();
        int expected = 3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevStationsOuteside() { // Переключение с указанного номера вниз на границу указанного диапазона
        Radio radio = new Radio(3);
        radio.setCarrentStation(5);
        radio.prev();
        int actual = radio.getCarrentStation();
        int expected = 3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextStationsOuteside() { // Переключение с указанного номера за границей указанного диапазона вниз
        Radio radio = new Radio(3);
        radio.setCarrentStation(5);
        radio.next();
        int actual = radio.getCarrentStation();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextStationsOutesideMax() { // Переключение с указанного номера за границей указанного диапазона вниз
        Radio radio = new Radio(9);
        radio.setCarrentStation(0);
        radio.prev();
        int actual = radio.getCarrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevStationsOutesideMin() { // Переключение с "невозможного" номера за границей
        Radio radio = new Radio(-1, 5);            // указанного диапазона вниз (проверка покрытия тестов)
        radio.setCarrentStation(0);
        radio.prev();
        int actual = radio.getCarrentStation();
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testUpVolume_0up() {
        Radio radio = new Radio(20);
        radio.setCarrentVolume(0);
        radio.up();
        int actual = radio.getCarrentVolume();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUpVolume_9Up() {
        Radio radio = new Radio(20);
        radio.setCarrentVolume(101);
        radio.up();
        int actual = radio.getCarrentVolume();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUpVolume_100up() {
        Radio radio = new Radio(20);
        radio.setCarrentVolume(100);
        radio.up();
        int actual = radio.getCarrentVolume();
        int expected = 100;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDowneVolume_0down() {
        Radio radio = new Radio(30);
        radio.setCarrentVolume(0);
        radio.down();
        int actual = radio.getCarrentVolume();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDowneVolume_100down() {
        Radio radio = new Radio(30);
        radio.setCarrentVolume(100);
        radio.down();
        int actual = radio.getCarrentVolume();
        int expected = 99;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDowneVolume_negdown() {
        Radio radio = new Radio(30);
        radio.setCarrentVolume(-1);
        radio.down();
        int actual = radio.getCarrentVolume();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
}
