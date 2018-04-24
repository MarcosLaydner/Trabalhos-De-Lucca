package trabalhinho2;

public class Hash {
	
	public int[] arrayNext;
	public int[] arrayData;
	public int tamanhoEspalhamento;

	
	public Hash(int tamanhoEspalhamento, int size) {
		
		this.tamanhoEspalhamento = tamanhoEspalhamento;
		arrayNext = new int[size];
		arrayData = new int[size];
		
		for(int i = tamanhoEspalhamento; i < arrayNext.length; i++) {
			
			if (i+1 < arrayNext.length) {
				arrayNext[i] = i+1;
			} else {
				arrayNext[i] = -1;
			}
				
		}
	}
	
	public int funcHash(int id) {
		return id % tamanhoEspalhamento;
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
	
	
	
	
	

}
