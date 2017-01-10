/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.PollutionSensors;

import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class PollutionSensorList {
    private ArrayList<PollutionSensor> pollutionSensorList;
    
    public PollutionSensorList()
    {
        pollutionSensorList = new ArrayList<PollutionSensor>();
    }

    public ArrayList<PollutionSensor> getPollutionSensorList() {
        return pollutionSensorList;
    }

    public void setPollutionSensorList(ArrayList<PollutionSensor> pollutionSensorList) {
        this.pollutionSensorList = pollutionSensorList;
    }
    
    public PollutionSensor addSensorDetails(PollutionSensor pollutionSensor)
    {
        pollutionSensorList.add(pollutionSensor);
        return pollutionSensor;
    }
}
