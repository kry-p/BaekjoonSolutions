import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int attempt = Integer.parseInt(input[0]);
        int size = Integer.parseInt(input[1]);
        TrafficLight[] trafficLight = new TrafficLight[size];
        int[] trafficLightPosition = new int[size];
        
        for (int i = 0; i < attempt; i++) {
            input = reader.readLine().split(" ");
            trafficLightPosition[i] = Integer.parseInt(input[0]);
            trafficLight[i] = new TrafficLight(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        }

        int currentPos = 0;
        int elapsedTime = 0;
        int currentTlIndex = 0;

        while (currentPos < size) {
            if (currentTlIndex >= attempt) {
                currentPos += 1;
            } else if (trafficLightPosition[currentTlIndex] == currentPos) {
                if (trafficLight[currentTlIndex].isGreen(elapsedTime)) {
                    currentPos += 1;
                    currentTlIndex += 1;
                } 
            } else {
                currentPos += 1;
            }
            elapsedTime += 1;
        }

        System.out.println(elapsedTime);
    }
}

class TrafficLight {
    private int redTime, greenTime;

    public TrafficLight(int redTime, int greenTime) {
        this.redTime = redTime;
        this.greenTime = greenTime;
    }

    public boolean isGreen(int currentTime) {
        if (currentTime % (redTime + greenTime) >= redTime)
            return true;
        else
            return false;
    }

}