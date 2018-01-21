
public class PointCP2Design5 extends PointCP5 {
	public PointCP2Design5(char type, double rho,double theta){
		super();
		if(type != 'C' && type != 'P')
		      throw new IllegalArgumentException();
		    	this.rho=(Math.sqrt(Math.pow(rho, 2) + Math.pow(theta, 2)));
		    	this.theta=(Math.toDegrees(Math.atan2(theta, rho)));
		    
		    
	}
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return (Math.cos(Math.toRadians(theta)) * rho);
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return (Math.sin(Math.toRadians(theta)) * rho);
	}

	@Override
	public double getRho() {
		// TODO Auto-generated method stub
		 return rho;
	}

	@Override
	public double getTheta() {
		// TODO Auto-generated method stub
		return theta;
	}

	@Override
	public double getDistance(PointCP5 pointB) {
		// TODO Auto-generated method stub
		 double deltaX = getX() - pointB.getX();
		    double deltaY = getY() - pointB.getY();
		    
		    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	@Override
	  public PointCP2Design5 rotatePoint(double rotation)
	  {
	    double radRotation = Math.toRadians(rotation);
	    double X = getX();
	    double Y = getY();
	        
	    return new PointCP2Design5('C',
	      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
	      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	  }


}
