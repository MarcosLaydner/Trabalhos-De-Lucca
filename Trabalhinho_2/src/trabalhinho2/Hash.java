package trabalhinho2;

public class Hash {
	
	public int[] arrayNext;
	public int[] arrayData;
	public int tamanhoEspalhamento;
	public int firstFree;

	// Legenda:
	// -1 = Nao vazio, mas sem proximo
	// -2 = vazio e sem proximo
	
	public Hash(int tamanhoEspalhamento, int size) {
		
		this.tamanhoEspalhamento = tamanhoEspalhamento;
		arrayNext = new int[size];
		arrayData = new int[size];
		this.firstFree = tamanhoEspalhamento +1;
		
		for (int i = 0; i < tamanhoEspalhamento; i++) {
			arrayNext[i] = -2;
		}
		
		for(int i = tamanhoEspalhamento; i < arrayNext.length; i++) {
			
			if (i+1 < arrayNext.length) {
				arrayNext[i] = i+1;
			} else {
				arrayNext[i] = -2;
			}
		}
	}
	
	public int funcHash(int id) {
		return id % tamanhoEspalhamento;
	}
	
	public boolean search(int num) {
		
		
		int current = funcHash(num);
		
		
		while (current != -1) {
			
			if(arrayNext[current] == -2) {
				return false;
			
			}else if (arrayData[current] == num) {
				return true;
			} else {
				current = arrayNext[current];
			}
		 }
		return false;
	}
	
	public void insert(int num) {
		
		int key = funcHash(num);
		

		if (arrayNext[key] == -2) {
			arrayData[key] = num;
			arrayNext[key] = -1;

		} else if(firstFree != -2) {

			arrayData[firstFree] = num;
			int aux = firstFree;
			firstFree = arrayNext[firstFree];
			arrayNext[aux] = -1;
			arrayNext[key] = firstFree;
		
		} else {
			System.out.println("Hash full");
		}
	}
	public void delete(int num) {
		boolean first = true;
		int key = funcHash(num);
		int prevKey = key;
		if(arrayNext[key] == -1) {
			if(arrayData[key] == num) {
				arrayNext[key] = -2;
			}
			else {
				System.out.println("Number not found for deletion");
			}
		}
		else {
			while (key != -1) {
				
				if(arrayNext[key] == -2) {
					System.out.println("Number not found for deletion");
					key = -1;
				
				}else if (arrayData[key] == num) {
					if(first) {
						arrayData[key] =  arrayData[arrayNext[key]];
						arrayNext[key] = arrayNext[arrayNext[key]];
					}else {
						
						arrayNext[prevKey] = arrayNext[key];
						if(arrayNext[key] != -1) {
							arrayNext[key] = arrayNext[arrayNext[key]];
						}	
					}
				} else {
					first = false;
					prevKey = key;
					key = arrayNext[key];
				}
			 }
		}
	}
}
