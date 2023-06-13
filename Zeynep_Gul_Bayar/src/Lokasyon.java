import java.io.*;

public class Lokasyon implements ILokasyon
{
    private int id;
    private String ulke;
    private String sehir;
    private String havalimani;

    public String dosyaYolu = "lokasyon.txt";

    public int getId()
    {
        return id;
    }

    public void setId(int value)
    {
        id = value;
    }

    public String getUlke()
    {
        return ulke;
    }

    public void setUlke(String value)
    {
        ulke = value;
    }

    public String getSehir()
    {
        return sehir;
    }

    public void setSehir(String value)
    {
        sehir = value;
    }

    public String getHavalimani()
    {
        return havalimani;
    }

    public void setHavalimani(String value)
    {
        havalimani = value;
    }

    public void LokasyonEkle(int id, String ulke, String sehir, String havalimani)
    {
        Lokasyon lokasyon = new Lokasyon();

        lokasyon.setId(id);
        lokasyon.setUlke(ulke);
        lokasyon.setSehir(sehir);
        lokasyon.setHavalimani(havalimani);

        Bilgiler.lokasyonlar.add(lokasyon);
    }

    public void LokasyonOlustur()
    {
    	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("lokasyon.txt");
        
        if (is != null)
        {
            try
            {
            	BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                while (true)
                {
                    String[] lokasyonDizi;

                    String satir = reader.readLine();

                    if (satir != null)
                    {
                        lokasyonDizi = satir.split(",");
                        LokasyonEkle(Bilgiler.lokasyonId, lokasyonDizi[0], lokasyonDizi[1], lokasyonDizi[2]);
                        Bilgiler.lokasyonId++;
                    }
                    else
                        break;
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}