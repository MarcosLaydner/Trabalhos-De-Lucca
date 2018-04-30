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
		
		int key = funcHash(num);
		int next = arrayNext[key];
		
		// percorre vendo se o dado a deletar é referenciado por algum antes dele, e se sim, faz o mesmo referenciar o próximo do num a deletar
		for(int i = 0; i < arrayNext.length; i++) {
			if(arrayNext[i] == num) {
				if(arrayNext[key] != -1) {
					arrayNext[i] = next;
				}
				arrayNext[i] = -2;
				i+= (arrayNext.length + 1);
			}
		}
		arrayNext[key] = -2;
	}
}
