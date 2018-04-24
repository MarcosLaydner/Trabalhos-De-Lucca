package exe;

public class Hash {
	
	public int[] arrayNext;
	public int[] arrayData;
	public int groupNum;

	
	public Hash(int groupNum, int size) {
		
		this.groupNum = groupNum;
		arrayNext = new int[size];
		arrayData = new int[size];
		
		for(int i = 0; i < arrayNext.length; i++) {
			arrayNext[i] = -1;
		}
	}
	
	public int funcHash(int id) {
		return id % groupNum;
	}
	
	public void insert(int num) {
		
		int key = funcHash(num);
		
		if (arrayNext[key] == -1) {
			arrayData[key] = num;
			arrayNext[key] = -2;
		} else {
			 
			for(int i = 0; i < arrayNext.length; i++) {
				if (arrayNext[i] == -1) {
					arrayData[i] = num;
					arrayNext[i] = arrayNext[key];
					arrayNext[key] = i;
					i += arrayNext.length;
				}
			}
		
		
		}
	
	}
	
	public void cu() {
		
	}
	
	
	

}
