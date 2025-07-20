public class HealthRecord {
    // Instance field
    private int height;  // student's height in centimeters

    // Constants (static final)
    private static final int MIN_PERMITTED_HEIGHT = 50; //fixed
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    // TODO: Initialize appropriately
    // Class-level tracking (static)
    private static int tallestHeight = MIN_PERMITTED_HEIGHT; //1st one to compare when we have nothing to compare with
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;

    // New static fields for average tracking
    private static int counter = 0;      // count number of objects
    private static double averageHeight; // track average height

    public HealthRecord(int height) { //this should be in class
        setHeight(height);
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {

        // TODO: Validate height is within permitted range
        if (height > MIN_PERMITTED_HEIGHT && height < MAX_PERMITTED_HEIGHT) {
            this.height = height;
        } else {
            this.height = DEFAULT_HEIGHT;
        }

        // TODO: Update tallest and shortest heights
        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }
        // Update average using: y' = (y*n + x)/(n+1)
        // Where:
        // y' = new average
        // y = current average
        // n = current count
        averageHeight = (averageHeight * counter + this.height) / (counter + 1);
        counter++;
    }

    public static int getTallestHeight() {
        return tallestHeight;
    }

    public static int getShortestHeight() {
        return shortestHeight;
    }

    public static double getAverageHeight() { //new
        return averageHeight;
    }

    public static int getCounter() { //new
        return counter;
    }

    public void displayDetails() {
        System.out.println("Height (cm) : " + getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("The tallest height (cm) : " + getTallestHeight());
        System.out.println("The shortest height (cm) : " + getShortestHeight());
        System.out.println("Average height (cm) : " + String.format("%.2f", getAverageHeight()));
        System.out.println("Number of records : " + getCounter());

    }

}
