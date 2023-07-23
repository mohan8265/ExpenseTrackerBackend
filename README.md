# ExpenseTrackerBackend


## Framework and language used 
* Spring Boot
* Java
---
## Data flow
1. controllers
    * ProductController
    * UserController

2. models
     1. dto 
        * SignInInput
    * AuthenticationToken 
    * Expense
    * Product
    * User
3. services
    * AuthTokenService
    * ExpenseService
    * ProductService
    * UserService
4. repositories
    * IAuthtokenRepo
    * IExpenseRepo
    * IProductRepo
    * IUserRepo

---

## Data Structure Used
* MySQL
* AWS
---

```Its a Expense Tracker Application here user first register themself by correct information. they can sign in by providing registered email and correct password user will get a token. now he/she can do CRUD operations on expenses. and user also can do CRUD operations on product model. after all user can sign out if they provide correct information.```
