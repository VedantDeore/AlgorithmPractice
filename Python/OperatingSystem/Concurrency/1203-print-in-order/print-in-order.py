import threading

class Foo:
    def __init__(self):
        self.turn =0
        self.condition = threading.Condition()



    def first(self, printFirst: 'Callable[[], None]') -> None:
        
        # printFirst() outputs "first". Do not change or remove this line.
        with self.condition:

            printFirst()
            self.turn =1
            self.condition.notify_all()


    def second(self, printSecond: 'Callable[[], None]') -> None:
        
        # printSecond() outputs "second". Do not change or remove this line.
        with self.condition:
            while self.turn != 1:
                self.condition.wait()

            printSecond()
            self.turn = 2
            self.condition.notify_all()


    def third(self, printThird: 'Callable[[], None]') -> None:
        
        # printThird() outputs "third". Do not change or remove this line.
        with self.condition:
            while self.turn != 2:
                self.condition.wait()
            
            printThird()