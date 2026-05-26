class Category:
    def __init__(self, name):
        self.name = name
        self.ledger = []

    def deposit(self, amount, description=""):
        self.ledger.append({
            "amount": amount,
            "description": description
        })

    def withdraw(self, amount, description=""):
        if self.check_funds(amount):
            self.ledger.append({
                "amount": -amount,
                "description": description
            })
            return True
        return False

    def get_balance(self):
        total = 0
        for item in self.ledger:
            total += item["amount"]
        return total

    def transfer(self, amount, category):
        if self.check_funds(amount):
            self.withdraw(amount, f"Transfer to {category.name}")
            category.deposit(amount, f"Transfer from {self.name}")
            return True
        return False

    def check_funds(self, amount):
        return amount <= self.get_balance()

    def __str__(self):
        title = self.name.center(30, "*") + "\n"

        items = ""
        for entry in self.ledger:
            description = entry["description"][:23]
            amount = f"{entry['amount']:.2f}"[:7]
            items += f"{description:<23}{amount:>7}\n"

        total = f"Total: {self.get_balance():.2f}"

        return title + items + total


def create_spend_chart(categories):
    withdrawals = []

    for category in categories:
        total = 0
        for item in category.ledger:
            if item["amount"] < 0:
                total += -item["amount"]
        withdrawals.append(total)

    total_spent = sum(withdrawals)

    percentages = []
    for amount in withdrawals:
        percent = int((amount / total_spent) * 100)
        percentages.append(percent - (percent % 10))

    chart = "Percentage spent by category\n"

    for i in range(100, -1, -10):
        chart += f"{i:>3}| "
        for percent in percentages:
            if percent >= i:
                chart += "o  "
            else:
                chart += "   "
        chart += "\n"

    chart += "    " + "-" * (len(categories) * 3 + 1) + "\n"

    max_length = max(len(category.name) for category in categories)

    for i in range(max_length):
        chart += "     "
        for category in categories:
            if i < len(category.name):
                chart += category.name[i] + "  "
            else:
                chart += "   "
        if i != max_length - 1:
            chart += "\n"

    return chart