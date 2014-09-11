package Tpdahp;

public interface ComputationInterface {

	public double[][] initialize(double[][] plate);
	
	public void compute(double[][] oldPlate, double[][] newPlate);
	
	public void display(double[][] newPlate);
}