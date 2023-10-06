package entities;

public class Categorie extends AbstractEntitie{
    static int nbrCat=0;
    public Categorie(int id, String libelle) {
        super(id, libelle);
    }

    // const defaut
    public Categorie(String libelle) {
        super(libelle);
        this.id =++nbrCat;
        // this.libelle = libelle;
    }
    public Categorie() {
        super();
    }


    @Override
    public String toString() {
        return "Categorie"+super.toString();
    }

    
    
    
}
