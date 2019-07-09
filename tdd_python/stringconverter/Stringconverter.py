import unittest

class Stringcalculator:

    def calculate(self, text):
        return 0


class StringconverterTest(unittest.TestCase):


    def test_emptyStringResultZero(self):
        stringcalculator = Stringcalculator()
        result = stringcalculator.calculate("")
        self.assertEqual(result, 0)

    '''Paste here additional tests by using TDD principles'''


if __name__ == '__main__':
    unittest.main()