/**
 * Created by Анджей on 13.05.2016.
 */
public class Dog implements Pet {
    private String name;

    public Dog(final String name) {
        this.name = name;
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
    public String getPetType() {
        return "Dog";
    }
}
