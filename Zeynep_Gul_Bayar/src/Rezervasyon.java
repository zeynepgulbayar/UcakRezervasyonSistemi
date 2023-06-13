public class Rezervasyon implements IRezervasyon
{
    private int id;
    private int musteriId;
    private int koltukNo;
    private int ucusId;
    private int ucret;

    public int getId()
    {
        return id;
    }

    public void setId(int value)
    {
        id = value;
    }

    public int getMusteriId()
    {
        return musteriId;
    }

    public void setMusteriId(int value)
    {
        musteriId = value;
    }

    public int getKoltukNo()
    {
        return koltukNo;
    }

    public void setKoltukNo(int value)
    {
        koltukNo = value;
    }

    public int getUcusId()
    {
        return ucusId;
    }

    public void setUcusId(int value)
    {
        ucusId = value;
    }

    public int getUcret()
    {
        return ucret;
    }

    public void setUcret(int value)
    {
        ucret = value;
    }

    public void RezervasyonEkle(int musteriId, int koltukNo, int ucusId, int ucret)
    {
        Rezervasyon rezervasyon = new Rezervasyon();

        rezervasyon.setId(Bilgiler.rezervasyonId);
        rezervasyon.setMusteriId(musteriId);
        rezervasyon.setKoltukNo(koltukNo);
        rezervasyon.setUcusId(ucusId);
        rezervasyon.setUcret(ucret);

        Bilgiler.rezervasyonId++;

        Bilgiler.rezervasyonlar.add(rezervasyon);

        Musteri musteri = (Musteri)Bilgiler.musteriler.get(musteriId);
        
        Ucus ucus = (Ucus)Bilgiler.ucuslar.get(ucusId - 2);
        
        Lokasyon lokasyon = new Lokasyon();

        System.out.println("\nMusteri Bilgileri: ");
        System.out.println("Musteri Adi: " + musteri.getAd());
        System.out.println("Musteri Soyadi: " + musteri.getSoyad());
        System.out.println("Musteri EPosta: " + musteri.getEPosta());
        System.out.println("Musteri Telefon: " + musteri.getTelefon());

        System.out.println("\nUcus Bilgileri: ");
        System.out.println("Ucus Numarasi: " + ucus.getUcusNo());
        lokasyon = (Lokasyon)Bilgiler.lokasyonlar.get(ucus.getKalkisLokasyonu() - 1);
        System.out.println("Kalkis Lokasyonu: " + lokasyon.getUlke() + " " + lokasyon.getSehir() + " " + lokasyon.getHavalimani());
        lokasyon = (Lokasyon)Bilgiler.lokasyonlar.get(ucus.getVarisLokasyonu() - 1);
        System.out.println("Varis Lokasyonu: " + lokasyon.getUlke() + " " + lokasyon.getSehir() + " " + lokasyon.getHavalimani());
        System.out.println("Ucus Tarihi: " + ucus.getUcusTarihi().toString());
        System.out.println("Koltuk Numarasi: " + koltukNo);
        System.out.print("Ucret: " + ucret);
    }
}