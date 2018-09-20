/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mkonda
 */
public class Trade {
    
    enum DIRECTION {BUY,SELL};
    
    private long tradeId = -1;
    
    private double quantity = 0;
    
    private String security = null;

    private DIRECTION tradeDirection = DIRECTION.BUY;
	
	public Trade(){
		
	}
	public Trade(DIRECTION direction, long tradeid, double quantity, String security ){
		setTradeDirection(direction);
		setTradeId(tradeid);
		setQuantity(quantity);
		setSecurity(security);
	}
  
    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
    

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public DIRECTION getTradeDirection() {
        return tradeDirection;
    }

    public void setTradeDirection(DIRECTION tradeDirection) {
        this.tradeDirection = tradeDirection;
    }
    
    
}
