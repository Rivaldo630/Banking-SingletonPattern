
# SingletonBanking

Ce projet implémente un exemple de journalisation d'un compte bancaire en utilisant le pattern Singleton en Java.

## Structure du projet

```
SingletonBanking/
├── src/
│   ├── CompteBancaire.java
│   ├── Journalisation.java
│   ├── Main.java
│   └── Utilisateur.java
├── logs/
│   └── journal.txt
└── README.md
```

## Description des classes

- **CompteBancaire** : Gère les opérations bancaires avec des méthodes pour déposer et retirer de l'argent.
- **Journalisation** : Utilise le pattern Singleton pour garantir une seule instance de journalisation des opérations.
- **Main** : Exécute l'application et affiche les résultats en console.

## Fonctionnalités

- **Dépôt d'argent** : Permet de déposer une somme d'argent sur le compte.
- **Retrait d'argent** : Permet de retirer une somme d'argent du compte.
- **Affichage du solde** : Affiche le solde actuel du compte.
- **Journalisation** : Toutes les transactions sont enregistrées dans un fichier texte `journal.txt` pour consultation ultérieure.

## Exemple d'utilisation

Lors de l'exécution de l'application, l'utilisateur peut interagir avec le programme via un menu interactif pour effectuer des dépôts, des retraits, afficher le solde et consulter les logs des transactions.

### Exemple de sortie

```
Entrez le numéro de compte: 123456789

1. Déposer de l'argent
2. Retirer de l'argent
3. Afficher le solde
4. Afficher les logs
5. Quitter
Choisissez une option: 1
Entrez le montant à déposer: 100
[2024-12-05T13:51:00] Dépôt de 100.0 FCFA sur le compte 123456789.

1. Déposer de l'argent
2. Retirer de l'argent
3. Afficher le solde
4. Afficher les logs
5. Quitter
Choisissez une option: 3
Solde actuel: 100.0 FCFA

1. Déposer de l'argent
2. Retirer de l'argent
3. Afficher le solde
4. Afficher les logs
5. Quitter
Choisissez une option: 5
Au revoir!
```

Toutes les transactions sont enregistrées dans le fichier `logs/journal.txt` pour une consultation ultérieure.
#
