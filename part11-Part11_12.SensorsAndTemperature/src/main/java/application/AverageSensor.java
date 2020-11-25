/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel
 */
public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private List<Integer> readingList;
    
    
    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.readingList = new ArrayList<>();
        
    }
    
    public void addSensor(Sensor toAdd){
        sensors.add(toAdd);
    }
    
    public List<Integer> readings(){
        return this.readingList;
    }

    @Override
    public boolean isOn() {
         for (Sensor s: sensors){
             if (s.isOn()){
                 return true;
             }
         }
         return false;
    }

    @Override
    public void setOn() {
        
        for (int i = 0; i<sensors.size();i++){
            sensors.get(i).setOn();    
        }
         
    }

    @Override
    public void setOff() {
        
        for (int i = 0; i<sensors.size();i++){
            sensors.get(i).setOff();    
        }
      
    }

    @Override
    public int read() {
        
        if (isOn()==false||sensors.isEmpty()){
            throw new IllegalStateException("Average Temp Sensor is off");
        }
        
        int total = 0;
        for (int i = 0; i<sensors.size(); i++){
            int read = sensors.get(i).read();
            total = total + read;
        }
        total = total/sensors.size();
        readingList.add(total);
        return total;
        
    }
    
}
