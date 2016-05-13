/**
 * Created by Анджей on 13.05.2016.
 */
public class Cat implements Pet{
    private String name;

    public Cat(final String name) {
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
        return "Cat";
    }
}
