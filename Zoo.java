package e1636806;

import java.util.ArrayList;

public final class Zoo {
    private static String nom;

    private static Employe employe;
    private static final int maxEnclos = 20;
    private static ArrayList<ArrayList<Enclos<Animal>>> groupeEnclos = new ArrayList<>(8);

    public static String getNom() { return nom; }
    public static String getEmploye() { return (employe.getPrenom() + " " + employe.getNom()); }
    public static ArrayList<ArrayList<Enclos<Animal>>> getGroupeEnclos() { return groupeEnclos; }

    public Zoo(String nom, Employe employe) {
        this.nom = nom;
        this.employe = employe;
    }


    public Animal initialiser100Animaux() { //G�n�ration de 100 animaux al�atoires
        int rndAnimal = (int) (Math.random() * 8) + 1;
        switch (rndAnimal) {
            case 1:
                return new Aigle();
            case 2:
                return new Baleine();
            case 3:
                return new Loup();
            case 4:
                return new Ours();
            case 5:
                return new Pingouin();
            case 6:
                return new Poisson();
            case 7:
                return new Requin();
            case 8:
                return new Tigre();
        }
        return null;
    }


    public static void main(String[] args) { //le vrai main, contient while loop //Faire do while
        Employe e1 = new Employe("Bob", "Gratton", 460420658, 71, true, "2015-05-17");
        Zoo zoo1 = new Zoo("Granby", e1);
        //Création des instances pour tous les ArrayList d'un même type d'enclos
        ArrayList grVolAigle = new ArrayList();
        ArrayList grAquaBal = new ArrayList();
        ArrayList grEnclosLoup = new ArrayList();
        ArrayList grEnclosOurs = new ArrayList();
        ArrayList grAquaPing = new ArrayList();
        ArrayList grAquaPoisson = new ArrayList();
        ArrayList grAquaRequin = new ArrayList();
        ArrayList grEnclosTigre = new ArrayList();

        //Ajout d'enclos du même type que l'ArrayList d'enclos
        for (int i = 0; i < 11; i++) { //Creates 11 pens.
            grVolAigle.add(new Voliere(Aigle.class));
            grAquaBal.add(new Aquarium<Baleine>(Baleine.class));
            grEnclosLoup.add(new Enclos<Loup>(Loup.class));
            grEnclosOurs.add(new Enclos<Ours>(Ours.class));
            grAquaPing.add(new Aquarium<Pingouin>(Pingouin.class));
            grAquaPoisson.add(new Aquarium<Poisson>(Poisson.class));
            grAquaRequin.add(new Aquarium<Requin>(Requin.class));
            grEnclosTigre.add(new Enclos<Tigre>(Tigre.class));
            groupeEnclos.add(grVolAigle);
            groupeEnclos.add(grAquaBal);
            groupeEnclos.add(grEnclosLoup);
            groupeEnclos.add(grEnclosOurs);
            groupeEnclos.add(grAquaPing);
            groupeEnclos.add(grAquaPoisson);
            groupeEnclos.add(grAquaRequin);
            groupeEnclos.add(grEnclosTigre);
        }

        for (int y = 0; y <= 5; y++) { //Makes a lot of animals,
            for (ArrayList<Enclos<Animal>> typeEnclos : groupeEnclos) {
                try {
                    for (int i = 0; i < typeEnclos.size(); i++) {
                        typeEnclos.get(i).addAnimal(new Aigle());
                        typeEnclos.get(i).addAnimal(new Baleine());
                        typeEnclos.get(i).addAnimal(new Loup());
                        typeEnclos.get(i).addAnimal(new Ours());
                        typeEnclos.get(i).addAnimal(new Pingouin());
                        typeEnclos.get(i).addAnimal(new Poisson());
                        typeEnclos.get(i).addAnimal(new Requin());
                        typeEnclos.get(i).addAnimal(new Tigre());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        do {
            e1.menuSelect();
            for (int i = 0; i < 7; i++) {
                for (int k = 0; k < groupeEnclos.size(); k++) { //Go through the 8 types of animals, afterwards goes through the whole inner pens.
                    for (Animal animal : groupeEnclos.get(k).get(i).getGroupAnimal()) { //Problem: after feeding, animal can become hungry immediately due to random.
                        animal.setDormir(Math.random() > 0.5);
                        animal.setManger(Math.random() > 0.5);
                        animal.setSante(Math.random() > 0.5);
                    }
                }
            }
        } while (true); //Placeholder for while
    }
}