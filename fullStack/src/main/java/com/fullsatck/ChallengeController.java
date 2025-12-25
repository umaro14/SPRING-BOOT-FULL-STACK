package com.fullsatck;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {

    private ChallengeService challengeService;                                        //DI

    public ChallengeController(ChallengeService challengeService){
      this.challengeService = challengeService;
    }
    
    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
       boolean isChallengeAdded = challengeService.addChallenge(challenge);
       if(isChallengeAdded) return new ResponseEntity<>("Challenge added successfully✅", HttpStatus.CREATED);
       else return new ResponseEntity<>("There was an error adding the challenge❌", HttpStatus.BAD_REQUEST) ;
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
       Challenge challenge = challengeService.getChallenge(month);
       if(challenge != null) return new ResponseEntity<>(challenge, HttpStatus.OK);
       else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge){
      boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedChallenge);
      if(isChallengeUpdated) return new ResponseEntity<>("Challenge updated successfully✅", HttpStatus.OK);
      else return new ResponseEntity<>("Cahllenge was not updated❌", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
       boolean isChallengeDeleted =  challengeService.deleteChallenge(id);
       if(isChallengeDeleted) return new ResponseEntity<>("Challenge " + id + " deleted Successfully", HttpStatus.OK);
       else return new ResponseEntity<>("Challenge not deleted", HttpStatus.NOT_FOUND);
    }
}
