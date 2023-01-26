from CalcModel import CalcModel


class OperModel(CalcModel):

    @classmethod
    def sumResult(self):
        return self.x + self.y

    @classmethod
    def subResult(self):
        return self.x - self.y

    @classmethod
    def multResult(self):
        return self.x * self.y

    @classmethod
    def divResult(self):
        return self.x / self.y

    @classmethod
    def setX(self, x):
        self.x = x

    @classmethod
    def setY(self, y):
        self.y = y
