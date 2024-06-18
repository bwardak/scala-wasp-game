# Wasp Game

## Logic

- Wasps are immutable instances, update by creating new instance
  - Check for hp being above 0, if <= 0, change isAlive to false
- Add form of id to wasps to randomise which is hit

## Plan

1) Create abstract class for wasps.
   - Include taking damage and if its still alive (bool)
2) Create different wasp classes with right attributes
   - Add method for queen to end game on death
3) Create class for attacking
   - Type command and press enter
4) Create class for game structure
   - Timer
   - Count attacks
   - Update the state displayed
5) Add string formatting etc
   - Display messages
   - Line for each input to make game look clean

## Extras

1) Add potential traits e.g wasp sounds, attack types
2) Make attack command a random word, attack if spelt correctly, punish if incorrect
3) Make wasp emoticon in terminal 
4) Health bars "#####"
5) File read/write for game stats