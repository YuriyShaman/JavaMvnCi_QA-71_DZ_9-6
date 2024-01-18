public class Radio {

    private int minCarrentStation = 0;
    private int carrentStation = minCarrentStation;
    private int maxCarrentStation = 9;

    public Radio(int minCarrentStation, int maxCarrentStation) {

        this.minCarrentStation = minCarrentStation;
        this.maxCarrentStation = maxCarrentStation;
        this.carrentStation = minCarrentStation;

        System.out.println("Макс. Радиостанция  № " + maxCarrentStation);
        System.out.println("Мин. Радиостанция  №  " + minCarrentStation);
    }

    public Radio(int size) {
        maxCarrentStation = minCarrentStation + size;


        System.out.println("Макс. Радиостанция  № " + maxCarrentStation);
    }

    public int getMinCarrentStation() {
        return minCarrentStation;
    }

    public int getMaxCarrentStation() {
        return maxCarrentStation;
    }

    public int getCarrentStation() {
        return carrentStation;
    }

    public void setCarrentStation(int carrentStation) {
        if (carrentStation <= minCarrentStation) {
            return;
        }
        if (carrentStation > maxCarrentStation) {
            return;
        }

        this.carrentStation = carrentStation;
    }

    public void next() {
        if (carrentStation != maxCarrentStation) {
            carrentStation++;
        } else {
            carrentStation = minCarrentStation;
        }
    }

    public void prev() {
        if (carrentStation != minCarrentStation) {
            carrentStation--;
        } else {
            carrentStation = maxCarrentStation;
        }
    }




    private int carrentVolume;

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
