package nextstep.subway.line;

import static nextstep.subway.station.StationTest.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.subway.line.domain.Section;
import nextstep.subway.line.domain.Sections;
import nextstep.subway.station.domain.Station;

@DisplayName("구간들 기능")
public class SectionsTest {

	@Test
	@DisplayName("생성 테스트")
	void createTest() {
		// given
		Sections expected = Sections.of(Collections.singletonList(SectionTest.SECTION_1));

		// when
		Sections sections = Sections.of(Collections.singletonList(SectionTest.SECTION_1));

		// then
		assertThat(sections).isEqualTo(expected);
	}

	@Test
	@DisplayName("추가 테스트")
	void addTest() {
		// given
		Sections sections = Sections.of();
		Sections expected = Sections.of(Collections.singletonList(SectionTest.SECTION_1));

		// when
		sections.add(SectionTest.SECTION_1);

		// then
		assertThat(sections).isEqualTo(expected);
	}

	@Test
	@DisplayName("역 목록 반환 테스트")
	void getStationsTest() {
		// given
		Sections sections = Sections.of(Collections.singletonList(SectionTest.SECTION_1));

		// when
		List<Station> stations = sections.getStations();

		// then
		assertThat(stations.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("역 목록 정렬 테스트")
	void getStationsSortTest() {
		// given
		Section section1 = Section.of(1L, 노포역, 서면역, 2);
		Section section2 = Section.of(2L, 서면역, 부산진역, 3);
		Section section3 = Section.of(3L, 부산진역, 다대포해수욕장역, 10);

		Sections sections = Sections.of(Arrays.asList(section1, section2, section3));

		// when
		List<Station> stations = sections.getStations();

		// then
		assertThat(stations).containsExactly(노포역, 서면역, 부산진역, 다대포해수욕장역);
	}

}
