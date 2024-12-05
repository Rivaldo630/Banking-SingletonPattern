#  Journalisation d’un compte bancaire

Afin de mettre en pratique le pattern Singleton en Java, prenons un court exemple d’implémentation dans le milieu bancaire. Tout d’abord, nous allons concevoir une classe `CompteBancaire` qui permet de déposer ou retirer de l’argent sur un compte. Mais nous souhaiterions pouvoir afficher les opérations (effectuées ou refusées) dans la console en cas de litige (il serait aussi possible d’utiliser en sortie un fichier texte). Cette petite application devra rapidement évoluer et il est fort probable que par la suite d’autres classes soient concernées par cette journalisation. Pour cela, nous allons implémenter une classe distincte nommée `Journalisation` reprenant le pattern Singleton. Ainsi, nous allons garantir que notre programme va utiliser une seule et même instance de la classe `Journalisation`. Une troisième classe intitulée `Main` permettra d’exécuter l’application et d’obtenir un résultat en console.

Sur ce diagramme UML, on retrouve les deux classes `Journalisation` et `CompteBancaire`. On remarque aisément que la classe `Journalisation` est basée sur le pattern Singleton. En effet, on trouve un attribut statique de type Singleton, un constructeur déclaré en privé et une méthode statique servant de pseudo-constructeur. Il existe aussi deux méthodes propres à l’utilisation de cette classe que sont `ajouterLog(string)` et `afficherLog()`. La classe `CompteBancaire` correspond à un compte. Celui-ci possède un numéro (identifiant) et un solde. Il est possible de déposer de l’argent ou d’en retirer grâce aux méthodes `deposerArgent(double)` et `retirerArgent(double)`. De plus, certaines vérifications sont effectuées notamment pour éviter un découvert (notre banque ne fait pas crédit). Ces deux dernières méthodes utilisent la classe `Journalisation` pour tracer les opérations. On remarque les appels à la méthode `getInstance()` pour obtenir une instance unique de cette classe.

### Instructions

1. **Classe `CompteBancaire`** :
   - Attributs : `numero` (int), `solde` (double)
   - Méthodes : `deposerArgent(double)`, `retirerArgent(double)`, `getSolde()`

2. **Classe `Journalisation`** :
   - Attributs : `instance` (statique), `logs` (List<String>)
   - Méthodes : `getInstance()`, `ajouterLog(String)`, `afficherLogs()`

3. **Classe `Main`** :
   - Méthode `main` pour exécuter l'application et interagir avec l'utilisateur.

### Exemple de log

La fonction `ajouterLog(log: string)` de la classe Singleton `Journalisation` doit ajouter une log avec la date et l’heure du jour. Exemple : `[30/04/2017 13h46] Dépôt de 100.0 FCFA sur le compte 123456789`.



### PS

La fonction `ajouterLog(log: string)` de la classe Singleton `Journalisation` doit ajouter une log avec la date et l’heure du jour. Exemple : `[30/04/2017 13h46] Dépôt de 100.0 FCFA sur le compte 123456789`.


#*****************************************************************************
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
