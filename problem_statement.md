Problem Statement
Vending Machine design was an open-ended and vague problem. At first thought, many different images flashed my mind and the problem looked intimidating. I decided to drill down the requirements by asking the Interviewer as many questions as I could.

After all the clarification, the expectation was to build software the could store items (track the inventory), accept cash, & dispense items. Additionally, the interviewer wanted the design and code to be extensible, reusable & modular.

Requirements
I listed the following requirements for the above problem statement

Vending Machine must keep track of the inventory
A person should be able to insert cash into the machine & choose an item
The Machine should confirm the inserted cash with the price of the selected item
The machine must display an error in case of insufficient cash or unavailable item
Finally, if all the above steps succeed then the user gets the selected item
Design
In any Object-oriented design interview, it always helps to identify the actors and the actions performed by them. In the above case, we have two actors Vending Machine and the User interacting. The user issues a command to the Machine and the Machine takes the necessary action.

If you think of buying an item like a transaction, the machine only processes one transaction at a time. For eg: If the machine is in the process of dispensing an item, then the user can’t insert cash and try to buy another item. After the machine dispenses the item, the user can buy a new item.

In simple words, a user can buy a new item by either aborting or completing the existing transaction. To solve this we can define different states of the Vending Machine. Depending on the request, either the machine can change it’s state or stay in the same state.

States
We can define the following states for the Vending Machine:-

Ready — Machine ready to accept cash
CashCollected — Machine has collected cash & user can now select the product or cancel the transaction
DispenseChange — Give back the change to the user
DispenseItem — Dispense the item upon successful validation of entered cash & the price of the selected item in inventory
TransactionCancelled — If the user cancels the transaction, return the cash given by the user