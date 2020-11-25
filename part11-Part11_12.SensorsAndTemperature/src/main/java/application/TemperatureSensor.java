/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Joel
 */
public class TemperatureSensor implements Sensor {
    private boolean isOn;
    private Random random;
    
    public TemperatureSensor(){
        this.random = new Random();
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void setOn() {
        this.isOn = true;
    }

    @Override
    public void setOff() {
        this.isOn = false;
    }

    @Override
    public int read() {
        if (isOn() == false) {
			throw new IllegalArgumentException("The device is off");
		} else {
			return random.nextInt(30 + 1 + 30) - 30;
		}
    }

  
    
  
    
}
