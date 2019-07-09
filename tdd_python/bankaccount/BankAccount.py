import unittest


class Bankaccount:
    amount = 0

    def __init__(self, amount):
        self.amount = amount

    def withdraw(self, money):
        balance = self.amount - money
        if balance >= 0:
            self.amount = balance
            return True
        else:
            return False

class BankaccountTest(unittest.TestCase):


    def test_thebank(self):
        account = Bankaccount(10)
        withdrawResult = account.withdraw(5)
        self.assertTrue(withdrawResult)


if __name__ == '__main__':
    unittest.main()