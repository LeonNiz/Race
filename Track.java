//Leon Nizovtsov 314801713, Kfir Kraus 318995115
public class Track {
    //Properties
    int finishedRacers ;
    //Constructor
    Track(){
        finishedRacers=0;
    }
    //Getter and Setter method
    int getFinishedRacers() {return finishedRacers;}
    synchronized void setFinishedRacers() {finishedRacers+=1;}
}
