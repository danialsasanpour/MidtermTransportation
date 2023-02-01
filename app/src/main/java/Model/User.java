package Model;

import androidx.annotation.NonNull;

public class User {

    private String username;
    private String takeBus;
    private String takeMetro;
    private String takeCar;
    private String takeBike;


    public User(String username, String takeBus, String takeMetro, String takeCar, String takeBike) {
        this.username = username;
        this.takeBus = takeBus;
        this.takeMetro = takeMetro;
        this.takeCar = takeCar;
        this.takeBike = takeBike;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTakeBus() {
        return takeBus;
    }

    public void setTakeBus(String takeBus) {
        this.takeBus = takeBus;
    }

    public String getTakeMetro() {
        return takeMetro;
    }

    public void setTakeMetro(String takeMetro) {
        this.takeMetro = takeMetro;
    }

    public String getTakeCar() {
        return takeCar;
    }

    public void setTakeCar(String takeCar) {
        this.takeCar = takeCar;
    }

    public String getTakeBike() {
        return takeBike;
    }

    public void setTakeBike(String takeBike) {
        this.takeBike = takeBike;
    }


    @NonNull
    @Override
    public String toString() {
        return "Username: " + username + "| Take Bus: " +
                takeBus + "| Take Metro: " + takeMetro +
                "| Take Car: " + takeCar + "| Take Bike: " + getTakeBike();
    }


}
