/**
* Health Monitor has students implement 1D arrays as a way to store and analyze a patient's health metrics. 
* The overall goal is to determine whether the patient is healthy by calculating their Health Score,
* and comparing it to predetermined ranges. 
* Write the HealthMonitor program inside the main method as per the assignment description. 
*
* Input Format: 
* | Age | Sleep Duration | Quality of Sleep | Physical Activity Level | Stress Level | Heart Rate | Daily Steps | Sex | BMI | BP | Sleep Disorder |
*
* Compilation: javac healthMonitor.java
* Execution: java healthMonitor <input metrics>
*
* @author Isha Gajera
* @author Anna Lu
*/
public class HealthMonitor {
    public static void main(String[] args) {
        //WRITE YOUR CODE HERE
        double age = Double.parseDouble(args[0]);
        double sleepDuration = Double.parseDouble(args[1]);
        double sleepQuality = Double.parseDouble(args[2]);
        double activityLevel = Double.parseDouble(args[3]);
        double stressLevel = Double.parseDouble(args[4]);
        double heartRate = Double.parseDouble(args[5]);
        double steps = Double.parseDouble(args[6]);

        char sex = args[7].charAt(0);
        char bmiCategory = args[8].charAt(0);
        char bloodPressure = args[9].charAt(0);
        char sleepDisorder = args[10].charAt(0);

        double agePoints = (100-age) / 10;
        double sleepDurationPoints = sleepDuration % 8;
        double sleepQualityPoints = sleepQuality;
        double activityLevelPoints = activityLevel / 10;
        double stressLevelPoints = 10 - stressLevel;

        double heartRatePoints;
        if (heartRate >= 60 && heartRate <= 100) heartRatePoints = 10.0; 
        else if (heartRate < 60) heartRatePoints = 7.0; 
        else heartRatePoints = 5.0; 

        double stepsPoints = (steps / 8000.0) * 10; 

        double bmiPoints = 0;
        if (bmiCategory == 'N') bmiPoints = 10.0;
        else if (bmiCategory == 'O') bmiPoints = 7.0;
        else if (bmiCategory == 'U' ) bmiPoints = 5.0;
        else
        bmiPoints = 3.0;

        double bloodPressurePoints;
        if (bloodPressure == 'N')
           bloodPressurePoints = 10.0;
        else if (bloodPressure == 'E')
           bloodPressurePoints = 7.0;
        else if (bloodPressure == 'O')
           bloodPressurePoints = 5.0;
        else 
           bloodPressurePoints = 3.0;

        double sleepDisorderPoints;
        if (sleepDisorder == 'N')
           sleepDisorderPoints = 10.0;
        else if (sleepDisorder == 'A')
           sleepDisorderPoints = 5.0;
        else 
           sleepDisorderPoints = 3.0;

        double totalScore = 
        (agePoints * 0.10) + 
        (sleepDurationPoints * 0.10) +
        (sleepQualityPoints * 0.10) +
        (activityLevelPoints * 0.10) +
        (stressLevelPoints * 0.10) +
        (heartRatePoints * 0.10) + 
        (stepsPoints * 0.05) +
        (bmiPoints * 0.15) +
        (bloodPressurePoints * 0.10) +
        (sleepDisorderPoints * 0.10);

        String category;
        if (sex== 'M') {
         if (totalScore > 7.5)
            category = "healthy";
        else if (totalScore >= 6.5)
            category = "average";
        else 
            category = "unhealthy";
        }

        else {
         if (totalScore > 7.0)
            category = "healthy";
        else if (totalScore >= 6.0)
            category = "average";
        else 
            category = "unhealthy";
        }

        System.out.println("Patient's health score of " + totalScore + " is " + category + ".");
        
    }
}
