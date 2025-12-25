package com.fullsatck;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {

    private ChallengeService challengeService;                                        //DI

    public ChallengeController(ChallengeService challengeService){
      this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return challengeService.getAllChallenges();
    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge){
       boolean isChallengeAdded = challengeService.addChallenge(challenge);
       if(isChallengeAdded){
             return "Challenge added successfully✅";
       }
       else {
        return "There was an error adding the challenge❌";
       }
      
    }
    
}
