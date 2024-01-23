import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static GeografijaDAO dao;
    private static Scanner ulaz;



    public static void main(String[] args){
        dao = GeografijaDAO.getInstance();
        ulaz = new Scanner(System.in);

        dao.obrisiSve();
        dao.regenerisi();

        System.out.println("Unesite drzavu: (Molim nemojte kliknuti na tipku 'Enter' pri prvom unosu nego kliknite  misem na kraju ove poruke i pocnite kucat!)");
        String unesena = ulaz.nextLine();
        Grad glavni = new Grad(dao.glavniGrad(unesena));

        System.out.println("Glavni grad unesene drzave je: "+glavni.getNaziv()+ " " + glavni.getBrojStanovnika());

        System.out.println("Unesite drzavu koju zelite da obrisete: ");
        dao.obrisiDrzavu(ulaz.nextLine());

        System.out.println("Svi gradovi u bazi sortirani po broju stanovnika (Nakon brisanja):");
        for(Grad x : dao.gradovi())
            System.out.println(x.getId() + " " + x.getNaziv() + " " + x.getBrojStanovnika() + " " + x.getDrzavaId());

        Grad novi = new Grad();
        novi.setId(0);
        System.out.println("Unesite naziv novog grada: ");
        novi.setNaziv(ulaz.nextLine());
        System.out.println("Broj stanovnika: ");
        novi.setBrojStanovnika(ulaz.nextInt());
        System.out.println("Id drzave u kojij se nalazi");
        novi.setDrzavaId(ulaz.nextInt());
        if(ulaz.hasNextLine()) ulaz.nextLine();
        dao.dodajGrad(novi);

        System.out.println("Svi gradovi u bazi sortirani po broju stanovnika (Nakon unosa):");
        for(Grad x : dao.gradovi())
            System.out.println(x.getId() + " " + x.getNaziv() + " " + x.getBrojStanovnika() + " " + x.getDrzavaId());

        Drzava nova = new Drzava();
        nova.setId(0);
        System.out.println("Unesite naziv nove drzave: ");
        nova.setNaziv(ulaz.nextLine());
        System.out.println("Unesite id glavnog grada");
        nova.setGlavniGradId(ulaz.nextInt());
        if(ulaz.hasNextLine()) ulaz.nextLine();
        dao.dodajDrzavu(nova);

        System.out.println("Sve drzave u bazi (Nakon unosa):");
        for(Drzava x : dao.sveDrzave())
            System.out.println(x.getId() + " " + x.getNaziv() + " " + x.getGlavniGradId());

        Grad izmjena = new Grad();
        System.out.println("Unesite id grada koji zelite da izmjenite: ");
        izmjena.setId(ulaz.nextInt());
        if(ulaz.hasNextLine()) ulaz.nextLine();
        System.out.println("Unesite novi naziv: ");
        izmjena.setNaziv(ulaz.nextLine());
        System.out.println("Unesite novi broj stanovnika: ");
        izmjena.setBrojStanovnika(ulaz.nextInt());
        System.out.println("Unesite id drzave na koju pokazuje: ");
        izmjena.setDrzavaId(ulaz.nextInt());
        if(ulaz.hasNextLine()) ulaz.nextLine();
        dao.izmjeniGrad(izmjena);

        System.out.println("Svi gradovi u bazi sortirani po broju stanovnika (Nakon izmjene):");
        for(Grad x : dao.gradovi())
            System.out.println(x.getId() + " " + x.getNaziv() + " " + x.getBrojStanovnika() + " " + x.getDrzavaId());

        System.out.println("Unesite naziv drzave koju trazite :");
        Drzava trazena = new Drzava(dao.nadjiDrzavu(ulaz.nextLine()));
        if(trazena.getId() == 0)
            System.out.println("Nazalost ne postoji trazena drzava u bazi!");
        else
            System.out.println(trazena.getId() + " " + trazena.getNaziv() + " " + trazena.getGlavniGradId());

        String sviGradovi = ispisiGradove();
        System.out.println(sviGradovi);

        glavniGrad();

        dao.obrisiSve();
        dao.regenerisi();
    }

    public static String ispisiGradove(){
        String rezultat = "";
        //ArrayList<Grad> lista = dao.gradovi();
        for(Grad x : dao.gradovi())
            rezultat = rezultat + x.getNaziv() + " (" + dao.nadjiDrzavuPoId(x.getDrzavaId()) + ") - " + x.getBrojStanovnika() + "\n";
        return rezultat;
    }

    public static void glavniGrad(){
        System.out.println("Unesite naziv drzave: ");
        String unesena = ulaz.nextLine();
        Grad glavni = new Grad(dao.glavniGrad(unesena));
        if(glavni.getNaziv() == null)  System.out.println("Nepostojeca drzava!");
        else{
            System.out.println("Glavni grad " + unesena + " je " + glavni.getNaziv());
        }
    }
}
