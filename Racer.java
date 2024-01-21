//Leon Nizovtsov 314801713, Kfir Kraus 318995115
public class Racer implements Runnable{
    //Properties
    private static int globalId = 1;
    private int id;
    private int speed;
    private Track track;
    //Constructor
    Racer(int s, Track t){
        if (s < 1 || s > 10) {
            System.out.println("Error: Invalid speed");
            return;
        }
        id=globalId++;
        speed = s;
        track=t;
    }
    //go synchronized method contain loop that every Thread run distance depend on his speed and after go to sleep for 100 milli to give the other Thread to run
    synchronized void go() {
        int counter=0;
        for (int i = 1; i <= 100; i++) {
            counter+=speed;
            System.out.println("Runner " + id + " ran " + counter + " meters");
            if (counter >= 100) {
                track.setFinishedRacers();
                switch(track.getFinishedRacers()) {
                    case 1:
                        System.out.println("Runner " + id + " finished " + track.getFinishedRacers() + "st");
                        break;
                    case 2:
                        System.out.println("Runner " + id + " finished " + track.getFinishedRacers() + "nd");
                        break;
                    case 3:
                        System.out.println("Runner " + id + " finished " + track.getFinishedRacers() + "rd");
                        break;
                    default:
                        System.out.println("Runner " + id + " finished " + track.getFinishedRacers() + "th");
                        break;
                }
                break;
            }
            try {
                // Simulate the running speed
                Thread.sleep(100 / speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //run method that call the go method.
    public void run() {
        go();
    }
}
