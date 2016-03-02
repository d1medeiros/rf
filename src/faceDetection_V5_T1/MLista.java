package faceDetection_V5_T1;

import java.util.Arrays;
// lista para guardar Pixels em um array e acha-los por um Ponto x e y
public class MLista {
	

	private int p[][];


	public MLista(int xSize, int ySize){
		p = new int[xSize][ySize];
	}

	
	public void add(int x, int y, int valor){
		p[x][y] = valor;
	}
	
	
	public int get(int x, int y){
		return this.p[x][y];
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(p);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MLista other = (MLista) obj;
		if (!Arrays.deepEquals(p, other.p))
			return false;
		return true;
	}

	
	
}
