/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.PollutionSensors;

import java.util.Date;

/**
 *
 * @author Reshmi
 */
public class PollutionSensor {
    private int co2SensorReading;
    private int ch4SensorReading;
    private int n2oSensorReading;
    private Date timeStamp;

    public int getCo2SensorReading() {
        return co2SensorReading;
    }

    public void setCo2SensorReading(int co2SensorReading) {
        this.co2SensorReading = co2SensorReading;
    }

    public int getCh4SensorReading() {
        return ch4SensorReading;
    }

    public void setCh4SensorReading(int ch4SensorReading) {
        this.ch4SensorReading = ch4SensorReading;
    }

    public int getN2oSensorReading() {
        return n2oSensorReading;
    }

    public void setN2oSensorReading(int n2oSensorReading) {
        this.n2oSensorReading = n2oSensorReading;
    } 

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
