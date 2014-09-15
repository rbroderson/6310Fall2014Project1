/**
 * 
 */
package Tpdahp;

/**
 * @author Jassimran
 *
 */
class Plate implements PlateInterface{
	
	private int dimension, topEdgeTemp, botEdgeTemp, leftEdgeTemp, rightEdgeTemp;
	
	public Plate() {
		super();
	}
	
	public int getD() {
		return dimension;
	}

	public void setD(int d) {
		if(d < 1 || d!= (int)d) {
            throw new IllegalArgumentException("Dimensions must be valid!");
        }
		this.dimension = d;
	}
	
	public void setTop(int top) {
		if(top > 100.0 || top < 0.0){
			throw new IllegalArgumentException("Temperature must be greater than 0 and less than 100.0");
		}
		this.topEdgeTemp = top;
	}

	public void setBot(int bot) {
		if(bot > 100.0 || bot < 0.0){
			throw new IllegalArgumentException("Temperature must be greater than 0 and less than 100.0");
		}
		this.botEdgeTemp = bot;
	}

	public void setLeft(int left) {
		if(left > 100.0 || left < 0.0){
			throw new IllegalArgumentException("Temperature must be greater than 0 and less than 100.0");
		}
		this.leftEdgeTemp = left;
	}

	public void setRight(int right) {
		if(right > 100.0 || right < 0.0){
			throw new IllegalArgumentException("Temperature must be greater than 0 and less than 100.0");
		}
		this.rightEdgeTemp = right;
	}

	public double[][] initiate(double[][] plate){
		
		for(int i = 1; i<=dimension; i++){
			//initializing edges to corresponding values
			plate[0][i] = topEdgeTemp;
			plate[dimension+1][i] = botEdgeTemp;
			plate[i][0] = leftEdgeTemp;
			plate[i][dimension+1] = rightEdgeTemp;
			
			//initializing rest of the nodes to 0.0
			for(int j = 1; j<=dimension; j++){
				plate[i][j] = 0.0;
			}
		}
		return plate;
	}
	
	public void simulate(double[][] oldPlate, double[][] newPlate){
		int done = 0;
		int equalibriumFlag = 0;
		while(done!=(dimension*20)){
			for(int i = 1; i<=dimension; i++){
				for(int j = 1; j<=dimension; j++){
					newPlate[i][j] = (oldPlate[i+1][j] + oldPlate[i-1][j]
							+ oldPlate[i][j+1] + oldPlate[i][j-1])/4.0;
					if(newPlate[i][j] - oldPlate[i][j] < 0.001 ){
						equalibriumFlag++;
					}
				}
			}
			
			//copy from newPlate to oldPlate to improve performance
			int length = newPlate.length;
			for (int i = 0; i < length; i++) {
				System.arraycopy(newPlate[i], 0, oldPlate[i], 0, newPlate[i].length);
			}
						
			done++;
			if(equalibriumFlag == (dimension*dimension) ){
				break;
			}
			equalibriumFlag = 0;
		}
	}
	
	public void display(double[][] newPlate){
		System.out.println("Results for "+ dimension +" x "+ dimension +" plate are: ");
		for(int i = 1; i<=dimension; i++){
			for(int j = 1; j<=dimension; j++){
				System.out.print( String.format("%.2f", newPlate[i][j]) + "   ");
			}
			System.out.println();
		}
	}
}
