/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class WorkQueue {
    private ArrayList<WorkRequest> workRequestList;
    
    public WorkQueue(){
        workRequestList = new ArrayList<WorkRequest>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void setWorkRequestList(ArrayList<WorkRequest> workRequestList) {
        this.workRequestList = workRequestList;
    }
    
}
