package Service;

import Model.Robot;

import java.util.List;

/**
 * Created by Yelena_Khamitchina on 27.11.2016.
 */
public class RobotOrder {
    private String orderId;
    private List<Robot> robotList;

    public RobotOrder(){}

    public RobotOrder(String orderId, List<Robot> robotList){
        this.orderId = orderId;
        this.robotList = robotList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId (String orderId) {
        this.orderId = orderId;
    }

    public List<Robot> getRobotList(){
        return robotList;
    }

    public void setRobotList(List<Robot> robotList) {
        this.robotList = robotList;
    }
}
