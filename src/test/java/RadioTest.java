
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void testNextStations_0next() {
        Radio radio = new Radio();
        radio.setCarrentStation(5);
        radio.setCarrentStation(0);
        radio.next();
        int actual = radio.getCarrentStation();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextStations_8next() {
        Radio radio = new Radio();
        radio.setCarrentStation(5);
        radio.setCarrentStation(8);
        radio.next();
        int actual = radio.getCarrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test //
    public void testNextStations_9next() {
        Radio radio = new Radio();
        radio.setCarrentStation(9);
        radio.next();
        int actual = radio.getCarrentStation();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevStations_0prev() {
        Radio radio = new Radio();
        radio.setCarrentStation(5);
        radio.setCarrentStation(0);
        radio.prev();
        int actual = radio.getCarrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevStations_1prev() {
        Radio radio = new Radio();
        radio.setCarrentStation(1);
        radio.prev();
        int actual = radio.getCarrentStation();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevStations_Up9prev() {
        Radio radio = new Radio();
        radio.setCarrentStation(11);
        radio.prev();
        int actual = radio.getCarrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevStations_Lou0prev() {
        Radio radio = new Radio();
        radio.setCarrentStation(-11);
        radio.prev();
        int actual = radio.getCarrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testUpVolume_0up() {
        Radio radio = new Radio();
        radio.setCarrentVolume(0);
        radio.up();
        int actual = radio.getCarrentVolume();
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test // Для срабатывания ветки
    public void testUpVolume_9Up() {
        Radio radio = new Radio();
        radio.setCarrentVolume(101);
        radio.up();
        int actual = radio.getCarrentVolume();
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUpVolume_100up() {
        Radio radio = new Radio();
        radio.setCarrentVolume(100);
        radio.up();
        int actual = radio.getCarrentVolume();
        int expected = 100;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDowneVolume_0down() {
        Radio radio = new Radio();
        radio.setCarrentVolume(0);
        radio.down();
        int actual = radio.getCarrentVolume();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDowneVolume_100down() {
        Radio radio = new Radio();
        radio.setCarrentVolume(100);
        radio.down();
        int actual = radio.getCarrentVolume();
        int expected = 99;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDowneVolume_negdown() {
        Radio radio = new Radio();
        radio.setCarrentVolume(-1);
        radio.down();
        int actual = radio.getCarrentVolume();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}

