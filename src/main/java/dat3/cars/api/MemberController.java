package dat3.cars.api;

import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/members")
@RestController
public class MemberController {

  MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  //Security ADMIN ONLY
  @GetMapping
  List<MemberResponse> getMembers(){
    return memberService.getMembers(true); //True --> Return all, since this is ADMIN only
  }

  //Security ADMIN ONLY
  @GetMapping(path = "/{username}")
  MemberResponse getMemberById(@PathVariable String username) {
    return memberService.findMemberByUsername(username);
  }

  //Security ANONYMOUS
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  MemberResponse addMember(@RequestBody MemberRequest body){
    return memberService.addMember(body);
  }

  //Security ADMIN  (eventually we will change it to use the currently log in user)
  @PutMapping("/{username}")
  ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
    return null;
  }

  //Security ADMIN ONLY
  @PatchMapping("/ranking/{username}/{value}")
  void setRankingForUser(@PathVariable String username, @PathVariable int value) {}

  // Security ADMIN ONLY
  @DeleteMapping("/{username}")
  void deleteMemberByUsername(@PathVariable String username) {}

}
