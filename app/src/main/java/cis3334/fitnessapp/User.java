package cis3334.fitnessapp;

/**
 * Created by evangelistachicheko on 4/27/17.
 */
import java.io.Serializable;


public class User implements Serializable {
    private String key;
    private String name;
    private String age;
    private String weight;
    private String height;
    private String heartRate;
    private String bloodPressure;
    private String date;


    public User() {
    }

    /*basic constructor for all strings to be added by the user
    * @param key, name, age, weight, height, heartRate, bloodPressure, date
     */
    public User(String key, String name, String age, String weight, String height, String heartRate, String bloodPressure, String date)  {
        this.key = key;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.date = date;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight(){
        return weight;
    }

    public void  setWeight(String weight){
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    /*
    * method returns string variable values
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", heart rate='" + heartRate + '\'' +
                ", blood pressure='" + bloodPressure + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
