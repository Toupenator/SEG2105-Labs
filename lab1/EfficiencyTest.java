public class EfficiencyTest{
  

 public static long inipointCPtest(char type, long testTime){
  long runtime = testTime*1000 * 1000 * 1000;
  long start = System.nanoTime();
  long count=0;
  long limit=start + runtime;
  while(System.nanoTime()<limit){
   new PointCP(type, Math.random()*100,Math.random()*100);
   count++;
  }
  return (runtime/count);
 }
  
 public static long iniPolarCP5(long testTime){
  long runtime = testTime*1000 * 1000 * 1000;
  long start = System.nanoTime();
  long count=0;
  long limit=start + runtime;
  while(System.nanoTime()<limit){
   new PointCP2Design5( Math.random()*100,Math.random()*100);
   count++;
  }
  return (runtime/count);
 }
 
 public static long iniCartesianCP5(long testTime){
  long runtime = testTime*1000 * 1000 * 1000;
  long start = System.nanoTime();
  long count=0;
  long limit=start + runtime;
  while(System.nanoTime()<limit){
   new PointCP3Design5( Math.random()*100,Math.random()*100);
   count++;
  }
  return (runtime/count);
 }
public static long getPointCP(char type,long testTime){
  long runtime = testTime*1000 * 1000 * 1000;
  long count=0;
  long start = System.nanoTime();
  long limit = start + runtime;
  PointCP tmp= new PointCP(type,10*Math.random(),10*Math.random());
  while (System.nanoTime() < limit) {
            tmp.getRho();
            count++;
            tmp.getTheta();
            count++;
  }
  long result = runtime / count;
  return result;
}
 public static long getPolarCP5(long testTime){
  long runtime =testTime*1000 * 1000 * 1000;
  long count=0;
  long start = System.nanoTime();
  long limit = start + runtime;
  PointCP2Design5 tmp= new PointCP2Design5(10*Math.random(),10*Math.random());
  while (System.nanoTime() < limit) {
            tmp.getRho();
            count++;
            tmp.getTheta();
            count++;
  }
  long result = runtime / count;
  return result;
}
public static long getCartesianCP5(long testTime){
  long runtime = testTime*1000 * 1000 * 1000;
  long count=0;
  long start = System.nanoTime();
  long limit = start + runtime;
  PointCP3Design5 tmp= new PointCP3Design5(10*Math.random(),10*Math.random());
  while (System.nanoTime() < limit) {
            tmp.getRho();
            count++;
            tmp.getTheta();
            count++;
  }
  long result = runtime / count;
  return result;
}
public static void main(String[] args){
  int testTime = 10;
        System.out.println("Average time for initializing C PointCP: "+inipointCPtest('C', testTime)+"ns");
        System.out.println("Average time for initializing C PointCP2Design5: "+iniPolarCP5(testTime)+"ns");
        System.out.println("Average time for initializing C PointCP3Design5: "+iniCartesianCP5(testTime)+"ns");
        System.out.println("Average time for initializing P PointCP: "+inipointCPtest('P', testTime)+"ns");
        System.out.println("Average time for initializing P PointCP2Design5: "+iniPolarCP5(testTime)+"ns");
        System.out.println("Average time for initializing P PointCP3Design5: "+iniCartesianCP5(testTime)+"ns");
        
        System.out.println("Average time for getting Cartesian from Cartesian PointCP: "+getPointCP('C', testTime)+"ns");
        System.out.println("Average time for getting Cartesian from Cartesian PointCP2Design5: "+getPolarCP5(testTime)+"ns");
        System.out.println("Average time for getting Cartesian from Cartesian PointCP3Design5: "+getCartesianCP5(testTime)+"ns");
        System.out.println("Average time for getting Polar from Cartesian PointCP: "+getPointCP('C', testTime)+"ns");
        System.out.println("Average time for getting Polar from Cartesian PointCP2Design5: "+getPolarCP5(testTime)+"ns");
        System.out.println("Average time for getting Polar from Cartesian PointCP3Design5: "+getCartesianCP5(testTime)+"ns");
        
        System.out.println("Average time for getting Cartesian from Polar PointCP: "+getPointCP('P', testTime)+"ns");
        System.out.println("Average time for getting Cartesian from Polar PointCP2Design5: "+getPolarCP5(testTime)+"ns");
        System.out.println("Average time for getting Cartesian from Polar PointCP3Design5: "+getCartesianCP5(testTime)+"ns");
        System.out.println("Average time for getting Polar from Polar PointCP: "+getPointCP('P', testTime)+"ns");
        System.out.println("Average time for getting Polar from Polar PointCP2Design5: "+getPolarCP5(testTime)+"ns");
        System.out.println("Average time for getting Polar from Polar PointCP3Design5: "+getCartesianCP5(testTime)+"ns");
        
}
}