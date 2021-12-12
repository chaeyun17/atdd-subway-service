package nextstep.subway.line.domain;

import javax.persistence.Embeddable;

import nextstep.subway.exception.AppException;
import nextstep.subway.exception.ErrorCode;

@Embeddable
public class Distance {

	public static final int MINIMUM = 1;

	private int distance;

	protected Distance() {
	}

	private Distance(int distance) {
		this.distance = distance;
	}

	public static Distance of(int distance) {
		validate(distance);
		return new Distance(distance);
	}

	private static void validate(int distance) {
		if (distance < MINIMUM) {
			throw new AppException(ErrorCode.WRONG_INPUT, "Distance 는 {}보다 커야합니다", MINIMUM);
		}
	}

	public Distance minus(Distance other) {
		return Distance.of(this.distance - other.distance);
	}

	public Distance plus(Distance other) {
		return Distance.of(this.distance + other.distance);
	}

	public boolean lessThanAndEqual(Distance other) {
		return this.distance <= other.distance;
	}

	public int toInt() {
		return distance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Distance distance1 = (Distance)o;

		return distance == distance1.distance;
	}

	@Override
	public int hashCode() {
		return distance;
	}

	@Override
	public String toString() {
		return "Distance{" +
			"distance=" + distance +
			'}';
	}
}
