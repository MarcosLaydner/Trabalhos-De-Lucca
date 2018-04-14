package trabalhinho1;

public class CakeClass implements datatype{
	
	private int id;
	private boolean hasCake;
	
	public CakeClass(int id, boolean hasCake) {
		this.id = id;
		this.hasCake = hasCake;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public boolean isThereCake() {
		return hasCake;
	}
	public void setCakeStatus(boolean hasCake) {
		this.hasCake = hasCake;
	}

}
