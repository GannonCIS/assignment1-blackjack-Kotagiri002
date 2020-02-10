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
    public void dealOutOpeningHand(){
        for(int i = 0; i<2; i++){
            for(Player currPlayer : myPlanner){
                currPlayer.getMyHand().addCard(myDeck.dealCard());
            }
            dealerHand.addCard(myDeck.dealCard());
        }
    }
    public void takePlayerTurn(){
        for(Player currPlayer : myPlayers){
                while(currPlayer.getMyHand().getNumOfCards() < 5 &&
                        currPlayer.getMyHand().getScore() < 21){
                    System.out.println(currPlayer.getName + "s Hand");
                    currPlayer.getMyHand().printHand();
                    System.out.println("Wanna Hit? (y/n)");
                    char opt = scan.next().charAt(0);
                    if(opt == "y"){
                        currPlayer.getMyHand().addCard(myDeck.dealCard());
                }
            }
            currPlayer.getMyHand().printHand();
        }
    }
    public void playerOutDealerHand(){
        while(dealerHand.getScore() < 16){
            dealerHand.addCard(myDeck.dealCard());
        }
        dealerHand.printHand();
    }
    public void declareWinners(){
        
    }
    private void initMyPlayers(int numPlayers){
        myPlayers = new Player(numPlayers);
        for(int i = 0; i < myPlayers.length; i++){
            System.out.print("Player"+ (i+1) + "What is your name");
            String name = scan.next();
            if(name.equals("")){
                myPlayers[i] = new Player(i+1);
            }else{
                myPlayers[i] = new Player(name);
            }
        }
    }
}
