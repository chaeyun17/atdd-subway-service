package nextstep.subway.line.dto;

import nextstep.subway.line.domain.Line;
import nextstep.subway.line.domain.Section;
import nextstep.subway.station.domain.Station;

public class SectionRequest {
	private Long upStationId;
	private Long downStationId;
	private int distance;

	public SectionRequest() {
	}

	public SectionRequest(Long upStationId, Long downStationId, int distance) {
		this.upStationId = upStationId;
		this.downStationId = downStationId;
		this.distance = distance;
	}

	public Long getUpStationId() {
		return upStationId;
	}

	public Long getDownStationId() {
		return downStationId;
	}

	public int getDistance() {
		return distance;
	}

	public Section toSection(Line line, Station upStation, Station downStation) {
		return Section.of(null, line, upStation, downStation, distance);
	}
}
