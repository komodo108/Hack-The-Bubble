# Hack-The-Bubble

### Motivation
Project for Hack the Bubble 2017 - done in 12 hours

### Maps
Maps are the thing on which the game is played. To make your own map, follow the steps below:
Notice the list of available blocks:
```text
    empty '.'
    finish 'Y'
    floor 'f'
    lava 'l'
    wall 'w'
    spike 's'
    door 'D'
    key 'K'
    lever1 'R'
    lever2 'Q'
    upgrade 'U'
    blockage1 'B'
    blockage2 'C'
    enemy 'E'
    cute1 'I'
    cute2 'T'

    ERROR 'X'
```
Maps are made from a 25*25 square of these blocks, the player should be spawned at the bottom left, 2 blocks up and 1 block right.
An example map is given:
```text
wwwwwwwwwwwwwwwwwwwwwwwww
wwww..ssssssssssss......Y
w..D.................ffff
wUfff....................
wfw......................
w.......................f
w....sff................w
w.....ss................w
........................w
ff......................w
w................fff.s..Q
w.........f......sssfwffw
R.........w.............w
wf........ws............w
w.s.......ws............w
w.f..f....ws............w
w.........ws.ff.......ffw
w........fws..........CK.
w.........ws.........ffff
w.........ws............w
w.........w.............w
w.....ffffw.............w
w.............fff.......w
wfff..........BUwss.....w
wwwwffffffffffffwwwfffffw
```
