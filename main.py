import math

operator = str(input("Please Enter The Process Operator: "))
number1 = int(input("Please Enter a Number: "))

if (operator == "sin"):
    print(str(math.sin((number1/180)*math.pi)))
    quit()

elif (operator == "cos"):
    print(str(math.cos((number1/180)*math.pi)))
    quit()

elif (operator == "tan"):
    print(str(math.tan((number1/180)*math.pi)))  
    quit()

elif (operator == "cot"):
    print(str(math.cot((number1/180)*math.pi)))
    quit()

number2 = int(input("Please Enter a Number: "))
    
if (operator == "+"):
    print(str(number1 + number2))

elif (operator == "-"):
    print(str((number1 - number2)))

elif (operator == "*"):
    print(str(number1 * number2))

elif (operator == "/"):
    print(str(number1 / number2))

elif (operator == "**"):
    print(str(number1 ** number2))

elif (operator == "%"):
    print(str(number1 % number2))


