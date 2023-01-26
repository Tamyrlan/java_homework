class View():

    def getValue(self, ph) -> float:
        return float(input(ph))

    def menuCalc(self):
        return int(input("MENU\n----------------\n1.Addition\n2.Substract\n3.Multiplication\n4.Division\n----------------\n0.Exit\n"))

    def printres(self, data, title):
        print(title, " ", data)
