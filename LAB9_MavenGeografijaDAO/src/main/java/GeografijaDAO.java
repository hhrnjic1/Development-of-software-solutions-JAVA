

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO{
    private static GeografijaDAO instance;
    private Connection conn;
    private PreparedStatement gradoviUpit, traziDrzavuUpit, traziGradoveDrzave, brisanjeGradovaDzaveUpit, brisanjeDrzaveUpit, obrisiGradoveSve, obrisiDrzaveSve ;
    private PreparedStatement dodajGradUpit, dajIdGradaUpit, dajIdDrzavaUpit, dodajDrzavuUpit , drzaveUpit, izmjeniGradUpit, nadjidrzavuUpit, nadjiDrzavuPoId;
    private String url = "jdbc:sqlite:Geografija.db";
    private String urlUser = "jdbc:sqlite:" + System.getProperty("user.home") + "/.GeografijaApp/Geografija.db";

    private GeografijaDAO(){
        try {
            conn = DriverManager.getConnection(urlUser);
            gradoviUpit = conn.prepareStatement("SELECT * FROM grad ORDER BY broj_stanovnika DESC");
            traziDrzavuUpit = conn.prepareStatement("SELECT g.id,g.naziv,g.broj_stanovnika,g.drzava from grad g, drzava d WHERE g.drzava = d.id AND d.naziv like ?");
            brisanjeGradovaDzaveUpit = conn.prepareStatement("DELETE FROM grad WHERE drzava = ?");
            brisanjeDrzaveUpit = conn.prepareStatement("DELETE FROM drzava WHERE naziv like ?");
            traziGradoveDrzave = conn.prepareStatement("SELECT id FROM drzava  WHERE  naziv like ?");
            obrisiDrzaveSve = conn.prepareStatement("DELETE FROM drzava");
            obrisiGradoveSve = conn.prepareStatement("DELETE FROM grad");
            dodajGradUpit = conn.prepareStatement("INSERT INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (?,?,?,?)");
            dajIdGradaUpit = conn.prepareStatement("SELECT MAX(id) FROM grad");
            dajIdDrzavaUpit = conn.prepareStatement("SELECT MAX(id) FROM drzava");
            dodajDrzavuUpit = conn.prepareStatement("INSERT INTO drzava (id,naziv,glavni_grad) VALUES (?,?,?)");
            drzaveUpit = conn.prepareStatement("SELECT * FROM drzava");
            izmjeniGradUpit = conn.prepareStatement("UPDATE grad SET naziv = ?, broj_stanovnika = ?, drzava = ? WHERE id = ? ");
            nadjidrzavuUpit = conn.prepareStatement("SELECT * FROM drzava WHERE naziv like ?");
            nadjiDrzavuPoId = conn.prepareStatement("SELECT naziv FROM drzava WHERE id= ?");
        } catch (SQLException e) {
            try {
                    regenerisi();
                    gradoviUpit = conn.prepareStatement("SELECT * FROM grad");
            }catch (SQLException s){
                System.out.println("Greska u regeneraciji sa bazom podataka!");
            }
        }

    }

    public void regenerisi(){
        Scanner ulaz = null;
        try {
                ulaz = new Scanner(new FileInputStream("Geografija.sql"));
                String sqlUpit = "";
                while(ulaz.hasNext()){
                    sqlUpit = sqlUpit + ulaz.nextLine();
                    if(sqlUpit.length() > 1 && sqlUpit.charAt(sqlUpit.length() - 1) == ';'){
                        try {
                            Statement stmt = conn.createStatement();
                            stmt.execute(sqlUpit);
                            sqlUpit = "";
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                    }
                }
                ulaz.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ne moze se regenerisati... nastavljamo sa praznom bazom!");
        }

    }

    public static GeografijaDAO getInstance(){
        if(instance == null) instance = new GeografijaDAO();
        return instance;
    }

    public ArrayList<Grad> gradovi(){
        ArrayList<Grad> listaGradova = new ArrayList<Grad>();

        try {
            ResultSet rs = gradoviUpit.executeQuery();
            while(rs.next()){
                Grad grad = new Grad(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                listaGradova.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaGradova;
    }
    //MOJA METODA
    public void obrisiSve(){
        try {
            obrisiGradoveSve.execute();
            obrisiDrzaveSve.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Drzava> sveDrzave(){
        ArrayList<Drzava> lista = new ArrayList<Drzava>();
        try {
            ResultSet rs = drzaveUpit.executeQuery();
            while(rs.next()){
                lista.add(new Drzava(rs.getInt(1),rs.getInt(3),rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String nadjiDrzavuPoId(int id){
        String rezultat = "";
        try {
            nadjiDrzavuPoId.setInt(1,id);
            ResultSet rs = nadjiDrzavuPoId.executeQuery();
            rezultat = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rezultat;
    }

    //METODE ZADATKA 3 Gore iznad se nalazi metoda gradovi!

    public Grad glavniGrad(String drzava){
        try {
            traziDrzavuUpit.setString(1,drzava);
            ResultSet rs = traziDrzavuUpit.executeQuery();
            if(rs.next()){
                return new Grad(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getInt(4));
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void obrisiDrzavu(String drzava){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        try {
            traziGradoveDrzave.setString(1,drzava);
            ResultSet rs = traziGradoveDrzave.executeQuery();
            brisanjeGradovaDzaveUpit.setInt(1,rs.getInt(1));
            brisanjeGradovaDzaveUpit.execute();
            brisanjeDrzaveUpit.setString(1,drzava);
            brisanjeDrzaveUpit.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dodajGrad(Grad ubaci){
        try {
            ResultSet rs = dajIdGradaUpit.executeQuery();
            dodajGradUpit.setInt(1,rs.getInt(1) + 1);
            dodajGradUpit.setString(2, ubaci.getNaziv());
            dodajGradUpit.setInt(3,ubaci.getBrojStanovnika());
            dodajGradUpit.setInt(4,ubaci.getDrzavaId());
            dodajGradUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajDrzavu(Drzava ubaci){
        try {
            ResultSet rs = dajIdDrzavaUpit.executeQuery();
            dodajDrzavuUpit.setInt(1,rs.getInt(1) + 1);
            dodajDrzavuUpit.setString(2,ubaci.getNaziv());
            dodajDrzavuUpit.setInt(3,ubaci.getGlavniGradId());
            dodajDrzavuUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void izmjeniGrad(Grad izmjeni){
        try {
            izmjeniGradUpit.setString(1,izmjeni.getNaziv());
            izmjeniGradUpit.setInt(2,izmjeni.getBrojStanovnika());
            izmjeniGradUpit.setInt(3,izmjeni.getDrzavaId());
            izmjeniGradUpit.setInt(4,izmjeni.getId());
            izmjeniGradUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Drzava nadjiDrzavu(String naziv){
        Drzava rezultat = new Drzava();
        try {
            nadjidrzavuUpit.setString(1,naziv);
            ResultSet rs = nadjidrzavuUpit.executeQuery();
            if(rs.next()){
                rezultat.setId(rs.getInt(1));
                rezultat.setNaziv(rs.getString(2));
                rezultat.setGlavniGradId(rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }

}
