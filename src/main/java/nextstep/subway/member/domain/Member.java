package nextstep.subway.member.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import nextstep.subway.BaseEntity;
import nextstep.subway.auth.application.AuthorizationException;
import nextstep.subway.auth.domain.LoginMember;

@Entity
public class Member extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private Email email;

	private String password;

	@Embedded
	private Age age;

	protected Member() {
	}

	private Member(Long id, String email, String password, Integer age) {
		this.id = id;
		this.email = Email.of(email);
		this.password = password;
		this.age = Age.of(age);
	}

	public static Member of(String email, String password, Integer age) {
		return new Member(null, email, password, age);
	}

	public static Member of(Long id, String email, String password, Integer age) {
		return new Member(id, email, password, age);
	}

	public Long getId() {
		return id;
	}

	public Email getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Age getAge() {
		return age;
	}

	public void update(Member member) {
		this.email = member.email;
		this.password = member.password;
		this.age = member.age;
	}

	public void checkPassword(String password) {
		if (!StringUtils.equals(this.password, password)) {
			throw new AuthorizationException();
		}
	}

	public LoginMember toLoginMember() {
		return new LoginMember(id, email, age);
	}
}
