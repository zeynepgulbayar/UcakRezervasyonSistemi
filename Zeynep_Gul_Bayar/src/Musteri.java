import java.util.Scanner;

public class Musteri implements IMusteri
{
    private int id;
    private String ad;
    private String soyad;
    private String ePosta;
    private String telefon;
    private boolean engelli;

    public int getId()
    {
        return id;
    }

    public void setId(int value)
    {
        id = value;
    }

    public String getAd()
    {
        return ad;
    }

    public void setAd(String value)
    {
        ad = value;
    }

    public String getSoyad()
    {
        return soyad;
    }

    public void setSoyad(String value)
    {
        soyad = value;
    }

    public String getEPosta()
    {
        return ePosta;
    }

    public void setEPosta(String value)
    {
        ePosta = value;
    }

    public String getTelefon()
    {
        return telefon;
    }

    public void setTelefon(String value)
    {
        telefon = value;
    }

    public boolean getEngelli()
    {
        return engelli;
    }

    public void setEngelli(boolean value)
    {
        engelli = value;
    }

    public void MusteriEkle(int id, String ad, String soyad, String email, String telefon, boolean engelli)
    {
        Musteri musteri = new Musteri();

        musteri.setId(id);
        musteri.setAd(ad);
        musteri.setSoyad(soyad);
        musteri.setEPosta(email);
        musteri.setTelefon(telefon);
        musteri.setEngelli(engelli);

        Bilgiler.musteriler.add(musteri);
    }

    public void MusteriOlustur()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Musteri Bilgileri");

            System.out.print("Adiniz: ");
            String ad = scanner.nextLine();

            System.out.print("Soyadiniz: ");
            String soyad = scanner.nextLine();

            System.out.print("E - Postaniz: ");
            String eposta = scanner.nextLine();

            String telefon;

            do
            {
                System.out.print("Telefon Numaranizi Giriniz: ");
                telefon = scanner.nextLine();
            } while (telefon.length() != 11 || !isLong(telefon));

            String engelli;
            boolean engel = false;

            do
            {
                System.out.print("Engelli Durumunuzu Giriniz (e, h): ");
                engelli = scanner.nextLine().toLowerCase();
            } while (!engelli.equals("e") && !engelli.equals("h"));

            if (engelli.equals("e"))
            {
                engel = true;
            }

            MusteriEkle(Bilgiler.musteriId, ad, soyad, eposta, telefon, engel);

            String mSecim;

            do
            {
                System.out.print("Baska Bir Musteri Eklemek Ister Misiniz? (e, h): ");
                mSecim = scanner.nextLine().toLowerCase();
            } while (!mSecim.equals("e") && !mSecim.equals("h"));

            if (mSecim.equals("e"))
            {
                Bilgiler.musteriId++;
            }

            if (mSecim.equals("h"))
            {
                break;
            }
        }
    }
    
    private static boolean isLong(String s)
    {
        try
        {
            Long.parseLong(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}