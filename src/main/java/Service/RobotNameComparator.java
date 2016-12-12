package Service;

import Model.Robot;

import java.util.Comparator;


/**
 * Created by Yelena_Khamitchina on 05.12.2016.
 */
public class RobotNameComparator implements Comparator<Robot> {

    @Override
    public int compare(Robot r1, Robot r2) {
        return r1.getToyName().compareTo(r2.getToyName());
    }
}
