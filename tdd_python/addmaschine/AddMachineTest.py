import unittest


class AddMaschine:
    value = 0
    addedNumbers = 0

    def __init__(self):
        self.value = 0
        self.addedNumbers = 0

    def add(self, number):
        self.value = self.value + number
        self.addedNumbers = self.addedNumbers + 1

    def sub(self, number):
        self.value = self.value - number
        self.addedNumbers = self.addedNumbers + 1

    def getSum(self):
        return self.value

    def getAverage(self):
        return self.value / self.addedNumbers

class AddMaschineTest(unittest.TestCase):


    def test_the_maschine(self):
        addMachine = AddMaschine()
        addMachine.add(2)
        self.assertEqual(addMachine.getSum(), 2)


if __name__ == '__main__':
    unittest.main()