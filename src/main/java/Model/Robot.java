package Model;

/**
 * Created by Yelena_Khamitchina on 24.11.2016.
 */
public class Robot extends Toy implements Comparable<Robot>{
    private RobotType type;
    private boolean hasLight;
    private int robotSize;

    public Robot() {}

    public Robot(int price, String toyName, String color, RobotType type, boolean hasLight, int size) {
        super(price, toyName, color);
        this.type = type;
        this.hasLight = hasLight;
        this.robotSize = size;
    }

    public RobotType getType() {
        return type;
    }

    public void setType(RobotType type) {
        this.type = type;
    }

    public boolean isHasLight() {
        return hasLight;
    }

    public void setHasLight(boolean hasLight) {
        this.hasLight = hasLight;
    }

    public int getRobotSize() {
        return robotSize;
    }

    public void setRobotSize(int robotSize) {
        this.robotSize = robotSize;
    }

    //переопределила метод sound. если это человек, то он может говорить и петь.
    //если это трансформер, то он может только говорить.
    //если это животное, то оно издает звуки животного мира.
    @Override
    public void sound(){
        if (type == RobotType.HUMAN)
            System.out.println("I can speak and sing because I'm human!");
        else if (type == RobotType.TRANSFORMER)
            System.out.println("I can only speak because I'm transformer!");
        else System.out.println("I can sound only as animal!");
    }
    //перегрузила метод move. если придет true, то направление движения вперед иначе назад.
    public void move (boolean goForward){}
    //перегрузила метод move. если придет переменная типа float, то это скорость движения.
    public void move (float Speed) {}

    //переопределила метод toString
    @Override
    public String toString()
    {
//        return "{ \"type\": \"" + type + "\", \"name\": \"" + super.getToyName() + "\", \"color\": \"" + super.getColor()
//                + "\", " + "\"costs\": " + super.getPrice() + "} \n";
        return "type=" + type + "|name=" + getToyName() + "|color=" + getColor() + "|price=" + getPrice();
    }

    //переопределение метода equals для того чтобы было невозможно добавить два и более одинаковых робота в набор
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (hasLight != robot.hasLight) return false;
        if (robotSize != robot.robotSize) return false;
        return type == robot.type;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (hasLight ? 1 : 0);
        result = 31 * result + robotSize;
        return result;
    }

    @Override
    public int compareTo(Robot r) {
        if (this.getPrice() > r.getPrice())
            return 1;
        else if (this.getPrice() < r.getPrice())
            return -1;
        else
            return 0;

    }
}
