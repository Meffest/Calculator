package ru.andzhey.clinic;

/**
 * Created by Анджей on 14.05.2016.
 */
public class ChudoUdo implements Pet {
    private String name;
    private String petType;

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public ChudoUdo(final String name, final String petType) {
        this.name = name;
        this.petType = petType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public  String getPetType() {
        return this.petType;
    }
}
