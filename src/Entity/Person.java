package Entity;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String country;
    private String numberDocument;

    public Person() {
    }

    public Person(int id, String name, String lastName, LocalDate dateOfBirth, String country, String numberDocument) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.numberDocument = numberDocument;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }
}
