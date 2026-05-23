def validate_isbn(isbn, length):
    # Fix 1: Corrected len() syntax error
    if len(isbn) != length:
        print(f'ISBN-{length} code should be {length} digits long.')
        return
        
    # Fix 2: Rectified off-by-one and IndexError bugs.
    # The last character is the check digit, the first length-1 characters are the main digits.
    main_digits = isbn[0:length - 1]
    given_check_digit = isbn[length - 1]
    
    # Fix 3: Handle ValueError if the main body contains non-numeric characters
    try:
        main_digits_list = [int(digit) for digit in main_digits]
    except ValueError:
        print("Invalid character was found.")
        return

    # Calculate the check digit from other digits
    if length == 10:
        expected_check_digit = calculate_check_digit_10(main_digits_list)
    else:
        expected_check_digit = calculate_check_digit_13(main_digits_list)
        
    # Check if the given check digit matches with the calculated check digit
    if given_check_digit == expected_check_digit:
        print('Valid ISBN Code.')
    else:
        print('Invalid ISBN Code.')

def calculate_check_digit_10(main_digits_list):
    digits_sum = 0
    # Multiply each of the first 9 digits by its corresponding weight (10 to 2) and sum up the results
    for index, digit in enumerate(main_digits_list):
        digits_sum += digit * (10 - index)
    # Find the remainder of dividing the sum by 11, then subtract it from 11
    result = 11 - digits_sum % 11
    if result == 11:
        expected_check_digit = '0'
    elif result == 10:
        expected_check_digit = 'X'
    else:
        expected_check_digit = str(result)
    return expected_check_digit

def calculate_check_digit_13(main_digits_list):
    digits_sum = 0
    # Multiply each of the first 12 digits by 1 and 3 alternately (starting with 1), and sum up the results
    for index, digit in enumerate(main_digits_list):
        if index % 2 == 0:
            digits_sum += digit * 1
        else:
            digits_sum += digit * 3
    # Find the remainder of dividing the sum by 10, then subtract it from 10
    result = 10 - digits_sum % 10
    if result == 10:
        expected_check_digit = '0'
    else:
        expected_check_digit = str(result)
    return expected_check_digit

def main():
    user_input = input('Enter ISBN and length: ')
    values = user_input.split(',')
    
    # Fix 4: Try/Except block to catch missing commas (IndexError)
    try:
        isbn = values[0]
        length_str = values[1]
    except IndexError:
        print("Enter comma-separated values.")
        return

    # Fix 5: Try/Except block to catch non-numeric lengths (ValueError)
    try:
        length = int(length_str)
    except ValueError:
        print("Length must be a number.")
        return

    # Fix 6: Fixed the IndentationErrors from the original code
    if length == 10 or length == 13:
        validate_isbn(isbn, length)
    else:
        print('Length should be 10 or 13.')

# Fix 7: Commented out the global main() call so the testing framework runs properly
# main()