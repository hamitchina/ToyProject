package Service;

import Model.Robot;
import Model.RobotType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yelena_Khamitchina on 09.12.2016.
 */
public final class RobotHandler {
    private static final Logger log = Logger.getLogger(RobotHandler.class);

    /**
     * Method that represents collection of robots as string
     * @param robots - List of robots
     * @return String which contains fields of the list of robots
     */
    public static String presentRobotsAsString(List<Robot> robots){
        log.info("Enter method \"presentRobotsAsString()\"");
        if (robots != null && robots.size() > 0){
            robots.size();
            log.info("Amount of robots: " + robots.size());
            return robots.toString()+ "\n Count of created robots:" + robots.size();
        } else {
            return "";
        }
    }

    /**
     * Method to export robots as string in pointed file
     * @param filePath - Path to file in the file system
     * @param robots - Collection of the robots
     */
    public static void exportRobotsToFile(String filePath, List<Robot> robots){
        new FileHandler().writeToFile(filePath, presentRobotsAsString(robots));
    }

    /**
     * Method to read file or resource as string
     * @param file - name of file if storeType is RESOURCE or full path to file if it is FILESYSTEM
     * @param storeType
     * @return
     */
    public static String getRobotsAsStringFromFile(String file, FileHandler.StoreType storeType){
        return new FileHandler().readFromFile(file, storeType);
    }

    /**
     * Method to create robots from string
     * @param string - string in right format with fields of robots
     * @return List<Robot> - Collections of robots
     */
    public static List<Robot> deserializeRobotsFromString(String string){
        if (string != null && string.length() > 0){
            if (string.startsWith("[") && string.endsWith("]")){
                string = string.substring(1, string.length() - 1);
                String[] arr = string.split(",");
                if (arr.length > 0){
                    log.info("Founded count of robots: " + arr.length);
                    List<Robot> robots = new ArrayList<>();
                    for (String str : arr){
                        Robot robot = getRobotObjectFromString(str);
                        if (robot != null){
                            robots.add(robot);
                        }
                    }
                    return robots;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Method to build robot object from string
     * @param robotTemplate - string with fields of robot
     * @return new robot with 4 main fields
     */
    private static Robot getRobotObjectFromString(String robotTemplate){
        String[] strArr = robotTemplate.split("\\|");
        if (strArr.length > 0) {
            log.info("Count of founded fields: " + strArr.length);
            Robot robot = new Robot();
            robot.setType(RobotType.valueOf(strArr[0].split("(\\w+=)")[1].toUpperCase()));
            robot.setToyName(strArr[1].split("(\\w+=)")[1]);
            robot.setColor(strArr[2].split("(\\w+=)")[1]);
            robot.setPrice(Integer.parseInt(strArr[3].split("(\\w+=)")[1]));
            return robot;
        } else {
            return null;
        }
    }
}
