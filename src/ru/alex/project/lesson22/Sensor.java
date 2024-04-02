package ru.alex.project.lesson22;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sensor {
    private double temperature;
    private double previousTemp;

    private List<Reactionable> reactionables = new ArrayList<>();

    public void addReact(Reactionable reactionable){
        reactionables.add(Objects.requireNonNull(reactionable));
    }

    public void removeReact(Reactionable reactionable){
        reactionables.remove(Objects.requireNonNull(reactionable));
    }

    public void changeTemperature(){
        temperature = Math.random() * 1000;
        reactionables.forEach(reactionable -> {
            reactionable.react(temperature);
            reactionable.log();
            });
    }

    Reactionable red = new Reactionable() {
        @Override
        public void react(double value) {
            if(value > 300){
                System.out.println("red " + value);
                }
        }
        @Override
        public void log() {
            if(temperature > 300 && temperature > previousTemp + 50){
                System.out.println("Температура повышается");
                previousTemp = temperature;
            }
            else if(temperature > 300 && temperature < previousTemp - 50){
                System.out.println("Температура понижается");
                previousTemp = temperature;
            }
        }
    };
    Reactionable yellow = new Reactionable() {
        @Override
        public void react(double value) {
            if(200 < value && value <= 300){
                System.out.println("yellow " + value);
                }
        }
        @Override
        public void log() {
            if(200 < temperature && temperature < 300 && temperature > previousTemp + 30){
                System.out.println("Температура повышается");
                previousTemp = temperature;
            }
            else if(200 < temperature && temperature < 300 && temperature < previousTemp - 30){
                System.out.println("Температура понижается");
                previousTemp = temperature;
            }
        }
    };
    Reactionable green = new Reactionable() {
        @Override
        public void react(double value) {
            if(100 < value && value <= 200){
                System.out.println("green " + value);
                }
        }
        @Override
        public void log() {
            if(100 < temperature && temperature < 200 && temperature > previousTemp + 10){
                System.out.println("Температура повышается");
                previousTemp = temperature;
            }
            else if(100 < temperature && temperature < 200 && temperature < previousTemp - 10){
                System.out.println("Температура понижается");
                previousTemp = temperature;
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Sensor sensor = new Sensor();
        sensor.addReact(sensor.red);
        sensor.addReact(sensor.yellow);
        sensor.addReact(sensor.green);
        sensor.changeTemperature();
        Thread.sleep(3000);
        sensor.changeTemperature();
        Thread.sleep(3000);
        sensor.changeTemperature();
        Thread.sleep(3000);
        sensor.changeTemperature();
        Thread.sleep(3000);
        sensor.changeTemperature();
        Thread.sleep(3000);
        sensor.changeTemperature();
    }
}

