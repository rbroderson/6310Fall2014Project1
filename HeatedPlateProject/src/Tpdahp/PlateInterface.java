/**
 * 
 */
package Tpdahp;

/**
 * @author Jassimran
 *
 */
public interface PlateInterface {

	public double[][] initiate(double[][] plate);
	
	public void simulate(double[][] oldPlate, double[][] newPlate);
	
	public void display(double[][] newPlate);
}
