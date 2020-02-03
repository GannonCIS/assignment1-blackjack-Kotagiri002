/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author gubotdev
 */
public class Dealer {
    private int handValue = 0;
    
    private int winner = 0;
    
    private Hand dealerHand = new Hand();
    
    public Card dealOpeningHands(){
        return null;
    }
    public int takePlayerTurns(Deck deck){
        return handValue;
        
    }
    
    public void playerOutDealerHand() {
        
    }
    
    public int declareWinner(){
        return winner;
    }
}
