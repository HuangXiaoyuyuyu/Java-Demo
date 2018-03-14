该demo中使用的就是如下两个不常见的方法：即弧度和角度的互换
	public static long toDegrees(double angrad):传回将angrad径度转换成角度   
	public static long toRadians(double angdeg): 传回将angdeg角度转换成径度

下面简单介绍下Math类并补充下Math类的其他用法： 
  java.lang.Math类中包含基本的数字操作，如指数、对数、平方根和三角函数。 
  java.math是一个包，提供用于执行任意精度整数(BigInteger)算法和任意精度小数(BigDecimal)算法的类。   
  java.lang.Math类中包含E和PI两个静态常量，以及进行科学计算的类(static)方法，可以直接通过类名调用。
 	public static final Double E = 2.7182818284590452354   
	public static final Double PI = 3.14159265358979323846 
  
	public static long abs(double x)：传回 x 的绝对值。X也可int long float   
	public static long sin(double x): 传回x径度的正弦函数值 
	public static long cos(double x)：传回x径度的余弦函数值     
	public static long tan(double x): 传回x径度的正切函数值   
	public static long asin(double x)：传回x值的反正弦函数值。   
	public static long acos(double x)：传回x值的反余弦函数值。   
	public static long atan(double x)：传回x值的反正切函数值。 
	public static long atan2(double x, double y)：传回极坐标（polar）的θ值   
	public static long floor(double x)：传回不大于x的最大整数值  
	public static long ceil(double x)：传回不小于x的最小整数值。   
	public static long exp(double x)：传回相当于ex值   
	public static long log(double x)：传回x的自然对数函数值   
	public static long max(double x,double y)：传回x、y较大数   
	public static long min(double x,double y)：传回x、y较小数  
	public static long pow(double x,double y)：传回x的y次幂值  
	public static long sqrt(double x): 传回x开平方值   
	public static long rint(double x):传回最接近x的整数值   
	public static long round(double x):传回x的四舍五入值 
	public static long random():传回随机数值,产生一个0-1之间的随机数(不包括0和1) 
	Math.log(100)/Math.log(10); 
		表示的是100的以10为底的对数函数的值，是2 向上取整用Math.ceil(double a) 向下取整用Math.floor(double a)。