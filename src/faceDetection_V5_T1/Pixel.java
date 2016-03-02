package faceDetection_V5_T1;

public class Pixel {
	
	//y = heigth
	//x = width
	//cor = cor em rgb
	private int y;
	private int x;
	private Cor cor;
	private Ponto ponto;
	
	
	public Pixel(){
	}

	
	public Pixel(int x, int y, Cor cor){
		this.x = x;
		this.y = y;
		this.ponto = new Ponto(x, y);
		this.cor = cor;
		
	}
	
	
	public Pixel(int x, int y){
		this.x = x;
		this.y = y;
		this.ponto = new Ponto(x, y);
		this.cor = new Cor(0,0,0);
	}

	public Pixel(int x, int y, String red){
		this.x = x;
		this.y = y;
		this.ponto = new Ponto(x, y);
		this.cor = new Cor(100,0,0);
	}
	

	public Ponto getPonto() {
		return this.ponto;
	}
	

	public int getY() {
		return y;
	}
	

	public int getX() {
		return x;
	}
	

	public Cor getCor() {
		return cor;
	}
	

	public int getColor() {
		return this.cor.getCor();
	}

	
	public int getCorSoma() {
		return cor.getCorSoma();
	}
	
	
	public void setCorSoma(int corSoma){
		cor.setCorSoma(corSoma);
	}
	
	
	public void pixelPosition(){
		
	}
	
	
	@Override
	public String toString() {
		
		return String.format("   x-%dy-%d=i-%dii-%d   ", this.getX(), this.getY(), this.getColor(),this.getCorSoma());
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((ponto == null) ? 0 : ponto.hashCode());
		result = prime * result + x;
		result = prime * result + y;
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
		Pixel other = (Pixel) obj;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (ponto == null) {
			if (other.ponto != null)
				return false;
		} else if (!ponto.equals(other.ponto))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


	
	
	
	
}
