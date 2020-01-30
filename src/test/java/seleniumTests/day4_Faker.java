package seleniumTests;

import com.github.javafaker.Faker;

public class day4_Faker {
    public static void main(String[] args) {
        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
    }

}
