package services;

import java.util.ArrayList;

import entities.Categorie;
import repositories.List.TableCategorie;

public class CategorieServiceImpl implements CategorieService {
    // couplage fort
    private TableCategorie categoriesRepository = new TableCategorie();
    // couplage faible
    // private ITables categoriesRepository;
    @Override
    public int add(Categorie categorie) {
        return categoriesRepository.insert(categorie);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public int update(Categorie categorie) {
        return categoriesRepository.update(categorie);
    }

    @Override
    public Categorie show(int id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        // TODO Auto-generated method stub
        return categoriesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
        for (int id=0; id<ids.length; id++){
            if(categoriesRepository.delete(id)==0){
                idsNotDelete[nbre++]=id;
            }
        }
        return idsNotDelete;
    }

    public boolean getCategorieByLibelle(String libelle){
        for(Categorie cat : categoriesRepository.findAll()){
            if(cat.getLibelle().equals(libelle)==true){
                return true;
            }
        }
        return false;
    }

    public Categorie getCategorieById(int idC){
        return categoriesRepository.findAll().stream().filter(p->p.getId()==idC).findFirst().orElse(null);
    }
    
}
