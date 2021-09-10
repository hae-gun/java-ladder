package nextstep.ladder2.ladder;

import nextstep.ladder2.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("생성 테스트")
    void create(){
        Ladder ladder = new Ladder(new MakeRealLine(), 5, 5);
        assertThat(ladder.lines()).containsExactly(new Line(new MakeRealLine(), 5));
    }

    @Test
    @DisplayName("움직이기")
    void movePlayersTest(){
        LineMaker maker = new LineMaker() {
            @Override
            public List<Boolean> makeLine(int size) {
                return Arrays.asList(true,false,true,false);
            }
        };

        Players players = Players.of("a,b,c,d,e");

        Ladder ladder = new Ladder(maker, 3, players.size());

        ladder.play(players);

        assertThat(players.indexes()).containsExactly(1,0,3,2,4);
    }
}