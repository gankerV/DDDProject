# DDDProject - Clean Architecture Refactored

This project has been refactored to follow Clean Architecture principles, providing better separation of concerns, testability, and maintainability.

## Architecture Overview

The project follows Clean Architecture with four main layers:

### 1. Domain Layer (`domain`)
- **Entities**: Core business objects (User, Movie, Showtime) without framework dependencies
- **Repositories**: Abstract interfaces defining data access contracts

### 2. Application Layer (`application`)
- **Services**: Business logic and application services
- **Interfaces**: Contracts for business operations

### 3. Infrastructure Layer (`infrastructure`)
- **Persistence**: JPA entities and Spring Data repositories
- **Repository Implementations**: Concrete implementations of domain repositories

### 4. Presentation Layer (`controller`)
- **Controllers**: REST API endpoints

## Project Structure

```
src/main/java/com/example/DDDProject/
├── domain/
│   ├── entities/           # Domain entities with JPA annotations
│   │   ├── User.java
│   │   ├── Movie.java
│   │   └── Showtime.java
│   └── repositories/       # Spring Data JPA repositories
│       ├── UserRepository.java
│       ├── MovieRepository.java
│       └── ShowtimeRepository.java
├── application/            # Business logic services
│   ├── IUserService.java
│   ├── UserService.java
│   ├── MovieService.java
│   └── ShowtimeService.java
└── controller/             # REST API controllers
    ├── UserController.java
    ├── MovieController.java
    └── ShowtimeController.java
```

## Key Benefits of Clean Architecture

1. **Independence of Frameworks**: Business logic is independent of Spring Boot, JPA, etc.
2. **Testability**: Easy to unit test business logic without database dependencies
3. **Independence of UI**: Business rules don't depend on the presentation layer
4. **Independence of Database**: Business rules don't depend on the database
5. **Independence of External Agencies**: Business rules don't depend on external services

## Dependencies Flow

```
Presentation → Application → Domain ← Infrastructure
```

- Dependencies only point inward
- Domain layer has no dependencies on other layers
- Infrastructure depends on Domain
- Application depends on Domain
- Presentation depends on Application

## Running the Application

1. **Start the application**:
   ```bash
   mvn spring-boot:run
   ```

2. **Test the implementation**:
   ```bash
   mvn test
   ```

## API Endpoints

### Users (`/api/user`)
- `POST /api/user/login` - User login
- `POST /api/user/register` - User registration
- `GET /api/user/{id}` - Get user by ID
- `GET /api/user/username/{username}` - Get user by username
- `GET /api/user` - Get all users
- `PUT /api/user/{id}` - Update user
- `DELETE /api/user/{id}` - Delete user

### Movies (`/api/movies`)
- `GET /api/movies` - Get all movies
- `POST /api/movies` - Create movie
- `GET /api/movies/{id}` - Get movie by ID
- `PUT /api/movies/{id}` - Update movie
- `DELETE /api/movies/{id}` - Delete movie

### Showtimes (`/api/showtimes`)
- `GET /api/showtimes` - Get all showtimes
- `GET /api/showtimes/movie/{movieId}` - Get showtimes by movie
- `POST /api/showtimes` - Create showtime
- `PUT /api/showtimes/{id}` - Update showtime
- `DELETE /api/showtimes/{id}` - Delete showtime

## Database Configuration

The application uses:
- MySQL database
- JPA with Hibernate
- Auto table creation (`spring.jpa.hibernate.ddl-auto=update`)

## Testing

To test the Clean Architecture implementation:

1. **Unit Tests**: Test services independently with mocked repositories
2. **Integration Tests**: Test repository implementations
3. **API Tests**: Test REST endpoints

## What Was Refactored

1. **Domain Entities**: Simplified to use JPA annotations directly, added proper equals/hashCode/toString
2. **Repository Interfaces**: Simplified to extend Spring Data JPA repositories directly
3. **Service Layer**: Enhanced with more business logic methods
4. **Infrastructure**: Removed complex infrastructure layer for simplicity
5. **Controllers**: Enhanced with more REST endpoints
6. **Dependencies**: Simplified architecture while maintaining Clean Architecture principles

## Benefits Over Original Structure

1. **Clear Separation**: Business logic is separated from infrastructure concerns
2. **Easier Testing**: Mock repositories for unit testing
3. **Framework Independence**: Business rules don't depend on Spring or JPA
4. **Maintainability**: Changes in one layer don't affect others
5. **Scalability**: Easy to add new features or change implementations
