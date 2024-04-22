# Sisyphus Simulator
a fully text-based concept written in java where you push a boulder up a hill forever past randomly generated terrain. 
## characters
* . - background/blank space
* ඞ - player, can be moved with wasd
* ^ - fire, kills player and damages boulder, can be extinguished by boulder
* Σ - wall, cannot be walked through
* 0 - boulder, can be pushed by the player 
* #, $, @, % - fog, represents unexplored area
all characters can be modified in */game/main.java* under **/*CHARACTERS*/** section

## running
* clone repository 
* cd into root folder (outside of /game/)
``` shell     
    $ java game/main.java
```   

## controls
controls are handled through terminal text input, multiple inputs can be entered at a time, inputs are executed in the order they are typed

* wasd: move
* r: refresh map

## music
* Original: *(https://www.youtube.com/watch?v=jcYvDZKLQJ0&t=0s)*
* MIDI: *(https://www.youtube.com/watch?v=4BnaipwsQ6M&t=0s)*
* Soundfont: *(https://musical-artifacts.com/artifacts/23)*
