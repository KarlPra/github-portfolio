# -*- coding: utf-8 -*-
"""
Created on Sat Oct  5 17:08:22 2024

@author: kcprasuhn
"""
import random

top_of_range=input("Type a number: ")

if top_of_range.isdigit():
    top_of_range = int(top_of_range)
    
    if top_of_range<=0:
        print("Please type a number than 0 the next time.")

else:
    print("Print type a number next time.")
    quit()
    
random_number = random.randint(0,top_of_range)
guesses=0

while True:
    guesses+=1
    user_guess = input("Make a guess: ")
    if user_guess.isdigit():
        user_guess = int(user_guess)
    else:
        print("Please type a number the next time")
        continue
    
    if user_guess == random_number:
        print("You got it!")
        break
    else:
        if user_guess> random_number:
            print("You were above the number!")
        else:
            print("You were below the number!")
        
print("You got it in", guesses, "guesses")