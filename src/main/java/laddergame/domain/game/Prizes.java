package laddergame.domain.game;

import laddergame.domain.vo.Column;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(final String[] resultNames) {
        validateResultNames(resultNames);
        prizes = createResults(resultNames);
    }

    private List<Prize> createResults(final String[] resultNames) {
        return IntStream.range(0, resultNames.length)
                .mapToObj(column -> new Prize(resultNames[column], column + 1))
                .collect(Collectors.toList());
    }

    private void validateResultNames(final String[] resultNames) {
        if (Objects.isNull(resultNames) || resultNames.length == 0) {
            throw new IllegalArgumentException("입력한 실행 결과들이 Null 또는 빈 배열입니다.");
        }
    }

    public Prize findByColumn(final Column findColumn) {
        return prizes.stream()
                .filter(result -> result.isSameColumn(findColumn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 열 번호가 없습니다. - " + findColumn.toInt()));
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}