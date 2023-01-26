from OperModel import OperModel
from View import View
from Model import Model


class Presenter():
    view = View()
    model = Model()

    def __init__(self, v):
        self.view = v

    def buttonStart(self):
        num = self.view.menuCalc()
        # if num==0:
        #     pass
        self.model = OperModel()
        self.buttonClick(num)

    def buttonClick(self, num):
        a = self.view.getValue("Enter first number: ")
        b = self.view.getValue("Enter second number: ")
        self.model.setX(a)
        self.model.setY(b)
        if num == 1:
            result = self.model.sumResult()
            self.view.printres(result, "Addition result: ")
        elif num == 2:
            result = self.model.subResult()
            self.view.printres(result, "Substract result: ")
        elif num == 3:
            result = self.model.multResult()
            self.view.printres(result, "Multiplication result: ")
        elif num == 4:
            result = self.model.divResult()
            self.view.printres(result, "Division result: ")
