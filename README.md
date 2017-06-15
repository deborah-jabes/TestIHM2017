# <img src="https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png" alt="class logo" class="logo"/> Introduction aux IHM en Java 

## Test d'IHM et langage Java [![Build Status](https://travis-ci.com/IUTInfoAix-M2105/TestIHM2017.svg?token=zPXgu159amQhEb4ShTxW&branch=master)](https://travis-ci.com/IUTInfoAix-M2105/TestIHM2017)

**Test du vendredi 16 juin 2017 – Durée 2 heures – Documents autorisés**

L’objet de cet exercice est la programmation d’un jeu du taquin. Le taquin est un jeu solitaire en forme de damier créé 
vers 1870 aux États-Unis. Sa théorie mathématique a été publiée par l'American Journal of mathematics pure and applied 
en 1879. En 1891, son invention fut revendiquée par Sam Loyd, au moment où le jeu connaissait un engouement considérable, 
tant aux États-Unis qu'en Europe. 

Il est composé de 15 petits carreaux numérotés de 1 à 15 qui glissent dans un cadre prévu pour 16. Il consiste à 
remettre dans l'ordre les 15 carreaux à partir d'une configuration initiale quelconque. Le principe a été étendu à 
toutes sortes d'autres jeux. La plupart sont à base de blocs rectangulaires plutôt que carrés, mais le but est toujours 
de disposer les blocs d'une façon déterminée par un nombre minimal de mouvements. Le Rubik's Cube est aujourd'hui 
considéré comme l'un des « descendants » du taquin.

L'image ci-dessous, illustre un jeu du taquin résolu :

![](https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/15-puzzle.svg/768px-15-puzzle.svg.png)

### Travail à réaliser
Votre travail dans la suite de ce sujet sera d'écrire pas à pas plusieurs classes importantes :
- Un objet `TaquinMain` est une application JavaFX permettant de jouer au Taquin.
- Un objet `TaquinIHM` est une scène de jeu avec laquelle les joueurs interagiront pour faire une partie à tour de rôle.
- Un objet `TaquinBoard` représente le plateau de jeu composé des 16 cases.
- Un objet `Carreau` représente un carreau du taquin.
- Un objet `StatusBar` permet d'afficher le score et l'état de la partie.

Le diagramme UML suivant donne un apperçu synthétique de la structure des classes de l'application :
![UML](src/main/resources/diagram.png)

Il y aura aussi plusieurs classes de moindre importance qui serviront d'outils pour les classes principales.

L'objectif de ce test est d'évaluer votre capacité à écrire une IHM à l'aide du langage Java, les méthodes complexes 
car trop algorithmiques n'auront pas à être implémentées. Vous pourrez retrouver une proposition de correction à l'adresse 
suivante : https://github.com/IUTInfoAix-m2105/TestIHM2017/

Le résultat attendu devra ressembler à la fenêtre suivante (mais n'inclura pas la durée que l'on aperçoit au bas de la fenêtre):

![IHM](src/main/resources/assets/taquin_screenshot.png)

### Implémentation de la classe `Carreau`

Le plateau de jeu du taquin sera composé de 16 cases, chacune contenant un carreau placé au départ sur une case au hasard, sauf la case vide.
Chaque carreau est numéroté de 1 à 15, numéro de sa position voulue dans le plateau pour résoudre le jeu.

1. Écrivez la classe `Carreau` qui sera publique et étendra `Button`. Elle possèdera les données membres privées suivantes :
     - `value` de type `Integer` qui correspond au numéro du carreau. 
     - `position` de type `Position`, la position courante dans le plateau.
     - `positionAttendue` de type `Position`, la position attendue en fin de jeu.

2. Écrivez un constructeur publique `Carreau(Integer numero, Position position)` qui : 
    - assigne les données membres locales correspondantes aux paramètres donnés.
    - fixe la largeur et hauteur du `Carreau` à `TaquinBoard.CELL_SIZE`, soit la taille d'une cellule. Utilisez les méthodes de `Button` : `setMinSize()`, `setMaxSize()` et `setPrefSize()`.
    - fixe l'alignement du contenu du carreau au centre.
    - fixe comme texte du bouton le numéro du carreau courant.

3. Écrivez les accesseurs publiques `getNumero()` et `getPosition()` qui renvoient leur donnée membre correspondante.

4. Écrivez le modifieur publique `setPosition(Position position)` qui assigne la donnée membre correspondante.

5. Écrivez la méthode publique `estBienPlace()` qui indique si le carreau est positionné à la position attendue en fin de partie.


### Implémentation de la classe `TaquinBoard`

La classe `TaquinBoard` est un composant graphique qui hérite de `GridPane` pour représenter visuellement le plateau de jeu.
Elle crée les carreaux du jeu, les place à une position aléatoire (mais solvable), et gère les coups du joueur.
Pour simplifier, la case vide sera matérialisée par un carreau particulier, dit "vide".

1. Écrire la déclaration d'une classe publique `TaquinBoard`, sous-classe de `GridPane`, réduite pour le moment à la déclaration des variables d'instance suivantes, toutes privées :
     - `taille` de type `int` qui contiendra la taille en largeur et en hauteur du plateau, de laquelle on en déduira le nombre de carreaux, `taille` x `taille` (ce qui comprend le carreau vide).
     - `carreaux` qui est une liste (`List`) d'objets `Carreau` que l'on sera créée et peuplée dans le constructeur
     - `carreauVide` qui est le `Carreau` particulier de la liste `carreaux`, qui sera créé pour représenter la case vide
     - `estPartieTerminee` qui est une **propriété booléenne** qui indiquera si la partie est terminée
     - `nombreDeMouvement` qui est une **propriété entière** qui indiquera le nombre de coups (déplacements) joués au cours de la partie courante
     - `ecouteurDeCarreau` qui est un gestionnaire des événements de type `ActionEvent` qui s'occupera de traiter les clics sur les carreaux, permettant au joueur de les déplacer

2. Écrire le constructeur public `TaquinBoard(int taille)` qui :
     - affecte à la variable d'instance correspondante la `taille` passée en paramètre
     - crée et initialise à `false` sa propriété `estPartieTerminee`
     - crée et initialise à 0 sa propriété `nombreDeMouvement`
     - initialise la liste (vide) des carreaux avec un objet `ArrayList`
     - appelle la méthode `creerEcouteurDeCarreau()` (qui initialisera la variable d'instance `ecouteurDeCarreau`)
     - appelle la méthode `initCarreaux()`

3. Écrire la méthode privée `initCarreaux()` qui crée tous les carreaux du plateau. Pour cela, elle :
     - initialise à 0 une variable locale contenant le numéro du carreau courant
     - utilise deux boucles imbriquées, l'une pour les lignes et l'autre pour les colonnes, pour créer les `taille` x `taille` objets `Carreau`. 
     Pour la création de chacun des carreaux, il faut :
          * incrémenter le numéro du carreau courant
          * créer l'objet `Carreau` avec son numéro et sa `Position` (ligne et colonne)
          * ajouter le carreau au `TaquinBoard` (qui est un `GridPane`)
          * (to be continued)

4. Écrire la méthode `private void placer(Carreau carreau, Position position)` qui place le carreau dans la nouvelle position donnée 
et fixe la position du `carreau` dans la `GridPane` en tant que contrainte (avec la méthode statique `GridPane.setConstraints()`).

5. Écrire la méthode `private void permuter(Carreau carreau1, Carreau carreau2)` qui permute les positions des deux carreaux 
donnés en paramètre à l'aide de la méthode `placer()` et incrémente le nombre de mouvements.

6. Écrire la méthode `private void deplacer(Carreau carreau)` qui déplace le `carreau` s'il est adjacent à la case vide. Dans cette méthode, vous devrez :
    - Créer une variable `positionCarreau` qui mémorise la position courante du carreau passé en paramètre.
    - Créer une variable `positionVide` qui mémorise la position de la case vide (`carreauVide`).
    - Créer des variables de type `Position` correspondant aux coordonnées à gauche, à droite, en haut et en bas de la position du carreau courant.
    - Tester si l'une de ces positions correspond à celle de la case vide. Si tel est le cas, les permuter.

7. Écrire la méthode `private void verifierFinDePartie()` qui fixe la propriété `estPartieTerminee` 
comme vraie si tous les carreaux de la liste sont bien placés à leur position attendue en fin de partie.

### Implémentation de la classe `StatusBar`
La classe `StatusBar` est un composant graphique permettant d'afficher l'état de la partie en cours. 
L'implémentation de cette classe vous est donnée ci-dessous :
```java
public class StatusBar extends BorderPane {
    private Label labelNombreDeMouvement = new Label();
    private Label labelTemps = new Label();
    private Label labelpartieTerminee = new Label();

    private IntegerProperty nombreDeMouvement = new SimpleIntegerProperty();
    private BooleanProperty estPartieTerminee = new SimpleBooleanProperty();

    private LocalTime time = LocalTime.now();
    private Timeline timer;
    private  StringProperty clock = new SimpleStringProperty("00:00:00");
    private  DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    public StatusBar() {
        creerAnimation();
        creerBindings();

        setLeft(labelNombreDeMouvement);
        setRight(labelTemps);
        setCenter(labelpartieTerminee);
    }

    private void creerAnimation() {
        timer = new Timeline(new KeyFrame(Duration.ZERO, e-> 
            clock.set(LocalTime.now().minusNanos(time.toNanoOfDay()).format(fmt))),
                new KeyFrame(Duration.seconds(1)));
        timer.setCycleCount(Animation.INDEFINITE);
    }

    private void creerBindings(){
        labelTemps.textProperty().bind(Bindings.concat("Durée : ",clock));
        labelNombreDeMouvement.textProperty().bind(Bindings.concat("Mouvements : ",nombreDeMouvement));
        labelpartieTerminee.textProperty().bind(when(estPartieTerminee).then("Partie terminée !").otherwise(""));
    }

    void nouvellePartie(){
        time = LocalTime.now();
        timer.playFromStart();
    }

    public IntegerProperty nombreDeMouvementProperty() {
        return nombreDeMouvement;
    }

    public BooleanProperty estPartieTermineeProperty() {
        return estPartieTerminee;
    }
}
```

### Implémentation de la classe `TaquinIHM`
La classe `TaquinIHM` représente le contenu de la fenêtre principale du Jeu (le noeud racine de la scène). En plus du 
plateau situé au centre, cette fenêtre contient une barre de menu en haut et une barre de statut en bas. La barre de menu 
contient un menu "Jeu" constitué d'une entrée "Nouvelle Partie" et d'une entrée "Quitter".

1. Écrire la déclaration d’une classe `TaquinIHM`, sous-classe de `BorderPane`, réduite, pour commencer, à 
ses variables d’instance, toutes privées :
    - `taille` de type `int` représente la taille du plateau de jeu.
    - `statusBar` de type `StatusBar` est l'objet matérialisant la barre de statut
    - `taquinBoard` de type `taquinBoard` est l'objet plateau de jeu
    - `menuBar` de type `MenuBar` est la barre de menu de notre jeu

2. Écrire la méthode `void nouvellePartie()` qui s'occupe de créer une nouvelle partie en effectuant le bon traitement 
sur le plateau de jeu et sur la barre de statut (regarder le diagramme UML pour trouver les méthodes à appeler).

3. Écrire la méthode `private Menu creerMenuJeu()` qui crée le menu "Jeu". Ce menu devra être constitué de deux items, 
un premier pour l'entrée "Nouvelle Partie" et un second pour "Quitter". Ne pas oublier d'ajouter un écouteur d'action 
(de la même façon que pour un bouton). "Nouvelle Partie" se contente d'appeler la méthode `nouvellePartie()` et "Quitter"
termine proprement de l'application.

4. Écrire la méthode `private MenuBar creerBarreDeMenu()` qui s'occupe de créer la barre de menu contenant que le menu "Jeu".

5. Écrire la méthode `private void creerBindings()` qui s'occupe de créer tous les bindings entre les différents 
composants de notre IHM. Cette méthode devra, lier les propriétés qui ont le même nom dans les classes `StatusBar` 
et `TaquinBoard`. Sur la propriété `estPartieTerminee` de la donnée membre `taquinBoard`, ajouter un écouteur de 
changement qui appelle la méthode `afficheDialogFinDePartie()` lorsque la partie est terminée. 

6. Écrire le constructeur par défaut de la classe `TaquinIHM`. Ce constructeur devra :
    - Initialiser correctement les différentes données membres.
    - Ajouter la barre de menu.
    - Placer le plateau de jeu au centre de la fenêtre.
    - Placer la barre de statut en bas de la fenêtre.
    - Créer les bindings.
    - Lancer une nouvelle partie.

### Implémentation de la classe `TaquinMain`

La classe `TaquinMain` est le programme principal de notre application. C'est elle qui a la responsabilité de 
charger la vue principale et de l'ajouter à la scène. Cette classe est une application JavaFX qui étend donc `Application`.

1. Écrire une méthode `main` aussi réduite que possible pour lancer l’exécution de l'application.


2. Écrire la méthode `public void start(Stage primaryStage)`. Elle devra :
    - Modifier le titre de la fenêtre en "Taquin".

    - Créer un objet `TaquinIHM`
    
    - l'Ajouter le comme racine du graphe de scène.

    - Rendre visible le stage.
