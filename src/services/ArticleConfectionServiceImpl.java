package services;

import java.util.ArrayList;

import entities.ArticleConfection;
import repositories.List.TableArticleConfection;

public class ArticleConfectionServiceImpl implements ArticleConfectionService{
     private TableArticleConfection ArticlesRepository = new TableArticleConfection();
    @Override
    public int add(ArticleConfection article) {
        return ArticlesRepository.insert(article);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return ArticlesRepository.findAll();
    }

    @Override
    public int update(ArticleConfection article) {
        return ArticlesRepository.update(article);
    }

    @Override
    public ArticleConfection show(int id) {
        return ArticlesRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        return ArticlesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
        for (int id=0; id<ids.length; id++){
            if(ArticlesRepository.delete(id)==0){
                idsNotDelete[nbre++]=id;
            }
        }
        return idsNotDelete;
    }

    public boolean getArticleByLibelle(String libelle){
        for(ArticleConfection art : ArticlesRepository.findAll()){
            if(art.getLibelle().equals(libelle)==true){
                return true;
            }
        }
        return false;
    }

    public ArticleConfection getArticleById(int idC){
        return ArticlesRepository.findAll().stream().filter(p->p.getId()==idC).findFirst().orElse(null);
    }
    
    
}
