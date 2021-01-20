import random
import string
import pyperclip # pip install pyperclip


# Alphabet, letters will be picked out of this randomly
alphabet = string.ascii_letters + string.digits + string.digits + string.punctuation


# Output password
password = ""


# Desired password length
password_length = 0


# Try to parse password length from user
try:
    password_length = int(input("Please input password length: "))
# The intered input was not a number, error thrown by the int() conversion attempt
except:
    print("The entered input was not a number")
    exit()


# Randomly pick out characters out of the alphabet
for a in range(0,password_length):
    password += alphabet[random.randint(0,len(alphabet)-1)]


user_input = input("Do you want the password to be shown? y/n: ")
pyperclip.copy(password)


if 'y' in user_input:
    print("The generated password is: %s" % password)
else:
    print("The password was copied to the clipboard!")