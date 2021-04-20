package FrameWork.Utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class FakerGeneration {

    private Faker faker;
    private String firstName;
    private String lastName;
    private String email;
    private String university;
    private String profession;
    private String genre;
    private String age;
    private String address;

    public FakerGeneration(WebDriver driver){
        faker = new Faker(new Locale("pt-BR"));

    }
    public String getFirstName(){
        firstName = faker.name().firstName();
        return firstName;
    }
    public String getLastName(){
        lastName = faker.name().lastName();
        return lastName;
    }
    public String getEmail(){
        email = faker.internet().emailAddress();
        return email;
    }
    public String getUniversity(){
        university = faker.university().name();
        return university;
    }
    public String getProfession(){
        profession = faker.job().title();
        return profession;
    }
    public String getGenre(){
        genre = faker.demographic().sex();
        return genre;
    }
    public String getAge(){

        age = faker.number().digit();
        return age;
    }

    public String getAddress(){

        address = faker.address().streetAddress();
        return address;
    }
}
