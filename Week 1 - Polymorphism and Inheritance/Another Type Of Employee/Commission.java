
public class Commission extends Hourly
{
    double totalSales;
    double commRate;
    
    public Commission(String eName, String eAddress, String ePhone,String socSecNumber, double rate, double ncommRate)
    {
        super(eName,eAddress,ePhone,socSecNumber,rate);
        commRate = ncommRate;
    }
    
    public void addSales(double totalSales)
    {
        totalSales = totalSales2;
    }
    
    @Override
    public double pay()
    {
        double payment = super.pay() + (totalSales*commRate);
        totalSales = 0;
        return payment;
    }
    
    @Override
    public String toString()
    {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }