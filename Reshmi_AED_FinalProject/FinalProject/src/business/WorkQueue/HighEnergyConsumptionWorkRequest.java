/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

/**
 *
 * @author Reshmi
 */
public class HighEnergyConsumptionWorkRequest extends WorkRequest{
    
    private String comment;
    private int energyConsumed;
    private String response;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(int energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
     
    
}
