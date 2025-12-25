package com.fullsatck;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeService {


    private  List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;                                             //the user should not be able to set their id, the service should set it

    public ChallengeService(){
        Challenge challenge1 = new Challenge(0L, "Feb", "Land a tech Job💻");     //default challenge                         //constructor
        challenges.add(challenge1);
    }


    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    public boolean addChallenge(Challenge challenge){
        if(challenge != null){
            challenge.setId(nextId++);                                                         //setId() from Challenge class
            challenges.add(challenge);
            return true;
        }
        else{
            return false;
        }
       
    }

    //get challenge by month
    public Challenge getChallenge(String month) {
        for(Challenge challenge: challenges){
          if(challenge.getMonth().equalsIgnoreCase(month)){
                return  challenge;
           }
        }
        return null;
    }


    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        for(Challenge challenge : challenges){
            if(challenge.getId().equals(id)) {
                challenge.setMonth(updatedChallenge.getMonth());
                challenge.setDescription(updatedChallenge.getDescription());
                return true;
            } 
        }
        return false;
    }


    /* public boolean deleteChallenge(Long id) {
       for(Challenge challenge : challenges){
            if(challenge.getId().equals(id)){
                challenges.remove(challenge);
                return true;
            };
       }
       return false;
    } */

    //SHOTER VERSION WITH LAMBDA EXPRESSION
    public boolean deleteChallenge(Long id) {
       return challenges.removeIf(challenge -> challenge.getId().equals(id));
    } 
}
