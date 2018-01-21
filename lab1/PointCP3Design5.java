
public class PointCP3Design5 extends PointCP5 {
	public PointCP3Design5(char type, double x, double y)
	  {
		super();
		if(type != 'C' && type != 'P')
		      throw new IllegalArgumentException();
		        this.x=Math.cos(Math.toRadians(y)) * x;
		        this.y=Math.sin(Math.toRadians(y)) * x;
	  }

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public double getRho() {
		// TODO Auto-generated method stub
		return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
	}

	@Override
	public double getTheta() {
		// TODO Auto-generated method stub
		return Math.toDegrees(Math.atan2(y, x));
	}

	@Override
	public double getDistance(PointCP5 pointB) {
		// TODO Auto-generated method stub
		double deltaX = getX() - pointB.getX();
	    double deltaY = getY() - pointB.getY();
	    
	    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	@Override
	public PointCP3Design5 rotatePoint(double rotation) {
		// TODO Auto-generated method stub

	    double radRotation = Math.toRadians(rotation);
	    double X = getX();
	    double Y = getY();
	        
	    return new PointCP3Design5('C',
	      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
	      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}

}
