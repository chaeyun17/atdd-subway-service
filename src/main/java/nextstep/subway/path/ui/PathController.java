package nextstep.subway.path.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nextstep.subway.auth.domain.AuthenticationPrincipal;
import nextstep.subway.auth.domain.LoginMember;
import nextstep.subway.path.application.PathService;
import nextstep.subway.path.dto.PathResponse;

@RestController
@RequestMapping("/paths")
public class PathController {

	private final PathService pathService;

	public PathController(final PathService pathService) {
		this.pathService = pathService;
	}

	@GetMapping
	public ResponseEntity findPath(@RequestParam Long source, @RequestParam Long target,
		@AuthenticationPrincipal(required = false) LoginMember loginMember) {
		PathResponse pathResponse = pathService.find(source, target, loginMember);
		return ResponseEntity.ok().body(pathResponse);
	}

}
