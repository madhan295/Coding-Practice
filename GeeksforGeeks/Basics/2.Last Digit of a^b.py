class Solution:
    def getLastDigit(self, a, b):
        if b == "0":
            return 1

        last_digit = int(a[-1])

        exponent = int(b)

        return pow(last_digit, exponent, 10)