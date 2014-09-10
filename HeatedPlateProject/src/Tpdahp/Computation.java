package Tpdahp;

public class Computation {
	
	int d, top, bot, left, right;
	double[][] oldPlate, newPlate;
	
	public Computation(int d, int top, int bot, int left, int right,
			double[][] oldPlate, double[][] newPlate) {
		super();
		this.d = d;
		this.top = top;
		this.bot = bot;
		this.left = left;
		this.right = right;
		this.oldPlate = oldPlate;
		this.newPlate = newPlate;
	}
	
	public int getD() {
		return d;
	}

	public Computation() {
		super();
	}

	public void setD(int d) {
		if(d < 1 || d!= (int)d) {
            throw new IllegalArgumentException("Dimensions must be valid!");
        }
		this.d = d;
	}
	
	public void setTop(int top) {
		if(top > 100.0 || top < 0.0){
			throw new IllegalArgumentException("Temperature must be greater than 0 and less than 100.0");
		}
		this.top = top;
	}

	public void setBot(int bot) {
		if(bot > 100.0 || bot < 0.0){
			throw new IllegalArgumentException("Temperature must be greater than 0 and less than 100.0");
		}
		this.bot = bot;
	}

	public void setLeft(int left) {
		if(left > 100.0 || left < 0.0){
			throw new IllegalArgumentException("Temperature must be greater than 0 and less than 100.0");
		}
		this.left = left;
	}

	public void setRight(int right) {
		if(right > 100.0 || right < 0.0){
			throw new IllegalArgumentException("Temperature must be greater than 0 and less than 100.0");
		}
		this.right = right;
	}

	double[][] initialize(double[][] plate){
		
		for(int i = 1; i<=d; i++){
			//initializing edges to corresponding values
			plate[0][i] = top;
			plate[d+1][i] = bot;
			plate[i][0] = left;
			plate[i][d+1] = right;
			
			//initializing rest of the nodes to 0.0
			for(int j = 1; j<=d; j++){
				plate[i][j] = 0.0;
			}
		}
		return plate;
	}
	
	void compute(double[][] oldPlate, double[][] newPlate){
		int done = 0;
		int equalibriumFlag = 0;
		while(done!=(d*20)){
			for(int i = 1; i<=d; i++){
				for(int j = 1; j<=d; j++){
					newPlate[i][j] = (oldPlate[i+1][j] + oldPlate[i-1][j]
							+ oldPlate[i][j+1] + oldPlate[i][j-1])/4.0;
					if(newPlate[i][j] - oldPlate[i][j] < 0.001 ){
						equalibriumFlag++;
					}
				}
			}
			
			//copy from newPlate to oldPlate
			for(int i = 1; i<=d; i++){
				for(int j = 1; j<=d; j++){
					oldPlate[i][j] = newPlate[i][j];
				}
			}
			//System.arraycopy(newPlate, 0, oldPlate, 0, oldPlate.length);
			
			done++;
			if(equalibriumFlag == (d*d) ){
				break;
			}
			equalibriumFlag = 0;
		}
	}
	
	void display(double[][] newPlate){
		System.out.println("Results for "+d+" x "+d+" plate are: ");
		for(int i = 1; i<=d; i++){
			for(int j = 1; j<=d; j++){
				System.out.print( String.format("%.2f", newPlate[i][j]) + "   ");
			}
			System.out.println();
		}
	}
}
