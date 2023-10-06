package entities;

public class AbstractEntitie {
    
    protected int id;
    protected String libelle;
    
    public AbstractEntitie(String libelle) {
        this.libelle = libelle;
    }
    public AbstractEntitie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public AbstractEntitie() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArticleConfection other = (ArticleConfection) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "AbstractEntitie [id=" + id + ", libelle=" + libelle + "]";
    }
}
