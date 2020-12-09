package bsu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Casino {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private String id;
    private String city;
    private String name;
    private Date date;
    private String game;
    private int rateValue;

    public Casino(String id, String city, String name, Date date, String game, int rateValue) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.date = date;
        this.game = game;
        this.rateValue = rateValue;
    }

    public Casino(String args[]) throws IllegalArgumentException, ParseException {
        if (args.length != 6) {
            throw new IllegalArgumentException("wrong DATA used");
        }
        this.id = args[0];
        this.city = args[1];
        this.name = args[2];
        this.date = dateFormat.parse(args[3]);
        this.game = args[4];
        this.rateValue = Integer.parseInt(args[5]);
    }

    public int getRateValue() {
        return rateValue;
    }

    public void setRateValue(int rateValue) {
        this.rateValue = rateValue;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casino casino = (Casino) o;
        return rateValue == casino.rateValue &&
                Objects.equals(id, casino.id) &&
                Objects.equals(city, casino.city) &&
                Objects.equals(name, casino.name) &&
                Objects.equals(date, casino.date) &&
                Objects.equals(game, casino.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, name, date, game, rateValue);
    }

    @Override
    public String toString() {
        return "Casino: " +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", game='" + game + '\'' +
                ", rate value=" + rateValue +
                '.';
    }
}

