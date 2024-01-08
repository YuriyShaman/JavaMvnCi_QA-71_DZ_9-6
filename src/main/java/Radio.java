public class Radio {

    private int carrentStation;
    private int carrentVolume;

    public void next() {

        if (carrentStation != 9) {
            carrentStation++;
        } else {
            carrentStation = 0;
        }
    }

    public void prev() {
        if (carrentStation != 0) {
            carrentStation--;
        } else {
            carrentStation = 9;
        }
    }

    public int getCarrentStation() {
        return carrentStation;
    }

    public void setCarrentStation(int carentStation) {
        if (carentStation < 0) {
            return;
        }
        if (carentStation > 9) {
            return;
        }
        this.carrentStation = carentStation;
    }

    public void up() {
        if (carrentVolume < 100) {
            carrentVolume++;
        } else {
            carrentVolume = 100;
        }
    }

    public void down() {
        if (carrentVolume > 0) {
            carrentVolume--;
        } else {
            carrentVolume = 0;
        }
    }

    public int getCarrentVolume() {
        return carrentVolume;
    }

    public void setCarrentVolume(int carrentVolume) {
        if (carrentVolume > 100) {
            return;
        }
        if (carrentVolume < 0) {
            return;
        }

        this.carrentVolume = carrentVolume;
    }
}
