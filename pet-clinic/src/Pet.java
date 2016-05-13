/**
 * Created by Анджей on 11.05.2016.
 */
public interface Pet {
    /**
     * Return pet name
     * @return
     */
    String getName();

    /**
     * Setup pet name
     * @param name
     */
    void setName(final String name);

    String getPetType();
}
