/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;
/**
 *
 * @author gubotdev
 */
public class Dealer {
    private Player[] myPlayers;
    private Deck myDeck = new Deck();
    private Hand dealerHand = new Hand();
    private Scanner scan = new Scanner(System.in);
    
    public Dealer(int numOfPlayers){
        
        initMyPlayers(numOfPlayers);
    }
    public void playGame(){
        dealOutOpeningHand();
        takePlayerTurn();
        playOutDealerHand();
        declareWinners();
    }
    public void dealOutOpeningHand(){
        for(int i = 0; i<2; i++){
            for(Player currPlayer : myPlayers){
                currPlayer.getMyHand().addCard(myDeck.dealCard());
            }
            dealerHand.addCard(myDeck.dealCard());
        }
    }
    public void takePlayerTurn(){
        for(Player currPlayer : myPlayers){
                while(currPlayer.getMyHand().getNumOfCards() < 5 &&
                        currPlayer.getMyHand().getScore() < 21){
                    System.out.println(currPlayer.getMyName() + "'s Hand");
                    currPlayer.getMyHand().printHand();
                    System.out.println("Wanna Hit? (y/n)");
                    char opt = scan.next().charAt(0);
                    if(opt == 'y'){
                        currPlayer.getMyHand().addCard(myDeck.dealCard());
                }else{
                        break;
                    }
            }
            currPlayer.getMyHand().printHand();
        }
    }
    public void playOutDealerHand(){
        while(dealerHand.getScore() < 16){
            dealerHand.addCard(myDeck.dealCard());
        }
        dealerHand.printHand();
        
    }
    public void declareWinners(){
        System.out.println("Dealer's Hand: ");
        dealerHand.printHand();
        for(int i = 0; i < myPlayers.length; i++){
            Player currPlayer = myPlayers[i];
            System.out.println(currPlayer.getMyName()+ "'s Hand: ");
            currPlayer.getMyHand().printHand();
            
            if(dealerHand.getScore() > 21 || 
                    currPlayer.getMyHand().getScore() > 21){
                
                if(currPlayer.getMyHand().getScore() > 21){
                    System.out.println(currPlayer.getMyName() +" you busted you"
                    + " loser!");
                    
                }else{
                    System.out.println(currPlayer.getMyName() + " dealer dealer"
                    + " you win");
                    
                }
            }else if(dealerHand.getScore() == 21 || 
                    dealerHand.getNumOfCards() > 4){
                System.out.println(currPlayer.getMyName() +" the dealer won you"
                        + " lose!!"); 
                
            }else if(currPlayer.getMyHand().getNumOfCards() > 4){
                System.out.println(currPlayer.getMyName() + "Five cards under"
                + "must be luck.. YOU WIN");
            }
            else if(currPlayer.getMyHand().getScore() > dealerHand.getScore()){
                System.out.println(currPlayer.getMyName() + " you win this time"
                + " but there will be another.. GOOD JOB");
            }else{
                System.out.println(currPlayer.getMyName() + " quit while you"
                        + " got enough for a cab ride home loser");
            }
        }
        
    }
    private void initMyPlayers(int num){
        myPlayers = new Player[num];
        for(int i = 0; i < myPlayers.length; i++){
            System.out.print("Player "+ (i+1) + " What is your name:");
            String name = scan.next();
            if(name.equals("")){
                myPlayers[i] = new Player(i+1);
            }else{
                myPlayers[i] = new Player(name);
            }
        }
    }
}