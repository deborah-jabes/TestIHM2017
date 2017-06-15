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

Il y aura aussi plusieurs classes de moindre importance qui serviront d'outils pour les classes principales.

L'objectif de ce test est d'évaluer votre capacité à écrire une IHM à l'aide du langage Java, les méthodes complexes 
car trop algorithmiques n'auront pas à être implémentées. Vous pourrez retrouver une proposition de correction à l'adresse 
suivante : https://github.com/IUTInfoAix-m2105/TestIHM2017/

Le résultat attendu devra ressembler à la fenêtre suivante :

![IHM](src/main/resources/assets/screenshoot.png)





