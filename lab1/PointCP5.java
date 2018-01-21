
public abstract class PointCP5 {
	  protected double x;
	  protected double y;
	  protected double rho;
	  protected double theta;
	  
	  public PointCP5(){}
	  
	  public abstract double getX();  
	  public abstract double getY();
	  public abstract double getRho();
	  public abstract double getTheta();
	  public abstract double getDistance(PointCP5 pointB);
	  public abstract PointCP5 rotatePoint(double rotation);
}
