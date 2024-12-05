import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> comptesValides = lireComptesValides("compte.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro de compte (ou tapez 'nouveau' pour créer un compte): ");
        String input = scanner.next();

        int numero;
        if (input.equalsIgnoreCase("nouveau")) {
            numero = creerNouveauCompte(scanner, comptesValides);
            System.out.println("Votre nouveau compte a été créé avec succès. Numéro de compte : " + String.format("%09d", numero));
        } else {
            numero = validerNumeroCompte(input, scanner);
            while (!comptesValides.contains(numero)) {
                System.out.print("Numéro de compte invalide. Entrez un numéro de compte valide: ");
                input = scanner.next();
                numero = validerNumeroCompte(input, scanner);
            }
        }

        CompteBancaire compte = new CompteBancaire(numero);

        while (true) {
            System.out.println("\n1. Déposer de l'argent");
            System.out.println("2. Retirer de l'argent");
            System.out.println("3. Afficher le solde");
            System.out.println("4. Afficher les logs");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le montant à déposer: ");
                    double montantDepot = scanner.nextDouble();
                    compte.deposerArgent(montantDepot);
                    break;
                case 2:
                    System.out.print("Entrez le montant à retirer: ");
                    double montantRetrait = scanner.nextDouble();
                    compte.retirerArgent(montantRetrait);
                    break;
                case 3:
                    System.out.println("Solde actuel: " + compte.getSolde() + " FCFA");
                    break;
                case 4:
                    Journalisation.getInstance().afficherLogs();
                    break;
                case 5:
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private static Set<Integer> lireComptesValides(String fichier) {
        Set<Integer> comptes = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(fichier))) {
            while (scanner.hasNextInt()) {
                comptes.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier de comptes non trouvé.");
        }
        return comptes;
    }

    private static int creerNouveauCompte(Scanner scanner, Set<Integer> comptesValides) {
        int numero;
        while (true) {
            System.out.print("Entrez un nouveau numéro de compte (9 chiffres): ");
            String input = scanner.next();
            numero = validerNumeroCompte(input, scanner);
            if (!comptesValides.contains(numero)) {
                comptesValides.add(numero);
                try (FileWriter writer = new FileWriter("compte.txt", true)) {
                    writer.write(String.format("%09d%n", numero));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                System.out.println("Le numéro de compte existe déjà. Veuillez en entrer un autre.");
            }
        }
        return numero;
    }

    private static int validerNumeroCompte(String input, Scanner scanner) {
        while (input.length() != 9 || !input.matches("\\d+")) {
            System.out.print("Numéro de compte invalide. Entrez un numéro de compte de 9 chiffres: ");
            input = scanner.next();
        }
        return Integer.parseInt(input);
    }
}
