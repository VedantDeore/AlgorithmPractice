import threading
from typing import Callable

class Semaphore:
    def __init__(self, count=0):
        self.count = count
        self.condition = threading.Condition()

    def setCount(self, c):
        with self.condition:
            self.count = c

    def signal(self):
        with self.condition:
            self.count += 1
            if self.count <= 0:
                self.condition.notify()   # notify ONE waiter

    def wait(self):
        with self.condition:
            self.count -= 1
            while self.count < 0:
                self.condition.wait()


class DiningPhilosophers:
    def __init__(self):
        self.forks = [Semaphore(1) for _ in range(5)]
        self.mutex = threading.Lock()

    def wantsToEat(self,
                   philosopher: int,
                   pickLeftFork: Callable[[], None],
                   pickRightFork: Callable[[], None],
                   eat: Callable[[], None],
                   putLeftFork: Callable[[], None],
                   putRightFork: Callable[[], None]) -> None:

        # Deadlock prevention
        with self.mutex:
            self.forks[(philosopher + 1) % 5].wait()
            self.forks[philosopher].wait()

        pickLeftFork()
        pickRightFork()

        eat()

        putLeftFork()
        self.forks[(philosopher + 1) % 5].signal()

        putRightFork()
        self.forks[philosopher].signal()
