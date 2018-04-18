import random

def intro():
    print("this is a rock paper scissors game;");
    print("r = rock; p = paper; s = scissors; l = leave game.");
def game():
    while True:
        move = input("What would you like to go, rock, paper or scissors? \n")
        computer_move = random.randint(1,3)
        if move == 'r' and computer_move == 1:
            print("The computer goes rock, tie game")
        if move == 'r' and computer_move == 2:
            print("The computer goes paper, you lost")
        if move == 'r' and computer_move == 3:
            print("The computer goes scissors, you won")
        if move == 'p' and computer_move == 1:
            print("The computer goes rock, you won")
        if move == 'p' and computer_move == 2:
            print("The computer goes paper, tie game")
        if move == 'p' and computer_move == 3:
            print("The computer goes scissors, you lost")
        if move == 's' and computer_move == 1:
            print("The computer goes rock, you lost")
        if move == 's' and computer_move == 2:
            print("The computer goes paper, you won")
        if move == 's' and computer_move == 3:
            print("The computer goes scissors, time game")
        if move == 'l':
            print("goodbye")
            break
        else :
            print("You should choose rock, paper or scissors")
intro()
game()

