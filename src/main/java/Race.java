
public class Race {

    String leaderName = "";
    int leaderDistance = 0;
    int time = 24;
    public void processParticipant(Car participant) {
        int participantDistance = participant.speed * time;
        if (leaderDistance < participantDistance) {
            leaderDistance = participantDistance;
            leaderName = participant.name;
        }
    }
}
