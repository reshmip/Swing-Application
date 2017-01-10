 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Sensors;

import java.util.Date;

/**
 *
 * @author Reshmi
 */
public class Sensor {
    private int sensorId;
    private int numberWatt;
    private int hours;
    private SensorType sensorType;
    private Date readingRecorded;
    private static int count=0;
    private String status;
    private String consumptionLevel;
    public enum SensorType{
        HEATER("Heater"),
        LIGHTS("Incandescent Bulbs"),
        MICROWAVE("Microwave"),
        TELEVISION("Television"),
        REFRIGERATOR("Refrigerator");
        
        private String value;
        private SensorType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }     
    }

    public Sensor()
    {
        count++;
        sensorId = count;
    }
    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public int getNumberWatt() {
        return numberWatt;
    }

    public void setNumberWatt(int numberWatt) {
        this.numberWatt = numberWatt;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public Date getReadingRecorded() {
        return readingRecorded;
    }

    public void setReadingRecorded(Date readingRecorded) {
        this.readingRecorded = readingRecorded;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConsumptionLevel() {
        return consumptionLevel;
    }

    public void setConsumptionLevel(String consumptionLevel) {
        this.consumptionLevel = consumptionLevel;
    }
    
    @Override
    public String toString() {
        return "S"+sensorId;
    }
    
    
}
