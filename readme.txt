Il y a parfois des problèmes au niveau du chargement de l'image même quand le path est un path relatif au projet. Nous n'avons pas pu comprendre pourquoi.

Si l'image ne charge pas lors de l'ouverture du programme, charger une autre image va le faire planter. C'est quelque chose qui est documenté dans le rapport de lab comme point à améliorer.

Pour régler le problème, il faut changer la variable path et badpath en ligne 17 et 19 du fichier "ModelFacade.Java" Il y a des images dans le projet (Cheetos2_500_535.jpg) qui vont fonctionner avec le path. Parfois un type de path relatif fonctionne et un autre non. Désolée du soucis. 

Nous utilisons la version 17 de java pour ce projet.