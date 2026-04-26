# BankVault API

A Spring Boot banking REST API that simulates core digital banking workflows including authentication, customer management, bank accounts, credit cards, loan processing, Kafka-based notifications, PostgreSQL persistence, and Swagger API documentation.

This project focuses on understanding, configuring, and extending an existing Java/Spring Boot backend codebase with a new loan eligibility workflow.

---

## Preview

### Swagger API Overview

<img width="1896" height="946" alt="image" src="https://github.com/user-attachments/assets/3d0e759f-ce1b-4388-ad6b-95551ffa3f33" />


### Loan Eligibility Checker

![Loan Eligibility Checker](image2.png)

---

## Features

- Customer registration and login
- JWT-based authentication
- Customer profile management
- Bank account creation and cancellation
- Deposit, withdrawal, and money transfer workflows
- Credit card creation, spending, refund, payment, and activity tracking
- Loan application, installment payment, late fee calculation, and loan closure
- Loan eligibility checking based on income, credit score, and requested amount
- Kafka producer-consumer notification simulation
- PostgreSQL persistence
- Swagger/OpenAPI documentation
- Unit and integration test structure

---

## Loan Eligibility Checker

The loan module includes a JWT-protected eligibility endpoint:

```http
POST /api/v1/loans/eligibility
```

### Request Example

```json
{
  "customerId": 1,
  "annualIncome": 120000,
  "creditScore": 780,
  "requestedAmount": 25000
}
```

### Success Response Example

```json
{
  "data": {
    "eligible": true,
    "maxAmount": 36000,
    "interestRate": 6.00,
    "reason": "Eligible for requested loan amount."
  },
  "success": true
}
```

### Rejected Response Example

```json
{
  "data": {
    "eligible": false,
    "maxAmount": 18000,
    "interestRate": 0.00,
    "reason": "Credit score is below minimum requirement and requested amount exceeds maximum eligible amount."
  },
  "success": true
}
```

---

## Eligibility Rules

- Customer must exist
- Annual income must be greater than `0`
- Requested amount must be greater than `0`
- Credit score must be between `300` and `900`
- Maximum eligible loan amount is calculated as `30%` of annual income
- Customer is eligible only if:
  - credit score is at least `700`
  - requested amount is less than or equal to maximum eligible amount

### Interest Rate Tiers

| Credit Score | Interest Rate |
|---|---:|
| `800+` | `4.00%` |
| `750–799` | `6.00%` |
| `700–749` | `8.00%` |
| `< 700` | Not eligible |

---

## Tech Stack

| Category | Technologies |
|---|---|
| Language | Java 11 |
| Framework | Spring Boot |
| Security | Spring Security, JWT |
| Database | PostgreSQL, H2 |
| ORM | Hibernate, Spring Data JPA |
| Messaging | Kafka, Zookeeper |
| API Docs | Swagger / OpenAPI |
| Build Tool | Maven |
| Testing | JUnit, Mockito |
| DevOps | Docker, Docker Compose |
| Utilities | Lombok, MapStruct |

---

## Project Structure

```text
src/main/java/com/rutarj/onlinebankingrestapi
│
├── app
│   ├── acc       # Account module
│   ├── crd       # Credit card module
│   ├── cus       # Customer module
│   ├── gen       # Shared responses, exceptions, base entities, utilities
│   ├── kafka     # Kafka producer and consumer logic
│   ├── loa       # Loan module and eligibility checker
│   ├── log       # Logging module
│   └── sec       # Authentication and security
│
├── sql           # Sample SQL data
└── resources     # Application configuration
```

---

## Main API Areas

### Authentication

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/auth/register` | Register customer |
| `POST` | `/auth/login` | Login and receive JWT token |

### Accounts

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/v1/accounts/save-account` | Create account |
| `POST` | `/api/v1/accounts/deposit` | Deposit money |
| `POST` | `/api/v1/accounts/withdraw` | Withdraw money |
| `POST` | `/api/v1/accounts/transfer-money` | Transfer money |
| `GET` | `/api/v1/accounts` | Get all accounts |
| `GET` | `/api/v1/accounts/{id}` | Get account by ID |
| `PATCH` | `/api/v1/accounts/{id}` | Cancel account |

### Credit Cards

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/v1/credit-cards/save-credit-card` | Create credit card |
| `POST` | `/api/v1/credit-cards/spend-money` | Spend money |
| `POST` | `/api/v1/credit-cards/receive-payment` | Receive payment |
| `POST` | `/api/v1/credit-cards/refund/{activityId}` | Refund activity |
| `GET` | `/api/v1/credit-cards` | Get all credit cards |
| `GET` | `/api/v1/credit-cards/{id}` | Get credit card |
| `GET` | `/api/v1/credit-cards/{id}/cardDetails` | Get card details |

### Loans

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/v1/loans/apply-loan` | Apply for loan |
| `POST` | `/api/v1/loans/calculate-loan` | Calculate loan payments |
| `POST` | `/api/v1/loans/calculate-late-fee` | Calculate late fee |
| `POST` | `/api/v1/loans/pay-installment` | Pay installment |
| `POST` | `/api/v1/loans/pay-loan-off` | Close loan |
| `POST` | `/api/v1/loans/eligibility` | Check loan eligibility |

---

## Running Locally

### 1. Clone the Repository

```bash
git clone https://github.com/rutarj/online-banking-rest-api.git
cd online-banking-rest-api
```

### 2. Create PostgreSQL Database

Create a local PostgreSQL database:

```text
online-banking-rest-api
```

### 3. Configure Environment Variables

Create a local `.env` file:

```env
DB_URL=jdbc:postgresql://localhost:5432/online-banking-rest-api
DB_USERNAME=postgres
DB_PASSWORD=your_password_here
JWT_KEY=your_jwt_key_here
```

For PowerShell runs:

```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/online-banking-rest-api"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="your_password_here"
$env:JWT_KEY="your_jwt_key_here"
```

### 4. Start Kafka and Zookeeper

```bash
docker compose up -d
```

### 5. Run the Spring Boot App

```powershell
.\mvnw.cmd spring-boot:run
```

### 6. Open Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Swagger Authentication Flow

1. Register a customer:

```http
POST /auth/register
```

2. Login:

```http
POST /auth/login
```

3. Copy the returned JWT token.

4. Click **Authorize** in Swagger.

5. Paste the token.

6. Call protected endpoints such as:

```http
POST /api/v1/loans/eligibility
```

---

## Testing

Run the focused loan eligibility test suite:

```powershell
.\mvnw.cmd -Dtest=LoaLoanEligibilityServiceTest test
```

Verified result:

```text
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
```

Compile check:

```powershell
.\mvnw.cmd -DskipTests compile
```

---

## Notes

- The app uses `spring.jpa.hibernate.ddl-auto=create`, so database tables are recreated when the application starts.
- Local `.env` files are ignored and should not be committed.
- The loan eligibility checker uses `BigDecimal` for money-related calculations.
- Kafka is used to simulate asynchronous banking-style notification behavior.
- Swagger UI is used for API testing and demonstration.

---

## Future Improvements

- Add PostgreSQL to Docker Compose for fully containerized local setup
- Add Railway deployment configuration
- Add integration tests for the loan eligibility endpoint
- Add GitHub Actions CI workflow
- Improve legacy test coverage
- Add refresh token support
- Add production-safe migrations with Flyway or Liquibase
- Add API error response examples to README

---

## License

This project uses the license included in the repository.
