/**
 * 
 * This is a class that allows you to create a sphere with a set radius. If a negative radius is given, the radius will be set to 0. If no radius is given, the radius will be set to 0.
 * 
 */

public class Sphere extends Object
    implements Comparable<Sphere>
{
    
    private double pi = Math.PI;
    private double fourThird = 4.0/3.0;
    private double radius;
    private double myVolume;
    private double mySurfaceArea;

    /** 
    * This is the default constructor. This will create a sphere with a radius of 0.
    */
    public Sphere() { this(0); }

    /** 
    * A constructor that will create sphere with the given radius. If the radius given is less than 0, set radius to 0.
    *
    * A negative radius is not allowed and will cause an Illegal ArgumentException to be thrown.
    *
    * @param    initialRadius The radius that you want to give the sphere.
    */
    public Sphere (double initialRadius){

        try{
            if(initialRadius < 0){
                throw new IllegalArgumentException("Radius can not be negative");
            }
            radius = initialRadius;
        }
        catch(IllegalArgumentException e){
            System.out.println("Error. Radius can not be set to a negative number. Try a positive number next time.");
        }         
    }

    /**
     * Return the volume of the sphere
     * 
     * @return The volume of the sphere
     */
    public double volume(){
        myVolume = fourThird * pi * (radius * radius * radius);
        return myVolume;
    }

    /**
     * Return the surface area of the sphere
     * 
     * @return The surface area of the sphere
     */
    public double surfaceArea(){
        mySurfaceArea = 4 * pi * (radius * radius);
        return mySurfaceArea;
    }

    /**
     * Set the radius of the Sphere to the newRadius provided newRadius >= 0. If newRadius < 0, no change to Sphere.
     * 
     * A negative radius is not allowed and will cause an Illegal ArgumentException to be thrown.
     * 
     * @param           newRadius The updated radius for the sphere.
     */
    public void setRadius(double newRadius){

        try{
            if(newRadius < 0){
                throw new IllegalArgumentException("Radius can not be negative");
            }
            radius = newRadius;
        }
        catch(IllegalArgumentException e){
            System.out.println("Error. Radius can not be set to a negative number. Try a positive number next time.");
        }       
    }

    /**
     * Returns the radius of the sphere
     * 
     * @return The radius of the sphere
     */
    public double getRadius(){
        return radius;
    }

    /**
     * Return a string representation of the Sphere
     * 
     * @return A string representation of the sphere.
     */
    public String toString(){
        String temp = new String();
        temp = "I am a sphere with a radius of " + this.getRadius() + ". My surface area is " + this.surfaceArea() + ". My volume is " + this.volume() + ".";
        return temp;
    }
/**
 * 
 * Compares the radius of the sphere to the Test sphere that is passed in the parameter.
 * 
 * @param Test The sphere that will be compared to this sphere.
 * @return -1 if this sphere's radius is smaller than test, 0 if they are equal, and 1 if this sphere's radius is larger than test's radius.
 */

    public int compareTo(Sphere Test){
        int result = 0;
        
        if(this.radius == Test.radius){
            result = 0;
        }
        if(this.radius < Test.radius){
            result = -1;
        }
        if(this.radius > Test.radius){
            result = 1;
        }

        return result;

    }

    /**
     * The main test bench for the class.
     * 
     * @param Args
     */
    public static void main(String Args[]){

        Sphere mySphereA;
        mySphereA = new Sphere(0);
        
        //Testing default constructor and getRadius function
        System.out.println("Testing that default constructor has created a sphere with a radius of zero using getRadius function:");
        if(mySphereA.getRadius() == 0){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail. Sphere does not have radius of 0.");
        }
        System.out.println();

        //Testing toString function
        System.out.println("Testing toString function:");
        System.out.println(mySphereA.toString());
        System.out.println();

        //Testing secondary constructor.
        Sphere mySphereB;
        mySphereB = new Sphere(5);
        System.out.println("Testing constructor with radius parameter by setting radius to 5:");
        System.out.println(mySphereB.toString());
        System.out.println();

        //Testing volume function
        System.out.println("Testing volume function:");
        if(mySphereB.volume() == 523.5987755982989){
            System.out.println("Pass. Volume is correct.");
        }
        else{
            System.out.println("Fail. Volume is not correct.");
        }
        System.out.println();

        //Testing surfaceArea function
        System.out.println("Testing surfaceArea function:");
        if(mySphereB.surfaceArea() == 314.1592653589793){
            System.out.println("Pass. Surface area is correct.");
        }
        else{
            System.out.println("Fail. Surface area is not correct.");
        }
        System.out.println();

        //Testing checkRadius function
        System.out.println("Testing checkRadius function:");
        mySphereA.setRadius(10);
        if(mySphereA.getRadius() == 10){
            System.out.println("Pass. Radius was changed");
        }
        else{
            System.out.println("Fail. Radius was not changed.");
        }
        System.out.println();

        //Testing compareTo function
        System.out.println("Testing compareTo function:");

        mySphereA.setRadius(5);
        if(mySphereA.compareTo(mySphereB) == 0){
            System.out.println("Sphere A and Sphere B have the same radius.");
        }
        mySphereA.setRadius(10);
        if(mySphereA.compareTo(mySphereB) == 1){
            System.out.println("Sphere A is larger than Sphere B.");
        }
        mySphereA.setRadius(2);
        if(mySphereA.compareTo(mySphereB) == -1){
            System.out.println("Sphere A is smaller than Sphere B.");
        }
        System.out.println();

        //Testing for negative number
        System.out.println("Testing for negative number: ");
        mySphereA.setRadius(-5);
        System.out.println("Radius of Sphere A is: " + mySphereA.getRadius());
        System.out.println();

        //Testing for spheres ranging from -100 to 100
        System.out.println("Testing for spheres with radius ranging from -100 to 100. The first 100 spheres should have a radius of 0: ");
        for(int i = -100; i < 101; i++){
            mySphereA.setRadius(i);
            System.out.println(mySphereA.toString());
        }

    }

}
