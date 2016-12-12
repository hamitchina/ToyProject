package Model;

/**
 * Created by Yelena_Khamitchina on 24.11.2016.
 */
public abstract class Toy implements MakingSounds, Movement {
    private int price;
    private String toyName;
    private String color;

    public Toy() {
    }

    public Toy(int price, String toyName, String color) {
        this.price = price;
        this.toyName = toyName;
        this.color = color;
    }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) { this.toyName = toyName; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    @Override
    public void move() {
        System.out.println("Any movements");
    }

    @Override
    public void sound() {
        System.out.println("Any sounds");
    }

    //переопределение метода equals для того чтобы было невозможно добавить два и более одинаковых робота в набор
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (price != toy.price) return false;
        if (toyName != null ? !toyName.equals(toy.toyName) : toy.toyName != null) return false;
        return !(color != null ? !color.equals(toy.color) : toy.color != null);
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (toyName != null ? toyName.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
