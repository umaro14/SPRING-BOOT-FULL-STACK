package com.fullsatck;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {

    private  List<Challenge> challenges = new ArrayList<>();

    public ChallengeController(){
        Challenge challenge1 = new Challenge(1L, "January", "programming language🩷");
        Challenge challenge2 = new Challenge(2L, "Feb", "Land a tech Job💻");
        challenges.add(challenge1);
        challenges.add(challenge2);
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge){
       challenges.add(challenge);
       return "Challenge added successfully";
    }
    
}
