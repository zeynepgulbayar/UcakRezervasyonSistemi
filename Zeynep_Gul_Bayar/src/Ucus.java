import java.util.Date;

public class Ucus implements IUcus
{
    private int id;
    private String ucusNo;
    private int kalkisLokasyonu;
    private int varisLokasyonu;
    private Date ucusTarihi;

    public int getId()
    {
        return id;
    }

    public void setId(int value)
    {
        id = value;
    }

    public String getUcusNo()
    {
        return ucusNo;
    }

    public void setUcusNo(String value)
    {
        ucusNo = value;
    }

    public int getKalkisLokasyonu()
    {
        return kalkisLokasyonu;
    }

    public void setKalkisLokasyonu(int value)
    {
        kalkisLokasyonu = value;
    }

    public int getVarisLokasyonu()
    {
        return varisLokasyonu;
    }

    public void setVarisLokasyonu(int value)
    {
        varisLokasyonu = value;
    }

    public Date getUcusTarihi()
    {
        return ucusTarihi;
    }

    public void setUcusTarihi(Date value)
    {
        ucusTarihi = value;
    }

    public void UcusEkle(String ucusNo, int kalkisLokasyonu, int varisLokasyonu, Date ucusTarihi)
    {
        Ucus ucus = new Ucus();

        ucus.setId(Bilgiler.ucusId);
        ucus.setUcusNo(ucusNo);
        ucus.setKalkisLokasyonu(kalkisLokasyonu);
        ucus.setVarisLokasyonu(varisLokasyonu);
        ucus.setUcusTarihi(ucusTarihi);

        Bilgiler.ucusId++;

        Bilgiler.ucuslar.add(ucus);
    }
}