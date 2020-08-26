package ladder;

import ladder.domain.Ladder;
import ladder.domain.LineRandomGenerator;
import ladder.domain.Participants;
import ladder.view.InputView;

public class LadderGameController {

    public static void main(String[] args) {
        String names = InputView.scanParticipantNames();

        Participants participants = Participants.of(names);
        int ladderHeight = InputView.scanLadderHeight();

        Ladder ladder = Ladder.of(ladderHeight, new LineRandomGenerator(participants));
    }
}
