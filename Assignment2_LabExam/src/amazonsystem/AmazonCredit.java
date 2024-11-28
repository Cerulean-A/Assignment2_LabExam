package amazonsystem;


public abstract class AmazonCredit {
	private float amount;

	private PaymentType type;

	public enum PaymentType {
		
		Cash,Check,Card
	}
	
	protected AmazonCredit(float amount, PaymentType type) {
		this.amount = amount;
		this.type =  type;
		}

	public void Payment(float amount) {
		setAmount(amount);
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}

	
	public float getAmount() {
		return amount;
	}


	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	} 
	

	@Override
	public String toString() {
		return "Payment [amount=" + amount + ", type=" + type + "]";
	} 
	
	
	
}
