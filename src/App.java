import java.util.ArrayList;
import java.util.Scanner;

import entities.ArticleConfection;
import entities.Categorie;
import entities.Unite;
import services.ArticleConfectionServiceImpl;
import services.CategorieServiceImpl;

public class App {
    static CategorieServiceImpl categorieServiceImpl = new CategorieServiceImpl();
    static ArticleConfectionServiceImpl ArticleServiceImpl = new ArticleConfectionServiceImpl();
    static int choix;
    static Scanner scanner = new Scanner(System.in);
    static int choixCategorie;
    static int choixArticle;
    static int index;
    public static void main(String[] args) throws Exception {
        do {
            switch (menu()) {
                case 1:
                    switch (menuCategorie()) {
                        case 1:
                            System.out.println("Libelle");
                            scanner.nextLine();
                            String libelle=scanner.nextLine();
                            System.out.println(categorieServiceImpl.getCategorieByLibelle(libelle));
                            if(categorieServiceImpl.getCategorieByLibelle(libelle)==false){
                                Categorie cat=new Categorie(libelle);
                                categorieServiceImpl.add(cat);
                            }else{
                                System.out.println("La categorie existe deja");
                            }
                            break;
                        case 2:
                            System.out.println("liste des categories");
                            categorieServiceImpl.getAll().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("liste des categories");
                            categorieServiceImpl.getAll().forEach(System.out::println);
                            System.out.println("Saisir l'id de la modificacion");
                            int idCat=scanner.nextInt();
                            scanner.nextLine();
                            if(categorieServiceImpl.getCategorieById(idCat)!=null){
                                System.out.println("Saisir le nouveau libelle");
                                String newlibelle=scanner.nextLine();
                                categorieServiceImpl.getCategorieById(idCat).setLibelle(newlibelle);
                                System.out.println("Libelle modifié avec success!!");
                            }else{
                                System.out.println("l'id ne correspond à aucune Categorie");
                            }
                            break;
                        case 4:
                            System.out.println("liste des categories");
                            categorieServiceImpl.getAll().forEach(System.out::println);

                            System.out.println("Saisir l'id de la suppression");
                            idCat=scanner.nextInt();
                            scanner.nextLine();
                            if(categorieServiceImpl.getCategorieById(idCat)!=null){
                                categorieServiceImpl.remove(idCat);
                            }else{
                                System.out.println("l'id ne correspond à aucune Categorie");
                            }
                        break;
                        case 5:
                            System.out.println("Nombre de categorie à supprimer:");
                            int nbrSup=scanner.nextInt();

                            for (int index = 1; index <= nbrSup; index++) {
                                System.out.println("liste des categories");
                                categorieServiceImpl.getAll().forEach(System.out::println);

                                System.out.println("Saisir l'id de la suppression");
                                idCat=scanner.nextInt();
                                scanner.nextLine();
                                if(categorieServiceImpl.getCategorieById(idCat)!=null){
                                    categorieServiceImpl.remove(idCat);
                                }else{
                                    System.out.println("l'id ne correspond à aucune Categorie");
                                }
                            }
                            break;
                            
                        default:
                            break;
                    }

                break;
                case 2:
                    switch (menuArticle()) {
                        case 1:
                            scanner.nextLine();
                            System.out.println("Libelle");
                            String libelleA=scanner.nextLine();
                            System.out.println("prix:");
                            double prix=scanner.nextDouble();
                            System.out.println("Quantite:");
                            double qte=scanner.nextDouble();
                            if(ArticleServiceImpl.getArticleByLibelle(libelleA)==false){
                                System.out.println("liste des categories");
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Choisir la Categorie");
                                Categorie cat=categorieServiceImpl.getCategorieById(scanner.nextInt());
                                ArticleConfection article=new ArticleConfection(libelleA, prix, qte);
                                article.setCategorie(cat);

                                System.out.println("nbre d'unites?:");
                                int nbrUnit=scanner.nextInt();
                                scanner.nextLine();
                                for (int index = 1; index <= nbrUnit; index++) {
                                    System.out.println("Libelle");
                                    String lib=scanner.nextLine();
                                    Unite uni=new Unite(index, lib);
                                    article.addUnite(uni);
                                    
                                }

                                ArticleServiceImpl.add(article);
                                System.out.println("Article ajouté avec succes!!!");
                            }else{
                                System.out.println("L'article a deja ete enregistré!!!");
                            }
                            break;
                        case 2:
                            System.out.println("liste des Articles de confection");
                            ArticleServiceImpl.getAll().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("liste des Articles de confection");
                            ArticleServiceImpl.getAll().forEach(System.out::println);
                            System.out.println("Saisir l'id de la modificacion");
                            int idArt=scanner.nextInt();
                            scanner.nextLine();
                            do {
                                System.out.println("1-Libelle,2-Prix,3-Quantite:");
                                System.out.println("Saisir l'index associé à,l'attribut à modifier:");
                                index=scanner.nextInt();
                            } while (index<1|| index>3);
                            if(index==1){
                                System.out.println("Saisir le nouveau libelle");
                                String newlibelle=scanner.nextLine();
                                ArticleServiceImpl.getArticleById(idArt).setLibelle(newlibelle);
                                System.out.println("Libelle modifié avec success!!");
                            }else if(index==2){
                                System.out.println("Saisir le nouveau prix");
                                double newprix=scanner.nextDouble();
                                ArticleServiceImpl.getArticleById(idArt).setPrix(newprix);
                                System.out.println("prix modifié avec success!!");
                            }else{
                                System.out.println("Saisir la nouvelle quantite");
                                double newqte=scanner.nextDouble();
                                ArticleServiceImpl.getArticleById(idArt).setQte(newqte);
                                System.out.println("quantite modifié avec success!!");
                            }
                            break;
                        case 4:
                            System.out.println("liste des Articles de confection");
                            ArticleServiceImpl.getAll().forEach(System.out::println);

                            System.out.println("Saisir l'id de la suppression");
                            idArt=scanner.nextInt();
                            scanner.nextLine();
                            if(ArticleServiceImpl.getArticleById(idArt)!=null){
                                ArticleServiceImpl.remove(idArt);
                            }else{
                                System.out.println("l'id ne correspond à aucune Categorie");
                            }
                            break;
                        case 5:
                            System.out.println("Nombre d'articles à supprimer:");
                            int nbrSup=scanner.nextInt();
                            for (int index = 1; index <= nbrSup; index++) {
                                System.out.println("liste des Articles de confection");
                                ArticleServiceImpl.getAll().forEach(System.out::println);

                                System.out.println("Saisir l'id de la suppression");
                                idArt=scanner.nextInt();
                                scanner.nextLine();
                                if(ArticleServiceImpl.getArticleById(idArt)!=null){
                                    ArticleServiceImpl.remove(idArt);
                                }else{
                                    System.out.println("l'id ne correspond à aucune Categorie");
                                }
                            }
                            
                            break;
                        default:
                            break;
                    }    

                break;
                default:
                System.out.println("AU REVOIR!!!!!");
                    break;
            }
        } while (choix!=3);
    }

    public static int menuCategorie(){   
        System.out.println("1-------Ajouter une Categorie");
        System.out.println("2-------Lister les Categories");
        System.out.println("3-------modifier une Categorie");
        System.out.println("4-------supprimer une Categorie");
        System.out.println("5-------supprimer plusieurs categories");
        System.out.println("6-------Menu General");
        do {
            System.out.println("Faites un choix");
            choixCategorie=scanner.nextInt();
        } while (choixCategorie<1 || choixCategorie>6);
        return choixCategorie;
    }

    public static int menuArticle(){   
        System.out.println("1-------Ajouter un Article de Confection");
        System.out.println("2-------Lister les Articles de Confection");
        System.out.println("3-------Modifier un Article de Confection");
        System.out.println("4-------Supprimer un Article de Confection");
        System.out.println("5-------supprimer plusieurs Articles de Confections");
        System.out.println("6-------Menu General");
        do {
            System.out.println("Faites un choix");
            choixArticle=scanner.nextInt();
        } while (choixArticle<1 || choixArticle>6);
        return choixArticle;
    }
    public static int menu(){   
        System.out.println("1-------CATEGORIE");
        System.out.println("2-------ARTICLE DE CONFECTION");
        System.out.println("3-------Quitter");
        do {
            System.out.println("Faites un choix");
            choix=scanner.nextInt();
        } while (choix<1 || choix>5);
        return choix;
    }
}
