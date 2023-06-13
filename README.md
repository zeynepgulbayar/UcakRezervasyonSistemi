# Java Proje Ödevi

### Uçak Rezervasyon Sistemi

* Müşteri bilgileri (ad, soyad, e-posta, telefon, engelli durumu) girilir.
* Başka müşteri eklenip eklenmeyeceği seçilir (e => Evet veya h => Hayır).
* Müşteri (sıra numarsı) seçilir.
* Listeden kalkış lokasyonu bilgisi (sıra numarası) seçilir.
* Listeden varış lokasyonu bilgisi (sıra numarası) seçilir. Kalkış lokasyonu ile aynı olamaz.
* Tarih bilgisi (sıra numarası) seçilir.
* Ekrana müşteri bilgileri ve uçuş bilgileri yazdırılır.

## Interfaceler

### ILokasyon
+ public interface ILokasyon
+ {
+     public int Id = 0;
+     public String Ulke = "";
+     public String Sehir = "";
+     public String Havalimani = "";
+ }

### IMusteri
+ public interface IMusteri
+ {
+     int Id = 0;
+     String Ad = "";
+     String Soyad = "";
+     String EPosta = "";
+     String Telefon = "";
+     Boolean Engelli = false;
+ }

### IRezervasyon
+ public interface IRezervasyon
+ {
+     int Id = 0;
+     int MusteriId = 0;
+     int KoltukNo = 0;
+     int UcusId = 0;
+     int Ucret = 0;
+ }

### IUcus
+ public interface IUcus
+ {
+     int Id = 0;
+     String UcusNo = "";
+     int KalkisLokasyonu = 0;
+     int VarisLokasyonu = 0;
+     Date UcusTarihi = new Date();
+ }

## Sınıflar

### Bilgiler
+ public class Bilgiler
+ {
+     public static int musteriId = 1;
+     public static int lokasyonId = 1;
+     public static int ucusId = 1;
+     public static int rezervasyonId = 1;

+     public static ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
+     public static ArrayList<Lokasyon> lokasyonlar = new ArrayList<Lokasyon>();
+     public static ArrayList<Ucus> ucuslar = new ArrayList<Ucus>();
+     public static ArrayList rezervasyonlar = new ArrayList();
+ }

### Lokasyon
+ public class Lokasyon implements ILokasyon
+ {
+     private int id;
+     private String ulke;
+     private String sehir;
+     private String havalimani;

+     public String dosyaYolu = "lokasyon.txt";

+     public int getId()
+     public void setId(int value)

+     public String getUlke()
+     public void setUlke(String value)

+     public String getSehir()
+     public void setSehir(String value)

+     public String getHavalimani()
+     public void setHavalimani(String value)

+     public void LokasyonEkle(int id, String ulke, String sehir, String havalimani)

+     public void LokasyonOlustur()
+ }

### mainClass
+ public class mainClass
+ {
+ 	public static void main(String[] args)
+ }

### Musteri
+ public class Musteri implements IMusteri
+ {
+     private int id;
+     private String ad;
+     private String soyad;
+     private String ePosta;
+     private String telefon;
+     private boolean engelli;

+     public int getId()
+     public void setId(int value)
    
+     public String getAd()
+     public void setAd(String value)
    
+     public String getSoyad()
+     public void setSoyad(String value)

+     public String getEPosta()
+     public void setEPosta(String value)

+     public String getTelefon()
+     public void setTelefon(String value)

+     public boolean getEngelli()
+     public void setEngelli(boolean value)

+     public void MusteriEkle(int id, String ad, String soyad, String email, String telefon, boolean engelli)

+     public void MusteriOlustur()
    
+     private static boolean isLong(String s)
+ }

### Rezervasyon
+ public class Rezervasyon implements IRezervasyon
+ {
+     private int id;
+     private int musteriId;
+     private int koltukNo;
+     private int ucusId;
+     private int ucret;

+     public int getId()
+     public void setId(int value)

+     public int getMusteriId()
+     public void setMusteriId(int value)

+     public int getKoltukNo()
+     public void setKoltukNo(int value)

+     public int getUcusId()
+     public void setUcusId(int value)

+     public int getUcret()
+     public void setUcret(int value)

+     public void RezervasyonEkle(int musteriId, int koltukNo, int ucusId, int ucret)
+ }

### Ucak
+ public class Ucus implements IUcus
+ {
+     private int id;
+     private String ucusNo;
+     private int kalkisLokasyonu;
+     private int varisLokasyonu;
+     private Date ucusTarihi;

+     public int getId()
+     public void setId(int value)

+     public String getUcusNo()
+     public void setUcusNo(String value)

+     public int getKalkisLokasyonu()
+     public void setKalkisLokasyonu(int value)

+     public int getVarisLokasyonu()
+     public void setVarisLokasyonu(int value)

+     public Date getUcusTarihi()
+     public void setUcusTarihi(Date value)

+     public void UcusEkle(String ucusNo, int kalkisLokasyonu, int varisLokasyonu, Date ucusTarihi)
+ }
