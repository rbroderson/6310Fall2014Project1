package Tpdahp;

public class Demo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Plate obj = new Plate();
		
		boolean inD = false, inL = false, inR = false, inT = false, inB = false;
		boolean flagD = false, flagL = false, flagR = false, flagT = false, flagB = false;
		for (String arg : args) {
			if (inD) {
                try {
                    obj.setD(Integer.parseInt(arg));
                } catch(NumberFormatException ex) {
                    System.err.println("ERROR: The dimensions must be integer values");
                    System.exit(1);
                } catch (IllegalArgumentException ex) {
                    System.err.println("ERROR: The dimensions must be greater than 0");
                    System.exit(1);
                }
                inD = false;
                flagD = true;
            } else if (inL) {
                try {
                    obj.setLeft(Integer.parseInt(arg));
                } catch (NumberFormatException ex) {
                    System.err.println("ERROR: Could not parse " + arg + "!");
                    System.exit(1);
                } catch (IllegalArgumentException ex) {
                    System.err.println("ERROR: Temperature must be in the range 0-100.0");
                    System.exit(1);
                }
                inL = false;
                flagL = true;
            } else if (inR) {
                try {
                    obj.setRight(Integer.parseInt(arg));
                } catch (NumberFormatException ex) {
                    System.err.println("ERROR: Could not parse " + arg + "!");
                    System.exit(1);
                } catch (IllegalArgumentException ex) {
                    System.err.println("ERROR: Temperature must be in the range 0-100.0");
                    System.exit(1);
                }
                inR = false;
                flagR = true;
            } else if (inB) {
                try {
                    obj.setBot(Integer.parseInt(arg));
                } catch (NumberFormatException ex) {
                    System.err.println("ERROR: Could not parse " + arg + "!");
                    System.exit(1);
                } catch (IllegalArgumentException ex) {
                    System.err.println("ERROR: Temperature must be in the range 0-100.0");
                    System.exit(1);
                }
                inB = false;
                flagB = true;
            } else if (inT) {
                try {
                    obj.setTop(Integer.parseInt(arg));
                } catch (NumberFormatException ex) {
                    System.err.println("ERROR: Could not parse " + arg + "!");
                    System.exit(1);
                } catch (IllegalArgumentException ex) {
                    System.err.println("ERROR: Temperature must be in the range 0-100.0");
                    System.exit(1);
                }
                inT = false;
                flagT = true;
            } else if ("-d".equals(arg) && !flagD) {
                inD = true;
            } else if ("-l".equals(arg) && !flagL) {
                inL = true;
            } else if ("-r".equals(arg) && !flagR) {
                inR = true;
            } else if ("-t".equals(arg) && !flagT) {
                inT= true;
            } else if ("-b".equals(arg) && !flagB){
                inB = true;
            }
            else {
            	System.err.println("ERROR: Could not parse arguments!");
                System.exit(1);
            }
		}
		
		double[][] oldPlate = new double[obj.getD()+2][obj.getD()+2];
		double[][] newPlate = new double[obj.getD()+2][obj.getD()+2];

		//Initialize oldPlate and newPlate
		oldPlate = obj.initiate(oldPlate);
		newPlate = obj.initiate(newPlate);
		
		//compute the equilibrium temperature
		obj.simulate(oldPlate, newPlate);
		
		//display final temperature of the grid
		obj.display(newPlate);
	}

}
