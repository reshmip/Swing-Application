/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Sensors;

import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class SensorsCatalog {
    private ArrayList<Sensor> sensorsList;
    
    public SensorsCatalog()
    {
        sensorsList = new ArrayList<Sensor>();
    }

    public ArrayList<Sensor> getSensorsList() {
        return sensorsList;
    }

    public void setSensorsList(ArrayList<Sensor> sensorsList) {
        this.sensorsList = sensorsList;
    }
    
    public Sensor addSensor(Sensor sensor)
    {
       // sensor = new Sensor();
        sensorsList.add(sensor);
        return sensor;
    }
    
     public String ExcessConsumption(Sensor sensor,int watts)
    {
        String consumption = "Efficient";
        int excessVal = 0;
        String name = sensor.getSensorType().getValue();
        /*Heater*/
        if(name.equals("Heater")){
            if(watts>800){
                excessVal = watts-800;
                consumption=excessVal+" excess consumption";
            }
        }
        /*Lights*/
        if(name.equals("Incandescent Bulbs")){
            if(watts>100){
                excessVal = watts-100;
                consumption=excessVal+" excess consumption";
            }
        }
        /*Microwave*/
        if(name.equals("Microwave")){
            if(watts>800){
                excessVal = watts-800;
                consumption=excessVal+" excess consumption";
            }
        }
        /*Television*/
        if(name.equals("Television")){
            if(watts>213){
                excessVal = watts-213;
                consumption=excessVal+" excess consumption";
            }
        }
        /*Refrigerator*/
        if(name.equals("Refrigerator")){
            if(watts>750){
                excessVal = watts-750;
                consumption=excessVal+" excess consumption";
            }
        }
        return consumption;
    }
}
