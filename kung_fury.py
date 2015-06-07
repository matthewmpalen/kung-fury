from random import choice
import string
from sys import stdout
from time import sleep

if __name__ == '__main__':
    try:
        with open('script.txt', 'r') as f:
            energy_converter_text = f.read()
    except IOError:
        print('Could not open file')
        exit()

    for i in range(2):
        for char in energy_converter_text:
            stdout.write(char)
            stdout.flush() # Needed to print 1 at a time
            sleep(0.02)

    count = 0
    chars = string.letters + string.digits

    while True:
        stdout.write(choice(chars))
        if count % 80 == 0:
            stdout.write('\n')
        stdout.flush()
        sleep(0.01)

        count += 1
