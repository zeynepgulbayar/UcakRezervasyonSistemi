import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class mainClass
{
	public static void main(String[] args)
    {
		Scanner input = new Scanner(System.in);
		
        Musteri musteri = new Musteri();
        musteri.MusteriOlustur();

        int Msayac = 1;

        for (Musteri item : Bilgiler.musteriler)
        {
            System.out.println(Msayac + ") " + item.getAd() + " " + item.getSoyad());
            Msayac++;
        }

        int Msecim = 0;

        do
        {
            System.out.print("Musteri Seciniz: ");
            try
            {
                Msecim = Integer.parseInt(input.nextLine());
            }
            catch (Exception e) { }
        } while (!(Msecim > 0 && Msecim < Bilgiler.musteriler.size() + 1));

        Lokasyon lokasyon = new Lokasyon();
        lokasyon.LokasyonOlustur();

        int KLsayac = 1;

        System.out.println("Lokasyonlar: ");

        for (Lokasyon item : Bilgiler.lokasyonlar)
        {
            System.out.println(KLsayac + ") " + item.getUlke() + " " + item.getSehir() + " " + item.getHavalimani());
            KLsayac++;
        }

        int KLsecim = 0;

        do
        {
            System.out.print("Kalkis Lokasyonu Seciniz: ");
            try
            {
                KLsecim = Integer.parseInt(input.nextLine());
            }
            catch (Exception e) { }
        } while (!(KLsecim > 0 && KLsecim < Bilgiler.lokasyonlar.size() + 1));

        boolean LKontrol = false;

        int VLsayac = 1;

        System.out.println("Lokasyonlar: ");

        for (Lokasyon item : Bilgiler.lokasyonlar)
        {
            System.out.println(VLsayac + ") " + item.getUlke() + " " + item.getSehir() + " " + item.getHavalimani());
            VLsayac++;
        }

        int VLsecim = 0;

        do
        {
            System.out.print("Varis Lokasyonu Seciniz: ");
            try
            {
                VLsecim = Integer.parseInt(input.nextLine());
            }
            catch (Exception e) { }

            if (VLsecim > 0 && VLsecim < Bilgiler.lokasyonlar.size() + 1)
            {
                if (Bilgiler.lokasyonlar.get(KLsecim - 1) == Bilgiler.lokasyonlar.get(VLsecim - 1))
                {
                    System.out.println("Secimler Ayni Olamaz.");
                }
                else
                {
                    LKontrol = true;
                }
            }
        } while (!(VLsecim > 0 && VLsecim < Bilgiler.lokasyonlar.size() + 1 && LKontrol));

        Date tarih = new Date();
        Date[] tarihler = new Date[10];

        for (int i = 0; i < tarihler.length; i++)
        {
            tarihler[i] = new Date(tarih.getTime() + (i + 1) * 24 * 60 * 60 * 1000);
        }

        for (int sayac = 1; sayac <= tarihler.length; sayac++)
        {
            System.out.println(sayac + ") " + tarihler[sayac - 1].toString());
        }

        int TSecim = 0;

        do
        {
            System.out.print("Tarih Seciniz: ");
            try
            {
                TSecim = Integer.parseInt(input.nextLine());
            }
            catch (Exception e) { }
        } while (!(TSecim > 0 && TSecim < tarihler.length + 1));

        Random random = new Random();
        String ucusNo = Msecim + "UN - " + random.nextInt(100);

        Ucus ucus = new Ucus();
        ucus.UcusEkle(ucusNo, KLsecim, VLsecim, tarihler[TSecim - 1]);
        int ucusId = Bilgiler.ucusId;

        int koltukNo = random.nextInt(200);

        int ucret = random.nextInt(5000 - 500) + 500;
        if (musteri.getEngelli())
            ucret = (int)(ucret * 0.5);

        Rezervasyon rezervasyon = new Rezervasyon();
        rezervasyon.RezervasyonEkle(Msecim - 1, koltukNo, ucusId, ucret);
        
        input.nextLine();
    }
}