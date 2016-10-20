import java.util.Random;

public class BloodPressureRunner {

    public static void main(String[] args) throws Exception {

        Random r = new Random();
        BloodPressureManager bm = new BloodPressureManager();
        BloodPressureManager.HighBloodPressureListener hbpl = bm.new HighBloodPressureListener();

        while (true) {
            int value = r.nextInt(150);
            bm.addData(value);
            bm.setBloodPressureListener(hbpl);
            Thread.sleep(500);
        }
    }
}

class BloodPressureManager {

    private int value;

    public void addData(int value) {
        this.value = value;
    }

    public void setBloodPressureListener(BloodPressureListener bps) {
        if (bps.checkBloodPressure(value)) {
            System.out.println("High Blood Pressure ! (Above 140) ");
        } else {
            System.out.println("Normal Blood Pressure");
        }
    }

    class HighBloodPressureListener implements BloodPressureListener {

        @Override
        public boolean checkBloodPressure(int value) {
            if (value > 140)
                return true;
            return false;
        }

    }

    interface BloodPressureListener {
        public boolean checkBloodPressure(int value);
    }

}
