��demo��ʹ�õľ������������������ķ����������ȺͽǶȵĻ���
	public static long toDegrees(double angrad):���ؽ�angrad����ת���ɽǶ�   
	public static long toRadians(double angdeg): ���ؽ�angdeg�Ƕ�ת���ɾ���

����򵥽�����Math�ಢ������Math��������÷��� 
  java.lang.Math���а������������ֲ�������ָ����������ƽ���������Ǻ����� 
  java.math��һ�������ṩ����ִ�����⾫������(BigInteger)�㷨�����⾫��С��(BigDecimal)�㷨���ࡣ   
  java.lang.Math���а���E��PI������̬�������Լ����п�ѧ�������(static)����������ֱ��ͨ���������á�
 	public static final Double E = 2.7182818284590452354   
	public static final Double PI = 3.14159265358979323846 
  
	public static long abs(double x)������ x �ľ���ֵ��XҲ��int long float   
	public static long sin(double x): ����x���ȵ����Һ���ֵ 
	public static long cos(double x)������x���ȵ����Һ���ֵ     
	public static long tan(double x): ����x���ȵ����к���ֵ   
	public static long asin(double x)������xֵ�ķ����Һ���ֵ��   
	public static long acos(double x)������xֵ�ķ����Һ���ֵ��   
	public static long atan(double x)������xֵ�ķ����к���ֵ�� 
	public static long atan2(double x, double y)�����ؼ����꣨polar���Ħ�ֵ   
	public static long floor(double x)�����ز�����x���������ֵ  
	public static long ceil(double x)�����ز�С��x����С����ֵ��   
	public static long exp(double x)�������൱��exֵ   
	public static long log(double x)������x����Ȼ��������ֵ   
	public static long max(double x,double y)������x��y�ϴ���   
	public static long min(double x,double y)������x��y��С��  
	public static long pow(double x,double y)������x��y����ֵ  
	public static long sqrt(double x): ����x��ƽ��ֵ   
	public static long rint(double x):������ӽ�x������ֵ   
	public static long round(double x):����x����������ֵ 
	public static long random():���������ֵ,����һ��0-1֮��������(������0��1) 
	Math.log(100)/Math.log(10); 
		��ʾ����100����10Ϊ�׵Ķ���������ֵ����2 ����ȡ����Math.ceil(double a) ����ȡ����Math.floor(double a)��