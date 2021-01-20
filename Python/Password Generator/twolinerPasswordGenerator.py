import random, string
print('Generated password: ' + ''.join(map(lambda a: (string.ascii_letters + string.digits + string.digits + string.punctuation)[random.randint(0,103)], range(0,int(input("Please input password length: "))))))

# Alphabet = string.ascii_letters + string.digits + string.digits + string.punctuation
# Map is used in place of a for loop
# Lambda function applied to the list range(0,password_length) = [0,1,2, ..., password_length-1]
# ''.join is used to join the list of characters ['c','c','c'] into a string 'ccc'