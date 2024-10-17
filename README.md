<h1 align="center">
    <a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.herokuapp.com?font=Ubuntu&weight=1200&size=42&pause=1000&color=C21DF7&background=1511D700&width=1000&height=80&lines=POS+-+RESTful+API+with+Spring+Framework+%F0%9F%96%A5%EF%B8%8F%F0%9F%91%A9%E2%80%8D%F0%9F%92%BB" alt="Typing SVG" /></a>
</h1>

**Food Mart** is a robust Point of Sale (POS) application tailored specifically for grocery stores, offering a streamlined and user-friendly interface to manage customer interactions, product inventories, and order transactions.<br>

Built using Spring MVC, Food Mart ensures scalable and reliable performance, making it suitable for both small and large-scale grocery operations.<br>

This project serves as an educational resource for mastering Spring-MVC development, covering best practices in enterprise application development, database integration, and layered architecture design.

## Project Installation
Follow these steps to install and set up the POS Management System:

1. Clone the repository using web url.
2. Install and configure JDK(JDK 21).
3. Install and configure TomcatEE version 10.
4. Run the project.


## Technologies Used

- Spring Framework (Spring Web MVC): Backend framework for building RESTful services.
- Spring Data JPA: Repository layer for database operations.
- Hibernate: ORM(Object Relational Mapping) for database interaction.

- MySQL: Relational database to store POS data.
- Lombok: Reduces boilerplate code (e.g., getters, setters) and supports logging with SLF4J.
- SLF4J: Logging facade used for logging and debugging.

## API Endpoints

### 01. Customer Management

- **POST** `/customers`: Add a new customer.
- **GET** `/customers`: Get all customers.
- **GET** `/customers/{customerId}`: Get a customer by using customer ID.
- **GET** `/customers/generate-next-customer-id`: To get next customer ID.
- **PUT** `/customers/{customerId}`: Update a customer by using customer ID.
- **DELETE** `/customers/{customerId}`: Delete a customer by using customer ID.


### 02. Item Management
- **POST** `/items`: Add a new item.
- **GET** `/items`: Get all items.
- **GET** `/items/{itemCode}`: Get a item by using item Code.
- **GET** `/items/generate-next-item-code`: To get next item code.
- **PUT** `/items/{itemCode}`: Update a item by using item code.
- **DELETE** `/items/{itemCode}`: Delete a item by using item code.

### 03. Orders Management
- **POST** `/orders`: Place a new order.
- **GET** `/orders`: Get all orders.
- **GET** `/orders/{orderId}`: Get a order by using order ID.
- **GET** `/orders/generate-next-order-id`: To get next order Id.
- **PUT** `/orders/{ordeId}`: Update a order by using order ID.
- **DELETE** `/orders/{orderId}`: Delete a order by using order ID.

## API Documentation

You can view the detailed API documentation for the Food Mart POS System, which includes comprehensive example requests and responses, by visiting this link.<br>
https://documenter.getpostman.com/view/36189376/2sAXxV7WJt

This documentation provides insights into how the API handles various functionalities, including order management, item handling, customer data, and more

<br>
The frontend code for the POS Management System is available in a separate repository. You can find it by this link<br>
https://github.com/yehaniharshika/AAD-Assignment-phase-02-pos-system-frontend.git

## License
© 2024 All Right Reserved Created By Yehani Harshika
<br/>
This project is licensed under the [MIT](License.txt) license







