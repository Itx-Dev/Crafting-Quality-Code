/**
 * Contains an intermediate result.  This consists of three parts:
 * <ul>
 * <li>p: the power of the position we are parsing in the decimal portion of the string
 * <li>s: the sign of the result
 * <li>v: the value so far
 * </ul>
 * 
 * @author merlin
 *
 */
public class InterimResult
{

  private double p;

  private int s;

  private double v;

  /**
   * Simple constructor
   * @param p p
   * @param s s
   * @param v v
   */
  public InterimResult(double p, int s, double v)
  {
    this.p = p;
    this.s = s;
    this.v = v;
  }
  /**
   * Copy Constructor
   * @param x the object we want to copy
   */
  public InterimResult(InterimResult x)
  {
    p = x.p;
    s = x.s;
    v = x.v;
  }
  
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    InterimResult other = (InterimResult) obj;
    if (Double.doubleToLongBits(p) != Double.doubleToLongBits(other.p))
      return false;
    if (s != other.s)
      return false;
    if (Double.doubleToLongBits(v) != Double.doubleToLongBits(other.v))
      return false;
    return true;
  }

  /**
   * @return p
   */
  public double getP()
  {
    return p;
  }

  /**
   * @return s
   */
  public int getS()
  {
    return s;
  }
  /**
   * @return v
   */
  public double getV()
  {
    return v;
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(p);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + s;
    temp = Double.doubleToLongBits(v);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
  /**
   * @param p the new p
   */
  public void setP(double p)
  {
    this.p = p;
  }

  /**
   * @param s the new s
   */
  public void setS(int s)
  {
    this.s = s;
  }

  /**
   * @param v the new v
   */
  public void setV(double v)
  {
    this.v = v;
  }

  /**
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    return "p = " + p + " s = " + s + " v = " + v;
  }
}