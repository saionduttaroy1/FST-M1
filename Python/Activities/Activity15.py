try:
    # Intentionally causing a NameError
    print(some_variable)
except NameError:
    print("A NameError occurred, but it has been handled.")
