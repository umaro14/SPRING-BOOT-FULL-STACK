package com.fullsatck;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeService {

    private  List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;                                             //the user should not be able to set their id, the service should set it

    public ChallengeService(){
        Challenge challenge1 = new Challenge(1L, "Feb", "Land a tech Job💻");
        challenges.add(challenge1);
    }


    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    public boolean addChallenge(Challenge challenge){
        if(challenge != null){
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        else{
            return false;
        }
       
    }
}
