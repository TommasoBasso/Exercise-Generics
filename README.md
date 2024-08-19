# Exercise-Generics

OVERVIEW
This project is a simple Java-based payment management system that demonstrates the use of object-oriented programming concepts such as interfaces, abstract classes, generics, and enums. 
The system allows for the management of different types of payments, such as credit card and PayPal payments, through a flexible and extensible design

FEATURES
Abstract Classes: The AbstractPayment class serves as a base class for all payment types, providing common fields and methods such as amount, status, and updateStatus.
Interfaces and Generics: The PaymentProcessor<T extends AbstractPayment> interface is implemented by specific payment processors like CreditCardProcessor and PayPalProcessor, providing methods to process, validate, and create payments.
Enums: The PaymentStatus enum defines various states a payment can have, such as PENDING, COMPLETED, FAILED, and REFUNDED.
Custom Payment Manager: The PaymentManager<T extends AbstractPayment> class handles a collection of payments and uses the appropriate PaymentProcessor to process them.

STRUCTURE
AbstractPayment - An abstract base class for all payment types.
CreditCardPayment and PayPalPayment - Concrete classes extending AbstractPayment, representing specific payment types.
PaymentProcessor<T> - A generic interface for processing payments.
CreditCardProcessor and PayPalProcessor - Concrete implementations of PaymentProcessor for processing specific payment types.
PaymentManager<T> - A class for managing a collection of payments and processing them.
